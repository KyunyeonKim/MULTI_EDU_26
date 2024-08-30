package test.com.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class MemberController {
	
	@GetMapping("/member/insert")
	public String insert() {
		log.info("/member/insert");
		return "member/insert";
	}
	
	@GetMapping("/member/update")
	public String update() {
		log.info("/member/update");
		return "member/update";
	}
	
	@GetMapping("/member/delete")
	public String delete() {
		log.info("/member/delete");
		return "member/delete";
	}
	
	@GetMapping("/member/selectAll")
	public String selectAll() {
		log.info("/member/selectAll");
		return "member/selectAll";
	}
	
	@GetMapping("/member/selectOne")
	public String selectOne() {
		log.info("/member/selectOne");
		return "member/selectOne";
	}
	
	@GetMapping("/member/insertOK")
	public String insertOK(MemberVO vo) {
		log.info("/member/insertOK");
		log.info("vo:{}",vo);
		
		return "redirect:/member/selectAll";
	}
	
	@GetMapping("/member/updateOK")
	public String updateOK(MemberVO vo) {
		log.info("/member/updateOK");
		log.info("vo:{}",vo);
		
		return "redirect:/member/selectOne?num="+vo.getNum();
	}
	
	@GetMapping("/member/deleteOK")
	public String deleteOK(MemberVO vo) {
		log.info("/member/deleteOK");
		log.info("vo:{}",vo);
		
		return "redirect:/member/selectAll";
	}
	

}
