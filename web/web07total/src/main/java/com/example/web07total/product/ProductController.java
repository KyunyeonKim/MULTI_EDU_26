package com.example.web07total.product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet({"/p_insert.do","/p_update.do","/p_delete.do","/p_selectOne.do",
        "/p_selectAll.do","/p_searchList.do","/p_insertOK.do","/p_updateOK.do",
"/p_deleteOK.do"})
public class ProductController extends HttpServlet {

    ProductDAO dao = new ProductDAOimpl();

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        String sPath = request.getServletPath();

        System.out.println("sPath:" + sPath);

        if(sPath.equals("/p_insert.do")){
            RequestDispatcher rd = request.getRequestDispatcher("product/insert.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/p_update.do")){

            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);

            ProductVO vo = new ProductVO();
            vo.setId(id);

            ProductVO vo2 = dao.selectOne(vo);

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("product/update.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/p_delete.do")){
            RequestDispatcher rd = request.getRequestDispatcher("product/delete.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/p_selectOne.do")){

            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);

            ProductVO vo = new ProductVO();
            vo.setId(id);

            ProductVO vo2 = dao.selectOne(vo);

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd = request.getRequestDispatcher("product/selectOne.jsp");
            rd.forward(request,response);

        }else if(sPath.equals("/p_selectAll.do")){

            List<ProductVO> list = dao.selectAll();

            request.setAttribute("list",list);

            RequestDispatcher rd = request.getRequestDispatcher("product/selectAll.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/p_searchList.do")){
            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");
            System.out.println(searchKey);
            System.out.println(searchWord);

            List<ProductVO> list = dao.searchList(searchKey,searchWord);
            request.setAttribute("list",list);

            RequestDispatcher rd = request.getRequestDispatcher("product/selectAll.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/p_insertOK.do")){
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String manufacturer = request.getParameter("manufacturer");
            System.out.println(name);
            System.out.println(description);
            System.out.println(manufacturer);

            ProductVO vo = new ProductVO();
            vo.setName(name);
            vo.setDescription(description);
            vo.setManufacturer(manufacturer);

            int result = dao.insert(vo);
            if(result ==1 ){
                System.out.println("insert successed...");
                response.sendRedirect("p_selectAll.do");//서블릿패스
            }else{
                System.out.println("insert failed...");
                response.sendRedirect("p_insert.do");//서블릿패스
            }

        }else if(sPath.equals("/p_updateOK.do")){
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String manufacturer = request.getParameter("manufacturer");
            System.out.println(id);
            System.out.println(name);
            System.out.println(description);
            System.out.println(manufacturer);

            ProductVO vo = new ProductVO();
            vo.setId(Integer.parseInt(id));
            vo.setName(name);
            vo.setDescription(description);
            vo.setManufacturer(manufacturer);

            int result = dao.update(vo);

            if(result ==1 ){
                System.out.println("update successed...");
                response.sendRedirect("p_selectOne.do?id="+id);//서블릿패스
            }else{
                System.out.println("update failed...");
                response.sendRedirect("p_update.do?id="+id);//서블릿패스
            }

        }else if(sPath.equals("/p_deleteOK.do")){
            String id = request.getParameter("id");
            System.out.println(id);

            ProductVO vo = new ProductVO();
            vo.setId(Integer.parseInt(id));

            int result = dao.delete(vo);
            if(result ==1 ){
                System.out.println("delete successed...");
                response.sendRedirect("p_selectAll.do");//서블릿패스
            }else{
                System.out.println("delete failed...");
                response.sendRedirect("p_delete.do?id="+id);//서블릿패스
            }

        }
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request,response);
    }

    public void destroy() {
    }
}
