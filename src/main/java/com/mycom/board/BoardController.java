package com.mycom.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/getListBoard.do")
    public String getListBoard(Model model1, Model model2, HttpServletRequest request, BoardVO vo) {
        System.out.println("===>Controller로 getListBoard() 접속");

        int currentPageNo = 0;
        int currentRecord = 0;

        System.out.println("ch1 : "+vo.getCh1());
        System.out.println("ch2 : "+vo.getCh2());

        if(request.getParameter("currentPageNo")!=null) {
            currentPageNo = (Integer.parseInt(request.getParameter("currentPageNo")));
            currentRecord = ((currentPageNo-1)*20);
            if(currentPageNo <= 0){
                currentPageNo = 0;
                currentRecord = currentPageNo*20;
            }
        }

        boardService.getListBoard(vo);
        BoardPaging boardPaging = new BoardPaging(boardService.getTotalCount(), currentPageNo);

        vo.setMinLimit(currentRecord);
        vo.setMaxLimit(boardPaging.getPageSize());

        System.out.println("min"+vo.getMinLimit());


        model1.addAttribute("boardList", boardService.getListBoard(vo));
        model2.addAttribute("boardPage", boardPaging);
        return "/board/listBoard.jsp";
    }

    @RequestMapping(value= "/getBoard.do")
    public String getBoard(BoardVO vo, Model model){
        System.out.println("===>Controller로 getBoard() 접속");
        System.out.println("num = "+vo.getNum());
        model.addAttribute("board",boardService.getBoard(vo));
        return "/board/contentBoard.jsp";
    }

    @RequestMapping(value = "/getUpdateContent.do")
    public String getUpdateContent(BoardVO vo, Model model){
        System.out.println("===>Controller로 getUpdateContent() 접속");
        model.addAttribute("board",boardService.getBoard(vo));
        return "/board/updateBoard.jsp";
    }

    @RequestMapping(value = "/insertBoard.do")
    public String insertBoard(BoardVO vo){
        System.out.println("===>Controller로 insertBoard() 접속");
        boardService.insertBoard(vo);
        return "redirect:getListBoard.do";
    }

    @RequestMapping(value = "/updateBoard.do")
    public String updateBoard(BoardVO vo){
        System.out.println("===>Controller로 updateBoard() 접속");
        boardService.updateBoard(vo);
        return "redirect:getListBoard.do";
    }

    @RequestMapping(value = "/deleteBoard.do")
    public String deleteBoard(BoardVO vo){
        System.out.println("===>Controller로 deleteBoard() 접속");
        boardService.deleteBoard(vo);
        return "redirect:getListBoard.do";
    }

}