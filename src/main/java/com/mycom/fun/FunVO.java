package com.mycom.fun;

import org.springframework.web.multipart.MultipartFile;

public class FunVO {
    private int num;
    private String email;
    private String writer;
    private String subject;
    private String content;
    private String passwd;
    private String reg_date;
    private String readcount;
    private String ip;
    private int ref;
    private int re_step;
    private int re_level;
    private String ch1;
    private String ch2;
    private int maxLimit;
    private int minLimit;
    private String fileName1;
    private String fileName2;
    private String fileName3;
    private MultipartFile uploadFile1;
    private MultipartFile uploadFile2;
    private MultipartFile uploadFile3;


    @Override
    public String toString() {
        return "FunVO{" +
                "num=" + num +
                ", writer='" + writer + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", passwd='" + passwd + '\'' +
                ", reg_date='" + reg_date + '\'' +
                ", readcount='" + readcount + '\'' +
                ", ip='" + ip + '\'' +
                ", ref=" + ref +
                ", re_step=" + re_step +
                ", re_level=" + re_level +
                ", ch1='" + ch1 + '\'' +
                ", ch2='" + ch2 + '\'' +
                ", maxLimit=" + maxLimit +
                ", minLimit=" + minLimit +
                '}';
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFileName1() {
        return fileName1;
    }

    public void setFileName1(String fileName1) {
        this.fileName1 = fileName1;
    }

    public String getFileName2() {
        return fileName2;
    }

    public void setFileName2(String fileName2) {
        this.fileName2 = fileName2;
    }

    public String getFileName3() {
        return fileName3;
    }

    public void setFileName3(String fileName3) {
        this.fileName3 = fileName3;
    }

    public MultipartFile getUploadFile1() {
        return uploadFile1;
    }

    public void setUploadFile1(MultipartFile uploadFile1) {
        this.uploadFile1 = uploadFile1;
    }

    public MultipartFile getUploadFile2() {
        return uploadFile2;
    }

    public void setUploadFile2(MultipartFile uploadFile2) {
        this.uploadFile2 = uploadFile2;
    }

    public MultipartFile getUploadFile3() {
        return uploadFile3;
    }

    public void setUploadFile3(MultipartFile uploadFile3) {
        this.uploadFile3 = uploadFile3;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public String getReadcount() {
        return readcount;
    }

    public void setReadcount(String readcount) {
        this.readcount = readcount;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public int getRe_step() {
        return re_step;
    }

    public void setRe_step(int re_step) {
        this.re_step = re_step;
    }

    public int getRe_level() {
        return re_level;
    }

    public void setRe_level(int re_level) {
        this.re_level = re_level;
    }

    public String getCh1() {
        return ch1;
    }

    public void setCh1(String ch1) {
        this.ch1 = ch1;
    }

    public String getCh2() {
        return ch2;
    }

    public void setCh2(String ch2) {
        this.ch2 = ch2;
    }

    public int getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    public int getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(int minLimit) {
        this.minLimit = minLimit;
    }
}
