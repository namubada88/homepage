<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="com.mycom.board.BoardService" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="com.mycom.board.BoardDAO" %>
<%@ page import="com.mycom.board.BoardVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycom.board.MainBoardDAO" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: mw
  Date: 2019-12-23
  Time: 오후 8:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MainBoardDAO mainBoardDAO = new MainBoardDAO();
    List<BoardVO> li = mainBoardDAO.getMainBoard();
    BoardVO vo = new BoardVO();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
<tr align="center"><td>번호</td><td width="300px">제목</td><td>작성자</td></tr>
    <%
        for (int i = 0; i < li.size(); i++) {
            vo = li.get(i);
    %>
    <tr><td align="center"><%=vo.getNum() %></td><td><%=vo.getSubject() %></td><td align="center"><%=vo.getWriter() %></td></tr>
    <%} %>
</table>
</body>
</html>
