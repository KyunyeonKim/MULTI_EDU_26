package Controller;


import member.MemberDAO;
import member.MemberDAOimpl;
import member.MemberVO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MemberController {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MemberDAO dao = new MemberDAOimpl();
}

