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
        <h1 class="w3-xlarge w3-text-green"><b>회원가입</b></h1>
        <hr style="width:50px;border:5px solid green" class="w3-round">
    </div>

    <div class="w3-container">
        <form name="f1" onsubmit="return checkJoinForm();" action="/insertUser.do" method="post">
            <input type="text" placeholder="아이디" name="id"><br/>
            <input type="text" placeholder="비밀번호" name="passwd"><br/>
            <input type="text" placeholder="이메일" name="email"><br/>
            <input type="text" placeholder="이름" name="name"><br/>
            <input type="text" placeholder="닉네임" name="nick"><br/>
            <input type="submit" value="회원가입"/>
        </form>
    </div>
</div>

<%@include file="/indexBottom.jsp" %>

<script language="JavaScript">
    function checkJoinForm() {
        var list = new Array();
        <c:forEach items="${listUser}" var="user">
        list.push("${user.id}");
        </c:forEach>

        if (f1.id.value == '') {
            alert("아이디를 입력해주세요.");
            f1.id.focus();
            return false;
        } else if (f1.passwd.value == '') {
            alert("비밀번호를 입력해주세요.");
            f1.passwd.focus();
            return false;
        } else if (f1.email.value == '') {
            alert("E-mail을 입력해주세요.");
            f1.email.focus();
            return false;
        } else if (f1.name.value == '') {
            alert("이름을 입력해주세요.");
            f1.name.focus();
            return false;
        } else if (f1.nick.value == '') {
            alert("닉네임을 입력해주세요.");
            f1.nick.focus();
            return false;
        } else {
            for (var i = 0; i < list.length; i++) {
                if (f1.id.value == list[i]) {
                    alert("이미 가입된 아이디입니다.");
                    f1.id.focus();
                    return false;
                }
            }
        }
        alert(f1.name.value + "님 회원가입을 축하합니다.");
    }
</script>