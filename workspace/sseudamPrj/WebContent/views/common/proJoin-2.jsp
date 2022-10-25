<%@page import="com.kh.sseudam.counsel.pro.vo.ProVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자격 정보 입력</title>
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
    input[type="number"]{
        border: none;
        border-bottom: 1px solid black;
        font-size: 18px;
        margin-top: 10px;
        margin-bottom: 5px;
        width: 350px;
    }

    .attached-file-btn{
        color: rgba(253, 121, 0, 1);
        border: 1px solid rgba(253, 121, 0, 1);
        font-size: 13px;
        border-radius: 15px;
        background-color: white;
        width: 65px;
        height: 25px;
    }

    /* .join-sequence > img{
        width: 50px;
        height: 15px;
        margin-right: 40px;
    } */

    .license{
        display: flex;
        border: 1px solid black;
        width: 350px;
        height: 220px;
        border-radius: 5px;
        flex-direction: column;
        margin-top: 20px;
        font-size: 12px;
    }

    .license-header{
        border-radius: 5px 5px 0px 0px;
        border-bottom: 1px solid black;
        background-color: rgba(217, 217, 217, 1);
        grid-column: 1 / -1;
    }

    .next-page{
        color: rgba(253, 121, 0, 1);
        background-color: white;
        border: none;
		cursor: pointer;
        font-size: 15px;
    }

</style>
</head>
<body>

    <%@ include file="/views/common/header.jsp" %>

	<nav>

        <h1 align="center">회원가입</h1>
        <h4 align="center">이곳은 쓰담쓰담에서 상담사로 활동하실 분들을 위한 회원가입 페이지 입니다.</h4>

	<form action="/sseudam/join/proJoinPage=1" method="post"> 
        <div class="join-area">
            
            <div class="join-step">
                <img src="<%=root%>/resources/img/join/횐가입.png">
                <img src="<%=root%>/resources/img/join/자격_정보_작성.png">
                <img src="<%=root%>/resources/img/join/프로필_작성.png">
                <img src="<%=root%>/resources/img/join/심사_승인.png">
                <img src="<%=root%>/resources/img/join/가입_완료.png">
            </div>

            <!-- <div class="join-sequence">
                <img src="../../resources/img/join/now.png">
                <img src="../../resources/img/join/next.png">
                <img src="../../resources/img/join/next.png">
                <img src="../../resources/img/join/next.png">
                <img src="../../resources/img/join/next.png">
            </div> -->

            <div class="join-0nd">
                <div>최종학력</div>
                <div><input type="text" name="education" required></div>
            </div>

            <div class="join-1nd">
                <div>자격증 이름</div>
                <div><input type="text" name="certificateName" required></div>
            </div>
            <div calss="join-2nd">
                <div>자격증 번호</div>
                <div><input type="text" name="certificateNum" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" required></div>
            </div>
            <div class="join-3nd">
                <div>
                    증빙서류
                    <input type="button" class="attached-file-btn" name="imgPath" value="첨부파일" onclick="location.href=''">
                </div>
                <div>
                    <div><input type="text" name="attached-file-name"></div>
                </div>
            </div>
            <div class="license">
                <div class="license-header">&nbsp;자격증 목록</div>
                <div class="license-list"></div>
            </div>
            
            <div class="next">
              	<br>
                <div><input type="submit" class="next-page" value="다음 페이지 작성"></div>
            </div>
            
        </div>
	</form>

    </nav>>

    <%@ include file="/views/common/footer.jsp" %>

</body>
</html>