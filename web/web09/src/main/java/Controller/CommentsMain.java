package Controller;

import comments.CommentsDAO;
import comments.CommentsDAOimpl;
import comments.CommentsVO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class CommentsMain {
    public static void main(String[] args) throws IOException {

        //mission
        //해당 게시글에 작성된 댓글기능을 구현하세요
        //java : CommentsVO,CommentsDAO,CommentsDAOimpl,CommentsMain
        //oracle db : comments - num(PK),content,writer,wdate,bnum(FK)

        CommentsDAO dao = new CommentsDAOimpl();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.println("메뉴를 선택하세요");
            System.out.println("1.입력,2.수정,3.삭제,4.번호검색,5.모두검색,6.검색어검색..[x입력시 종료]");
            String menu = br.readLine();
            System.out.println("==========================");

            //1.insert
            if(menu.equals("1")){
                System.out.println("bnum:");
                int bnum = Integer.parseInt(br.readLine());
                System.out.println("content:");
                String content = br.readLine();
                System.out.println("writer:");
                String writer = br.readLine();


                CommentsVO vo = new CommentsVO();
                vo.setBnum(bnum);
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
            }
            else if(menu.equals("2")){
                System.out.println("num:");
                int num = Integer.parseInt(br.readLine());

                System.out.println("content:");
                String content = br.readLine();


                CommentsVO vo = new CommentsVO();
                vo.setNum(num);
                vo.setContent(content);

                int result = dao.update(vo);
                System.out.println("result:"+result);
                if(result==1){
                    System.out.println("update successed...");
                }else{
                    System.out.println("update failed...");
                }
                System.out.println("=================");
            }
            else if(menu.equals("3")){
                System.out.println("num:");
                int num = Integer.parseInt(br.readLine());

                CommentsVO vo = new CommentsVO();
                vo.setNum(num);

                int result = dao.delete(vo);
                System.out.println("result:"+result);
                if(result==1){
                    System.out.println("delete successed...");
                }else{
                    System.out.println("delete failed...");
                }
                System.out.println("=================");
            }
            else if(menu.equals("4")){

                System.out.println("num:");
                int num = Integer.parseInt(br.readLine());

                CommentsVO vo = new CommentsVO();
                vo.setNum(num);

                CommentsVO vo2 = dao.selectOne(vo);
                System.out.println(vo2);
                if(vo2 != null){
                    System.out.println("selectOne successed...");
                }else{
                    System.out.println("selectOne failed...");
                }
                System.out.println("=================");
            }
            else if(menu.equals("5")){
                System.out.println("bnum:");
                int bnum = Integer.parseInt(br.readLine());
                //5.selectAll
                List<CommentsVO> list = dao.selectAll(bnum);
                System.out.printf("%s %5s %8s %10s %10s \n","게시글번호","댓글번호","내용","작성자","작성일자");
                for(CommentsVO x : list){
                    //System.out.println(x);
                    System.out.printf("%8d %8d %10s %10s %10s \n",
                            x.getBnum(),x.getNum(),x.getContent(),x.getWriter(),x.getWdate());
                }

                System.out.println("=================");
            }
            else if(menu.equals("6")){
                //6.searchList
                System.out.println("searchKey[writer or content]:");
                String searchKey = br.readLine();

                System.out.println("searchWord:");
                String searchWord = br.readLine();

                System.out.println("bnum:");
                int bnum = Integer.parseInt(br.readLine());

                List<CommentsVO> list = dao.searchList(searchKey,searchWord,bnum);
                System.out.printf("%3s %5s %8s %10s %10s \n","게시글번호","댓글번호","내용","작성자","작성일자");
                for(CommentsVO x : list){
                    //System.out.println(x);
                    System.out.printf("%8d %8d %10s %10s %10s \n",
                            x.getBnum(),x.getNum(),x.getContent(),x.getWriter(),x.getWdate());
                }
                System.out.println("=================");
            }

            if(menu.equals("x"))break;
        }






        System.out.println("프로그램 종료");


    }//end main
}//end class
