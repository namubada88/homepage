package com.mycom.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/insertBoardForm.do")
    public String insertForm(){
        return "/board/insertBoard.jsp";
    }

    @RequestMapping(value = "/getListBoard.do")
    public String getListBoard(Model model, HttpServletRequest request, BoardVO vo) {
        System.out.println("===>Controller로 getListBoard() 접속");

        int currentPageNo = 0;
        int currentRecord = 0;

        if(request.getParameter("currentPageNo")!=null) {
            currentPageNo = (Integer.parseInt(request.getParameter("currentPageNo")));
            currentRecord = ((currentPageNo-1)*20);
            if(currentPageNo <= 0){
                currentPageNo = 0;
                currentRecord = currentPageNo*20;
            }
        }

        if(request.getParameter("ch1")!=null){
            vo.setCh1(request.getParameter("ch1"));
        }
        if(request.getParameter("ch2")!=null){
            vo.setCh2(request.getParameter("ch2"));
        }

        System.out.println("ch1 : "+vo.getCh1());
        System.out.println("ch2 : "+vo.getCh2());

        boardService.getListBoard(vo);
        BoardPaging boardPaging = new BoardPaging(boardService.getTotalCount(), currentPageNo);

        vo.setMinLimit(currentRecord);
        vo.setMaxLimit(boardPaging.getPageSize());

        model.addAttribute("boardList", boardService.getListBoard(vo));
        model.addAttribute("boardPage", boardPaging);
        model.addAttribute("ch1", vo.getCh1());
        model.addAttribute("ch2", vo.getCh2());
        return "/board/listBoard.jsp";
    }

    @RequestMapping(value= "/getBoard.do")
    public String getBoard(BoardVO vo, Model model){
        System.out.println("===>Controller로 getBoard() 접속");
        System.out.println("num = "+vo.getNum());
        model.addAttribute("board",boardService.getBoard(vo));
        return "/board/contentBoard.jsp";
    }

    @RequestMapping(value = "/getUpdateBoardContent.do")
    public String getUpdateContent(BoardVO vo, Model model, HttpServletRequest request){
        System.out.println("===>Controller로 getUpdateContent() 접속");
        BoardVO m = boardService.getBoard(vo);
        String passwd = request.getParameter("passwd");
        if(!passwd.equals(m.getPasswd())){
            model.addAttribute("num", vo.getNum());
            return "/board/errorPasswd.jsp?num="+vo.getNum()+"";
        }
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
    public String deleteBoard(BoardVO vo, HttpServletRequest request, Model model){
        System.out.println("===>Controller로 deleteBoard() 접속");
        BoardVO m = boardService.getBoard(vo);
        String passwd = request.getParameter("passwd");
        if(!passwd.equals(m.getPasswd())){
            System.out.println("getupdate 접똑!");
            model.addAttribute("num", vo.getNum());
            return "/board/errorPasswd.jsp?num="+vo.getNum()+"";
        }
        boardService.deleteBoard(vo);
        return "redirect:getListBoard.do";
    }

}