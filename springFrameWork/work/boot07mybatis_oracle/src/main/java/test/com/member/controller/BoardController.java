package test.com.member.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import test.com.member.service.BoardService;

@Slf4j
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;



}
