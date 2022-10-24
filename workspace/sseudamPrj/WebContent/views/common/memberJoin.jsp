<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>(일반) 회원가입</title>
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
        cursor: pointer;
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

    .join-submit > .submit{
        width: 167px;
        height: 42px;
        border: none;
        border-radius: 5px;
        color: white;
        background-color: rgba(163, 215, 165, 1);
        margin-left: 23%;
        font-size: 18px;
        cursor: pointer;
    }

    input::placeholder{
        font-size: 15px;
        color:rgba(204, 204, 204, 1);
    }
    
    .overlap-check-btn{
        color: rgba(253, 121, 0, 1);
        border: 1px solid rgba(253, 121, 0, 1);
        font-size: 13px;
        border-radius: 15px;
        background-color: white;
        width: 75px;
        height: 25px;
        cursor: pointer;
    }
    
</style>
</head>
<body>

    <%@ include file="/views/common/header.jsp" %>

	<div class="main">
        <h1 align="center" class="join">회원가입</h1>
        <h4 align="center" class="join-guide">이곳은 쓰담쓰담에 함께 하실 분들을 위한 회원가입 페이지 입니다.</h4>

		<form action="/sseudam/join/memberJoin" method="post">
			<div class="join-area">
	            <div>아이디</div>
	            <div>
	            	<input type="text" class="memberId-input" name="memberId" placeholder="6~14자 이내로 영문, 숫자를 조합하여 작성" required>
	            	<input type="submit" class="overlap-check-btn" value="중복확인">
	            </div>
	
	            <div>비밀번호</div>
	            <div>
	                <input type="password" name="memberPwd1" placeholder="6~14자 이내로 영문, 숫자, 특수문자를 조합하여 작성" required>
	            </div>
	
	            <div>비밀번호 확인</div>
	            <div>
	                <input type="password" name="memberPwd2">
	            </div>
	
	            <div>이름</div>
	            <div>
	                <input type="text" name="memberName" required>
	            </div>
	
	            <div>닉네임</div>
	            <div>
	                <input type="text" name="memberNick" placeholder="6~14자 이내로 작성(특수문자 불가능)" required>
	            </div>
	
	            <div>연락처</div>
	            <div>
	                <input type="tel" name="phone" placeholder="예) 01012345678" required>
	            </div>
	
	            <div>이메일(선택)</div>
	            <div>
	                <input type="email" name="email">
	            </div>
				
				<!-- 이 부분 테이블에 추가 해야 할 듯...? -->
				<!-- ㄴㄴ y 안 하면 안 넘어가게 하는 코드 있음 -->
	            <div class="join-TOS">
	                <label>
	                    <input type="checkbox" id="agree">
	                    (필수) 서비스 이용약관 및 개인정보 처리방침에 동의합니다.
	                </label>
	                <br>
	                <label>
	                    <input type="checkbox">
	                    (선택) 이벤트 진행 등의 마케팅 정보를 수신합니다.
	                </label>
	            </div>
	
	            <div class="join-submit">
	                <br><input type="submit" value="가입하기" class="submit">
	            </div>
	
	        </div>
		</form>
		
            
    </div>

    <%@ include file="/views/common/footer.jsp" %>


</body>
</html>