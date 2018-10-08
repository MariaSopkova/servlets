<%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 06.10.2018
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<%
    List<Integer> list = (List<Integer>) request.getAttribute("list");
    for (Integer i : list) {
%>
<%=i%><BR>
<%
    }
%>
</body>
</html>

</body>
</html>
