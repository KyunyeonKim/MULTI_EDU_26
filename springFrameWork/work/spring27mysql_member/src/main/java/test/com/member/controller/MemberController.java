package test.com.member.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import test.com.member.model.MemberVO;
import test.com.member.service.MemberService;

@Slf4j
@Controller
public class MemberController {
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	MemberService service;
	
	@Autowired
	private HttpSession session;
	
	
	@RequestMapping(value = "/m_insert.do", method = RequestMethod.GET)
	public String m_insert() {
		log.info("m_insert");
		
		return "member/insert";
	}
	
	
	@RequestMapping(value = "/m_update.do", method = RequestMethod.GET)
	public String m_update(MemberVO vo,Model model) {
		log.info("m_update");
		log.info("{}",vo);
		
		MemberVO vo2 = service.selectOne(vo);
		log.info("vo2:{}",vo2);
		
		model.addAttribute("vo2",vo2);
		
		return "member/update";
	}
	
	@RequestMapping(value = "/m_delete.do", method = RequestMethod.GET)
	public String m_delete() {
		log.info("m_delete");
		
		return "member/delete";
	}
	
	@RequestMapping(value = "/m_selectAll.do", method = RequestMethod.GET)
	public String m_selectAll(Model model, 
			@RequestParam(defaultValue = "1")int cpage,
			@RequestParam(defaultValue = "3")int pageBlock) {
		log.info("m_selectAll");
		log.info("cpage : {}",cpage);
		log.info("pageBlock : {}",pageBlock);
		
//		List<MemberVO> list = service.selectAll();
		List<MemberVO> list = service.selectAllPageBlock(cpage,pageBlock);
		log.info("{}",list);
		
		model.addAttribute("list",list);
		
		int totalPageCount = 1;
		int totalRows = service.getTotalRows();
		log.info("totalRows : {}",totalRows);
		if(totalRows / pageBlock == 0) {
			totalPageCount = 1;
		}else if(totalRows % pageBlock == 0) {
			totalPageCount = totalRows / pageBlock;
		}else {
			totalPageCount = totalRows / pageBlock + 1;
		}
		
		model.addAttribute("totalPageCount",totalPageCount);
		
		return "member/selectAll";
	}
	
	@RequestMapping(value = "/m_searchList.do", method = RequestMethod.GET)
	public String m_searchList(Model model,@RequestParam(defaultValue = "name")String searchKey,
			@RequestParam(defaultValue = "ki")String searchWord, 
			@RequestParam(defaultValue = "1")int cpage,
			@RequestParam(defaultValue = "3")int pageBlock) {
		log.info("m_searchList");
		log.info("searchKey:{}",searchKey);
		log.info("searchWord:{}",searchWord);
		log.info("cpage : {}",cpage);
		log.info("pageBlock : {}",pageBlock);
		
//		List<MemberVO> list = service.searchList(searchKey,searchWord);
		List<MemberVO> list = service.searchListPageBlock(cpage,pageBlock,searchKey,searchWord);
		log.info("{}",list);
		
		model.addAttribute("list",list);
		
		
		
		int totalPageCount = 1;
		int totalRows = service.getSearchListTotalRows(searchKey,searchWord);
		log.info("totalRows : {}",totalRows);
		if(totalRows / pageBlock == 0) {
			totalPageCount = 1;
		}else if(totalRows % pageBlock == 0) {
			totalPageCount = totalRows / pageBlock;
		}else {
			totalPageCount = totalRows / pageBlock + 1;
		}
		
		model.addAttribute("totalPageCount",totalPageCount);
		
		return "member/selectAll";
	}
	
	@RequestMapping(value = "/m_selectOne.do", method = RequestMethod.GET)
	public String m_selectOne(MemberVO vo,Model model ) {
		log.info("m_selectOne");
		log.info("{}",vo);
		
		MemberVO vo2 = service.selectOne(vo);
		log.info("vo2:{}",vo2);
		
		model.addAttribute("vo2",vo2);
		
		return "member/selectOne";
	}
	
