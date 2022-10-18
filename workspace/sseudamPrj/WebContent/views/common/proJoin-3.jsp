<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 작성</title>
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
        display: grid;
        grid-template-rows: 1fr 5fr 6fr;;
        /* grid-template-columns: 1fr 2fr 2fr; */


    }
    
    img{
        width: 60px;
        height: 60px;
    }
    
    input:focus {outline: none;}


    input[type="submit"]{
        width: 167px;
        height: 42px;
        border: none;
        border-radius: 5px;
        color: white;
        background-color: rgba(163, 215, 165, 1);
        font-size: 18px;
        margin-top: 10px;
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

            <div class="join-guide">
                <h2>프로필 작성</h2>
                <h4>쓰담쓰담 대표 프로필과 소개 내용을 작성해 주세요.</h4>
            </div>
    
            <div class="profile">
                <div></div>
                <div></div>
                <div></div>
            </div>

            <div>
                <br><input type="submit" value="작성 완료" class="btn">
            </div>

        </div>

        
    </nav>>

    <%@ include file="/views/common/footer.jsp" %>

</body>
</html>