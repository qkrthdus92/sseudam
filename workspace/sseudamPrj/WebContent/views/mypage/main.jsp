<%@page import="com.kh.sseudam.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" />
<meta charset="UTF-8">
<title>일반회원 마이페이지 메인 :: 쓰담쓰담</title>
<style>
    #wrap{
		position: relative;
        background: #F5F5F5;
    }
    #main{
        width: 1200px;
        height: 851px;
        left: 341px;
        top: 169px;
		margin: auto;

        /* white */

        background: #FFFFFF;
        /* border */

        border: 1px solid #DFDFDF;
    }
    #left{
        position: absolute;
        width: 550px;
        height: 851px;
        background: #FFFFFF;
		box-shadow : 3px 0 0 rgba(0, 0, 0, 0.25);
        /* box-shadow: 0px 4px 20px rgba(0, 0, 0, 0.25); */
    }
    #profile{
        width: 167px;
        height: 160px;   
       margin-left: 35%;
       border-radius: 50px;
       margin-top: 5%;
    }
    #ment{
        width: 348px;
        height: 57px;
        border: 1px solid #87C57D;
        background-color: #C8FFDE ;
        color: #1EA811;
        display: flex;
        justify-content: center;
        align-items: center;
        margin-left: 20%;
        border-radius: 20px;
        font-weight: bolder;
    }
    #leftbot{
        margin-top: 10%;
        margin-left: 17%;
    }
    #leftmenu{
        font-size: 30px;
        font-weight: bold;
        line-height: 50px;
        
    }
    #right1{
        width: 530px;
        height: 286px;
        margin-left: 600px;
        margin-top: 50px;
        filter: drop-shadow(0px 4px 20px rgba(0, 0, 0, 0.25));
    }
    #righttop{
        font-size: 24px;
        background-color: #87C57D;
        color: white;
        border-top-left-radius: 20px;
        border-top-right-radius: 20px;
        text-align: left;
    }
    #rightbot{
        width: 100%;
        font-size: 20px;
        font-weight: lighter;
        background-color: white;
        text-align: left;
        line-height: 35px;
    }
    #rightbot1{
        width: 100%;
        font-size: 20px;
        font-weight: lighter;
        background-color: white;
        text-align: left;
        line-height: 35px;
        border-bottom-left-radius: 20px;
        border-bottom-right-radius: 20px;
    }
    #icon{
        width: 20px;
        height: 20px;
        margin-left: 10px;
    }
    #editbnt{
    	   position: fixed;
        left: 460px;
        top: 8px;
        cursor: pointer;
    }
    .editbnt{
        position: fixed;
        left: 460px;
        top: 8px;
        cursor: pointer;
    }
    #right2{
        width: 530px;
        height: 86px;
        margin-left: 600px;
        margin-top: -60px; /*??이유를 모르겠는 마진...근데 됨..*/
        filter: drop-shadow(0px 4px 20px rgba(0, 0, 0, 0.25));
    }
    #right3{
        width: 530px;
        height: 86px;
        margin-left:  600px;
        margin-top: 20px;
        filter: drop-shadow(0px 4px 20px rgba(0, 0, 0, 0.25));
    }
    #right4{
        width: 530px;
        height: 129px;
        margin-left: 600px;
        margin-top: 20px;
        filter: drop-shadow(0px 4px 20px rgba(0, 0, 0, 0.25)); 
    }
    #right5{
        width: 530px;
        height: 129px;
        margin-left: 600px;
        margin-top: 20px;
        filter: drop-shadow(0px 4px 20px rgba(0, 0, 0, 0.25)); 
    }
	#popup {
	  display: flex;
	  justify-content: center;
	  align-items: center;
	  position: fixed;
	  top: 0;
	  left: 0;
	  width: 100%;
	  height: 100%;
	  background: rgba(0, 0, 0, .7);
	  z-index: 1;
	  backdrop-filter: blur(4px);
	  -webkit-backdrop-filter: blur(4px);
	}
	
	#popup.hide {
	  display: none;
	}
	
	#popup.multiple-filter {
	  backdrop-filter: blur(4px) grayscale(90%);
	  -webkit-backdrop-filter: blur(4px) grayscale(90%);
	}
	
	#popup .content {
	  padding: 20px;
	  background: #fff;
	  border-radius: 5px;
	  box-shadow: 1px 1px 3px rgba(0, 0, 0, .3);
	  width: 400px;
	  height: 400px;
	} 

	.popup-head{
	width:100%;
	height:100px; 
	display:grid;
	grid-template-rows: 2fr 1fr 1fr;
	align-items:center;
	justify-content:center;
	}
	.head-title{
		margin-top: 30px;
		margin-left: 20px;
		font-size: 18px;
		font-weight: bold;
	}

	#popup-logo{
		width: 100%;
		height: 50px;
	}

	.popup-body{              
	width:100%;
	height: 220px;
	background-color:#ffffff; 
	}

	.popup-foot{                      
	width:100%;
	height:50px;
	}
	.pop-btn{ 
	display:inline-flex;           
	width:50%;                      
	height:100%;                   
	justify-content:center;        
	align-items:center;            
	float:left;  
	background-color: #87C57D;                  
	color:#FFFFFF;                
	cursor:pointer;     
	border-style: none;           
	}
	#confirm{                
	border-right:1px solid #FFFFFF;
	}
	#popup-text{
		font-size: 20px;
		margin-top: 80px;
	}
	#quit{
		padding-left: 35px;
		cursor:pointer;   
	}
	
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<div id="wrap">
	    <div id="main">
	        <div id="left">
	            <div id="leftftop">
	                <div><h1 align="center">마이페이지</h1></div>
	                <div><img id="profile" src="../../resources/img/mypage/프로필.png" alt="프로필사진"></div>
	                <div><h2 align="center"><%= loginMember.getName() %> </h2></div>
	                <div><h3 align="center"><%= loginMember.getNick() %> </h3></div>
	                <div id="ment"><%= loginMember.getId() %> 님 좋은 하루되세요.</div>
	            </div>
	            <div id="leftbot">
	                <table>
	                    <tr>
	                        <th id="leftmenu">내프로필</th>
	                        <td></td>
	                    </tr>
	                    <tr>
	                        <th id="leftmenu">내가쓴글</th>
	                        <td></td>
	                    </tr>
	                    <tr>
	                        <th id="leftmenu">나의상담</th>
	                        <td></td>
	                    </tr>
	                    <tr>
	                        <th id="leftmenu">&nbsp;&nbsp; 나의좋아요</th>
	                        <td></td>
	                    </tr>
	                     <tr>
	                        <th id="quit" align="left" onclick="location.href='/sseudam/mypage/quit';">회원탈퇴</th>
	                        <td></td>
	                    </tr>
	                </table>
	            </div>
	        </div>
	
	        <div id="right1">
	            <table>
	                <tr>
	                    <th id="righttop">&nbsp;&nbsp;&nbsp;&nbsp;내프로필 <button class="editbnt" onclick="showPopup(true)" >수정</button></th>
	                    <td></td>
	                </tr>
	                <tr>
	                    <th id="rightbot"><img  id ="icon" src="../../resources/img/mypage/전화.png" alt="전화기">&nbsp;&nbsp;전화번호</th>
	                    <td></td>
	                </tr>
	                <tr>
	                    <th id="rightbot"><img  id ="icon" src="../../resources/img/mypage/닉네임.png" alt="닉네임">&nbsp;&nbsp;닉네임</th>
	                    <td></td>
	                </tr>
	                <tr>
	                    <th id="rightbot"><img  id ="icon" src="../../resources/img/mypage/메일.png" alt="이메일">&nbsp;&nbsp;이메일</th>
	                    <td></td>
	                </tr>
	                <tr>
	                    <th id="rightbot1"><img  id ="icon" src="../../resources/img/mypage/비밀번호.png" alt="비밀번호">&nbsp;&nbsp;비밀번호</th>
	                    <td></td>
	                </tr>
	            </table>
	        </div>
	        <div id="right2">
	            <table>
	                <tr>
	                    <th id="righttop">&nbsp;&nbsp;&nbsp;&nbsp;마이테스트</th>
	                    <td></td>
	                </tr>
	                <tr>
						<!-- 점수확인페이지로이동 -->
	                    <th id="rightbot1"><img  id ="icon" src="../../resources/img/mypage/테스트.png" alt="테스트">&nbsp;&nbsp;나의 점수 <button id="editbnt" onclick="location.href='/sseudam/mypage/testscore'">조회</button></th>
	                    <td></td>
	                </tr>
	            </table>
	        </div>
	        <div id="right3">
	            <table>
	                <tr>
	                    <th id="righttop">&nbsp;&nbsp;&nbsp;&nbsp;나의좋아요</th>
	                    <td></td>
	                </tr>
	                <tr>
	                    <th id="rightbot1"><img  id ="icon" src="../../resources/img/mypage/좋아요.png" alt="좋아요">&nbsp;&nbsp;좋아요 컨텐츠 <button id="editbnt" onclick="location.href='/sseudam/mypage/likeyum?pno=1'" >조회</button></th>
	                    <td></td>
	                </tr>
	            </table>
	        </div>
	        <div id="right4">
	            <table>
	                <tr>
	                    <th id="righttop">&nbsp;&nbsp;&nbsp;&nbsp;내가쓴글</th>
	                    <td></td>
	                </tr>
	                <tr>
	                    <th id="rightbot"><img  id ="icon" src="../../resources/img/mypage/글쓰기.png" alt="글쓰기">&nbsp;&nbsp;내가 쓴 게시글조회</th>
	                    <td></td>
	                </tr>
	                <tr>
	                    <th id="rightbot1"><img  id ="icon" src="../../resources/img/mypage/댓글.png" alt="댓글">&nbsp;&nbsp;내가 쓴 댓글 <button id="editbnt" onclick="location.href='/sseudam/mypage/boardcheck?pno=1'" >조회</button></th>
	                    <td></td>
	                </tr>
	            </table>
	        </div>
	        <div id="right5">
	            <table>
	                <tr>
	                    <th id="righttop">&nbsp;&nbsp;&nbsp;&nbsp;나의상담</th>
	                    <td></td>
	                </tr>
	                <tr>
	                    <th id="rightbot"><img  id ="icon" src="../../resources/img/mypage/예약.png" alt="상담예약">&nbsp;&nbsp;상담 예약 내역조회</th>
	                    <td></td>
	                </tr>
	                <tr>
	                    <th id="rightbot1"><img  id ="icon" src="../../resources/img/mypage/결제.png" alt="결제2">&nbsp;&nbsp;결제 내역 <button id="editbnt" onclick="location.href='/sseudam/mypage/resercheck?pno=1'" >조회</button></th>
	                    <td></td>
	                </tr>
	            </table>
	        </div>
	    </div>
	    
		<div id="popup" class="hide">
		  <div class="content">
				<div class="popup-head">
					<div  ><img id="popup-logo" src="../../resources/img/header/logo.png" alt=""></div>
					<div class="head-title">&nbsp;&nbsp;&nbsp;&nbsp;프로필 수정을 위해 <br> 비밀번호를 입력해주세요.</div>
				</div>
				<form action="/sseudam/mypage/edit" onsubmit="return check();">
					<div class="popup-body">
						<label id="popup-text"> 비밀번호 :</label>
						<input id="popup-text" type="password" name="memberPwd1">
					</div>
					<div class="popup-foot">
						<!-- 프로필수정페이지로이동 -->
						<input type="submit" class="pop-btn" id="confirm"   type="submit" value="확인">
						<button class="pop-btn" id="close" onclick="closePopup()" >창 닫기</button>
					</div>
				</form>
		  </div>
		</div>

	</div>
	<%@ include file="/views/common/footer.jsp" %>
    
<script type="text/javascript">
	function showPopup(multipleFilter) {
		const popup = document.querySelector('#popup');
	  
	  if (multipleFilter) {
	  	popup.classList.add('multiple-filter');
	  } else {
	  	popup.classList.remove('multiple-filter');
	  }
	  
	  popup.classList.remove('hide');
	}
	
	function closePopup() {
		const popup = document.querySelector('#popup');
	  popup.classList.add('hide');
	}

</script>

<%-- <script type="text/javascript">
//비번 일치여부 체크
const pwd1 = document.querySelector("input[name=memberPwd1]");
const pwd2 = '<%= loginMember.getPwd()%>';

function check(){
	if(pwd1.value.length > 0 && pwd1.value == pwd2.value){
		return true;
	}else{
		alert('패스워드가 일치하지 않습니다.');
		return false;
	}
}	

</script> --%>



</body>
</html>