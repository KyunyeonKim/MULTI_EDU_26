package com.example.web06jdbc.main;

import multi.java20jdbc_oracle.test.test.com.board.BoardDAO;
import multi.java20jdbc_oracle.test.test.com.board.BoardDAOimpl;
import multi.java20jdbc_oracle.test.test.com.board.BoardVO;
import multi.java20jdbc_oracle.test.test.com.product.ProductVO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class BoardMain {
    public static void main(String[] args) throws IOException {
        System.out.println("hello");

       //게시글 프로그램을 메뉴기능을 넣어서 Main09처럼 완성하기
        //BoardVO,BoardDAO,BoardDAOimpl
        //반복문이 종료되기 전까지
        //1.입력,2.수정,3.삭제,4.번호검색,5.모두검색,6.검색어검색 이 반복되도록 작성하세요
        //[x입력시 종료]

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BoardDAO dao = new BoardDAOimpl();

        while(true){
            System.out.println("메뉴를 선택하세요");
            System.out.println("1.입력,2.수정,3.삭제,4.번호검색,5.모두검색,6.검색어검색..[x입력시 종료]");
            String menu = br.readLine();
            System.out.println("==========================");

            //1.insert
            if(menu.equals("1")){
                System.out.println("title:");
                String title = br.readLine();
                System.out.println("content:");
                String content = br.readLine();
                System.out.println("writer:");
                String writer = br.readLine();


                BoardVO vo = new BoardVO();
                vo.setTitle(title);
                vo.setContent(content);
                vo.setWriter(writer);


                int result = dao.insert(vo);
                System.out.println("result:"+result);
                if(result==1){
                    System.out.println("insert successed...");
                }else{
                    System.out.println("inert failed...");
                }
                System.out.println("=================");
            }else if(menu.equals("2")){
                System.out.println("num:");
                int num = Integer.parseInt(br.readLine());
                System.out.println("title:");
                String title = br.readLine();
                System.out.println("content:");
                String content = br.readLine();
                System.out.println("writer:");
                String writer = br.readLine();

                BoardVO vo = new BoardVO();
                vo.setNum(num);
                vo.setTitle(title);
                vo.setContent(content);
                vo.setWriter(writer);

                int result = dao.update(vo);
                System.out.println("result:"+result);
                if(result==1){
                    System.out.println("update successed...");
                }else{
                    System.out.println("update failed...");
                }
                System.out.println("=================");
            }else if(menu.equals("3")){
                System.out.println("num:");
                int num = Integer.parseInt(br.readLine());

                BoardVO vo = new BoardVO();
                vo.setNum(num);

                int result = dao.delete(vo);
                System.out.println("result:"+result);
                if(result==1){
                    System.out.println("delete successed...");
                }else{
                    System.out.println("delete failed...");
                }
                System.out.println("=================");
            }else if(menu.equals("4")){

                System.out.println("num:");
                int num = Integer.parseInt(br.readLine());

                BoardVO vo = new BoardVO();
                vo.setNum(num);

                BoardVO vo2 = dao.selectOne(vo);
                System.out.println(vo2);
                if(vo2 != null){
                    System.out.println("selectOne successed...");
                }else{
                    System.out.println("selectOne failed...");
                }
                System.out.println("=================");
            }else if(menu.equals("5")){
                //5.selectAll
                List<BoardVO> list = dao.selectAll();
                System.out.printf("%3s %5s %8s %10s %10s \n","번호","제목","내용","작성자","작성일자");
                for(BoardVO x : list){
                    //System.out.println(x);
                    System.out.printf("%3d %10s %10s %10s %10s \n",
                            x.getNum(),x.getTitle(),x.getContent(),x.getWriter(),x.getWdate());
                }

                System.out.println("=================");
            }else if(menu.equals("6")){
                //6.searchList
                System.out.println("searchKey[title or content]:");
                String searchKey = br.readLine();

                System.out.println("searchWord:");
                String searchWord = br.readLine();

                List<BoardVO> list = dao.searchList(searchKey,searchWord);
                System.out.printf("%3s %5s %8s %10s %10s \n","번호","제목","내용","작성자","작성일자");
                for(BoardVO x : list){
                    //System.out.println(x);
                    System.out.printf("%3d %10s %10s %10s %10s \n",
                            x.getNum(),x.getTitle(),x.getContent(),x.getWriter(),x.getWdate());
                }
                System.out.println("=================");
            }

            if(menu.equals("x"))break;
        }






        System.out.println("프로그램 종료");

    }//end main
}//end class
