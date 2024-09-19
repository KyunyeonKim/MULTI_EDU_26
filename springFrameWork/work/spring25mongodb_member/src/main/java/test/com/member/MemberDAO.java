package test.com.member;

import java.util.List;

import org.bson.Document;

public interface MemberDAO {

	public long insertOne(MemberVO vo);
	public long insertMany();
	
	public long updateOne(MemberVO vo);
	public long updateMany(MemberVO vo);
	
	public long deleteOne(MemberVO vo);
	public long deleteMany(MemberVO vo);
	
	public List<MemberVO> findAll();
	public List<Document> findAllDoc();
	public List<MemberVO> findAll2(int page,int limit);
	
	
	public List<MemberVO> searchList(String searchKey,String searchWord);
	public List<MemberVO> searchList2(String searhKey,String searchWord,int page,int limit);
	
	public MemberVO findOne(MemberVO vo);
	public Document findOneDoc(MemberVO vo);
	
	public List<MemberVO> searchList3(int num1, int num2) ;
	public List<MemberVO> searchList4(int num1, int num2) ;
	
	
}
