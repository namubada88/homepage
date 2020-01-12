<%@ page import="com.mycom.fun.FunVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycom.fun.MainFunDAO" %>
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
    MainFunDAO mainFunDAO = new MainFunDAO();
    List<FunVO> list = mainFunDAO.getMainFun();
    FunVO fo = new FunVO();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="0">
    <tr align="center"><td>번호</td><td width="300px">제목</td><td>작성자</td></tr>
    <%
        for (int i = 0; i < list.size(); i++)
        { fo = list.get(i);
    %>
    <tr><td align="center"><%=fo.getNum() %></td><td><%=fo.getSubject() %></td><td align="center"><%=fo.getWriter() %></td></tr>
    <%} %>
</table>
</body>
</html>