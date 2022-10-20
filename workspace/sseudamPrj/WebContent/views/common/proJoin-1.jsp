<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
    	padding: 20px;
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
        font-size: 18px;
        margin-top: 10px;
        margin-bottom: 5px;
        width: 350px;
    }

    .gende-box-top{
        width: 355px;
    }

    .gender-box>label{
        font-size: 16px;
        margin-right: 20px;
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
        width: 65px;
        height: 25px;
    }

    .next-page{
        color: rgba(253, 121, 0, 1)
    }

</style>
</head>
<body>

    <%@ include file="/views/common/header.jsp" %>

	<nav>

        <h1 align="center">회원가입</h1>
        <h4 align="center">이곳은 쓰담쓰담에서 상담사로 활동하실 분들을 위한 회원가입 페이지 입니다.</h4>

        
        <div class="join-area">
            
            <div class="join-step">
                <img src="../../resources/img/join/횐가입.png">
                <img src="../../resources/img/join/자격_정보_작성.png">
                <img src="../../resources/img/join/프로필_작성.png">
                <img src="../../resources/img/join/심사_승인.png">
                <img src="../../resources/img/join/가입_완료.png">
            </div>

            <div class="join-1nd">
                <div>아이디</div>
                <div>
                    <input type="text" name="memberId" style="width: 280px;" placeholder="6~14자 이내로 영문, 숫자를 조합하여 작성">
                    <input type="button" class="overlap-check-btn" value="중복확인" onclick="location.href=''">
                </div>
            </div>

                <div calss="join-2nd">
                    <div>비밀번호</div>
                    <div><input type="password" name="memberPwd1" placeholder="6~14자 이내로 영문, 숫자, 특수문자를 조합하여 작성"></div>
                </div>
                <div class="join-2nd2">
                    <div>비밀번호 확인</div>
                    <div><input type="password" name="memberPwd2"></div>
                </div>
                <div class="join-3nd">
                    <div>이름</div>
                    <div><input type="text" name="Name"></div>
                </div>

    
            <div class="gende-box-top">성별</div>
            <div class="join-4nd">
                <div class="gender">
                    <div class="gender-box">
                            <label>여자
                                <input type="checkbox" name="gender" value="female">
                            </label>
                            <label>남자
                                <input type="checkbox" name="gender" value="male">
                            </label>
                    </div>
                </div>
            </div>
            
            <div class="join-5nd">
                <div>연락처</div>
                <div><input type="tel" name="phone" placeholder="예) 01012345678"></div>
            </div>
            <div calss="join-6nd">
                <div>이메일</div>
                <div><input type="email" name="email"></div>
            </div>
            <div class="join-under">
                <div class="TOS">
                    <div class="TOS-1nd">
                        <br>
                        <label>
                            <input type="checkbox">
                            (필수) 서비스 이용약관 및 개인정보 처리방침에 동의합니다.
                        </label>
                    </div>
                    <div calss="TOS-2nd">
                        <label>
                            <input type="checkbox">
                            (선택) 이벤트 진행 등의 마케팅 정보를 수신합니다.
                        </label>
                    </div>
                </div>
            </div>
            <div class="next">
                <div><br><a href="" class="next-page">다음페이지 작성</a></div>
            </div>
            
        </div>
        

    </nav>

    <%@ include file="/views/common/footer.jsp" %>

</body>
</html>