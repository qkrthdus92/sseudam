<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
	String root1 = request.getContextPath();
%>    
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" />
<meta charset="UTF-8">
<title>에러페이지 :: 쓰담쓰담</title>
<style>
	body{
		padding: 0;
        margin: 0;
		background-color: rgba(245, 245, 245, 1);
	}

	h1{
		margin-bottom: 90%;
		font-family: "S-CoreDream-3Light";
		color: rgba(128, 124, 124, 1);
	}

	#error-content{
		width: 1088px;
		height: 755px;
		background-color: white;
		margin: auto;
		display: flex;
		flex-direction: column;
		align-items: center;
	}

	#error-content > .error-page{
		text-align: center;
		margin: auto;
	}

	.error-img{
		width: 850px;
		height: 600px;
	}
	
	.back-page{
		font-family: "S-CoreDream-3Light";
        color: gray;
        border: none;
		cursor: pointer;
        font-size: 20px;
		font-weight: bold;
		margin-bottom: 230px;
	}
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	
	<div id="error-content">
		<div class="error-page"><img class="error-img" src="<%=root1%>/resources/img/error/error404.gif"></div>
		<div class="back-page" onclick="history.back();">이전 페이지로 이동</div>
	</div>
	
	<%@ include file="/views/common/footer.jsp" %>


</body>
</html>