	@RequestMapping(value = "/m_insertOK.do", method = RequestMethod.POST)
	public String m_insertOK(MemberVO vo) throws IllegalStateException, IOException {
		log.info("m_insertOK");
		log.info("{}",vo);
		
		String realPath = context.getRealPath("resources/upload_img");
		log.info(realPath);

		String originName = vo.getFile().getOriginalFilename();
		log.info("originName:{}", originName);
		
		if (originName.length() == 0) {// 넘어온 파일이 없을때 default.png 할당
			vo.setImg_name("default.png");
		} else {
			// 중복이미지 이름을 배제하기위한 처리
			String save_name = "img_" + System.currentTimeMillis() + originName.substring(originName.lastIndexOf("."));
			log.info("save_name:{}", save_name);
			vo.setImg_name(save_name);

			File f = new File(realPath, save_name);
			vo.getFile().transferTo(f);

			//// create thumbnail image/////////
			BufferedImage original_buffer_img = ImageIO.read(f);
			BufferedImage thumb_buffer_img = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = thumb_buffer_img.createGraphics();
			graphic.drawImage(original_buffer_img, 0, 0, 50, 50, null);

			File thumb_file = new File(realPath, "thumb_" + save_name);

			ImageIO.write(thumb_buffer_img, save_name.substring(save_name.lastIndexOf(".") + 1), thumb_file);

		}
		
		
		int result = service.insert(vo);
		log.info("result:{}",result);
		
		return "redirect:m_selectAll.do";
	}
	
	@RequestMapping(value = "/m_updateOK.do", method = RequestMethod.POST)
	public String m_updateOK(MemberVO vo) throws IllegalStateException, IOException {
		log.info("m_updateOK");
		log.info("{}",vo);
		
		String realPath = context.getRealPath("resources/upload_img");
		log.info(realPath);

		String originName = vo.getFile().getOriginalFilename();
		log.info("originName:{}", originName);
		
		if (originName.length() == 0) {// 넘어온 파일이 없을때 기존이미지 할당
			vo.setImg_name(vo.getImg_name());//
		} else {
			// 중복이미지 이름을 배제하기위한 처리
			String save_name = "img_" + System.currentTimeMillis() + originName.substring(originName.lastIndexOf("."));
			log.info("save_name:{}", save_name);
			vo.setImg_name(save_name);

			File f = new File(realPath, save_name);
			vo.getFile().transferTo(f);

			//// create thumbnail image/////////
			BufferedImage original_buffer_img = ImageIO.read(f);
			BufferedImage thumb_buffer_img = new BufferedImage(50, 50, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = thumb_buffer_img.createGraphics();
			graphic.drawImage(original_buffer_img, 0, 0, 50, 50, null);

			File thumb_file = new File(realPath, "thumb_" + save_name);

			ImageIO.write(thumb_buffer_img, save_name.substring(save_name.lastIndexOf(".") + 1), thumb_file);

		}
		
		
		int result = service.update(vo);
		log.info("result:{}",result);
		
		return "redirect:m_selectOne.do?num="+vo.getNum();
	}
	
	@RequestMapping(value = "/m_deleteOK.do", method = RequestMethod.POST)
	public String m_deleteOK(MemberVO vo) {
		log.info("m_deleteOK");
		log.info("{}",vo);
		
		int result = service.delete(vo);
		log.info("result:{}",result);
		
		return "redirect:m_selectAll.do";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		log.info("/login.do");
		
		return "member/login";
	}
	
	
	@RequestMapping(value = "/loginOK.do", method = RequestMethod.POST)
	public String loginOK(MemberVO vo) {
		log.info("/loginOK.do");
		
		MemberVO vo2 = service.login(vo);
		log.info("vo2:{}",vo2);
		
		if(vo2 != null) {
			session.setAttribute("user_id", vo.getId());
			return "redirect:home.do";
		}else {
			return "redirect:login.do";
		}
	}
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout() {
		log.info("/logout.do");
		
		session.removeAttribute("user_id");
		
		return "redirect:home.do";
	}
	
	
}//end class
