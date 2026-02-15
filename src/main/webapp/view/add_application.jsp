<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/AddApplicationServlet"
      method="post">
Name: <input type="text" name="name"><br>
Position: <input type="text" name="position"><br>
Email: <input type="email" name="email"><br>
Status: <input type="text" name="status"><br>
<input type="submit" value="Add">
</form>
</body>
</html>