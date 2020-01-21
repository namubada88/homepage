<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="UTF-8">
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${PageContext.request.contextPath}"/>
<div class="w3-main" style="margin-left:340px;margin-right:40px; margin-top:80px;">
    <p><%=request.getSession().getServletContext().getRealPath("/fileSave/")%></p>
    <form name="f1" onsubmit="return Passwd();" action="/getUpdateFunContent.do?num=${fun.num}" method="post">
        <table border="1" name="t1" cellspacing="0" cellpadding="0">
            <tr>
                <td width="10%" align="center">글번호</td>
                <td width="25%">${fun.num}</td>
                <td width="10%" align="center">조회수</td>
                <td width="25%">${fun.readcount}</td>
            </tr>
            <tr>
                <td align="center">작성자</td>
                <td>${fun.writer}</td>
                <td align="center">작성일</td>
                <td>${fun.reg_date}</td>
            </tr>
            <tr>
                <td align="center">글제목</td>
                <td colspan="3">${fun.subject}</td>
            </tr>
            <tr>
                <td colspan="4" align="center">글내용</td>
            </tr>
            <tr>
                <td colspan="4" style="overflow: visible" width="500">
                    <div>
                        ${fun.content}
                    </div>
                    <div>
                        <c:if test="${fun.fileName1 != null}">
                            <img src="${contextPath}/fileDownload.do?fileName=${fun.fileName1}"
                                 style="width: 100%"/><br/>
                        </c:if>
                        <c:if test="${fun.fileName2 != null}">
                            <img src="${contextPath}/fileDownload.do?fileName=${fun.fileName2}"
                                 style="width: 100%"/><br/>
                        </c:if>
                        <c:if test="${fun.fileName3 != null}">
                            <img src="${contextPath}/fileDownload.do?fileName=${fun.fileName3}"
                                 style="width: 100%"/><br/>
                        </c:if>
                    </div>
                </td>
            </tr>
            <tr>
                <td align="center">비밀번호</td>
                <td colspan="3"><input type="password" name="passwd"></td>
            </tr>
            <tr>
                <td colspan="4" align="center">
                    <input type="submit" value="글수정">
                    <input type="button" value="글삭제" onclick="deletePasswd()">
                    <input type="button" value="글목록" onclick="window.location='/getListFun.do'">
                </td>
            </tr>
        </table>
    </form>
</div>

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
            location.href = '/deleteFun.do?num=${fun.num}&passwd=' + f1.passwd.value;
        }
    }
</script>