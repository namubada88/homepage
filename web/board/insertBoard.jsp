<%@include file="indexTop.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="UTF-8">
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="w3-main" style="margin-left:340px;margin-right:40px; margin-top:80px;">
    <form action="/insertBoard.do" method="post">
        <table border="1" width="70%">
            <tr>
                <td width="70" align="center">이름</td>
                <td width="100"><input type="text" name="writer"></td>
            </tr>
            <tr>
                <td align="center">Email</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td align="center">제목</td>
                <td><input type="text" name="subject" style="width: 95%;"></td>
            </tr>
            <tr>
                <td align="center">내용</td>
                <td><textarea name="content" style="width: 95%;height: 200px;"></textarea></td>
            </tr>
            <tr>
                <td align="center">비밀번호</td>
                <td><input type="password" name="passwd"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="글쓰기">
                    <input type="button" value="글목록" onclick="window.location='/getListBoard.do'">
                </td>
            </tr>
        </table>
    </form>
<%@include file="/indexBottom.jsp" %>