<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>(일반) 회원가입</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	//[중복확인] 버튼 클릭 이벤트
	$('#idCheckBtn').click(function()){
	//AJAX 통신 시작
	$.ajax({
		type : 'POST',
		url : '/sseudam/memberJoin',
		data : {userId : $('#id').val()},
		async : false,
		success : function(data){
		var id = data;
		id(id.length > 1){
			$('#result').html("중복");
		}else{
			$('#result').html("통과");
		}
	}
		
	});
	});
});
</script>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js">
</script>
</head>
<body>

    <%@ include file="/views/common/header.jsp" %>

	<div class="main">
        <h1 align="center" class="join">회원가입</h1>
        <h4 align="center" class="join-guide">이곳은 쓰담쓰담에 함께 하실 분들을 위한 회원가입 페이지 입니다.</h4>

		<form action="/sseudam/join/memberJoin" method="post" name="join">
			<div class="join-area">
	            <div>아이디</div>
	            <div>
	            	<input type="text" id="id" class="memberId-input" name="memberId" placeholder="6~14자 이내 영문, 숫자를 포함하여 작성" required>
	            	<button type="button" id="idCheckBtn" class="overlap-check-btn" onclick="idCheck()" >중복확인</button>
	            	<div id="result"></div>
	            </div>					
	
	            <div>비밀번호</div>
	            <div>
	                <input type="password" id="pwd1" name="memberPwd1" placeholder="6~14자 이내 영문, 숫자, 특수문자를 포함하여 작성" required>
	            </div>
	
	            <div>비밀번호 확인</div>
	            <div>
	                <input type="password" id="pwd2" name="memberPwd2">
	            </div>
	
	            <div>이름</div>
	            <div>
	                <input type="text" id="name" name="memberName" required>
	            </div>
	
	            <div>닉네임</div>
	            <div>
	                <input type="text" id="nick" name="memberNick" placeholder="6~14자 이내로 작성(특수문자 불가능)" required>
	            </div>
	
	            <div>연락처</div>
	            <div>
	                <input type="tel" id="phone" name="phone" placeholder="예) 01012345678" required>
	            </div>
	
	            <div>이메일(선택)</div>
	            <div>
	                <input type="email" name="email">
	            </div>
				
	            <div class="join-TOS">
	            	<form name="checkBox">
		                <label>
		                    <input type="checkbox" id="agreeCheck" name="agreeCheck">
		                    <a style="color: red;">(필수)</a> 서비스 이용약관 및 개인정보 처리방침에 동의합니다.
		                </label>
		                <br>
		                <label>
		                    <input type="checkbox">
		                    (선택) 이벤트 진행 등의 마케팅 정보를 수신합니다.
		                </label>
	            	</form>
	            </div>
	
	            <div class="join-submit">
	                <br><input type="submit" onclick="return joincheck();" value="가입하기" class="submit">
	            </div>
	
	        </div>
		</form>

    </div>
    <script>
	    
    	function joincheck(){
    		var getId = document.getElementById("id");
    		var getPwd1 = document.getElementById("pwd1");
    		var getPwd2 = document.getElementById("pwd2");
    		var getName = document.getElementById("name");
    		var getNick = document.getElementById("nick");
    		 		
    		var id = getId.value;
    		var pwd1 = getPwd1.value;
    		var pwd2 = getPwd2.value;
    		var name = getName.value;
    		var nick = getNick.value;
    		
    		var checkId = /^[a-zA-Z0-9]{6,14}$/;	//영문+숫자
    		var checkPwd = /^(?=.*[a-zA-Z])(?=.*[#?!@$%^&*-])(?=.*[0-9]).{6,14}$/; //문자 + 특수문자
			var checkName = /^[가-힣a-zA-Z]+$/;	//한글+영문
    		
			var cb = document.checkBox;
    		
    		if(!checkId.test(id)){
    			alert("아이디는 6~14자 이내로 영문, 숫자를 포함하여 작성해 주세요.")
    			return false;
    		}
    		
    		if(!checkPwd.test(pwd1)){
    			alert("비밀번호는 6~14자 이내로 영문, 숫자, 특수문자를 포함하여 작성해 주세요.")
    			return false;
    		}
    		
    		if(pwd1 != pwd2){
    			alert("비밀번호가 일치하지 않습니다.")
    			return false;
    		}
    		
    		if(!checkName.test(name)){
    			alert("이름은 한글과 영문으로 입력해 주세요.")
    			return false;
    		}
    		
    		if(!checkName.test(nick)){
    			alert("닉네임은 한글과 영문으로 입력해 주세요.")
    			return false;
    		}
		
    		<!-- 체크여부 확인이 안 됨 -->
    		if(!cb.agreeCheck.checked){
    			alert("약관에 동의해 주세요.")
    			cb.agreeCheck.focus();
    			return false;
    		}
    		
    		
    	}

    	
    </script>

    <%@ include file="/views/common/footer.jsp" %>
    



</body>
</html>