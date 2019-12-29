<%@include file="indexTop.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="UTF-8">
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="w3-main" style="margin-left:340px;margin-right:40px; margin-top:80px;">
    <form name="f1" onsubmit="return cehckInsertForm();" action="/insertBoard.do" method="post">
        <table border="1" width="70%">
            <tr>
                <td width="70" align="center">작성자</td>
                <td colspan="3" width="50"><input type="hidden" name="writer" value="${sessionNICK}">${sessionNICK}</td>
            </tr>
            <tr>
                <td align="center" width="10%">Email</td>
                <td width="25%">
                    <input type="hidden" name="email" value="${sessionEMAIL}">${sessionEMAIL}
                </td>
                <td width="10%" align="center">IP</td>
                <td width="25%">
                    <%
                        String ip = request.getHeader("X-Forwarded-For");
                        if(ip == null) ip = request.getRemoteAddr();
                    %>
                    <input type="hidden" name="ip" value="<%=ip %>"><%=ip %>
                </td>
            </tr>
            <tr>
                <td align="center">제목</td>
                <td colspan="3"><input type="text" name="subject" style="width: 95%;"></td>
            </tr>
            <tr>
                <td align="center">내용</td>
                <td colspan="3"><textarea name="content" style="width: 95%;height: 200px;"></textarea></td>
            </tr>
            <tr>
                <td align="center">비밀번호</td>
                <td colspan="3"><input type="password" name="passwd"></td>
            </tr>
            <tr>
                <td colspan="4" align="center">
                    <input type="submit" value="글쓰기">
                    <input type="button" value="글목록" onclick="window.location='/getListBoard.do'">
                </td>
            </tr>
        </table>
    </form>
    <%@include file="/indexBottom.jsp" %>

    <script>
        function cehckInsertForm() {
            if(f1.subject.value == ''){
                alert("제목을 입력해주세요.");
                f1.subject.focus();
                return false;
            } else if(f1.content.value == ''){
                alert("내용을 입력해주세요.")
                f1.content.focus();
                return false;
            } else if(f1.passwd.value == ''){
                alert("비밀번호를 입력해주세요.");
                f1.passwd.focus();
                return false;
            }
        }
    </script>