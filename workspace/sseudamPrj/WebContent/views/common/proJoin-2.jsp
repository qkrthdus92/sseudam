<%@page import="com.kh.sseudam.pro.vo.ProJoinPage1Vo"%>
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
        padding-bottom: 25px;
    }

    .join-step-check > img{
        width: 20px;
        height: 20px;
        margin-left: 35%;
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
        border: 1px solid white;
        font-size: 13px;
        width: 73px;
        height: 25px;
    }

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
	<% ProJoinPage1Vo proVo1 = (ProJoinPage1Vo)request.getAttribute("proVo1"); %>
	
    <%@ include file="/views/common/header.jsp" %>

	<nav>

        <h1 align="center">회원가입</h1>
        <h4 align="center">이곳은 쓰담쓰담에서 상담사로 활동하실 분들을 위한 회원가입 페이지 입니다.</h4>

	<form action="/sseudam/join/proJoinPage?page=2" method="post" enctype="multipart/form-data">
	
		<input type="hidden" name="memberId" value="<%= proVo1.getId() %>">
		<input type="hidden" name="memberPwd1" value="<%= proVo1.getPwd() %>">
		<input type="hidden" name="memberName" value="<%= proVo1.getName() %>">
		<input type="hidden" name="gender" value="<%= proVo1.getGender() %>">
		<input type="hidden" name="phone" value="<%= proVo1.getPhone() %>">
		<input type="hidden" name="email" value="<%= proVo1.getEmail() %>">
		
	
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

            <div class="join-0nd">
                <div>최종학력</div>
                <div><input type="text" name="education" placeholder="예) ㅇㅇㅇ대학교 석사" required></div>
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
                    <input type="file" id="cerFile" class="attached-file-btn" name="imgPath" value="첨부파일">
                </div>
                <div>
                    <div>
                    <input type="text" id="cer-file-upload-name" name="attached-file-name">
					<script type="text/javascript">
				      var jq = jQuery.noConflict();
				      
				      jq("#cerFile").on('change', function() {
				         var fileName = jq("#cerFile").val();
				         jq("#cer-file-upload-name").val(fileName);
				      });
				   </script>
                    </div>
                </div>
            </div>
            <div class="license">
                <div class="license-header">&nbsp;자격증 목록</div>
               	<div>자격증 이름</div>
               	<div>자격증 번호</div>
               	<div>증빙서류</div>
            </div>
            
            <div class="next">
              	<br>
                <div><input type="submit" class="next-page" value="다음 페이지 작성"></div>
            </div>
            
        </div>
	</form>

    </nav>

    <%@ include file="/views/common/footer.jsp" %>

</body>
</html>