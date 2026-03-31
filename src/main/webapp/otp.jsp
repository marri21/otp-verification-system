<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="verifyOtp" method="post">
    Enter OTP: <input type="text" name="otp"><br>
    <button type="submit">Verify</button>
</form>

<%
if("wrong".equals(request.getParameter("msg"))){
%>
<h3 style="color:red;">OTP entered was wrong</h3>
<% } %>
</body>
</html>