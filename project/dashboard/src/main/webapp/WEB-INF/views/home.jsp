<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
<head>
	<title>Home</title>
</head>

<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>


	
	<%
		Object ID = session.getAttribute("memberID");
		String getData = (String) ID;
	
	%>

	
	
	<c:if test="${not empty memberID}">
		
		숨겨왔던나~의 수줍은마음모두 네게 줄게이~ 에잉예~에에에에엥
		<p> member name and pw is ${memberID}.</p>	
		<script>
		var item = sessionStorage.getItem("memberID");
		console.log(item);
		
	</script>
	</c:if>
	
	
	
	
	<c:if test = "${empty memberID }">
	<a href="LogIn/Join"><button> 회원가입 </button></a>
	<a href="LogIn/login"><button> 로그인 </button></a>
	</c:if>
</body>
</html>
