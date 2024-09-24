package test.com.member.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<MemberVO> selectAllPageBlock(int cpage, int pageBlock) {
		log.info("selectAllPageBlock");
		log.info("cpage : {}", cpage);
		log.info("pageBlock : {}", pageBlock);

		int startRow = (cpage - 1) * pageBlock + 1;// 오라클 rownum은 1번부터 시작해서 +1

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow - 1);// mysql의 행은 0행부터시작한다. -1해준다
		map.put("pageBlock", pageBlock);

		return sqlSession.selectList("M_SELECT_ALL_PAGE_BLOCK", map);
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
	public List<MemberVO> searchListPageBlock(int cpage, int pageBlock, String searchKey, String searchWord) {
		log.info("searchListPageBlock()...");
		log.info("searchKey:{}", searchKey);
		log.info("searchWord:{}", searchWord);
		log.info("cpage : {}", cpage);
		log.info("pageBlock : {}", pageBlock);

		int startRow = (cpage - 1) * pageBlock + 1;// 오라클 rownum은 1번부터 시작해서 +1

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", startRow - 1);// mysql의 행은 0행부터시작한다. -1해준다
		map.put("pageBlock", pageBlock);
		map.put("searchWord", "%" + searchWord + "%");

		List<MemberVO> list = null;

		if (searchKey.equals("name")) {
			list = sqlSession.selectList("M_SEARCH_LIST_PAGE_BLOCK_NAME", map);
		} else if (searchKey.equals("id")) {
			list = sqlSession.selectList("M_SEARCH_LIST_PAGE_BLOCK_ID", map);
		}

		return list;
	}

	@Override
	public int getTotalRows() {
		log.info("getTotalRows()...");

		return sqlSession.selectOne("M_TOTAL_ROWS");
	}

	@Override
	public int getSearchListTotalRows(String searchKey, String searchWord) {
		log.info("getSearchListTotalRows()...");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchWord", "%" + searchWord + "%");

		if (searchKey.equals("name")) {
			return sqlSession.selectOne("M_SEARCH_LIST_TOTAL_ROWS_NAME", map);
		} else {
			return sqlSession.selectOne("M_SEARCH_LIST_TOTAL_ROWS_ID", map);
		}

	}

	@Override
	public MemberVO login(MemberVO vo) {
		log.info("login()....{}", vo);

		return sqlSession.selectOne("M_LOG_IN", vo);
	}

}
