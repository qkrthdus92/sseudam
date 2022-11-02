<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
	String root1 = request.getContextPath();
%>    
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

	h1{
		padding-top: 100%;
		padding-bottom: 50%;
	}

	#error-content{
		width: 1088px;
		height: 855px;
		border: 1px solid white;
		background-color: white;
		margin: auto;
		display: flex;
    	flex-direction: column;
    	align-items: flex-start;
		align-items: center;
	}

	.error-img{
		width: 200px;
		height: 200px;
	}
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	
	<div id="error-content">
		<div><h1>"<%= msg %>"</h1></div>
		<div><img class="error-img" src="<%=root1%>/resources/img/error/error.png"></div>
	</div>
	
	<%@ include file="/views/common/footer.jsp" %>


</body>
</html>