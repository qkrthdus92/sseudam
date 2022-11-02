<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" />
<meta charset="UTF-8">
<title>전문가 회원가입 :: 쓰담쓰담</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<style>

    body{
        padding: 0;
        margin: 0;
		background-color: rgba(245, 245, 245, 1);
	}

    nav{
        width: 1088px;
        height: 855px;
        background-color: white;
        display: flex;
        flex-direction: column;
        margin: auto;
        font-family: 'S-CoreDream-3Light';
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

    .join-step > img{
    	padding-left: 20px;
        padding-right: 20px;
    }
    
    .join-step-check{
        width: 350px;
        padding-bottom: 25px;
    }

    .join-step-check > img{
        width: 20px;
        height: 20px;
        margin-left: 10px;
    }

    .join-area{
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }
    
    img{
        width: 60px;
        height: 60px;
    }
    
    input:focus {outline: none;}

    input[type="text"],
    input[type="password"],
    input[type="tel"],
    input[type="email"]{
        border: none;
        border-bottom: 1px solid black;
        font-size: 16px;
        margin-top: 10px;
        margin-bottom: 5px;
        width: 350px;
    }

    .gende-box-top{
        width: 355px;
    }

    .gender-box > label{
        font-size: 16px;
        margin-right: 20px;
    }
    
   label{
        font-size: 13px;
        cursor: pointer;
    }

    input::placeholder{
        font-size: 14px;
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
        font-family: 'S-CoreDream-3Light';
    }

    .next-page{
        color: rgba(253, 121, 0, 1);
        background-color: white;
        border: none;
		cursor: pointer;
        font-size: 15px;
        font-family: 'S-CoreDream-3Light';
    }

	#memberId{
		width: 273px;
	}

    #cheIdResult{
    	font-size: 13px;
    	margin-bottom: 5px;
    }

</style>
</head>
<body>

    <%@ include file="/views/common/header.jsp" %>

	<nav>

        <h1 align="center">회원가입</h1>
        <h4 align="center">이곳은 쓰담쓰담에서 상담사로 활동하실 분들을 위한 회원가입 페이지 입니다.</h4>

	<form action="/sseudam/join/proJoinPage?page=1" method="post" enctype="multipart/form-data">  
        <div class="join-area">
            
            <div class="join-step">
                <img src="<%=root%>/resources/img/join/횐가입.png">
                <img src="<%=root%>/resources/img/join/자격_정보_작성.png">
                <img src="<%=root%>/resources/img/join/프로필_작성.png">
                <img src="<%=root%>/resources/img/join/가입_완료.png">
            </div>
            
            <div class="join-step-check">
                <img src="<%=root%>/resources/img/join/단계체크.png">
            </div>

            <div class="join-1nd">
                <div>아이디</div>
                <div>
                    <input type="text" id="memberId" name="memberId" placeholder="6~14자 이내 영문, 숫자를 포함하여 작성" maxlength="14" required>
                    <button input type="button" onclick="proIdCheck();" id="idCheckBtn" class="overlap-check-btn">중복확인</button>
                    <div id="cheIdResult" type="hidden"></div>
                </div>
            </div>

                <div class="join-2nd">
                    <div>비밀번호</div>
                    <div><input type="password" id="pwd1" name="memberPwd1" placeholder="6~14자 이내 영문, 숫자, 특수문자를 포함하여 작성" maxlength="14" required></div>
                </div>
                <div class="join-2nd2">
                    <div>비밀번호 확인</div>
                    <div><input type="password" id="pwd2" name="memberPwd2"></div>
                </div>
                <div class="join-3nd">
                    <div>이름</div>
                    <div><input type="text" id="name" name="memberName" required></div>
                </div>

    
            <div class="gende-box-top">성별</div>
            <div class="join-4nd">
                <div class="gender">
                    <div class="gender-box">
                            <label>여자
                                <input type="checkbox" id="gender1" name="gender" value="F" onclick='checkOnlyOne(this)'>
                            </label>
                            <label>남자
                                <input type="checkbox" id="gender2" name="gender" value="M" onclick='checkOnlyOne(this)'>
                            </label>
                    </div>
                </div>
            </div>
            
            <div class="join-5nd">
                <div>연락처</div>
                <div><input type="tel" id="phone" name="phone" placeholder="예) 01012345678" maxlength="13" required></div>
            </div>
            <div class="join-6nd">
                <div>이메일</div>
                <div><input type="email" id="eamil" name="email" maxlength="20" required></div>
            </div>
            <div class="join-under">
                <div class="TOS">
                    <div class="TOS-1nd">
                        <br>
                        <label>
                            <input type="checkbox" required>
	                    	<a style="color: red;">(필수)</a> 서비스 이용약관 및 개인정보 처리방침에 동의합니다.
                        </label>
                    </div>
                    <div class="TOS-2nd">
                        <label>
                            <input type="checkbox">
                            (선택) 이벤트 진행 등의 마케팅 정보를 수신합니다.
                        </label>
                    </div>
                </div>
            </div>
            <div class="next">
                <br>
                <div><input type="submit" onclick="return joincheck();" class="next-page" value="다음 페이지 작성"></div>
            </div>
            
        </div>
        
	</form>

    </nav>
    
    <script>
	    
    	function joincheck(){
    		
    		//아이디 중복확인 여부 체크
            let idCheck = $("#cheIdResult").text();

            console.log(idCheck);

            if (idCheck.includes("현재")) {
          	alert("현재 사용 중인 아이디입니다.");
              return false;
            } else if (idCheck.includes("가능한")){
          	return true;
            } else{
          	alert("아이디 중복확인을 해주세요.");
    	            return false;  
            }
    		
    		var getId = document.getElementById("memberId");
    		var getPwd1 = document.getElementById("pwd1");
    		var getPwd2 = document.getElementById("pwd2");
    		var getName = document.getElementById("name");
    		var getGender1 = document.getElementById("gender2");
    		var getGender2 = document.getElementById("gender2");
    		
    		var id = getId.value;
    		var pwd1 = getPwd1.value;
    		var pwd2 = getPwd2.value;
    		var name = getName.value;
    		var gender1 = getGender1.value;
    		var gender2 = getGender2.value;
    		
    		var checkId = /^[a-zA-Z0-9]{6,14}$/;	//영문+숫자
    		var checkPwd = /^(?=.*[a-zA-Z])(?=.*[#?!@$%^&*-])(?=.*[0-9]).{6,14}$/; //문자 + 특수문자
			var checkName = /^[가-힣a-zA-Z]+$/;	//한글+영문

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
		
    	}
	
    	/* 체크박스 하나만 선택 */
    	function checkOnlyOne(element) {
    		  
    		  const checkboxes 
    		      = document.getElementsByName("gender");
    		  
    		  checkboxes.forEach((cb) => {
    		    cb.checked = false;
    		  })
    		  
    		  element.checked = true;
    		}
    	
    </script>
    
	<script type="text/javascript">
    	// 아이디 중복 검사
    	function proIdCheck(){
    		 
    		$.ajax({
    			url : "/sseudam/ProIdCheck",
    			method : "GET",
    			data :
    				{
    					"proIdCheck" : $('#memberId').val()
    				},
    			success : function(x){
    				console.log(x);
    				$('#cheIdResult').text(x);
    			},
    			error : function(y){
    				console.log(y);
    			}
    		});
    	}
    </script>
    
    <%@ include file="/views/common/footer.jsp" %>

</body>
</html>