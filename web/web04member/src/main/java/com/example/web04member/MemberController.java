package com.example.web04member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/memberInsert.do", "/memberUpdate.do", "/memberDelete.do", "/memberSelectOne.do",
        "/memberSelectAll.do", "/memberInsertOK.do", "/memberUpdateOK.do", "/memberDeleteOK.do"})
public class MemberController extends HttpServlet {

    private List<MemberVO> memberList = new ArrayList<>();

    @Override
    public void init()  {
        memberList.add(new MemberVO(1, "홍길동", "hong@example.com", "010-0000-5678"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String sPath = request.getServletPath();
        System.out.println("sPath: " + sPath);

        if (sPath.equals("/memberInsert.do")) {
            RequestDispatcher rd = request.getRequestDispatcher("member/insert.jsp");
            rd.forward(request, response);

        } else if (sPath.equals("/memberUpdate.do")) {
            int id = Integer.parseInt(request.getParameter("id"));
            MemberVO member = getMemberById(id);
            request.setAttribute("member", member);
            RequestDispatcher rd = request.getRequestDispatcher("member/update.jsp");
            rd.forward(request, response);

        } else if (sPath.equals("/memberDelete.do")) {
            int id = Integer.parseInt(request.getParameter("id"));
            MemberVO member = getMemberById(id);
            request.setAttribute("member", member);
            RequestDispatcher rd = request.getRequestDispatcher("member/delete.jsp");
            rd.forward(request, response);

        } else if (sPath.equals("/memberSelectOne.do")) {
            int id = Integer.parseInt(request.getParameter("id"));
            MemberVO member = getMemberById(id);
            request.setAttribute("member", member);
            RequestDispatcher rd = request.getRequestDispatcher("member/selectOne.jsp");
            rd.forward(request, response);

        } else if (sPath.equals("/memberSelectAll.do")) {
            request.setAttribute("memberList", memberList);
            RequestDispatcher rd = request.getRequestDispatcher("member/selectAll.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String sPath = request.getServletPath();
        System.out.println("sPath: " + sPath);

        if (sPath.equals("/memberInsertOK.do")) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");

            // 더미 데이터 추가
            int id = memberList.size() + 1;
            MemberVO newMember = new MemberVO(id, name, email, phone);
            memberList.add(newMember);

            // 작성 완료 후 리디렉션
            response.sendRedirect(request.getContextPath() + "/memberSelectAll.do");

        } else if (sPath.equals("/memberUpdateOK.do")) {
            // 업데이트 처리
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");

            for (int i = 0; i < memberList.size(); i++) {
                MemberVO member = memberList.get(i);
                if (member.getId() == id) {
                    member.setName(name);
                    member.setEmail(email);
                    member.setPhone(phone);
                    break;
                }
            }

            response.sendRedirect(request.getContextPath() + "/memberSelectAll.do");

        } else if (sPath.equals("/memberDeleteOK.do")) {
            // 삭제 처리
            int id = Integer.parseInt(request.getParameter("id"));
            for (int i = 0; i < memberList.size(); i++) {
                if (memberList.get(i).getId() == id) {
                    memberList.remove(i);
                    break;
                }
            }
            response.sendRedirect(request.getContextPath() + "/memberSelectAll.do");
        }
    }

    private MemberVO getMemberById(int id) {
        for (int i = 0; i < memberList.size(); i++) {
            MemberVO member = memberList.get(i);
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Servlet destroyed");
    }
}
