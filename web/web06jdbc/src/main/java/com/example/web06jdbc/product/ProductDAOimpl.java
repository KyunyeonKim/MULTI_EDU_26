package com.example.web06jdbc.product;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOimpl implements ProductDAO {
    List<ProductVO> list = new ArrayList<>();



    private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "hr";
    private static final String PASSWORD = "hi123456";
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;


    public ProductDAOimpl() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("driver 성공");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int insert(ProductVO vo) {
        System.out.println("insert()...");
        System.out.println(vo);

        int flag = 0;
        if (list.size() == 0) {
            vo.setNum(1);
        } else {
            vo.setNum(list.get(list.size() - 1).getNum() + 1);
        }
        list.add(vo);
        flag = 1;
        return flag;
    }


    @Override
    public int update(ProductVO vo) {
        System.out.println("update()...");
        System.out.println(vo);

        int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNum() == vo.getNum()) {
                list.set(i, vo);
                flag = 1;
            }
        }
        return flag;
    }


    @Override
    public int delete(ProductVO vo) {
        System.out.println("delete()...");
        System.out.println(vo);
        int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNum() == vo.getNum()) {
                list.remove(i);
                flag = 1;
            }
        }
        return flag;
    }

    @Override
    public ProductVO selectOne(ProductVO vo) {
        System.out.println("selectOne()...");
        System.out.println(vo);

        ProductVO vo2 = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNum() == vo.getNum()) {
                vo2 = list.get(i);
            }
        }

        return vo2;
    }


    @Override
    public List<ProductVO> selectAll() {
        System.out.println("selectAll()...");
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("driver 성공");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }


    @Override
    public List<ProductVO> searchList(String searchKey, String searchWord) {
        System.out.println("searchList()...");
        System.out.println(searchKey);
        System.out.println(searchWord);
        List<ProductVO> vos = new ArrayList<>();

        if (searchKey.equals("pname")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getPname().contains(searchWord)) {
                    vos.add(list.get(i));
                }
            }
        }
        else if(searchKey.equals("model")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getModel().contains(searchWord)) {
                    vos.add(list.get(i));
                }
            }
        }
        return vos;
    }
}

