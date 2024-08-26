package test.com.fileupload.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SampleDAOimpl implements SampleDAO {

	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public int insert(SampleVO vo) {
		log.info("insert()...{}",vo);
		return sqlSession.insert("S_INSERT",vo);
	}


	@Override
	public List<SampleVO> selectAll() {
		log.info("selectAll()...");
		return sqlSession.selectList("S_SELECT_ALL");
	}

}
