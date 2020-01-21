package com.mycom.fun;

import com.mycom.board.BoardVO;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

@Controller
public class FunController {
    @Autowired
    FunService funService;

    @RequestMapping(value = "/insertForm.do")
    public String insertForm(){
        return "/fun/insertFun.jsp";
    }

    @RequestMapping(value = "/getListFun.do")
    public String getListFun(Model model, HttpServletRequest request, FunVO vo){
        System.out.println();

        int currentPageNo = 0;
        int currentRecord = 0;

        if(request.getParameter("currentPageNo")!=null){
            currentPageNo = (Integer.parseInt(request.getParameter("currentPageNo")));
            //현재 페이지 레코드 갯수 표시를 위해서는 현재 페이지에서 -1을 해야 함
            currentRecord = ((currentPageNo-1)*20);

            //현재 페이지가 0보다 작을 경우 default 값이 0이 되도록 설정
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

        funService.getListFun(vo);
        FunPaging funPaging = new FunPaging(funService.getCountFun(), currentPageNo);

        //Sql limit에 들어갈 min과 max setting
        vo.setMinLimit(currentRecord);
        vo.setMaxLimit(funPaging.getPageSize());

        model.addAttribute("funList", funService.getListFun(vo));
        model.addAttribute("funPage", funPaging);
        model.addAttribute("ch1", vo.getCh1());
        model.addAttribute("ch2", vo.getCh2());

        return "/fun/listFun.jsp";

    }
    @RequestMapping(value = "/insertFun.do")
    public String insertFun(FunVO vo, HttpServletRequest request) throws IOException {
        System.out.println("===>Controller로 insertFun() 접속");
        System.out.println("writer : "+vo.getWriter());



        MultipartFile uploadFile1 = vo.getUploadFile1();
        MultipartFile uploadFile2 = vo.getUploadFile2();
        MultipartFile uploadFile3 = vo.getUploadFile3();
        String genId1 = UUID.randomUUID().toString().substring(5,12);
        String genId2 = UUID.randomUUID().toString().substring(5,12);
        String genId3 = UUID.randomUUID().toString().substring(5,12);


        String RealPath = request.getSession().getServletContext().getRealPath("/fileSave/");
        System.out.println("RealPath : "+RealPath);

        if(!uploadFile1.isEmpty()){
            System.out.println("접속1");
            String originalFileName1 = uploadFile1.getOriginalFilename();
            System.out.println("파일명1 : "+originalFileName1);
            String saveFileName1 = genId1 + "." + FilenameUtils.getExtension(originalFileName1);
            uploadFile1.transferTo(new File(RealPath+saveFileName1));
            vo.setFileName1(saveFileName1);
        }
        if(!uploadFile2.isEmpty()){
            System.out.println("접속2");
            String originalFileName2 = uploadFile2.getOriginalFilename();
            System.out.println("파일명2 : "+originalFileName2);
            String saveFileName2 = genId2 + "." + FilenameUtils.getExtension(originalFileName2);
            uploadFile2.transferTo(new File(RealPath+saveFileName2));
            vo.setFileName2(saveFileName2);
        }

        if(!uploadFile3.isEmpty()){
            System.out.println("접속3");
            String originalFileName3 = uploadFile3.getOriginalFilename();
            System.out.println("파일명3 : "+originalFileName3);
            String saveFileName3 = genId3 + "." + FilenameUtils.getExtension(originalFileName3);
            uploadFile3.transferTo(new File(RealPath+saveFileName3));
            vo.setFileName3(saveFileName3);
        }

        funService.insertFun(vo);
        return "redirect:getListFun.do";
    }

    @RequestMapping(value = "getFun.do")
    public String  getFun(FunVO vo, Model model){
        System.out.println("===>Controller로 getFun 접속");
        model.addAttribute("fun",funService.getFun(vo));
        return "/fun/contentFun.jsp";
    }

    @RequestMapping(value = "/getUpdateFunContent.do")
    public String getUpdateContent(FunVO vo, Model model, HttpServletRequest request){
        System.out.println("===>Controller로 getUpdateContent() 접속");
        FunVO m = funService.getFun(vo);
        String passwd = request.getParameter("passwd");
        if(!passwd.equals(m.getPasswd())){
            model.addAttribute("num", vo.getNum());
            return "/fun/errorPasswd.jsp?num="+vo.getNum()+"";
        }
        model.addAttribute("fun",funService.getFun(vo));
        return "/fun/updateFun.jsp";
    }

    @RequestMapping(value = "/deleteFun.do")
    public String deleteFun(FunVO vo, HttpServletRequest request, Model model){
        System.out.println("===>Controller로 deleteFun() 접속");
        String RealPath = request.getSession().getServletContext().getRealPath("/fileSave/");
        String filename1;
        String filename2;
        String filename3;

        FunVO m = funService.getFun(vo);

        String passwd = request.getParameter("passwd");
        if(!passwd.equals(m.getPasswd())){
            model.addAttribute("num", vo.getNum());
            return "/fun/errorPasswd.jsp?num="+vo.getNum()+"";
        }

        filename1 = m.getFileName1();
        filename2 = m.getFileName2();
        filename3 = m.getFileName3();

        File file1 = new File(RealPath+filename1);
        File file2 = new File(RealPath+filename2);
        File file3 = new File(RealPath+filename3);

        file1.delete();
        file2.delete();
        file3.delete();

        funService.deleteFun(vo);
        return "redirect:getListFun.do";
    }

    @RequestMapping(value = "/updateFun.do")
    public String updateFun(FunVO vo){
        System.out.println("===>Controller로 updateFun() 접속");
        funService.updateFun(vo);
        return "redirect:getListFun.do";
    }

}
