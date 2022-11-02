<%@page import="com.kh.sseudam.pro.vo.ProJoinPage2Vo"%>
<%@page import="com.kh.sseudam.pro.vo.ProJoinPage1Vo"%>
<%@page import="com.kh.sseudam.counsel.pro.vo.ProVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		ProJoinPage2Vo ProVo2 = (ProJoinPage2Vo)session.getAttribute("ProJoinPage2Vo");
%>

<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" />
<meta charset="UTF-8">
<title>전문가 회원가입 :: 쓰담쓰담</title>
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

    .join-top > input::placeholder{
        font-size: 13px;
        color:rgba(204, 204, 204, 1);
    }
    
   .join-top > div > input[type="text"]{
        font-size: 16px;
        margin-left: 15px;
   }
    
    img{
        width: 60px;
        height: 60px;
    }
    
    input:focus {outline: none;}

	.cer-upload{
		margin-top: 20px;
		margin-right: 37%;
	}

    .education{
        border: none;
        border-bottom: 1px solid black;
        font-size: 15px;
        margin-top: 10px;
        margin-bottom: 5px;
        width: 200px;
        height: 20px;
    }
	
	.join-middle > .join-middle-list{
		width: 550px;
		height: 25px;
        display: grid;
        grid-template-columns: 1.2fr 1.5fr 1.1fr;
        text-align: center;
        margin-top: 10px;
        margin-bottom: 2px;
        margin-left: 20px;
        font-size: 13px;
        border-radius: 13px 13px 0px 0px;
        background-color: rgba(217, 217, 217, 1);
	}
	
    .join-middle > .join-middle-list > div{
        margin-top: 3px;
        font-weight: bold;
    }

    .join-middle > .cer-upload{
        padding-left: 28px;
        font-size: 14px;
        color: gray;
    }

	.cer-edit > div{
		width: 520px;
        display: grid;
        grid-template-columns: 1fr 1fr 0.8fr;
        text-align: center;
        border-bottom: 1px solid rgba(217, 217, 217, 1);
	}
	
	.cer-edit > div > div > input[type="text"]
	{
		border: none;
        text-align: center;
        font-size: 13px;
        padding: 7px;
	}
	
	.cer-edit > div > div > input[type="file"]{
		padding: 3px;
	}
	
	.plus-btn{
		margin-top: 10px;
	}

    .next-page{
        color: rgba(253, 121, 0, 1);
        background-color: white;
        border: none;
		cursor: pointer;
        font-size: 15px;
        text-align: center;
        font-family: 'S-CoreDream-3Light';
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

            <div class="join-top">
                <div>최종학력<input type="text" class="education" name="education" placeholder="예) ㅇㅇㅇ대학교 석사" required></div>
            </div>
            
            <div class="join-middle">
                <div class="cer-upload">* 이곳에서 자격증을 등록해주세요.</div>
                <div class="join-middle-list">
                    <div>자격증 이름</div>
                    <div>자격증 번호</div>
                    <div>증빙서류</div>
                </div>
            </div>
			
			<div class="cer-edit">
				<div>
					<div><input type='text' class='cer-edit' name='certificateName' placeholder='자격증 이름을 입력하세요' /></div>
					<div><input type='text' class='cer-edit' name='certificateNum' placeholder='자격번호를 입력하세요' /></div>
					<div><input type='file' class='upload-btn' name='imgPath' multiple/></div>
				</div>
			</div>
			
	          <div class="cer-edit cer-target">
	          
	           
	            
	            
	       
	          </div>


			<input type="button" class="plus-btn" value="추가" onclick="cerAd();">
		          
	            <div class="next">
	              	<br>
	                <div><input type="submit" class="next-page" value="다음 페이지 작성"></div>
	            </div>
				   
                    </div>
                </div>
            </div>
            
        
	</form>
    </nav>

     <script>
      function cerAd() {
      
        const cerTarget = document.querySelector('.cer-target');
        const newDiv0 = document.createElement('div');

        const newDiv1 = document.createElement('div');
        newDiv1.innerHTML = "<input type='text' class='cer-edit' name='certificateName' placeholder='자격증 이름을 입력하세요' />";
        const newDiv2 = document.createElement('div');
        newDiv2.innerHTML = "<input type='text' class='cer-edit' name='certificateNum' placeholder='자격번호를 입력하세요' />";
        const newDiv3 = document.createElement('div');
        newDiv3.innerHTML = "<input type='file' class='upload-btn' name='imgPath' multiple/>";

        newDiv0.appendChild(newDiv1);
        newDiv0.appendChild(newDiv2);
        newDiv0.appendChild(newDiv3);

        cerTarget.appendChild(newDiv0);
       

      }
    </script>

    <%@ include file="/views/common/footer.jsp" %>

</body>
</html>