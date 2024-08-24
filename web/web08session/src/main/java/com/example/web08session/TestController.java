package com.example.web08session;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({"/login.do","/loginOK.do","/logout.do"})
public class TestController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {


        String sPath = request.getServletPath();
        System.out.println(sPath);

        if(sPath.equals("/home.do")){
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/login.do")){
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/loginOK.do")){
            String id = request.getParameter("id");
            String pw = request.getParameter("pw");
            System.out.println(id);
            System.out.println(pw);

            //dao.login(vo);//로그인 성공실패 리턴 null
            //성공했다라고 가정
            HttpSession session = request.getSession();
            session.setAttribute("user_id",id);//EL${user_id}
            session.setAttribute("name","kim");//EL${user_id}
            session.setMaxInactiveInterval(5*60);//5분




            response.sendRedirect("home.do");
        }else if(sPath.equals("/logout.do")){
            //로그아웃에 적용할 메소드들
            HttpSession session = request.getSession();
            //session.removeAttribute("user_id");//속성제거
            session.invalidate();//세션 제거
            response.sendRedirect("home.do");
        }

    }//end doGet...

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request,response);
    }

    public void destroy() {
    }
}