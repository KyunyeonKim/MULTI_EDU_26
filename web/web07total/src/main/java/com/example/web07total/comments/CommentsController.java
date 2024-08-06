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

        try {
            if (sPath.equals("/c_selectOne.do")) {
                // 게시글 번호를 파라미터에서 가져옴
                String numParam = request.getParameter("num");
                if (numParam != null && !numParam.trim().isEmpty()) {
                    int boardNum = Integer.parseInt(numParam);
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
                } else {
                    // 오류 처리: 파라미터가 없거나 비어 있음
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid board number.");
                }

            } else if (sPath.equals("/c_update.do")) {
                // 댓글 번호를 파라미터에서 가져옴
                String numParam = request.getParameter("num");
                if (numParam != null && !numParam.trim().isEmpty()) {
                    int commentId = Integer.parseInt(numParam);
                    CommentsVO commentVO = new CommentsVO();
                    commentVO.setCommentId(commentId);
                    CommentsVO commentDetails = dao.selectOne(commentVO);

                    request.setAttribute("comment", commentDetails);
                    request.setAttribute("boardNum", request.getParameter("boardNum"));

                    RequestDispatcher rd = request.getRequestDispatcher("comments/update.jsp");
                    rd.forward(request, response);
                } else {
                    // 오류 처리: 파라미터가 없거나 비어 있음
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid comment ID.");
                }

            } else if (sPath.equals("/c_deleteOK.do")) {
                // 댓글 번호를 파라미터에서 가져옴
                String numParam = request.getParameter("num");

                if (numParam != null && !numParam.trim().isEmpty()) {
                    int commentId = Integer.parseInt(numParam);

                    CommentsVO commentVO = new CommentsVO();
                    commentVO.setCommentId(commentId);

                    int result = dao.delete(commentVO);

                    if (result == 1) {
                        System.out.println("Delete succeeded...");
                    } else {
                        System.out.println("Delete failed...");
                    }
                    // 댓글 삭제 후 원래 페이지로 리다이렉트
                    // 게시글 번호를 리다이렉트에 사용하기 위해 /c_selectOne.do로 리다이렉트 시 게시글 번호가 필요함
                    response.sendRedirect("c_selectOne.do?num=" + request.getParameter("boardNum"));
                } else {
                    // 오류 처리: 파라미터가 없거나 비어 있음
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid parameters for deletion.");
                }

            } else if (sPath.equals("/c_insertOK.do")) {
                // 댓글 내용, 작성자, 게시글 번호를 파라미터에서 가져옴
                String content = request.getParameter("content");
                String writer = request.getParameter("writer");
                String boardNumParam = request.getParameter("boardNum");

                if (content != null && !content.trim().isEmpty() &&
                        writer != null && !writer.trim().isEmpty() &&
                        boardNumParam != null && !boardNumParam.trim().isEmpty()) {
                    int boardNum = Integer.parseInt(boardNumParam);

                    CommentsVO commentVO = new CommentsVO();
                    commentVO.setCommentContent(content); // 수정된 부분
                    commentVO.setCommenter(writer); // 수정된 부분
                    commentVO.setBoardNum(boardNum); // 수정된 부분

                    int result = dao.insert(commentVO);

                    if (result == 1) {
                        System.out.println("Insert succeeded...");
                    } else {
                        System.out.println("Insert failed...");
                    }
                    response.sendRedirect("c_selectOne.do?num=" + boardNum);
                } else {
                    // 오류 처리: 파라미터가 없거나 비어 있음
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid parameters for insertion.");
                }
            }
        } catch (NumberFormatException e) {
            // 숫자 포맷 예외 처리
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid number format.");
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
