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
    <form name="f1" onsubmit="return Passwd();" action="/getUpdateBoardContent.do?num=${board.num}" method="post">
        <table border="1" name="t1" cellspacing="0" cellpadding="0">
            <tr>
                <td width="10%" align="center">글번호</td>
                <td width="25%">${board.num}</td>
                <td width="10%" align="center">조회수</td>
                <td width="25%">${board.readcount}</td>
            </tr>
            <tr>
                <td align="center">작성자</td>
                <td>${board.writer}</td>
                <td align="center">작성일</td>
                <td >${board.reg_date}</td>
            </tr>
            <tr>
                <td align="center">글제목</td>
                <td colspan="3">${board.subject}</td>
            </tr>
            <tr><td align="center" colspan="4">글내용</td></tr>
            <tr>
                <div style="max-width: 30%;">
                <td colspan="4" width="500px" height="300">${board.content}</td>
                </div>
            </tr>
            <tr>
                <td align="center">비밀번호</td>
                <c:if test="${errorPasswd == null}">
                    <td colspan="3"><input type="password" name="passwd"></td>
                </c:if>
                <c:if test="${errorPasswd != null}">
                    <td colspan="3"><input type="password" name="passwd">잘못된 비밀번호입니다.</td>
                </c:if>
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
    <%@include file="/main/indexBottom.jsp" %>
    <script>
        function Passwd() {
            if (f1.passwd.value == '') {
                alert("비밀번호가 입력되지않았습니다.");
                f1.passwd.focus();
                return false;
            }
        }

        function deletePasswd() {
            if (f1.passwd.value == '') {
                alert("비밀번호가 입력되지않았습니다.");
                f1.passwd.focus();
                return false;
            } else {
                location.href = '/deleteBoard.do?num=${board.num}&passwd='+f1.passwd.value;
            }
        }
    </script>