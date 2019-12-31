<%--
  Created by IntelliJ IDEA.
  User: mw
  Date: 2019-12-31
  Time: 오후 1:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    alert("비밀번호가 다릅니다.")
    location.href="getFun.do?num=<%=request.getParameter("num") %>"
</script>