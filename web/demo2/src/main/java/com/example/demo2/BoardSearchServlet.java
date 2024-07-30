package com.example.demo2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "boardSearchServlet", urlPatterns = "/search.do")
public class BoardSearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String title = "Sample Title " + id;
        String content = "Sample Content for item " + id;

        request.setAttribute("title", title);
        request.setAttribute("content", content);
        request.setAttribute("id", id);

        request.getRequestDispatcher("/searchResult.jsp").forward(request, response);
    }
}
