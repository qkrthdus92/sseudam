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

    .join-sequence > img{
        width: 50px;
        height: 15px;
        margin-right: 40px;
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

            <div class="join-sequence">
                <img src="../../resources/img/join/now.png">
                <img src="../../resources/img/join/next.png">
                <img src="../../resources/img/join/next.png">
                <img src="../../resources/img/join/next.png">
                <img src="../../resources/img/join/next.png">
            </div>

            <div class="join-1nd">
                <div>자격증 이름</div>
                <div><input type="text" name="licenseName"></div>
            </div>
            <div calss="join-2nd">
                <div>자격증 번호</div>
                <div><input type="number" name="memberPwd1"></div>
            </div>
            <div class="join-2nd2">
                <div>증빙서류</div>
                <div><input type="button" class="attached-file-btn" value="첨부파일" onclick="location.href=''"></div>
            </div>
            
            <div class="next">
                <div><br><a href="" class="next-page">다음페이지 작성</a></div>
            </div>
            
        </div>
        

    </nav>>

    <%@ include file="/views/common/footer.jsp" %>

</body>
</html>