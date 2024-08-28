package test.com.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class TestController {
	
	@GetMapping("/test/insert")
	public String insert() {
		log.info("/test/insert");
		return "test/insert";
	}
	
	@GetMapping("/test/update")
	public String update() {
		log.info("/test/update");
		return "test/update";
	}
	
	@GetMapping("/test/delete")
	public String delete() {
		log.info("/test/delete");
		return "test/delete";
	}
	
	@GetMapping("/test/selectAll")
	public String selectAll() {
		log.info("/test/selectAll");
		return "test/selectAll";
	}
	
	@GetMapping("/test/selectOne")
	public String selectOne() {
		log.info("/test/selectOne");
		return "test/selectOne";
	}
	
	@GetMapping("/test/insertOK")
	public String insertOK(TestVO vo) {
		log.info("/test/insertOK");
		log.info("vo:{}",vo);
		
		return "redirect:/test/selectAll";
	}
	
	@GetMapping("/test/updateOK")
	public String updateOK(TestVO vo) {
		log.info("/test/updateOK");
		log.info("vo:{}",vo);
		
		return "redirect:/test/selectOne?num="+vo.getNum();
	}
	
	@GetMapping("/test/deleteOK")
	public String deleteOK(TestVO vo) {
		log.info("/test/deleteOK");
		log.info("vo:{}",vo);
		
		return "redirect:/test/selectAll";
	}
	

}
