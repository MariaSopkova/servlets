<%@ page import="ru.innopolis.stc.servlets.student.StudentInformation" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 09.10.2018
  Time: 0:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
<%
    StudentInformation student = (StudentInformation)request.getAttribute("studentInfo");
%>
<div>
    Name: <%student.getStudent().getName();%>
</div>
</body>
</html>
