<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../include/header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
	
    padding: 50px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

.button {
  display: inline-block;
  border-radius: 4px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 15px;
  padding: 10px;
  width: 100px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
  float: right;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}


.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
tr:hover{background-color:#f5f5f5}
tr:nth-child(1){background-color: pink}


</style>
<script type="text/javascript">
	$(document).ready(function() {
		$("#writeBtn").click(function() {
			location.href="${path}/board/write.do";
		});
	});
</script>
</head>
<body>
<%@include file="../include/menu.jsp" %>

<section class="container">
<header><h2>게시판</h2></header><br>

	<article class="col-sm-9">
	<span style="float: left;">총 게시물 수 : ${map.count }</span>
	<button class="button" id="writeBtn"><span>글쓰기</span></button>
		<table class="table" >
			<tr><th>번호</th><th>제목</th><th>글쓴이</th><th>조회수</th></tr>
	<c:if test="${requestScope.map.list != null }">	
		<c:forEach var="row" items="${requestScope.map.list }">
	<tr><td>${row.bno }</td><td><a href="${path}/board/view.do?bno=${row.bno}">${row.title }</a></td>
	<td>${row.writer }</td><td>${row.viewcnt }</td></tr>
</c:forEach>
	</c:if>
		</table>
	</article>	
</section>
</body>
</html>