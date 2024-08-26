    package Controller;

    import board.BoardDAO;
    import board.BoardDAOimpl;
    import board.BoardVO;
    import jakarta.servlet.RequestDispatcher;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;

    import java.io.IOException;
    import java.util.List;

    @WebServlet({
            "/c_insert.do",
            "/c_update.do",
            "/c_delete.do",
            "/search.do",
            "/searchAll.do",
            "/c_insertOK.do",
            "/c_updateOK.do",
            "/c_deleteOK.do",
            "/board.do"
    })
    public class BoardController extends HttpServlet {
        BoardDAO dao = new BoardDAOimpl();

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            String spath = request.getServletPath();
            System.out.println(spath);

            try {
                if (spath.equals("/c_insert.do")) {
                    RequestDispatcher rd = request.getRequestDispatcher("board/insert.jsp");
                    rd.forward(request, response);
                } else if (spath.equals("/board.do")) {
                    RequestDispatcher rd = request.getRequestDispatcher("board/insert.jsp");
                    rd.forward(request, response);

                } else if (spath.equals("/c_update.do")) {
                    String num = request.getParameter("num");
                    BoardVO vo = new BoardVO();
                    vo.setNum(Integer.parseInt(num));
                    BoardVO vo2 = dao.selectOne(vo);
                    request.setAttribute("vo2", vo2);
                    RequestDispatcher rd = request.getRequestDispatcher("board/update.jsp");
                    rd.forward(request, response);
                } else if (spath.equals("/c_delete.do")) {
                    String num = request.getParameter("num");
                    request.setAttribute("num", num);
                    RequestDispatcher rd = request.getRequestDispatcher("board/delete.jsp");
                    rd.forward(request, response);
                } else if (spath.equals("/search.do")) {
                    String num = request.getParameter("num");
                    BoardVO vo = new BoardVO();
                    vo.setNum(Integer.parseInt(num));
                    BoardVO vo2 = dao.selectOne(vo);
                    request.setAttribute("vo2", vo2);
                    RequestDispatcher rd = request.getRequestDispatcher("board/selectOne.jsp");
                    rd.forward(request, response);
                } else if (spath.equals("/searchAll.do")) {
                    List<BoardVO> list = dao.selectAll();
                    request.setAttribute("list", list);
                    RequestDispatcher rd = request.getRequestDispatcher("board/selectAll.jsp");
                    rd.forward(request, response);
                } else if (spath.equals("/c_insertOK.do")) {
                    String title = request.getParameter("title");
                    String content = request.getParameter("content");
                    String writer = request.getParameter("writer");
                    BoardVO vo = new BoardVO();
                    vo.setTitle(title);
                    vo.setContent(content);
                    vo.setWriter(writer);
                    int result = dao.insert(vo);
                    if (result == 1) {
                        System.out.println("Insert succeeded...");
                        response.sendRedirect("searchAll.do");
                    } else {
                        System.out.println("Insert failed...");
                        response.sendRedirect("c_insert.do");
                    }
                } else if (spath.equals("/c_updateOK.do")) {
                    String num = request.getParameter("num");
                    String title = request.getParameter("title");
                    String content = request.getParameter("content");
                    String writer = request.getParameter("writer");
                    BoardVO vo = new BoardVO();
                    vo.setNum(Integer.parseInt(num));
                    vo.setTitle(title);
                    vo.setContent(content);
                    vo.setWriter(writer);
                    int result = dao.update(vo);
                    if (result == 1) {
                        System.out.println("Update succeeded...");
                        response.sendRedirect("search.do?num=" + num);
                    } else {
                        System.out.println("Update failed...");
                        response.sendRedirect("c_update.do?num=" + num);
                    }
                } else if (spath.equals("/c_deleteOK.do")) {
                    String num = request.getParameter("num");
                    BoardVO vo = new BoardVO();
                    vo.setNum(Integer.parseInt(num));
                    int result = dao.delete(vo);
                    if (result == 1) {
                        System.out.println("Delete succeeded...");
                        response.sendRedirect("searchAll.do");
                    } else {
                        System.out.println("Delete failed...");
                        response.sendRedirect("c_delete.do?num=" + num);
                    }
                }
            } catch (NumberFormatException e) {
                // 숫자 포맷 예외 처리
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid number format.");
            }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            doGet(request, response);
        }

        public void destroy() {
        }
    }
