package com.example.demo2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "boardServlet", urlPatterns = {"/insert.do", "/update.do", "/delete.do"})
public class BoardServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/insert.do":
                insert(request, response);
                break;
            case "/update.do":
                update(request, response);
                break;
            case "/delete.do":
                delete(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        request.setAttribute("message", "Board item inserted successfully!");
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        request.setAttribute("message", "Board item updated successfully!");
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("message", "Board item deleted successfully!");
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
