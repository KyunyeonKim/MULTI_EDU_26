package com.example.web07total.comments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentsDAOimpl implements CommentsDAO {

    private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "hr";
    private static final String PASSWORD = "hi123456";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public CommentsDAOimpl() {
        try {
            Class.forName(DRIVER_NAME);
            System.out.println("Driver loaded successfully...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not found", e);
        }
    }

    @Override
    public int insert(CommentsVO vo) {
        System.out.println("insert()....");
        System.out.println(vo);
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established...");

            String sql = "INSERT INTO comments (COMMENT_ID, BOARD_NUM, COMMENT_CONTENT, COMMENTER, COMMENT_DATE) VALUES (seq_comments.NEXTVAL, ?, ?, ?, CURRENT_TIMESTAMP)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, vo.getBoardNum());
            pstmt.setString(2, vo.getCommentContent());
            pstmt.setString(3, vo.getCommenter());

            flag = pstmt.executeUpdate();
            System.out.println("Rows affected: " + flag);
        } catch (SQLException e) {
            throw new RuntimeException("Error executing SQL", e);
        } finally {
            closeResources();
        }
        return flag;
    }

    @Override
    public int update(CommentsVO vo) {
        System.out.println("update()....");
        System.out.println(vo);
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established...");

            String sql = "UPDATE comments SET COMMENT_CONTENT = ?, COMMENTER = ? WHERE COMMENT_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getCommentContent());
            pstmt.setString(2, vo.getCommenter());
            pstmt.setInt(3, vo.getCommentId());

            flag = pstmt.executeUpdate();
            System.out.println("Rows affected: " + flag);
        } catch (SQLException e) {
            throw new RuntimeException("Error executing SQL", e);
        } finally {
            closeResources();
        }
        return flag;
    }

    @Override
    public int delete(CommentsVO vo) {
        System.out.println("delete()....");
        System.out.println(vo);
        int flag = 0;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established...");

            String sql = "DELETE FROM comments WHERE COMMENT_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, vo.getCommentId());

            flag = pstmt.executeUpdate();
            System.out.println("Rows affected: " + flag);
        } catch (SQLException e) {
            throw new RuntimeException("Error executing SQL", e);
        } finally {
            closeResources();
        }
        return flag;
    }

    @Override
    public CommentsVO selectOne(CommentsVO vo) {
        System.out.println("selectOne()....");
        System.out.println(vo);
        CommentsVO vo2 = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established...");

            String sql = "SELECT * FROM comments WHERE COMMENT_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, vo.getCommentId());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                vo2 = new CommentsVO();
                vo2.setCommentId(rs.getInt("COMMENT_ID"));
                vo2.setBoardNum(rs.getInt("BOARD_NUM"));
                vo2.setCommentContent(rs.getString("COMMENT_CONTENT"));
                vo2.setCommenter(rs.getString("COMMENTER"));
                vo2.setCommentDate(rs.getTimestamp("COMMENT_DATE"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error executing SQL", e);
        } finally {
            closeResources();
        }
        return vo2;
    }

    @Override
    public List<CommentsVO> selectAll(int boardNum) {
        System.out.println("selectAll()....");
        List<CommentsVO> list = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established...");

            String sql = "SELECT * FROM comments WHERE BOARD_NUM = ? ORDER BY COMMENT_ID DESC";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardNum);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                CommentsVO vo = new CommentsVO();
                vo.setCommentId(rs.getInt("COMMENT_ID"));
                vo.setBoardNum(rs.getInt("BOARD_NUM"));
                vo.setCommentContent(rs.getString("COMMENT_CONTENT"));
                vo.setCommenter(rs.getString("COMMENTER"));
                vo.setCommentDate(rs.getTimestamp("COMMENT_DATE"));
                list.add(vo);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error executing SQL", e);
        } finally {
            closeResources();
        }
        return list;
    }

    private void closeResources() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException("Error closing ResultSet", e);
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException("Error closing PreparedStatement", e);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException("Error closing Connection", e);
            }
        }
    }
}
