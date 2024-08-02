package com.example.web07total.comments;

import java.util.List;

public interface CommentsDAO {
    int insert(CommentsVO vo);
    int update(CommentsVO vo);
    int delete(CommentsVO vo);
    CommentsVO selectOne(CommentsVO vo);
    List<CommentsVO> selectAll(int boardNum);
}
