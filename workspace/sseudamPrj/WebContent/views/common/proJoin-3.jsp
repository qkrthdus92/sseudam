<%@page import="com.kh.sseudam.pro.vo.ProJoinPage1Vo"%>
<%@page import="com.kh.sseudam.pro.vo.ProJoinPage2Vo"%>
<%@page import="com.kh.sseudam.counsel.pro.vo.ProVo"%>
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
    }

    .join-step-check > img{
        width: 20px;
        height: 20px;
        margin-left: 61%;
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
    
    #profile-img-btn{
    	height: 50px;
    	border: 1px solid red;
    }

</style>
</head>
<body>
	<% ProJoinPage1Vo proVo1 = (ProJoinPage1Vo)request.getAttribute("proVo1"); %>
	<% ProJoinPage2Vo proVo2 = (ProJoinPage2Vo)request.getAttribute("proVo2"); %>

    <%@ include file="/views/common/header.jsp" %>

	<nav>

        <h1 align="center">회원가입</h1>
        <h4 align="center">이곳은 쓰담쓰담에서 상담사로 활동하실 분들을 위한 회원가입 페이지 입니다.</h4>

	<form action="/sseudam/join/proJoinPage?page=3" method="post" enctype="multipart/form-data"> 
	
		<input type="hidden" name="memberId" value="<%= proVo1.getId() %>">
		<input type="hidden" name="memberPwd1" value="<%= proVo1.getPwd() %>">
		<input type="hidden" name="memberName" value="<%= proVo1.getName() %>">
		<input type="hidden" name="gender" value="<%= proVo1.getGender() %>">
		<input type="hidden" name="phone" value="<%= proVo1.getPhone() %>">
		<input type="hidden" name="email" value="<%= proVo1.getEmail() %>">
		
		<input type="hidden" name="education" value="<%= proVo2.getEducation() %>">
		<input type="hidden" name="certificateName" value="<%= proVo2.getCertificateName() %>">
		<input type="hidden" name="certificateNum" value="<%= proVo2.getCertificateNum() %>">
		<input type="hidden" name="cerImg" value="<%= proVo2.getImgPath() %>">
	
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

            <div class="join-guide">
                <h2>프로필 작성</h2>
                <h4>쓰담쓰담 대표 프로필과 소개 내용을 작성해 주세요.</h4>
            </div>
    
            <div class="profile">
                <div id="profile-header"></div>
                <div id="profile-middle-left">프로필 사진</div>
                <div id="profile-middle-right">
                        <div>
                            <img src="<%=root%>/resources/img/join/프로필.png" id="profile">
                        </div>
                        <div id="profile-img-btn">
                            <input type="file" id="profile-img" value="사진 선택" name="img">
                            <input type="button" value="삭제">
                        </div>
                </div>
                <div id="profile-button-left">소개</div>
                <div id="profile-button-right">
                    <div id="profile-button-right-province"><br>상담 분야<br>
                        <label>청소년
                            <input type="checkbox" name="counselType" value="1">
                        </label>
                        <label>가족심리
                            <input type="checkbox" name="counselType" value="2 ">
                        </label>
                        <label>우울증
                            <input type="checkbox" name="counselType" value="3">
                        </label>
                        <label>취업/진로
                            <input type="checkbox" name="counselType" value="4">
                        </label>
                    </div>
                    <div id="introduce">소개글
                        <br><input type="text" id="introduce-text" name="introduce">
                    </div>
                </div>
            </div>

            <div class="join-btn">
                <br><input type="submit" value="작성 완료" class="btn">
            </div>

        </div>
	</form>
		
    </nav>

    <%@ include file="/views/common/footer.jsp" %>

</body>
</html>