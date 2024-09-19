package test.com.mongo;

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
public class MemoRestController {

	@Autowired
	MemoService service;

	@ResponseBody
	@RequestMapping(value = "/findAll.do", method = RequestMethod.GET)
	public List<MemoVO> findAll() {
		log.info("/findAll.do");

		List<MemoVO> list = service.findAll();
		log.info("list.size() : {}", list.size());

		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/findAll2.do", method = RequestMethod.GET)
	public List<MemoVO> findAll2(@RequestParam(defaultValue = "1")int page,
			@RequestParam(defaultValue = "3")int limit) {
		log.info("/findAll2.do");
		log.info("page:{}",page);
		log.info("limit:{}",limit);

		List<MemoVO> list = service.findAll2(page,limit);
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
	public List<MemoVO> searchList(@RequestParam(defaultValue = "name") String searchKey,
			@RequestParam(defaultValue = "nn") String searchWord) {
		log.info("/searchList.do");
		log.info("searchKey:{}", searchKey);
		log.info("searchWord:{}", searchWord);

		List<MemoVO> list = service.searchList(searchKey, searchWord);
		log.info("list.size() : {}", list.size());

		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/searchList2.do", method = RequestMethod.GET)
	public List<MemoVO> searchList2(@RequestParam(defaultValue = "name") String searchKey,
			@RequestParam(defaultValue = "nn") String searchWord,
			@RequestParam(defaultValue = "1")int page,
			@RequestParam(defaultValue = "3")int limit) {
		log.info("/searchList2.do");
		log.info("searchKey:{}", searchKey);
		log.info("searchWord:{}", searchWord);
		log.info("page:{}",page);
		log.info("limit:{}",limit);
		
		List<MemoVO> list = service.searchList2(searchKey, searchWord,page,limit);
		log.info("list.size() : {}", list.size());
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/searchList3.do", method = RequestMethod.GET)
	public List<MemoVO> searchList3(@RequestParam(defaultValue = "0")int age1,
			@RequestParam(defaultValue = "0")int age2) {
		log.info("/searchList3.do");
		log.info("age1:{}",age1);
		log.info("age2:{}",age2);
		
		List<MemoVO> list = service.searchList3(age1, age2);
		log.info("list.size() : {}", list.size());
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/searchList4.do", method = RequestMethod.GET)
	public List<MemoVO> searchList4(@RequestParam(defaultValue = "0")int age1,
			@RequestParam(defaultValue = "0")int age2) {
		log.info("/searchList4.do");
		log.info("age1:{}",age1);
		log.info("age2:{}",age2);
		
		List<MemoVO> list = service.searchList4(age1, age2);
		log.info("list.size() : {}", list.size());
		
		return list;
	}

	@ResponseBody
	@RequestMapping(value = "/findOne.do", method = RequestMethod.GET)
	public MemoVO findOne(MemoVO vo) {
		log.info("/findOne.do");
		log.info("vo : {}", vo);

		MemoVO vo2 = service.findOne(vo);
		log.info("vo2 : {}", vo2);

		return vo2;
	}

	// insertOneOK.do?age=101&name=kim1&office=multi1&phone=0201
	// {"result":1} or {"result":0}
	@ResponseBody
	@RequestMapping(value = "/insertOneOK.do", method = RequestMethod.GET)
	public Map<String, Long> insertOneOK(MemoVO vo) {
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

	// updateOneOK.do?age=102&name=yang2&office=multi2&phone=0222
	// {"result":1} or {"result":0}
	@ResponseBody
	@RequestMapping(value = "/updateOneOK.do", method = RequestMethod.GET)
	public Map<String, Long> updateOneOK(MemoVO vo) {
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
	public Map<String, Long> updateManyOK(MemoVO vo) {
		log.info("/updateManyOK.do");
		log.info("vo : {}", vo);

		Long result = service.updateMany(vo);
		log.info("result : {}", result);

		Map<String, Long> map = new HashMap<String, Long>();
		map.put("result", result);

		return map;
	}

	// deleteOneOK.do?age=101
	// {"result":1} or {"result":0}
	@ResponseBody
	@RequestMapping(value = "/deleteOneOK.do", method = RequestMethod.GET)
	public Map<String, Long> deleteOneOK(MemoVO vo) {
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
	public Map<String, Long> deleteManyOK(MemoVO vo) {
		log.info("/deleteManyOK.do");
		log.info("vo : {}", vo);
		
		Long result = service.deleteMany(vo);
		log.info("result : {}", result);
		
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("result", result);
		
		return map;
	}

	//미션 : spring25mongodb_member : CRUD처리 핵심로직 구현하기
	//pagkage : test.com.member : RestAPI로 구현하기
	//데이터베이스 : multi
	//컬렉션 : member
	
	
	
}
