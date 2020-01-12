<%@include file="indexTop.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="UTF-8">
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<header class="w3-container w3-top w3-hide-large w3-green w3-xlarge w3-padding">
    <a href="javascript:void(0)" class="w3-button w3-green w3-margin-right" onclick="w3_open()">☰</a>
    <span>나무바다</span>
</header>

<div class="w3-main" style="margin-left:340px;margin-right:40px; margin-top:80px;">

    <div class="w3-container" style="margin-top:80px" id="user">
        <h1 class="w3-xlarge w3-text-green"><b>로그인</b></h1>
        <hr style="width:50px;border:5px solid green" class="w3-round">
    </div>

    <div class="w3-container">
        <form name="f1" onsubmit="return checkLoginForm();" action="/loginUser.do">
            <input type="text" placeholder="아이디" name="id"><br/>
            <input type="text" placeholder="비밀번호" name="passwd"><br/>
            <input type="submit" value="로그인"/>
        </form>
    </div>
</div>

<%@include file="/main/indexBottom.jsp" %>

<script>
    function checkLoginForm() {
        if (f1.id.value == '') {
            alert("아이디를 입력해주세요.");
            f1.id.focus();
            return false;
        } else if (f1.passwd.value == '') {
            alert("비밀번호를 입력해주세요.");
            f1.passwd.focus();
            return false;
        }
    }
</script>

