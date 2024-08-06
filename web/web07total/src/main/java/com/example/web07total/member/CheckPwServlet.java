package com.example.web07total.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkPw.do")
public class CheckPwServlet extends HttpServlet {
    private MemberDAO dao;

    public void CheckServlet() {
        dao = new MemberDAOimpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        boolean isAvailable = dao.checkPw(id,pw);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print("{\"available\": " + isAvailable + "}");
        out.flush();
    }
}
