package test.com.member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberDAO_JPA extends JpaRepository<MemberVO_JPA, Object> {

	// jpa함수 커스텀(정해진 규칙)
	public List<MemberVO_JPA> findByOrderByNumDesc();
	public List<MemberVO_JPA> findByOrderByNumAsc();
	
	//****JPQL : @Query(객체(대소문자 구분함)를 테이블로 표현하는 쿼리)
	@Query("select vo from MemberVO_JPA vo order by num desc")
	public List<MemberVO_JPA> selectAllDesc_JPQL();
	
	@Query("select vo from MemberVO_JPA vo order by num asc")
	public List<MemberVO_JPA> selectAllAsc_JPQL();
	
	
	//DB쿼리를 그대로 사용가능-복잡한 쿼리문 사용시 권장.
	@Query(nativeQuery = true,value="select * from member_jpa order by num desc")
	public List<MemberVO_JPA> selectAllDesc_Native();
	
	@Query(nativeQuery = true,value="select * from member_jpa order by num asc")
	public List<MemberVO_JPA> selectAllAsc_Native();
	
	@Query(nativeQuery = true,value="select * from member_jpa order by num desc limit ?1,?2")
	public List<MemberVO_JPA> selectAllPageBlock(int startRow, int pageBlock);
	
	
	//selectOne
	public MemberVO_JPA findByNum(int num);
	
	
	//searchList - 대소문자 구분
	public List<MemberVO_JPA> findByIdLike(String searchWord);
	public List<MemberVO_JPA> findByNameLike(String searchWord);
	
	
	//searchList - 대소문자 구분하지 않음
	public List<MemberVO_JPA> findByIdIgnoreCaseLike(String searchWord);
	public List<MemberVO_JPA> findByNameIgnoreCaseLike(String searchWord);
	
	//searchList - 대소문자 구분하지 않음 + 역정렬
	public List<MemberVO_JPA> findByIdIgnoreCaseLikeOrderByNumDesc(String searchWord);
	public List<MemberVO_JPA> findByNameIgnoreCaseLikeOrderByNumDesc(String searchWord);
	
	
	//searchListPageBlock + Native Query(대소문자 구분안함)
	@Query(nativeQuery = true,value="select * from member_jpa "
			+ " where upper(user_id) like upper(?1) "
			+ " order by num desc limit ?2,?3")
	public List<MemberVO_JPA> searchListPageBlockUserId(String searchWord, int startRow, int pageBlock);
	
	@Query(nativeQuery = true,value="select * from member_jpa "
			+ " where upper(user_name) like upper(?1) "
			+ " order by num desc limit ?2,?3")
	public List<MemberVO_JPA> searchListPageBlockUserName(String searchWord, int startRow, int pageBlock);
	
	
	@Query(nativeQuery = true,value="select count(*) total_rows from member_jpa"
			+ " where user_id like ?1")
	public long getSearchTotalRowsId(String searchWord);
	
	@Query(nativeQuery = true,value="select count(*) total_rows from member_jpa"
			+ " where user_name like ?1")
	public long getSearchTotalRowsName(String searchWord);
	
	
	
	

}
