<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" />
<meta charset="UTF-8">
<title>정보수정 :: 쓰담쓰담</title>
<style>

    body{
        padding: 0;
        margin: 0;
		background-color: rgba(245, 245, 245, 1);
	}

    .main{
		width: 1088px;
		height: 855px;
		border: 1px solid white;
		background-color: white;
		margin: auto;
	}

    .join-area{
        width: 470px;
        height: 585px;
        display: grid;
        grid-template-columns: 4fr;
        grid-template-rows: repeat(15 , 1fr);
        margin-left: 30%;
        margin-top: 40px;
    }

    .join-area>div{
        font-size: 18px;
    }

    label{
        font-size: 13px;
    }

    h1{
        margin-top: 40px;
        margin-bottom: 7px;
        margin-right: 36%;
        font-size: 30px;
    }

    h4{
        color: gray;
        font-weight: normal;
        margin-top: 0;
        margin-left: 8%;
        font-size: 17px;
    }

    input:focus {outline: none;}

    input[type="text"],
    input[type="password"],
    input[type="tel"],
    input[type="email"]{
        border: none;
        border-bottom: 1px solid black;
        width: 75%;
        font-size: 18px;
    }

    input[type="submit"]{
        width: 167px;
        height: 42px;
        border: none;
        border-radius: 5px;
        color: white;
        background-color: rgba(163, 215, 165, 1);
        margin-left: 23%;
        font-size: 18px;
    }

    input::placeholder{
        font-size: 15px;
        color:rgba(204, 204, 204, 1);
    }
    
    #gender-box>label{
        font-size: 18px;
        margin-left: 15%;
    }
    
    .overlap-check-btn{
        color: rgba(253, 121, 0, 1);
        border: 1px solid rgba(253, 121, 0, 1);
        font-size: 13px;
        border-radius: 15px;
        background-color: white;
        width: 75px;
        height: 25px;
    }
    
</style>
</head>
<body>

    <%@ include file="/views/common/header.jsp" %>

	<div class="main">
        <h1 align="center">정보수정</h1>

		<form action="/sseudam/mypage/edit" method="post">
	        <div class="join-area">
	
	            <div>비밀번호</div>
	            <div>
	                <input type="password" name="memberPwd1" value="<%=loginMember.getPwd() %>" placeholder="6~14자 이내로 영문, 숫자, 특수문자를 조합하여 작성">
	            </div>
	
	
	            <div>닉네임</div>
	            <div>
	                <input type="text" name="memberNick" value="<%=loginMember.getNick() %>" placeholder="6~14자 이내로 작성(특수문자 불가능)">
	            </div>
	
	            <div>연락처</div>
	            <div>
	                <input type="tel" name="memberPhone" value="<%=loginMember.getPhone() %>" placeholder="예) 01012345678">
	            </div>
	
	            <div>이메일</div>
	            <div>
	                <input type="email" name="memberEmail" value="<%=loginMember.getEmail()%>" >
	            </div>
	
	            <div>
	                <br><input type="submit" value="수정하기" class="btn">
	            </div>
	            
	        </div>
         </form>
    </div>

    <%@ include file="/views/common/footer.jsp" %>

</body>
</html>