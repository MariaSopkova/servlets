<%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 06.10.2018
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Welcome</title>
  </head>
  <body>
    <div>
      <%
        if("noAuth".equals(request.getParameter("action"))){
      %>
        <div>Извините, вы магл</div>
      <%}
      %>
      <form method="post" name="/index">
        <input type="text" name="login">
        <input type="password" name="password">
        <input type="submit">
      </form>
      <a href="greatHall">great hall</a>
    </div>
  </body>
</html>
