package com.example.web06jdbc.main;



import multi.java20jdbc_oracle.test.test.com.product.ProductDAO;
import multi.java20jdbc_oracle.test.test.com.product.ProductDAOimpl;
import multi.java20jdbc_oracle.test.test.com.product.ProductVO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ProductMain {

    public static void main(String[] args) throws IOException {
        System.out.println("hello");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ProductDAO dao = new ProductDAOimpl();

        while(true){
            System.out.println("메뉴를 선택하세요");
            System.out.println("1.입력, 2.수정, 3.삭제, 4.번호검색, 5.모두검색, 6.검색어검색.. [x입력시 종료]");
            String menu = br.readLine();
            System.out.println("==========================");

            //1.insert
            if(menu.equals("1")){
                System.out.println("pname:");
                String pname = br.readLine();
                System.out.println("model:");
                String model = br.readLine();
                System.out.println("price:");
                int price = Integer.parseInt(br.readLine());
                System.out.println("count:");
                int count = Integer.parseInt(br.readLine());

                ProductVO vo = new ProductVO();
                vo.setPname(pname);
                vo.setModel(model);
                vo.setPrice(price);
                vo.setCount(count);


                int result = dao.insert(vo);
                System.out.println("result : " + result);
                if(result==1){
                    System.out.println("insert successed...");
                }else{
                    System.out.println("inert failed...");
                }
                System.out.println("=========================");
            }



            //update
            else if(menu.equals("2")){
                System.out.println("num:");
                int num = Integer.parseInt(br.readLine());
                System.out.println("pname:");
                String pname = br.readLine();
                System.out.println("model:");
                String model = br.readLine();
                System.out.println("price:");
                int price = Integer.parseInt(br.readLine());
                System.out.println("count:");
                int count = Integer.parseInt(br.readLine());

                ProductVO vo = new ProductVO();
                vo.setNum(num);
                vo.setPname(pname);
                vo.setModel(model);
                vo.setPrice(price);
                vo.setCount(count);

                int result = dao.update(vo);
                System.out.println("result : " + result);
                if(result==1){
                    System.out.println("update successed...");
                }else{
                    System.out.println("update failed...");
                }
                System.out.println("=======================");
            }



            //delete
            else if(menu.equals("3")){
                System.out.println("num:");
                int num = Integer.parseInt(br.readLine());

                ProductVO vo = new ProductVO();
                vo.setNum(num);

                int result = dao.delete(vo);
                System.out.println("result : " + result);
                if(result==1){
                    System.out.println("delete successed...");
                }else{
                    System.out.println("delete failed...");
                }
                System.out.println("======================");
            }



            //searchOne
            else if(menu.equals("4")){
                System.out.println("num:");
                int num = Integer.parseInt(br.readLine());

                ProductVO vo = new ProductVO();
                vo.setNum(num);

                ProductVO vo2 = dao.selectOne(vo);
                System.out.println(vo2);

                if(vo2 != null){
                    System.out.println("selectOne successed...");
                }else{
                    System.out.println("selectOne failed...");
                }
                System.out.println("======================");
            }
            else if(menu.equals("5")){
                //5.selectAll
                List<ProductVO> list = dao.selectAll();
                System.out.printf("%3s %8s %10s %10s %10s \n","번호","제품명","모델명","단가","재고");
                for(ProductVO x : list){
                    System.out.printf("%3d %15s %10s %10d %10d \n",
                            x.getNum(),x.getPname(),x.getModel(),x.getPrice(),x.getCount());
                }
                System.out.println("======================");
            }
            //6.searchList
            else if(menu.equals("6")){
                System.out.println("searchKey[pname or model]:");
                String searchKey = br.readLine();

                System.out.println("searchWord:");
                String searchWord = br.readLine();

                List<ProductVO> list = dao.searchList(searchKey,searchWord);
                System.out.printf("%3s %8s %10s %10s %10s \n","번호","제품명","모델명","단가","재고");
                for(ProductVO x : list){
                    System.out.printf("%3d %15s %10s %10d %10d \n",
                            x.getNum(),x.getPname(),x.getModel(),x.getPrice(),x.getCount());
                }
                System.out.println("======================");
            }

            if(menu.equals("x")) break;
        }

        System.out.println("프로그램 종료");


    }//end main
}//end class
