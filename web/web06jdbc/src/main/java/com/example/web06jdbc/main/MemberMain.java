package com.example.web06jdbc.main;

import multi.java20jdbc_oracle.test.test.com.member.MemberDAO;
import multi.java20jdbc_oracle.test.test.com.member.MemberDAOimpl;
import multi.java20jdbc_oracle.test.test.com.member.MemberVO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MemberMain {
    public static void main(String[] args) throws IOException {
        System.out.println("hello");

       //Main05프로그램을 메뉴기능을 넣어서 Main08처럼 완성하기
        //반복문이 종료되기 전까지
        //1.입력,2.수정,3.삭제,4.번호검색,5.모두검색,6.검색어검색 이 반복되도록 작성하세요
        //[x입력시 종료]

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MemberDAO dao = new MemberDAOimpl();
        while(true){
            System.out.println("메뉴를 선택하세요");
            System.out.println("1.입력,2.수정,3.삭제,4.번호검색,5.모두검색,6.검색어검색..[x입력시 종료]");
            String menu = br.readLine();
            System.out.println("==========================");
            //menu = "x";
            if(menu.equals("1")){
                //입력
                System.out.println("id:");
                String id = br.readLine();
                System.out.println("pw:");
                String pw = br.readLine();
                System.out.println("name:");
                String name = br.readLine();
                System.out.println("tel:");
                String tel = br.readLine();

                MemberVO vo = new MemberVO();
                vo.setId(id);
                vo.setPw(pw);
                vo.setName(name);
                vo.setTel(tel);

                int result = dao.insert(vo);
                System.out.println("result:"+result);
                if(result==1){
                    System.out.println("insert successed");
                }else{
                    System.out.println("insert failed");
                }
                System.out.println("=======================");
            }else if(menu.equals("2")){
                //수정
                System.out.println("num:");
                int num = Integer.parseInt(br.readLine());
                System.out.println("id:");
                String id = br.readLine();
                System.out.println("pw:");
                String pw = br.readLine();
                System.out.println("name:");
                String name = br.readLine();
                System.out.println("tel:");
                String tel = br.readLine();


                MemberVO vo = new MemberVO();
                vo.setNum(num);
                vo.setId(id);
                vo.setPw(pw);
                vo.setName(name);
                vo.setTel(tel);

                int result = dao.update(vo);
                System.out.println("result:"+result);

                if(result==1){
                    System.out.println("update successed");
                }else{
                    System.out.println("update failed");
                }
                System.out.println("=======================");
            }else if(menu.equals("3")){
                //삭제
                System.out.println("num:");
                int num = Integer.parseInt(br.readLine());

                MemberVO vo = new MemberVO();
                vo.setNum(num);

                int result = dao.delete(vo);
                System.out.println("result:"+result);
                if(result==1){
                    System.out.println("delete successed");
                }else{
                    System.out.println("delete failed");
                }
                System.out.println("=======================");
            }else if(menu.equals("4")){
                //번호검색
                System.out.println("num:");
                int num = Integer.parseInt(br.readLine());

                MemberVO vo = new MemberVO();
                vo.setNum(num);

                MemberVO vo2 = dao.selectOne(vo);

                if(vo2 != null){
                    System.out.println("selectOne successed");
                }else{
                    System.out.println("selectOne failed");
                }
                System.out.println(vo2);
                System.out.println("=======================");
            }else if(menu.equals("5")){
                System.out.println("aa");
                //모두검색
                List<MemberVO> list = dao.selectAll();
                System.out.printf("%3s %2s %8s %10s %10s \n","번호","ID","PW","NAME","TEL");

                System.out.println("bb");
                for(MemberVO x: list){
                    //System.out.println(x);
                    System.out.printf("%3s %5s %8s %7s %10s \n",
                            x.getNum(),x.getId(),x.getPw(),x.getName(),x.getTel());
                    System.out.println("cc");

                }
                if(list.size()==0)System.out.println("selectAll failed");
                System.out.println("=======================");
            }else if(menu.equals("6")){
                //검색어검색
                System.out.println("searchKey:");
                String searchKey = br.readLine();
                System.out.println("searchWord:");
                String searchWord = br.readLine();
                List<MemberVO> list = dao.searchList(searchKey,searchWord);
                System.out.printf("%3s %2s %8s %10s %10s \n","번호","ID","PW","NAME","TEL");

                for(MemberVO x: list){
                    //System.out.println(x);
                    System.out.printf("%3s %5s %8s %7s %10s \n",
                            x.getNum(),x.getId(),x.getPw(),x.getName(),x.getTel());

                }
                if(list.size()==0)System.out.println("searchList failed");
                System.out.println("=======================");
            }
            //menu = "x";
            if(menu.equals("x"))break;
        }


        System.out.println("프로그램 종료");

    }//end main
}//end class
