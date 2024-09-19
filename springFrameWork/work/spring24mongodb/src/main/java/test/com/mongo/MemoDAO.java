package test.com.mongo;

import java.util.List;

import org.bson.Document;

public interface MemoDAO {

	public long insertOne(MemoVO vo);
	public long insertMany();
	
	public long updateOne(MemoVO vo);
	public long updateMany(MemoVO vo);
	
	public long deleteOne(MemoVO vo);
	public long deleteMany(MemoVO vo);
	
	public List<MemoVO> findAll();
	public List<Document> findAllDoc();
	public List<MemoVO> findAll2(int page,int limit);
	
	
	public List<MemoVO> searchList(String searchKey,String searchWord);
	public List<MemoVO> searchList2(String searhKey,String searchWord,int page,int limit);
	
	public MemoVO findOne(MemoVO vo);
	public Document findOneDoc(MemoVO vo);
	
	public List<MemoVO> searchList3(int age1, int age2);
	public List<MemoVO> searchList4(int age1, int age2);
	
}
