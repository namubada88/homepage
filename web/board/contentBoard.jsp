<%@include file="indexTop.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="UTF-8">
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="w3-main" style="margin-left:340px;margin-right:40px; margin-top:80px;">
    <html>
    <head>
    </head>
    <body>
    <form name="f1" onsubmit="return Passwd();" action="/getUpdateContent.do?num=${board.num}" method="post">
    <table border="1" name="t1">
        <tr>
            <td width="70" align="center">글번호</td>
            <td width="100">${board.num}</td>
            <td width="70" align="center">조회수</td>
            <td width="100">${board.readcount}</td>
        </tr>
        <tr>
            <td align="center">작성자</td>
            <td>${board.writer}</td>
            <td align="center">작성일</td>
            <td width="200">${board.reg_date}</td>
        </tr>
        <tr>
            <td align="center">글제목</td>
            <td colspan="3">${board.subject}</td>
        </tr>
        <tr>
            <td align="center">글내용</td>
            <td colspan="3" height="300">${board.content}</td>
        </tr>
        <tr>
            <td align="center">비밀번호</td>
            <td width="50" colspan="3"><input type="password" name="passwd"></td>
        </tr>
        <tr>
            <td colspan="4" align="center">
                <input type="submit" value="글수정">
                <input type="button" value="글삭제" onclick="deletePasswd()">
                <input type="button" value="글목록" onclick="window.location='/getListBoard.do'">
            </td>
        </tr>
    </table>
    </form>
    </body>
    </html>
<%@include file="/indexBottom.jsp" %>
  <script>
    var passwd = '${board.passwd}';

    function Passwd() {
        if(f1.passwd.value==''){
            alert("비밀번호가 입력되지않았습니다.");
            f1.passwd.focus();
            return false;
        } else if(f1.passwd.value != passwd){
            alert("비밀번호가 다릅니다.");
            f1.passwd.focus();
            return false;
        }
    }

    function deletePasswd() {
        if(f1.passwd.value==''){
            alert("비밀번호가 입력되지않았습니다.");
            f1.passwd.focus();
            return false;
        }else if(f1.passwd.value != passwd){
            alert("비밀번호가 다릅니다.");
            f1.passwd.focus;
            return false;
        }else{
            location.href='/deleteBoard.do?num=${board.num}';
        }

    }
  </script>