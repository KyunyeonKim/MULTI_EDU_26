package test.com.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import test.com.member.model.BoardVO;
import test.com.member.service.BoardService;
import test.com.member.service.MemberService;

@Slf4j
@Controller
public class BoardController {

	@Autowired
	BoardService service;

	@GetMapping("/board/insert")
	public String insert() {
		log.info("/board/insert");
		return "board/insert";
	}

	@GetMapping("/board/update")
	public String update(BoardVO vo,Model model) {
		log.info("/board/update");
		log.info("vo:{}", vo);

		BoardVO vo2 = service.selectOne(vo);
		log.info("vo2:{}", vo2);

		model.addAttribute("vo2", vo2);
		
		
		return "board/update";
	}

	@GetMapping("/board/delete")
	public String delete() {
		log.info("/board/delete");
		return "board/delete";
	}

	@GetMapping("/board/selectAll")
	public String selectAll(Model model) {
		log.info("/board/selectAll");

		List<BoardVO> list = service.selectAll();
		log.info("list.size():{}", list.size());

		model.addAttribute("list", list);

		return "board/selectAll";
	}
	
	@GetMapping("/board/searchList")
	public String searchList(Model model,
			@RequestParam(defaultValue = "id")String searchKey,
			@RequestParam(defaultValue = "ad")String searchWord) {
		log.info("/board/searchList");
		log.info("searchKey:{}",searchKey);
		log.info("searchWord:{}",searchWord);

		List<BoardVO> list = service.searchList(searchKey,searchWord);
		log.info("list.size():{}", list.size());

		model.addAttribute("list", list);

		return "board/selectAll";
	}

	@GetMapping("/board/selectOne")
	public String selectOne(BoardVO vo,Model model) {
		log.info("/board/selectOne");
		log.info("vo:{}", vo);

		BoardVO vo2 = service.selectOne(vo);
		log.info("vo2:{}", vo2);

		model.addAttribute("vo2", vo2);

		return "board/selectOne";
	}

	@PostMapping("/board/insertOK")
	public String insertOK(BoardVO vo) {
		log.info("/board/insertOK");
		log.info("vo:{}", vo);

		int result = service.insertOK(vo);
		log.info("result:{}", result);
		if (result == 1) {
			return "redirect:/board/selectAll";
		} else {
			return "redirect:/board/insert";
		}
	}

	@PostMapping("/board/updateOK")
	public String updateOK(BoardVO vo) {
		log.info("/board/updateOK");
		log.info("vo:{}", vo);
		
		int result = service.updateOK(vo);
		log.info("result:{}", result);
		if (result == 1) {
			return "redirect:/board/selectOne?num=" + vo.getNum();
		} else {
			return "redirect:/board/update?num=" + vo.getNum();
		}
	}

	@PostMapping("/board/deleteOK")
	public String deleteOK(BoardVO vo) {
		log.info("/board/deleteOK");
		log.info("vo:{}", vo);
		
		int result = service.deleteOK(vo);
		log.info("result:{}", result);
		if (result == 1) {
			return "redirect:/board/selectAll";
		} else {
			return "redirect:/board/delete?num=" + vo.getNum();
		}
	}

}
