package test.com.member.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberDAOimpl implements MemberDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public int insert(MemberVO vo) {
		log.info("insert()...");
		log.info("{}", vo);

		return sqlSession.insert("M_INSERT", vo);
	}

	@Override
	public int update(MemberVO vo) {
		log.info("update()...");
		log.info("{}", vo);

		return sqlSession.update("M_UPDATE", vo);
	}

	@Override
	public int delete(MemberVO vo) {
		log.info("delete()...");
		log.info("{}", vo);

		return sqlSession.delete("M_DELETE", vo);
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		log.info("selectOne()...");
		log.info("{}", vo);

		return sqlSession.selectOne("M_SELECT_ONE", vo);
	}

	@Override
	public List<MemberVO> selectAll() {
		log.info("selectAll()...");

		return sqlSession.selectList("M_SELECT_ALL");
	}

	@Override
	public List<MemberVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()...");
		log.info("searchKey:{}", searchKey);
		log.info("searchWord:{}", searchWord);
		List<MemberVO> list = null;

		if (searchKey.equals("name")) {
			list = sqlSession.selectList("M_SEARCH_LIST_NAME", "%" + searchWord + "%");
		} else if (searchKey.equals("id")) {
			list = sqlSession.selectList("M_SEARCH_LIST_ID", "%" + searchWord + "%");
		}

		return list;
	}

	@Override
	public MemberVO idCheck(MemberVO vo) {
		log.info("idCheck()....{}",vo);
		
		return sqlSession.selectOne("M_ID_CHECK", vo);
	}
	

}
