package com.example.web07total.comments;

import com.example.web07total.board.BoardDAO;
import com.example.web07total.board.BoardDAOimpl;
import com.example.web07total.board.BoardVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet({"/c_insertOK.do", "/c_update.do", "/c_deleteOK.do", "/c_selectOne.do"})
public class CommentsController extends HttpServlet {

    private CommentsDAO dao = new CommentsDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String sPath = request.getServletPath();

        System.out.println("sPath: " + sPath);

        if (sPath.equals("/c_selectOne.do")) {
            // 게시글 번호를 파라미터에서 가져옴
            int boardNum = Integer.parseInt(request.getParameter("num"));
            System.out.println("Board number: " + boardNum);

            // 게시글 조회
            BoardVO boardVO = new BoardVO();
            boardVO.setNum(boardNum);
            BoardDAO boardDAO = new BoardDAOimpl();
            BoardVO boardDetails = boardDAO.selectOne(boardVO);

            // 댓글 목록 조회
            List<CommentsVO> commentsList = dao.selectAll(boardNum);

            request.setAttribute("board", boardDetails);
            request.setAttribute("commentsList", commentsList);

            RequestDispatcher rd = request.getRequestDispatcher("board/selectOne.jsp");
            rd.forward(request, response);

        } else if (sPath.equals("/c_update.do")) {
            // 댓글 번호를 파라미터에서 가져옴
            int commentId = Integer.parseInt(request.getParameter("num"));
            CommentsVO commentVO = new CommentsVO();
            commentVO.setCommentId(commentId);
            CommentsVO commentDetails = dao.selectOne(commentVO);

            request.setAttribute("comment", commentDetails);
            request.setAttribute("boardNum", request.getParameter("boardNum"));

            RequestDispatcher rd = request.getRequestDispatcher("comments/update.jsp");
            rd.forward(request, response);

        } else if (sPath.equals("/c_deleteOK.do")) {
            // 댓글 번호와 게시글 번호를 파라미터에서 가져옴
            int commentId = Integer.parseInt(request.getParameter("num"));
            int boardNum = Integer.parseInt(request.getParameter("boardNum"));

            CommentsVO commentVO = new CommentsVO();
            commentVO.setCommentId(commentId);

            int result = dao.delete(commentVO);

            if (result == 1) {
                System.out.println("Delete succeeded...");
                response.sendRedirect("c_selectOne.do?num=" + boardNum);
            } else {
                System.out.println("Delete failed...");
                response.sendRedirect("c_selectOne.do?num=" + boardNum);
            }

        } else if (sPath.equals("/c_insertOK.do")) {
            // 댓글 내용, 작성자, 게시글 번호를 파라미터에서 가져옴
            String content = request.getParameter("content");
            String writer = request.getParameter("writer");
            int boardNum = Integer.parseInt(request.getParameter("boardNum"));

            CommentsVO commentVO = new CommentsVO();
            commentVO.setCommentContent(content); // 수정된 부분
            commentVO.setCommenter(writer); // 수정된 부분
            commentVO.setBoardNum(boardNum); // 수정된 부분

            int result = dao.insert(commentVO);

            if (result == 1) {
                System.out.println("Insert succeeded...");
                response.sendRedirect("c_selectOne.do?num=" + boardNum);
            } else {
                System.out.println("Insert failed...");
                response.sendRedirect("c_selectOne.do?num=" + boardNum);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
