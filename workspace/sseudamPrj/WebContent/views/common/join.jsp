<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	body{
		padding: 0;
        margin: 0;
		background-color: rgba(245, 245, 245, 1);
	}

	#main{
		width: 1088px;
		height: 855px;
		border: 1px solid white;
		background-color: white;
		margin: auto;
		align-content: center;
	}

	#btn1{
		margin-right: 5%;
	}

	#btn2{
		margin-left: 5%;
	}

	.button{
		background-color: white;
		border: 1px solid black;
		color: black;
		font-size: 25px;
		font-weight: bold;
		width: 270px;
		height: 230px;
		border-radius: 15px;
		box-shadow: 0 5px 3px rgb(199, 198, 198);
		cursor: pointer;
	}

	.btn{
		text-align: center;
		margin-top: 22%;
	}
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	

		<div id="main">
			<div class="btn">
				<button type="button" id="btn1" class="button" value="Normal" onclick="location.href='<%=root%>/join/memberJoin'"><img src="<%=root%>/resources/img/join/join.png" style="width : 160px; height : 150px;"><br>일반 회원가입</button>
				<button type="button" id="btn2" class="button" value="Expert" onclick="location.href='<%=root%>/join/proJoinPage=1'"><img src="<%=root%>/resources/img/join/projoin.png" style="width : 160px; height : 150px;"><br>전문가 회원가입</button>
			</div>
		</div>

	
	<%@ include file="/views/common/footer.jsp" %>
</body>
</html>