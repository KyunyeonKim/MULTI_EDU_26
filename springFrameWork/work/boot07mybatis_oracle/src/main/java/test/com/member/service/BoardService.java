package test.com.member.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.com.member.mapper.BoardMapper;
import test.com.member.model.BoardVO;
import test.com.member.model.MemberVO;

import java.util.List;

@Service
public class BoardService {


    @Autowired
    BoardMapper mapper;


    public int insertOK(BoardVO vo) {
        return mapper.insertOK(vo);
    }

    public List<BoardVO> selectAll(){
        return mapper.selectAll();
    }

    public BoardVO selectOne(BoardVO vo) {
        return mapper.selectOne(vo);
    }

    public int updateOK(BoardVO vo) {
        return mapper.updateOK(vo);
    }

    public int deleteOK(BoardVO vo) {
        return mapper.deleteOK(vo);
    }

    public List<BoardVO> searchList(String searchKey, String searchWord) {
        if(searchKey.equals("id")) {
            return mapper.searchListId("%"+searchWord+"%");
        }else {
            return mapper.searchListName("%"+searchWord+"%");
        }

    }



}
