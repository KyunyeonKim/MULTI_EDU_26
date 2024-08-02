package com.example.web06jdbc.member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOimpl implements MemberDAO {

    private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "hr";
    private static final String PASSWORD = "hi123456";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public MemberDAOimpl() {
        try {
            Class.forName(DRIVER_NAME);
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load driver", e);
        }
    }

    @Override
    public int insert(MemberVO vo) {
        // Sequence 사용
        String sql = "INSERT INTO members (num, id, pw, name, tel) VALUES (member_seq.NEXTVAL, ?, ?, ?, ?)";
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getId());
            pstmt.setString(2, vo.getPw());
            pstmt.setString(3, vo.getName());
            pstmt.setString(4, vo.getTel());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error during insert", e);
        } finally {
            closeResources();
        }
    }

    @Override
    public int update(MemberVO vo) {
        String sql = "UPDATE members SET id = ?, pw = ?, name = ?, tel = ? WHERE num = ?";
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getId());
            pstmt.setString(2, vo.getPw());
            pstmt.setString(3, vo.getName());
            pstmt.setString(4, vo.getTel());
            pstmt.setInt(5, vo.getNum());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error during update", e);
        } finally {
            closeResources();
        }
    }

    @Override
    public int delete(MemberVO vo) {
        String sql = "DELETE FROM members WHERE num = ?";
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, vo.getNum());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error during delete", e);
        } finally {
            closeResources();
        }
    }

    @Override
    public MemberVO selectOne(MemberVO vo) {
        String sql = "SELECT * FROM members WHERE num = ?";
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, vo.getNum());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                MemberVO resultVo = new MemberVO();
                resultVo.setNum(rs.getInt("num"));
                resultVo.setId(rs.getString("id"));
                resultVo.setPw(rs.getString("pw"));
                resultVo.setName(rs.getString("name"));
                resultVo.setTel(rs.getString("tel"));
                return resultVo;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error during selectOne", e);
        } finally {
            closeResources();
        }
    }

    @Override
    public List<MemberVO> selectAll() {
        List<MemberVO> resultList = new ArrayList<>();
        String sql = "SELECT * FROM members";
        try {
            System.out.println("Attempting to connect to the database...");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection successful.");

            pstmt = conn.prepareStatement(sql);
            System.out.println("Executing query: " + sql);
            rs = pstmt.executeQuery();

            if (!rs.next()) {
                System.out.println("No data found.");
                return resultList;
            }

            do {
                System.out.println("Processing record...");
                MemberVO vo = new MemberVO();
                vo.setNum(rs.getInt("num"));
                vo.setId(rs.getString("id"));
                vo.setPw(rs.getString("pw"));
                vo.setName(rs.getString("name"));
                vo.setTel(rs.getString("tel"));
                resultList.add(vo);
                System.out.println("Added record: " + vo.getId());
            } while (rs.next());

            System.out.println("Number of records retrieved: " + resultList.size());
            return resultList;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error during selectAll", e);
        } finally {
            closeResources();
        }
    }

    @Override
    public List<MemberVO> searchList(String searchKey, String searchWord) {
        String sql = "SELECT * FROM members WHERE " + searchKey + " LIKE ?";
        List<MemberVO> vos = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + searchWord + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                MemberVO vo = new MemberVO();
                vo.setNum(rs.getInt("num"));
                vo.setId(rs.getString("id"));
                vo.setPw(rs.getString("pw"));
                vo.setName(rs.getString("name"));
                vo.setTel(rs.getString("tel"));
                vos.add(vo);
            }
            return vos;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error during searchList", e);
        } finally {
            closeResources();
        }
    }

    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
