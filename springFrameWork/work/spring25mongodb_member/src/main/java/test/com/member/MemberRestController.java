package test.com.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberRestController {

	@Autowired
	MemberService service;

	@ResponseBody
	@RequestMapping(value = "/findAll.do", method = RequestMethod.GET)
	public List<MemberVO> findAll() {
		log.info("/findAll.do");

		List<MemberVO> list = service.findAll();
		log.info("list.size() : {}", list.size());

		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/findAll2.do", method = RequestMethod.GET)
	public List<MemberVO> findAll2(@RequestParam(defaultValue = "1")int page,
			@RequestParam(defaultValue = "3")int limit) {
		log.info("/findAll2.do");
		log.info("page:{}",page);
		log.info("limit:{}",limit);
		
		List<MemberVO> list = service.findAll2(page,limit);
		log.info("list.size() : {}", list.size());
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/findAllDoc.do", method = RequestMethod.GET)
	public List<Document> findAllDoc() {
		log.info("/findAllDoc.do");

		List<Document> list = service.findAllDoc();
		log.info("list.size() : {}", list.size());

		return list;
	}

	@ResponseBody
	@RequestMapping(value = "/searchList.do", method = RequestMethod.GET)
	public List<MemberVO> searchList(@RequestParam(defaultValue = "name") String searchKey,
			@RequestParam(defaultValue = "nn") String searchWord) {
		log.info("/searchList.do");
		log.info("searchKey:{}", searchKey);
		log.info("searchWord:{}", searchWord);

		List<MemberVO> list = service.searchList(searchKey, searchWord);
		log.info("list.size() : {}", list.size());

		return list;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/searchList2.do", method = RequestMethod.GET)
	public List<MemberVO> searchList2(@RequestParam(defaultValue = "name") String searchKey,
			@RequestParam(defaultValue = "nn") String searchWord,
			@RequestParam(defaultValue = "1")int page,
			@RequestParam(defaultValue = "3")int limit) {
		log.info("/searchList2.do");
		log.info("searchKey:{}", searchKey);
		log.info("searchWord:{}", searchWord);
		log.info("page:{}",page);
		log.info("limit:{}",limit);
		
		List<MemberVO> list = service.searchList2(searchKey, searchWord,page,limit);
		log.info("list.size() : {}", list.size());
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/searchList3.do", method = RequestMethod.GET)
	public List<MemberVO> searchList3(@RequestParam(defaultValue = "0")int num1,
			@RequestParam(defaultValue = "0")int num2) {
		log.info("/searchList3.do");
		log.info("num1:{}",num1);
		log.info("num2:{}",num2);
		
		List<MemberVO> list = service.searchList3(num1, num2);
		log.info("list.size() : {}", list.size());
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/searchList4.do", method = RequestMethod.GET)
	public List<MemberVO> searchList4(@RequestParam(defaultValue = "0")int num1,
			@RequestParam(defaultValue = "0")int num2) {
		log.info("/searchList4.do");
		log.info("num1:{}",num1);
		log.info("num2:{}",num2);
		
		List<MemberVO> list = service.searchList4(num1, num2);
		log.info("list.size() : {}", list.size());
		
		return list;
	}

	@ResponseBody
	@RequestMapping(value = "/findOne.do", method = RequestMethod.GET)
	public MemberVO findOne(MemberVO vo) {
		log.info("/findOne.do");
		log.info("vo : {}", vo);

		MemberVO vo2 = service.findOne(vo);
		log.info("vo2 : {}", vo2);

		return vo2;
	}

	// {"result":1} or {"result":0}
	@ResponseBody
	@RequestMapping(value = "/insertOneOK.do", method = RequestMethod.GET)
	public Map<String, Long> insertOneOK(MemberVO vo) {
		log.info("/insertOneOK.do");
		log.info("vo : {}", vo);

		Long result = service.insertOne(vo);
		log.info("result : {}", result);

		Map<String, Long> map = new HashMap<String, Long>();
		map.put("result", result);

		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/insertManyOK.do", method = RequestMethod.GET)
	public Map<String, Long> insertManyOK() {
		log.info("/insertManyOK.do");
		
		Long result = service.insertMany();
		log.info("result : {}", result);
		
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("result", result);
		
		return map;
	}

	// updateOneOK.do?num=102&name=yang2&office=multi2&phone=0222
	// {"result":1} or {"result":0}
	@ResponseBody
	@RequestMapping(value = "/updateOneOK.do", method = RequestMethod.GET)
	public Map<String, Long> updateOneOK(MemberVO vo) {
		log.info("/updateOneOK.do");
		log.info("vo : {}", vo);

		Long result = service.updateOne(vo);
		log.info("result : {}", result);

		Map<String, Long> map = new HashMap<String, Long>();
		map.put("result", result);

		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateManyOK.do", method = RequestMethod.GET)
	public Map<String, Long> updateManyOK(MemberVO vo) {
		log.info("/updateManyOK.do");
		log.info("vo : {}", vo);
		
		Long result = service.updateMany(vo);
		log.info("result : {}", result);
		
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("result", result);
		
		return map;
	}

	// deleteOneOK.do?num=101
	// {"result":1} or {"result":0}
	@ResponseBody
	@RequestMapping(value = "/deleteOneOK.do", method = RequestMethod.GET)
	public Map<String, Long> deleteOneOK(MemberVO vo) {
		log.info("/deleteOneOK.do");
		log.info("vo : {}", vo);

		Long result = service.deleteOne(vo);
		log.info("result : {}", result);

		Map<String, Long> map = new HashMap<String, Long>();
		map.put("result", result);

		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteManyOK.do", method = RequestMethod.GET)
	public Map<String, Long> deleteManyOK(MemberVO vo) {
		log.info("/deleteManyOK.do");
		log.info("vo : {}", vo);
		
		Long result = service.deleteMany(vo);
		log.info("result : {}", result);
		
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("result", result);
		
		return map;
	}

	
	
	
	
}
