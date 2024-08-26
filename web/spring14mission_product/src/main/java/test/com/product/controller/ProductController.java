package test.com.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import test.com.product.model.ProductVO;
import test.com.product.service.ProductService;


@Controller
public class ProductController {

	int n;
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService service;
	
	@RequestMapping(value = "/p_insert.do", method = RequestMethod.GET)
	public String p_insert() {
		logger.info("p_insert");

		return "product/insert";
	}
	
	
	@RequestMapping(value = "/p_update.do", method = RequestMethod.GET)
	public String p_update(ProductVO vo,Model model) {
		logger.info("p_update");
		logger.info("{}",vo);
		
		ProductVO vo2 = service.selectOne(vo);
		logger.info("vo2:{}",vo2);
		
		model.addAttribute("vo2",vo2);
		
		return "product/update";
	}
	
	@RequestMapping(value = "/p_delete.do", method = RequestMethod.GET)
	public String p_delete() {
		logger.info("p_delete");
		
		return "product/delete";
	}
	
	@RequestMapping(value = "/p_selectAll.do", method = RequestMethod.GET)
	public String p_selectAll(Model model) {
		logger.info("p_selectAll");
		
		List<ProductVO> list = service.selectAll();
		logger.info("{}",list);
		
		model.addAttribute("list",list);
		
		return "product/selectAll";
	}
	
	@RequestMapping(value = "/p_searchList.do", method = RequestMethod.GET)
	public String p_searchList(Model model,@RequestParam(defaultValue = "pname")String searchKey,
			@RequestParam(defaultValue = "ph")String searchWord) {
		logger.info("p_searchList");
		logger.info("searchKey:{}",searchKey);
		logger.info("searchWord:{}",searchWord);
		
		List<ProductVO> list = service.searchList(searchKey,searchWord);
		logger.info("{}",list);
		
		model.addAttribute("list",list);
		
		return "product/selectAll";
	}
	
	@RequestMapping(value = "/p_selectOne.do", method = RequestMethod.GET)
	public String p_selectOne(ProductVO vo,Model model ) {
		logger.info("p_selectOne");
		logger.info("{}",vo);
		
		ProductVO vo2 = service.selectOne(vo);
		logger.info("vo2:{}",vo2);
		
		model.addAttribute("vo2",vo2);
		
		return "product/selectOne";
	}
	
	@RequestMapping(value = "/p_insertOK.do", method = RequestMethod.POST)
	public String p_insertOK(ProductVO vo) {
		logger.info("p_insertOK");
		logger.info("{}",vo);
		
		int result = service.insert(vo);
		logger.info("result:{}",result);
		
		return "redirect:p_selectAll.do";
	}
	
	@RequestMapping(value = "/p_updateOK.do", method = RequestMethod.POST)
	public String p_updateOK(ProductVO vo) {
		logger.info("p_updateOK");
		logger.info("{}",vo);
		
		int result = service.update(vo);
		logger.info("result:{}",result);
		
		return "redirect:p_selectAll.do";
	}
	
	@RequestMapping(value = "/p_deleteOK.do", method = RequestMethod.POST)
	public String p_deleteOK(ProductVO vo) {
		logger.info("p_deleteOK");
		logger.info("{}",vo);
		
		int result = service.delete(vo);
		logger.info("result:{}",result);
		
		return "redirect:p_selectAll.do";
	}
	
	
	
	
	
}//end class
