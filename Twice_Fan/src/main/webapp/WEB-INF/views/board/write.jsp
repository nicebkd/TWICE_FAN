<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../include/header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
article {
	border: 1px solid black;
}

label {
	width: 80px;
	height: auto;
}

.submit_btn {
	text-align: center;
}

.boardcontent{
	margin: 0 auto;
}	


</style>
</head>
<body>
<%@include file="../include/menu.jsp" %>
<section class="container">
	<article class="col-sm-9">
<header><h2>글쓰기</h2></header>
<hr>
<form action="${path}/board/write.do" method="post">
<div>
	<label>닉네임 </label> <input type="text" name="writer" value="${sessionScope.dto.u_name}" readonly="readonly">
</div>	
<div>
	<label>제목 </label> <input type="text" name="title">
</div>
<div class="boardcontent">
	<textarea rows="20" cols="80" name="content"></textarea>
</div>
<div class="submit_btn">
<input type="submit" value="글쓰기" >
</div>
</form>
</article>
</section>
</body>
</html>