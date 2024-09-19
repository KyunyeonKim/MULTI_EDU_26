package test.com.member;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberDAOimpl implements MemberDAO {

	@Autowired
	MongoCollection<Document> member;

	@Override
	public long insertOne(MemberVO vo) {
		log.info("insertOne()....");
		log.info("vo:{}", vo);
		
		long flag = 0;
		
		try {
			Document doc = new Document();
			doc.put("num", vo.getNum());
			doc.put("id", vo.getId());
			doc.put("pw", vo.getPw());
			doc.put("name", vo.getName());
			doc.put("tel", vo.getTel());
			
			member.insertOne(doc);
			flag = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public long insertMany() {
		log.info("insertMany()....");
		
		long flag = 0;
		
		try {
			List<Document> docs = new ArrayList<Document>();
			for (int i = 7; i <= 11 ; i++) {
				Document doc = new Document();
				doc.put("num", i);
				doc.put("id", "admin"+i);
				doc.put("pw", "hi000"+i);
				doc.put("name", "yang"+i);
				doc.put("tel", "011"+i);
				docs.add(doc);
			}
			
			member.insertMany(docs);
			flag = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public long updateOne(MemberVO vo) {
		log.info("updateOne()....");
		log.info("vo:{}", vo);
		
		long flag = 0;
		
		try {
			
			Document doc = new Document();
			doc.put("id", vo.getId());
			doc.put("pw", vo.getPw());
			doc.put("name", vo.getName());
			doc.put("tel", vo.getTel());
			
			Bson set = new Document("$set",doc);
			
			flag = member.updateOne(new Document("num",vo.getNum()),set).getModifiedCount();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public long updateMany(MemberVO vo) {
		log.info("updateMany()....");
		log.info("vo:{}", vo);
		
		long flag = 0;
		
		try {
			
			Document doc = new Document();
			doc.put("id", vo.getId());
			doc.put("pw", vo.getPw());
			doc.put("name", vo.getName());
			doc.put("tel", vo.getTel());
			
			Bson set = new Document("$set",doc);
			
			flag = member.updateMany(Filters.gte("num",vo.getNum()),set).getModifiedCount();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public long deleteOne(MemberVO vo) {
		log.info("deleteOne()....");
		log.info("vo:{}", vo);
		
		long flag = 0;
		
		try {
						
			flag = member.deleteOne(new Document("num",vo.getNum())).getDeletedCount();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public long deleteMany(MemberVO vo) {
		log.info("deleteMany()....");
		log.info("vo:{}", vo);
		
		long flag = 0;
		
		try {
						
			flag = member.deleteMany(Filters.gte("num",vo.getNum())).getDeletedCount();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public List<MemberVO> findAll() {
		log.info("findAll()...");

		FindIterable<Document> docs = member.find().sort(new Document("num", -1));

		List<MemberVO> list = new ArrayList<MemberVO>();

		for (Document doc : docs) {
			// log.info(doc.toJson());
			MemberVO vo = new MemberVO();
			vo.setMid(doc.get("_id").toString());
			vo.set_id(doc.get("_id").toString());
			vo.setNum(doc.getInteger("num", 0));
			vo.setId(doc.getString("id"));
			vo.setPw(doc.getString("pw"));
			vo.setName(doc.getString("name"));
			vo.setTel(doc.getString("tel"));
			list.add(vo);
		}

		return list;
	}

	@Override
	public List<Document> findAllDoc() {
		log.info("findAllDoc()...");

		FindIterable<Document> docs = member.find().sort(new Document("num", -1));

		List<Document> list = new ArrayList<Document>();

		for (Document doc : docs) {
			// log.info(doc.toJson());
			
			list.add(doc);
		}

		return list;
	}

	@Override
	public List<MemberVO> findAll2(int page, int limit) {
		log.info("findAll2()...");
		log.info("page:{}",page);
		log.info("limit:{}",limit);
		
		// ~~~.find({}).sort({num:-1}).skip((page-1)*limit).limit(3)
		FindIterable<Document> docs = 
				member.find().sort(new Document("num", -1)).skip((page-1)*limit).limit(limit);

		List<MemberVO> list = new ArrayList<MemberVO>();

		for (Document doc : docs) {
			// log.info(doc.toJson());
			MemberVO vo = new MemberVO();
			vo.setMid(doc.get("_id").toString());
			vo.set_id(doc.get("_id").toString());
			vo.setNum(doc.getInteger("num", 0));
			vo.setId(doc.getString("id"));
			vo.setPw(doc.getString("pw"));
			vo.setName(doc.getString("name"));
			vo.setTel(doc.getString("tel"));
			list.add(vo);
		}

		return list;
	}

	@Override
	public List<MemberVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()....");
		log.info("searchKey:{}", searchKey);
		log.info("searchWord:{}", searchWord);
		
		Bson filter = Filters.regex(searchKey, searchWord);
		FindIterable<Document> docs = member.find(filter).sort(new Document("num", -1));

		List<MemberVO> list = new ArrayList<MemberVO>();

		for (Document doc : docs) {
			// log.info(doc.toJson());
			MemberVO vo = new MemberVO();
			vo.setMid(doc.get("_id").toString());
			vo.set_id(doc.get("_id").toString());
			vo.setNum(doc.getInteger("num", 0));
			vo.setId(doc.getString("id"));
			vo.setPw(doc.getString("pw"));
			vo.setName(doc.getString("name"));
			vo.setTel(doc.getString("tel"));
			list.add(vo);
		}

		return list;
	}

	@Override
	public List<MemberVO> searchList2(String searchKey, String searchWord, int page, int limit) {
		log.info("searchList()....");
		log.info("searchKey:{}", searchKey);
		log.info("searchWord:{}", searchWord);
		log.info("page:{}",page);
		log.info("limit:{}",limit);
		
		Bson filter = Filters.regex(searchKey, searchWord);
		FindIterable<Document> docs = member.find(filter)
				.sort(new Document("num", -1))
				.skip((page-1)*limit)
				.limit(limit);

		List<MemberVO> list = new ArrayList<MemberVO>();

		for (Document doc : docs) {
			// log.info(doc.toJson());
			MemberVO vo = new MemberVO();
			vo.setMid(doc.get("_id").toString());
			vo.set_id(doc.get("_id").toString());
			vo.setNum(doc.getInteger("num", 0));
			vo.setId(doc.getString("id"));
			vo.setPw(doc.getString("pw"));
			vo.setName(doc.getString("name"));
			vo.setTel(doc.getString("tel"));
			list.add(vo);
		}

		return list;
	}

	@Override
	public MemberVO findOne(MemberVO vo) {
		log.info("findOne()...");

		FindIterable<Document> docs = member.find(new Document("num", vo.getNum()));

		MemberVO vo2 = new MemberVO();
		for (Document doc : docs) {
			log.info(doc.toJson());

			vo2.setMid(doc.get("_id").toString());
			vo2.set_id(doc.get("_id").toString());
			vo2.setNum(doc.getInteger("num", 0));
			vo2.setId(doc.getString("id"));
			vo2.setPw(doc.getString("pw"));
			vo2.setName(doc.getString("name"));
			vo2.setTel(doc.getString("tel"));
		}

		return vo2;
	}

	@Override
	public Document findOneDoc(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> searchList3(int num1, int num2) {
		log.info("searchList3()....");
		log.info("num1:{}", num1);
		log.info("num2:{}", num2);
		
		Bson filter = Filters.and(Filters.gte("num", num1),Filters.lte("num", num2));
		
		FindIterable<Document> docs = member.find(filter).sort(new Document("num", -1));

		List<MemberVO> list = new ArrayList<MemberVO>();

		for (Document doc : docs) {
			// log.info(doc.toJson());
			MemberVO vo = new MemberVO();
			vo.setMid(doc.get("_id").toString());
			vo.set_id(doc.get("_id").toString());
			vo.setNum(doc.getInteger("num", 0));
			vo.setId(doc.getString("id"));
			vo.setPw(doc.getString("pw"));
			vo.setName(doc.getString("name"));
			vo.setTel(doc.getString("tel"));
			list.add(vo);
		}

		return list;
	}

	@Override
	public List<MemberVO> searchList4(int num1, int num2) {
		log.info("searchList4()....");
		log.info("num1:{}", num1);
		log.info("num2:{}", num2);
		
		Bson filter = Filters.in("num", num1,num2);
		
		FindIterable<Document> docs = member.find(filter).sort(new Document("num", -1));

		List<MemberVO> list = new ArrayList<MemberVO>();

		for (Document doc : docs) {
			// log.info(doc.toJson());
			MemberVO vo = new MemberVO();
			vo.setMid(doc.get("_id").toString());
			vo.set_id(doc.get("_id").toString());
			vo.setNum(doc.getInteger("num", 0));
			vo.setId(doc.getString("id"));
			vo.setPw(doc.getString("pw"));
			vo.setName(doc.getString("name"));
			vo.setTel(doc.getString("tel"));
			list.add(vo);
		}

		return list;
	}
	
	

}
