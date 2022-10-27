<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쓰담쓰담 회원가입</title>
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
    	padding-left: 20px;
        padding-right: 20px;
    }
    
    .join-step-check{
        width: 400px;
        padding-bottom: 25px;
    }

    .join-step-check > img{
        width: 20px;
        height: 20px;
        margin-left: 87%;
    }

    .join-area{
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    .join-guide{
        width: 473px;
    }

    .join-guide > h4{
        margin-left: 0;
    }

    .join-guide > h2{
        margin-bottom: 0;
    }

    .profile{
        width: 473px;
        height: 377px;
        border: 1px solid black;
        border-radius: 15px;
        margin: auto;
    }
    
    img{
        width: 60px;
        height: 60px;
    }
    
    .join-wait > img{
        width: 180px;
        height: 180px;
        margin-top: 55px;
    }

    .join-wait-comment{
        margin-top: 50px;
        text-align: center;
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
                <img src="<%=root%>/resources/img/join/횐가입.png">
                <img src="<%=root%>/resources/img/join/자격_정보_작성.png">
                <img src="<%=root%>/resources/img/join/프로필_작성.png">
                <img src="<%=root%>/resources/img/join/가입_완료.png">
            </div>
            
            <div class="join-step-check">
                <img src="<%=root%>/resources/img/join/단계체크.png">
            </div>

            <div class="join-wait">
                <img src="<%=root%>/resources/img/join/승인 대기.png">
            </div>

            <div class="join-wait-comment">
                심사 승인 결과는 3일 이내로 전송해 드립니다.
                <br> 입력하신 이메일을 확인해 주세요!
            </div>
        </div>

        
    </nav>

    <%@ include file="/views/common/footer.jsp" %>

</body>
</html>