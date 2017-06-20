<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../include/header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
	section{
		margin-top: 70px;
	}
	
	article{
		border: 1px solid pink;
		padding: 15px;
	}
	
	.input-group{
		width: 550px;
	}
	
	section{
		text-align: center;
		
	}
	
	div{
		margin: 0 auto;
	}
	
</style>
</head>
<script>

 $(document).ready(function() {
	 
	 var
	 id =$("#u_id"),
	 pw =$("#u_pw"),
	 pw2 =$("#u_pw2"),
	 email =$("#u_email"),
	 name =$("#u_name");
	 
	 var re_id = /^[a-z0-9]{3,10}$/; // 아이디 검사식
		var re_pw = /^[a-z0-9]{3,18}$/; // 비밀번호 검사식
		var re_email = /^([\w\.-]+)@([a-z\d\.-]+)\.([a-z\.]{2,6})$/; // 이메일 검사식
		var re_name = /^[가-힣-a-z0-9]{2,12}$/; //이름 유효성
		var id_check;
		var name_check;
	
	$("#join_Btn").click(function() {
	 	if(!re_id.test(id.val())){
	 		console.log("아이디 형식에 맞지 않습니다.")
	 		id.focus();
	 	}else if(id_check ==false){
	 		console.log("중복된 아이디 입니다.");
	 	}else if(!re_name.test(name.val())){
	 		console.log("닉네임 형식이 아닙니다.");
	 		name.focus();
	 	}else if(name_check ==false){
	 		console.log("중복된 닉네임 입니다.");
	 	}else if(!re_pw.test(pw.val())){
	 		console.log("비밀번호형식에 맞지 않습니다.");
	 		pw.focus();
	 	}else if(pw.val()!=pw2.val()){
	 		console.log("두 비밀번호가 다릅니다.");
	 		pw.val("");
	 		pw2.val("");
	 		pw.focus();
	 	}else if(!re_email.test(email.val())){
	 		console.log("이메일 형식이 아닙니다.");
	 		email.focus();
	 	
	 	}else{
	 		$("form").submit();
	 	}
	});
	 

	 $("#u_id").blur(function() {
		 
		 var u_id=$("#u_id").val();
		 var param="u_id="+u_id;
		
		 $.ajax({
		 	type :"post",
			url : "${path}/member/idcheck.do",
			data : param,
			success : function(data) {
				if(data=="success"){
					console.log(data);
					id_check=true;
				}else if(data=="fail"){
					console.log(data);
					id_check=false;
				}
			}
		 });
	});
	 
	 $("#u_name").blur(function() {
		 var u_name=$("#u_name").val();
		 var param="u_name="+u_name;
		
		 $.ajax({
		 	type :"post",
			url : "${path}/member/namecheck.do",
			data : param,
			success : function(data) {
				if(data=="success"){
					console.log(data);
					name_check=true;
				}else if(data=="fail"){
					console.log(data);
					name_check=false;
				}
			}
		 });
	});
	 
	 
	 $("#u_pw").blur(function() {
	
	 });
	 
	 $("#u_pw2").blur(function() {
	
	 });
	 
	 $("#u_email").blur(function() {
		
	});
		

});

</script>
<body>

<%@include file="../include/menu.jsp" %>
<section class="container">
	<article class="col-sm-10">
	<header><h2>회원 가입</h2></header>
	<form action="${path}/member/insert.do" method="post" name="Join">
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
      <input id="u_id" type="text" class="form-control" name="u_id" placeholder="아이디" > 
    </div><br>
   
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
      <input id="u_name" type="text" class="form-control" name="u_name" placeholder="닉네임" >
    </div><br>

    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
      <input id="u_pw" type="password" class="form-control" name="u_pw" placeholder="패스워드">
    </div><br>
    
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
      <input id="u_pw2" type="password" class="form-control" name="u_pw2" placeholder="패스워드 확인">
    </div><br>
    
    <div class="input-group">
      <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
      <input id="u_email" type="email" class="form-control" name="u_email" placeholder="이메일">
    </div><br>
    
        
   
    
    <div>
    	<button class="btn btn-danger" type="button" id="join_Btn">회원가입</button>
    </div> 
  </form>
  
	
	</article>

	
</section>

</body>
</html>