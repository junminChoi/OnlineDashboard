<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Login Page</title>
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
// ID 중복 확인 함수
function checkID(){
	var inputID = document.getElementById("UserID").value;
	$.ajax({
		type:"POST",
		url:"/LogIn/chkAvailableID",
		data:"inputID=" + inputID,
		success : function(data){
			if(data == true){
				document.getElementById("isOkayForID").innerHTML = "위 아이디로 가입이 가능합니다!!";
			}else{
				document.getElementById("isOkayForID").innerHTML = "이미 사용중이거나 부적합한 아이디입니다.";
			}
		},
		error : function(){
			alert("에러")
		}
	});
}

function signIn(){
	var inputID = document.getElementById("UserID").value;
	var inputPW = document.getElementById("UserPW").value;
	var userPWCheck = document.getElementById("UserPWCheck").value;
	
	
	$.ajax({
		type:"POST",
		url:"/joinMember",
		data:{"inputID" : inputID , "inputPW" : inputPW , "userPWCheck" : userPWCheck},
		success : function(data){
			location.href = "/";
		},
		error : function(){
			alert("오류-아이디 및 비밀번호를 다시 확인해주세요")
		}
	});

}

//비밀번호 포커싱
$( document ).ready(function() {
		$("#UserPW").focus(function(){
			$("#isOkayForPW").text('포커싱');
		});
		$("#UserPW").blur(function(){
			var inputPW = document.getElementById("UserPW").value;
			$.ajax({
				type:"POST",
				url:"/LogIn/chkAvailablePW",
				data:"inputPW=" + inputPW,
				success : function(data){
					if(data == true){
						document.getElementById("isOkayForPW").innerHTML = "이 비밀번호로 가입이 가능합니다!!";
					}else{
						document.getElementById("isOkayForPW").innerHTML = "부적합한 비밀번호입니다.";
					}
				},
				error : function(){
					alert("에러")
				}
			});
		});
		$("#UserPWCheck").blur(function(){
			var userPW = document.getElementById("UserPW").value;
			var userPWCheck = document.getElementById("UserPWCheck").value;
			var pws = {"UserPW": userPW , "userPWCheck" : userPWCheck};
			$.ajax({
				type:"POST",
				url:"/LogIn/chkisPWSame",
				data:pws,
				success : function(data){
					if(data == true){
						document.getElementById("isOkayForPWCheck").innerHTML = "비밀번호가 같습니다 ㅋㅋㄹㅃㅃ";
					}else{
						document.getElementById("isOkayForPWCheck").innerHTML = "비밀번호가 같지 않습니다.";
					}
				},
				error : function(){
					alert("에러")
				}
			});
		});
});




</script>
</head>
<body>
<P>  The time on the server is ${serverTime}. </P>
	<br>
	<br>
	<!-- 아이디 부분 -->
	
	
	<p>아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자여야합니다.</p>
	
	
	아이디 : <input type = "text" id = "UserID" size = "10">&nbsp;&nbsp; <button onclick = "checkID()"> 중복 확인 </button><br>
	<div id = "isOkayForID"> 사용 가능 여부 </div>
	
	<br>
	<!-- 비밀번호 부분 -->
	비밀번호 : <input type = "password" id = "UserPW" size = "10"><div id = "isOkayForPW"> 사용 가능 여부 </div>
	<br>
	비밀번호 확인 : <input type = "password" id = "UserPWCheck" size = "10" ><div id = "isOkayForPWCheck"> 사용 가능 여부 </div>
	
	
	
	<br>
	<br>
	<br>
	<button onclick = "signIn()"> 회원가입 </button>
	<!--   location = '/joinMember' -->
	
	
</body>
</html>