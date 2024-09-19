package test.com.member;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
public class MemberService {

	@Autowired
	MemberDAO dao;
	
	public long insertOne(MemberVO vo) {
		return dao.insertOne(vo);
	}

	
	public long insertMany() {
		return dao.insertMany();
	}

	
	public long updateOne(MemberVO vo) {
		return dao.updateOne(vo);
	}

	
	public long updateMany(MemberVO vo) {
		return dao.updateMany(vo);
	}

	
	public long deleteOne(MemberVO vo) {
		return dao.deleteOne(vo);
	}

	
	public long deleteMany(MemberVO vo) {
		return dao.deleteMany(vo);
	}

	
	public List<MemberVO> findAll() {
		
		return dao.findAll();
	}

	
	public List<Document> findAllDoc() {
		
		return dao.findAllDoc();
	}

	
	public List<MemberVO> findAll2(int page, int limit) {
		
		return dao.findAll2(page, limit);
	}

	
	public List<MemberVO> searchList(String searhKey, String searchWord) {
		
		return dao.searchList(searhKey, searchWord);
	}

	
	public List<MemberVO> searchList2(String searhKey, String searchWord, int page, int limit) {
		
		return dao.searchList2(searhKey, searchWord, page, limit);
	}

	
	public MemberVO findOne(MemberVO vo) {
		
		return dao.findOne(vo);
	}

	
	public Document findOneDoc(MemberVO vo) {
		
		return dao.findOneDoc(vo);
	}


	public List<MemberVO> searchList3(int num1, int num2) {
		return dao.searchList3(num1,num2);
	}


	public List<MemberVO> searchList4(int num1, int num2) {
		return dao.searchList4(num1,num2);
	}
	

}
