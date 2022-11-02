<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String msg = (String)request.getAttribute("msg"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쓰담쓰담 에러페이지</title>
<style>
	body{
		padding: 0;
        margin: 0;
		background-color: rgba(245, 245, 245, 1);
	}

	#error-content{
		width: 1088px;
		height: 855px;
		border: 1px solid white;
		background-color: white;
		margin: auto;
		align-content: center;
		display: flex;
    	flex-direction: column;
    	align-items: center;
      	justify-content: center;
	}

	.error-img{
		border: 1px solid red;
		width: 200px;
		height: 200px;
	}
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	
	<div id="error-content">
		<div><h1>"<%= msg %>"</h1></div>
		<div><img class="error-img" src="<%=root%>/resources/img/error/errorpage.png"></div>
	</div>
	
	<%@ include file="/views/common/footer.jsp" %>


</body>
</html>