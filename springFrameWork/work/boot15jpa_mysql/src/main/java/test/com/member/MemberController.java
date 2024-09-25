package test.com.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {

	@Autowired
	private MemberService service;

	@GetMapping("/member/insert")
	public String insert() {
		log.info("/member/insert");
		return "member/insert";
	}

	@GetMapping("/member/update")
	public String update(Model model,MemberVO_JPA vo) {
		log.info("/member/update");
		
		MemberVO_JPA vo2 = service.selectOne(vo);
		log.info("vo2:{}", vo2);
		
		model.addAttribute("vo2",vo2);
		
		return "member/update";
	}

	@GetMapping("/member/delete")
	public String delete() {
		log.info("/member/delete");
		return "member/delete";
	}

	@GetMapping("/member/selectAll")
	public String selectAll(Model model, @RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock) {
		log.info("/member/selectAll");

//		List<MemberVO_JPA> list = service.selectAll();
		List<MemberVO_JPA> list = service.selectAllPageBlock(cpage, pageBlock);
		log.info("list.size():{}", list.size());
		for (MemberVO_JPA vo : list) {
			log.info(vo.toString());
		}
		model.addAttribute("list", list);

		// 총행카운트 얻기.
		long total_rows = service.getTotalRows();
		log.info("total_rows:{}", total_rows);

		long totalPageCount = 0;

		// 총행카운트와 페이지블럭을 나눌때의 알고리즘을 추가기
		if (total_rows / pageBlock == 0) {
			totalPageCount = 1;
		} else if (total_rows % pageBlock == 0) {
			totalPageCount = total_rows / pageBlock;
		} else {
			totalPageCount = total_rows / pageBlock + 1;
		}
		log.info("totalPageCount:{}", totalPageCount);

		model.addAttribute("totalPageCount", totalPageCount);

		return "member/selectAll";
	}

	@GetMapping("/member/searchList")
	public String searchList(Model model, @RequestParam(defaultValue = "id") String searchKey,
			@RequestParam(defaultValue = "ad") String searchWord, @RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock) {
		log.info("/member/searchList");
		log.info("searchKey:{}", searchKey);
		log.info("searchWord:{}", searchWord);
		log.info("cpage:{}", cpage);
		log.info("pageBlock:{}", pageBlock);

//		List<MemberVO_JPA> list = service.searchList(searchKey,searchWord);
		List<MemberVO_JPA> list = service.searchListPageBlock(searchKey, searchWord, cpage, pageBlock);
		log.info("list.size():{}", list.size());
		for (MemberVO_JPA vo : list) {
			log.info(vo.toString());
		}
		model.addAttribute("list", list);

		// searchWord에 따른 총카운트 얻기
		// select count(*) total_rows from member_jpa where user_id like '%ad%';
		long total_rows = service.getSearchTotalRows(searchKey, searchWord);
		log.info("total_rows:{}", total_rows);

		
		long totalPageCount = 0;
		// 총행카운트와 페이지블럭을 나눌때의 알고리즘을 추가기
		if (total_rows / pageBlock == 0) {
			totalPageCount = 1;
		} else if (total_rows % pageBlock == 0) {
			totalPageCount = total_rows / pageBlock;
		} else {
			totalPageCount = total_rows / pageBlock + 1;
		}
		log.info("totalPageCount:{}", totalPageCount);

		model.addAttribute("totalPageCount", totalPageCount);

		return "member/selectAll";
	}

	@GetMapping("/member/selectOne")
	public String selectOne(Model model, MemberVO_JPA vo) {
		log.info("/member/selectOne");
		log.info("vo:{}", vo);

		MemberVO_JPA vo2 = service.selectOne(vo);
		log.info("vo2:{}", vo2);
		
		model.addAttribute("vo2",vo2);

		return "member/selectOne";
	}

	@PostMapping("/member/insertOK")
	public String insertOK(MemberVO_JPA vo) {
		log.info("/member/insertOK");
		log.info("vo:{}", vo);

		int result = service.insertOK(vo);
		log.info("result:{}", result);

		return "redirect:/member/selectAll";
	}

	@PostMapping("/member/updateOK")
	public String updateOK(MemberVO_JPA vo) {
		log.info("/member/updateOK");
		log.info("vo:{}", vo);

		int result = service.updateOK(vo);
		log.info("result:{}", result);

		return "redirect:/member/selectOne?num=" + vo.getNum();
	}

	@PostMapping("/member/deleteOK")
	public String deleteOK(MemberVO_JPA vo) {
		log.info("/member/deleteOK");
		log.info("vo:{}", vo);

		int result = service.deleteOK(vo);
		log.info("result:{}", result);

		return "redirect:/member/selectAll";
	}

}
