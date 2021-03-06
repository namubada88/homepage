<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<title>나무바다</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
<style>
    <%@ include file="css.jsp"%>
    body, h1, h2, h3, h4, h5 {
        font-family: "Poppins", sans-serif
    }

    body {
        font-size: 16px;
    }

    .w3-half img {
        margin-bottom: -6px;
        margin-top: 16px;
        opacity: 0.8;
        cursor: pointer
    }

    .w3-half img:hover {
        opacity: 1
    }
</style>
<body>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-green w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;"
     id="mySidebar"><br>
    <a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-hide-large w3-display-topleft"
       style="width:100%;font-size:22px">Close Menu</a>
    <div class="w3-container">
        <a href="/"><h3 class="w3-padding-64 w3-bar-item w3-button w3-hover-green"><b>NAMUBADA</b></h3></a>
    </div>
    <div class="w3-bar-block">
        <c:if test="${sessionNICK eq null}">
            <b class="w3-bar-item">로그인 하세요</b>
            <a href="/getListUserLogin.do" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">로그인</a>
            <a href="getListUser.do" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">회원가입</a>
        </c:if>
        <c:if test="${sessionNICK != null}">
            <div class="w3-bar-item">
                <span style="font-size: medium;">${sessionNICK}님 환영합니다.</span><br/>
                <span style="font-size: medium;"><a href="/logoutUser.do">로그아웃</a></span>
            </div>
        </c:if>

        <a href="/" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">처음으로</a>
        <a href="getListBoard.do" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">게시판</a>
        <a href="getListFun.do" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">자료실</a>
        <a href="#services" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">모의쇼핑몰(Making)</a>
        <a href="#services" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">최저가검색(Planing)</a>
    </div>
</nav>