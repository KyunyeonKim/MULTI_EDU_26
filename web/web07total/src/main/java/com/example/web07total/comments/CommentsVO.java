package com.example.web07total.comments;

import java.sql.Timestamp;

public class CommentsVO {

    private int commentId;
    private int boardNum;
    private String commentContent;
    private String commenter;
    private Timestamp commentDate;

    // Getters and Setters
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getBoardNum() {
        return boardNum;
    }

    public void setBoardNum(int boardNum) {
        this.boardNum = boardNum;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }

    public Timestamp getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Timestamp commentDate) {
        this.commentDate = commentDate;
    }

    @Override
    public String toString() {
        return "CommentsVO{" +
                "commentId=" + commentId +
                ", boardNum=" + boardNum +
                ", commentContent='" + commentContent + '\'' +
                ", commenter='" + commenter + '\'' +
                ", commentDate=" + commentDate +
                '}';
    }
}
