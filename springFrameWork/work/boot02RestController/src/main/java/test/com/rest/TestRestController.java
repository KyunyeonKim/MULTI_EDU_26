package test.com.rest;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RestController
public class TestRestController {

	//@RequestMapping(value="api/json_selectOne.do", method=RequestMethod.GET)
	@GetMapping("api/json_selectOne.do")
//	public TestVO json_selectOne(
//			@RequestParam(defaultValue = "0") String num) {
		public TestVO json_selectOne(TestVO vo) {
		log.info("api/json_selectOne.do");
		log.info("vo:{}",vo);
		//{"name":"kim","age":33}
		//스프링부트에서는 jackson라이브러리 추가없도 사용가능
		TestVO vo2 = new TestVO();
		vo2.setName("lee");
		vo2.setAge(44);
//		return "{\"name\":\"kim\",\"age\":33}";
		return vo2;
	}
	
	@GetMapping("api/json_selectAll.do")
	public List<TestVO> json_selectAll() {
		log.info("api/json_selectAll.do");
		//[{"name":"kim","age":33},{"name":"kim","age":33}]
		List<TestVO> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			TestVO vo = new TestVO();
			vo.setName("lee"+1);
			vo.setAge(44+i);
			list.add(vo);
		}
		
//		return "[{\"name\":\"kim1\",\"age\":33},{\"name\":\"kim2\",\"age\":44}]";
		return list;
	}
	
//	@GetMapping("api/json_insertOK.do")
	@PostMapping("api/json_insertOK.do")
	public Map<String, Integer> json_insertOK(TestVO vo) {
		log.info("api/json_insertOK.do");
		log.info("vo:{}",vo);
		
		//{"result":1}
		Map<String, Integer> map = new HashMap<>();
		map.put("result", 1);
		
//		return "{\"result\":1}";
		return map;
	}
	
	@GetMapping("api/json_nicknameCheck.do")
	public Map<String, String> json_nicknameCheck(TestVO vo) {
		log.info("api/json_nicknameCheck.do");
		log.info("vo:{}",vo);
		
		//{"result":"Not OK"}
		Map<String, String> map = new HashMap<>();
		map.put("result", "Not OK");
		
		return map;
	}
	
	
}
