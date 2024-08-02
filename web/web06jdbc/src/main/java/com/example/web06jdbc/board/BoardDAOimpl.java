package com.example.web06jdbc.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOimpl implements BoardDAO {

    List<BoardVO> list = new ArrayList<>();


    private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "hr";
    private static final String PASSWORD = "hi123456";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;



    public BoardDAOimpl(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("driver 성공");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insert(BoardVO vo) {
        System.out.println("inert()....");
        System.out.println(vo);
        int flag = 0;

        vo.setNum(list.get(list.size()-1).getNum()+1);
        vo.setWdate(new Timestamp(System.currentTimeMillis()).toString());

        list.add(vo);

        flag = 1;
        return flag;
    }

    @Override
    public int update(BoardVO vo) {
        System.out.println("update()....");
        System.out.println(vo);
        int flag = 0;

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getNum()== vo.getNum()){
                vo.setWdate(new Timestamp(System.currentTimeMillis()).toString());
                list.set(i,vo);
                flag = 1;

            }
        }

        return flag;
    }

    @Override
    public int delete(BoardVO vo) {
        System.out.println("delete()....");
        System.out.println(vo);
        int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getNum()== vo.getNum()){
                list.remove(i);
                flag = 1;
            }
        }
        return flag;
    }

    @Override
    public BoardVO selectOne(BoardVO vo) {
        System.out.println("selectOne()....");
        System.out.println(vo);
        BoardVO vo2 = null;

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getNum()== vo.getNum()){
                vo2 = list.get(i);
            }
        }

        return vo2;
    }

    @Override
    public List<BoardVO> selectAll() {
        System.out.println("selectAll()....");

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("driver 성공");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<BoardVO> searchList(String searchKey, String searchWord) {
        System.out.println("searchList()....");
        System.out.println(searchKey);
        System.out.println(searchWord);
        List<BoardVO> vos = new ArrayList<>();
        if(searchKey.equals("title")){
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getTitle().contains(searchWord)){
                    vos.add(list.get(i));
                }
            }
        }else if(searchKey.equals("content")){
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getContent().contains(searchWord)){
                    vos.add(list.get(i));
                }
            }
        }else{
           vos = list;
        }
        return vos;
    }


}//end class
