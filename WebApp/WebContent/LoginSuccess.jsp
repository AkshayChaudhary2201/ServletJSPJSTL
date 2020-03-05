<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
 <div align="center">
  <h1>You have logged in successfully</h1>
 
 <%String username=request.getParameter("name"); %>



<h3>Welcome <%out.println(username);%></h3><br>
<h4>Select an action to perform:</h4><br><br>

<table>
 <tr><td><a href="list.jsp">All Registered Users</a></td></tr>

</table>
</div>
</body>
</html>