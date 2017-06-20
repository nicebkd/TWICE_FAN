<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="include/header.jsp" %>
	<title>Tiwce_F HomePage</title>
<style type="text/css">

	section{
		border: 1px solid black;
	}
	
	aside{
		border: 1px solid black;
	}
		

</style>
<script>
$(document).ready(function() {
	$("#loginBtn").click(function() {
		var u_id = $("#login_id").val();
		var u_pw = $("#login_pw").val();

		if(u_id==""){
			alert("아이디를 입력해주세요.");
			$("#login_id").focus();
			return;
		}else if(u_pw==""){
			alert("비밀번호를 입력해주세요.");
			$("#login_pw").focus();
			return;
		}
		
		/* document.form1.action="${path}/member/login_check.do";
		document.form1.submit();
		 */
		
 		var param = "u_id="+u_id+"&u_pw="+u_pw;
		 
		$.ajax({
			type:"post",
			url:"${path}/member/login.do",
			data : param,
			success : function(data){
				console.log(data);
				if(data=="success"){
					location.href="${path}"
				}else{
					$("#loginCheck").html('<span style="color:red">아이디 및 패스워드가 일치 하지 않습니다.</span>');	
				}
			}
		}); 
	});
});
</script>
</head>
<body>

<%@include file="include/menu.jsp" %>

<div class="container">
<section class="col-sm-9">



d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
<br>d
</section>
<aside class="col-sm-3">
	ASIDE
</aside>
</div>
<%@include file="include/footer.jsp" %>
</body>
</html>
