<%@ page import="ru.innopolis.stc.servlets.greatHall.HogwartsInfo" %>
<%@ page import="ru.innopolis.stc.servlets.greatHall.HouseInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.innopolis.stc.pojo.StudentPojo" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 13.10.2018
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    HogwartsInfo hogwartsInfo = (HogwartsInfo)request.getAttribute("HogwartsInfo");
    List<HouseInfo> housesInfo;
    if(hogwartsInfo != null){
        housesInfo = hogwartsInfo.getHouses();
        for (HouseInfo house: housesInfo) {%>
            <%=house.getHouse().getName()%> <%=house.getHouse().getPoints()%> <br>
            <%
                List<StudentPojo> students = house.getStudents();
                for(StudentPojo student : students){%>
                    <%=student.getName() + " " + student.getSurname()%>
                <%}
            %>
        <%}
    }
%>
</body>
</html>
