<%@include file="indexTop.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Top menu on small screens -->
<header class="w3-container w3-top w3-hide-large w3-green w3-xlarge w3-padding">
    <a href="javascript:void(0)" class="w3-button w3-green w3-margin-right" onclick="w3_open()">☰</a>
    <span>나무바다</span>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu"
     id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:340px;margin-right:40px">


    <!-- Header -->
    <div class="w3-container" style="margin-top:80px" id="board">
        <h1 class="w3-jumbo w3-green"><b>NAMUBADA</b></h1>
    </div>

    <%--Introduce--%>
    <div class="w3-container" id="planBoard" style="margin-top:75px; color: green; font-weight: bolder;">
        <h1 class="w3-xxxlarge w3-text-green"><b>소개</b></h1>
        <hr style="width:50px;border:5px solid green" class="w3-round">
        <p>• 구직중인 신입 웹 개발자입니다. 잘 부탁드립니다. (domain goddady에서 구매, cafe24에서 호스트 서버 임대 중)</p>
        <p>• 보유기술1 : JSP, Spring, MyBatis, JSTL, EL, HTMl, CSS, Javascript, DBMS(MariaDB, Oracle, MySql 다룹니다.), Git
            사용가능, MVC 패턴으로
            웹
            구축</p>
        <p>• 보유기술2 : Eclipse, IntelliJ IDEA 사용가능, 가상머신을 이용한 리눅스 서버구축, 로그인, 게시판, 자료실, 관리자 페이지 구축가능, 모의 쇼핑몰 구축중</p>
        <p>• 자격증 : 네트워크 관리사 2급, 전자상거래 운용사</p>
        <p>• 공부예정항목 : Spring Boot, JPA, Vue.js, CentOS 리눅스, namubada.com 각종 기능 추가 예정</p>
        <p>• Git Page : https://github.com/namubada88 <a href="https://github.com/namubada88"> 소스코드 확인 바로가기(클릭)</a></p>
        <p>• 공부 기록 블로그 : http://www.namubada.net <a href="http://www.namubada.net">바로가기(클릭)</a></p>
    </div>

    <!-- Board sector -->
    <div class="w3-row-padding">
        <h1 class="w3-xxxlarge w3-text-green"><b>게시판</b></h1>
        <hr style="width:50px;border:5px solid green" class="w3-round">
        <span class="w3-xlarge">최신글</span>&nbsp;<span style="font-size: small; "><a
            href="/getListBoard.do">더보기+</a></span>
        <%@include file="mainList.jsp" %>
    </div>

    <!-- Fun sector -->
    <div class="w3-container" id="funBoard" style="margin-top:75px">
        <h1 class="w3-xxxlarge w3-text-green"><b>자료실</b></h1>
        <hr style="width:50px;border:5px solid green" class="w3-round">
        <span class="w3-xlarge">최신글</span>&nbsp;<span style="font-size: small; "><a
            href="/getListFun.do">더보기+</a></span>
        <%@include file="mainFun.jsp" %>
    </div>

    <!-- Preparing sector -->
    <div class="w3-container" id="planBoard" style="margin-top:75px">
        <h1 class="w3-xxxlarge w3-text-green"><b>계획</b></h1>
        <hr style="width:50px;border:5px solid green" class="w3-round">
        <h2>계획일정</h2>
    </div>
    <!-- W3.CSS Container -->
    <%@include file="indexBottom.jsp" %>
