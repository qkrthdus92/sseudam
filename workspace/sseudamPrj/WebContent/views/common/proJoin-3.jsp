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
        grid-template-rows: 1fr 4fr 7fr;;
        grid-template-columns: 2.5fr 7.5fr;
    }
    
    #profile-header{
        border-bottom: 1px solid black;
        border-radius: 15px 15px 0px 0px;
        background-color: rgba(217, 217, 217, 1);
        grid-column: 1 / -1;
    }

    #profile-middle-left{
        border-bottom: 1px solid black;
        border-right: 1px solid black;
    }

    #profile-middle-left{
        text-align: center;
        padding: 45% 0;
        font-size: 18px;
        font-weight: bold;
    }

    #profile-middle-right{
        border-bottom: 1px solid black;
        display: flex;
    }

    #profile{
        width: 100px;
        height: 100px;
        border-radius: 70%;
        margin-left: 20px;
        margin-top: 12px;
    }

    input[type="button"]{
        border: none;
        background-color: white;
        margin-top: 70%;
        margin-left: 10px;
    }
    
    #profile-button-left{
        border-right: 1px solid black;
        text-align: center;
        padding: 65% 0;
        font-size: 18px;
        font-weight: bold;
    }

    #profile-button-right-province{
        margin-left: 5px;
    }

    #profile-button-right-province > label{
        font-size: 13px;
        margin-left: 10px;
    }
    
    img{
        width: 60px;
        height: 60px;
    }
    
    input:focus {outline: none;}


    .join-btn > .btn{
        width: 167px;
        height: 42px;
        border: none;
        border-radius: 5px;
        color: white;
        background-color: rgba(163, 215, 165, 1);
        font-size: 18px;
        margin-top: 10px;
        cursor: pointer;
    }

    #introduce{
        margin-top: 10px;
        margin-left: 5px;
    }

    #introduce-text{
        width: 300px;
        height: 100px;
        margin-left: 20px;
        margin-top: 5px;
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
                <div id="profile-header"></div>
                <div id="profile-middle-left">프로필 사진</div>
                <div id="profile-middle-right">
                        <div>
                            <img src="../../resources/img/join/프로필.png" id="profile">
                        </div>
                        <div id="profile-img-btn">
                            <input type="button" id="profile-img" value="사진 선택" onclick="location.href=''">
                            <input type="button" id="profile-img-delet" value="삭제" onclick="location.href=''">
                        </div>
                </div>
                <div id="profile-button-left">소개</div>
                <div id="profile-button-right">
                    <div id="profile-button-right-province"><br>상담 분야<br>
                        <label>청소년
                            <input type="checkbox" name="province" value="youth">
                        </label>
                        <label>가족심리
                            <input type="checkbox" name="province" value="family ">
                        </label>
                        <label>우울증
                            <input type="checkbox" name="province" value="depression">
                        </label>
                        <label>취업/진로
                            <input type="checkbox" name="province" value="course">
                        </label>
                    </div>
                    <div id="introduce">소개글
                        <br><input type="text" id="introduce-text">
                    </div>
                </div>
            </div>

            <div class="join-btn">
                <br><input type="button" value="작성 완료" onclick="location.href='<%=root%>/views/common/proJoin-4.jsp'" class="btn">
            </div>

        </div>

    </nav>

    <%@ include file="/views/common/footer.jsp" %>

</body>
</html>