<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<form action = "loginCheck" method = "POST">
		ID : <input type = "text" name = "userID" value = '${cookieID}'><br>
		Password : <input type = "password" name = "userPwd" value = '${cookiePW}'><br>
		<input type = "checkbox" name = "isIDSave" value="true"> 아이디/비밀번호 저장
		<input type = "submit" value = "login">
	</form>
	

</body>
</html>