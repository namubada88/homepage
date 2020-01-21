package com.mycom.common.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class FileDownload {

    @RequestMapping("/fileDownload.do")
    public void fileDownload(@RequestParam("fileName") String fileName,
                             HttpServletResponse response, HttpServletRequest request) throws Exception {
        String CURR_IMAGE_REPO_PATH = request.getSession().getServletContext().getRealPath("/fileSave/");
        OutputStream out = response.getOutputStream();
        String downFile=CURR_IMAGE_REPO_PATH+"\\"+fileName;
        System.out.println("파일 경로 : "+downFile);
        File f = new File(downFile);

        FileInputStream in = new FileInputStream(f);

        byte[] buffer = new byte[1024 * 8];
        while (true) {
            int count = in.read(buffer);
            if (count == -1)
                break;
            out.write(buffer, 0, count);
        }
        in.close();
        out.close();
    }
}
