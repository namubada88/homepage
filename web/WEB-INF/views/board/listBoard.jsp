<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="UTF-8">
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<header class="w3-container w3-top w3-hide-large w3-green w3-xlarge w3-padding">
    <a href="javascript:void(0)" class="w3-button w3-green w3-margin-right" onclick="w3_open()">☰</a>
    <span>나무바다</span>
</header>

<div class="w3-main" style="margin-left:340px;margin-right:40px; margin-top:80px;">
    <div class="w3-container">
        <input type="button" value="글쓰기" onclick="return checkLogin()"/>
        <form action="/getListBoard.do" method="post">
            <select name="ch1">
                <option value="subject">제목</option>
                <option value="writer">글쓴이</option>
            </select>
            <input type="text" name="ch2">
            <input type="submit" value="검색">
        </form>
        <table border=1 cellspacing="0" cellpadding="0" style="margin-top: 3px">
            <tr align="center">
                <td>번호</td>
                <td width="400px">제목</td>
                <td width="100px">글쓴이</td>
                <td>작성일</td>
                <td>조회</td>
            </tr>
            <c:forEach items="${boardList }" var="board">
                <fmt:parseDate value="${board.reg_date}" var="dateFmt" pattern="yyyy-MM-dd HH:mm:ss"/> <%--날짜 형식 저장--%>
                <tr>
                    <td align="center">${board.num }</td>
                    <td><a href="/getBoard.do?num=${board.num}">${board.subject }</a></td>
                    <td align="center">${board.writer }</td>
                    <td><fmt:formatDate value="${dateFmt}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                    <td align="center">${board.readcount}</td>
                </tr>
            </c:forEach>
        </table>


        <%--페이징 처리--%>
        <div style="margin-top: 10px">
            <c:set var="Start" value="${boardPage.startPageNo}"></c:set>
            시작페이지 : ${Start}<br/>
            전체페이지 : ${boardPage.countPage}<br/>
            <%--            <c:set var="done_loop" value="false"/>--%>
            <c:set var="i" value="${boardPage.startPageNo}"/>
            <c:if test="${boardPage.startPageNo > 5}">
                <a href="/getListBoard.do?currentPageNo=${boardPage.startPageNo-5}&ch1=${ch1}&ch2=${ch2}">◀이전</a>
            </c:if>
            <c:forEach begin="${boardPage.startPageNo}" end="${boardPage.endPageNo}" step="1">
                <%--<c:if test="${done_loop ne true}">--%>
                <c:if test="${i-1 < boardPage.countPage}">
                    <a href="/getListBoard.do?currentPageNo=${i}&ch1=${ch1}&ch2=${ch2}">[${i}]</a>
                    <c:set var="i" value="${i+1}"></c:set>
                </c:if>
                <%--</c:if>--%>
            </c:forEach>
            <c:if test="${boardPage.endPageNo < boardPage.countPage}">
                <a href="/getListBoard.do?currentPageNo=${boardPage.startPageNo+5}&ch1=${ch1}&ch2=${ch2}">다음▶</a>
            </c:if>

        </div>

    </div>
</div>


<script>
    function checkLogin() {
        var id = '${sessionID}';
        if (id == '') {
            alert("로그인 후 글쓰기가 가능합니다.");
            return false;
        } else {
            location.href = 'insertBoard.jsp';
        }
    }
</script>