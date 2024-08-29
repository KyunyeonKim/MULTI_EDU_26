package test.com.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import test.com.member.model.BoardVO;

@Mapper
public interface BoardMapper {

	//추상메소드명(예:insertOK)이 sqlMapper_*.xml 문서의 id와 같아야한다.
	public int insertOK(BoardVO vo);
	
	public List<BoardVO> selectAll();

	public BoardVO selectOne(BoardVO vo);

	public int updateOK(BoardVO vo);
	public int deleteOK(BoardVO vo);

	public List<BoardVO> searchListTitle(String searchWord);

	public List<BoardVO> searchListContent(String searchWord);

}
