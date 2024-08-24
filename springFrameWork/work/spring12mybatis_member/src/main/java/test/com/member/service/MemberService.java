package test.com.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import test.com.member.model.MemberDAO;
import test.com.member.model.MemberVO;

@Slf4j
@Service
public class MemberService {
	
	@Autowired
	MemberDAO dao;
	
	public MemberService() {
		log.info("MemberService()...");
	}
	
	public int insert(MemberVO vo) {
		log.info("insert()...");
		return dao.insert(vo);
	}
	public int update(MemberVO vo){
		log.info("update()...");
		return dao.update(vo);
	}
	public int delete(MemberVO vo){
		log.info("delete()...");
		return dao.delete(vo);
	}
	public MemberVO selectOne(MemberVO vo){
		log.info("selectOne()...");
		return dao.selectOne(vo);
	}
	public List<MemberVO> selectAll(){
		log.info("selectAll()...");
		return dao.selectAll();
	}
	public List<MemberVO> searchList(String searchKey,String searchWord){
		log.info("searchList()...");
		return dao.searchList(searchKey, searchWord);
	}

}
