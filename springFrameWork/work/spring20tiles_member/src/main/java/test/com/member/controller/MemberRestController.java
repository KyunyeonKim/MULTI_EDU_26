package test.com.member.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import test.com.member.model.MemberVO;
import test.com.member.service.MemberService;

@Slf4j
@Controller
public class MemberRestController {

	@Autowired
	MemberService service;
	
	
	@ResponseBody // RestController 처리 어노테이션 객체
	@RequestMapping(value = "/api/json_idCheck.do", method = RequestMethod.GET)
	public Map<String, String> json_idCheck(MemberVO vo) {
		log.info("/json_idCheck.do....{}",vo);
		
		MemberVO vo2 = service.idCheck(vo);
		log.info("vo2:{}",vo2);

		Map<String, String> map = new HashMap<String, String>();
		if(vo2 != null) {
			map.put("result", "Not OK");
		}else {
			map.put("result", "OK");
		}

		return map;
	}
	

}
