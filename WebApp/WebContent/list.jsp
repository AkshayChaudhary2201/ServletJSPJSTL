<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="green">
<sql:setDataSource
var="myDS"
driver="com.mysql.jdbc.Driver"
url="jdbc:mysql://localhost:3306/webapp"
user="root" password="adm@123"/>

<sql:query var="listUsers" dataSource="${myDS}">
Select * from login;
</sql:query>

<div align="center">
<table border="1" cellpadding="5">
<caption><h2>List Of Users</h2></caption>
<tr>
<th>Name</th>
<th>Address</th>
<th>Password</th>
</tr>
<c:forEach var="user" items="${listUsers.rows}">
<tr>
<td><c:out value="${user.name}"/></td>
<td><c:out value="${user.address}"/></td>
<td><c:out value="${user.password}"/></td>
</tr>
</c:forEach>
</table>
</div>

</body>
</html>