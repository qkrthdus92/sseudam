<%@page import="com.kh.sseudam.pro.vo.ProMemberJoinVo"%>
<%@page import="com.kh.sseudam.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String root = request.getContextPath();%>

<!-- 회원가입 성공 알림 -->
<%	
	String alertMsg = (String)session.getAttribute("alertMsg");
	session.removeAttribute("alertMsg");
	
	MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
	ProMemberJoinVo proLoginMember = (ProMemberJoinVo)session.getAttribute("proLoginMember");
%>

	<script>
			<%if(alertMsg != null){%>
							alert('<%= alertMsg %>');
			<%}%>
	</script>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
	
<style>
  @font-face {
    font-family: "S-CoreDream-3Light";
    src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-3Light.woff")
      format("woff");
    font-weight: normal;
    font-style: normal;
  }

  @font-face {
    font-family: "GmarketSansMedium";
    src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff")
      format("woff");
    font-weight: normal;
    font-style: normal;
  }

  ::-webkit-scrollbar {
    width: 10px; /*스크롤바의 너비*/
  }

  ::-webkit-scrollbar-thumb {
    background-color: rgb(189, 189, 189); /*스크롤바의 색상*/
    border-radius: 10px; /*스크롤바 라운드*/
  }
  ::-webkit-scrollbar-thumb:hover {
    background-color: rgb(110, 110, 110);
  }

  ::-webkit-scrollbar-track {
    background-color: rgb(255, 255, 255); /*스크롤바 트랙 색상*/
    border-radius: 10px; /*스크롤바 트랙 라운드*/
    box-shadow: inset 0px 0px 5px rgba(0, 0, 0, 0.2); /*스크롤바 트랙 안쪽 그림자*/
  }

  /* 공통*/
  html,
  body {
    padding: 0;
    margin: 0;
  }

  div {
    box-sizing: border-box;
  }

  .main-header {
    height: 169px;
    border-bottom: 1px solid #dfdfdf;
  }

  .main-wrapper {
    width: 1200px;
    /* height: 100%; */
  }
  
  .main-header-top-bg{
  	height: 30px;
  	background-color: #f5f5f5;
  	display:flex;
  	justify-content: center;
  	border-bottom: 1px solid #dfdfdf;
  }

  .main-header-top {
  	margin:auto;
  	width:1200px;        
    display: flex;
    justify-content: space-around;
    flex-direction: row;
    padding-left: 30px;


    font-size: 13px;
    font-weight: 600;
  }

  .main-header-top > .main-wrapper > span:last-child {
    margin-left: 10px;
    margin-right: 10px;
  }

  .main-header-title {
    height: 83px;
    display: flex;
    justify-content: center;
    border-bottom: 1px solid #dfdfdf;
  }

  .main-header-top > .main-wrapper {
    display: flex;
    justify-content: flex-end;
    align-items: center;
  }
	
	.main-header-top > .main-wrapper-right{
    justify-content: flex-start;
	}
  .main-header-title > .main-wrapper {
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .main-header-logo {
    position: absolute;
    top: calc(50%+37px);
  }

  .main-header-logo img {
    width: 197px;
    height: 42px;
  }

  .main-header-icons {
    position: absolute;
    right: 0;
    display: flex;
  }

  .main-header-title-wrapper {
    position: relative;
  }

  .main-header-icon > a {
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .main-header-icon > a > i {
    font-size: 20px;
  }

  .main-header-icon > a > span {
    margin-top: 5px;
    font-size: 16px;
    font-family: "GmarketSansMedium";
  }

  .main-header-icon:last-child {
    margin-left: 20px;
  }

  .main-header-nav {
    height: 57px;
    display: flex;
    justify-content: center;
    font-family: "GmarketSansMedium";
  }

  .main-header-nav > .main-wrapper {
    display: flex;
    font-size: 20px;
  }

  .main-header-nav > .main-wrapper > div {
    width: 20%;
    display: flex;
    justify-content: center;
    align-items: center;
    position: relative;
  }

  .main-header-nav-color {
    width: 100%;
    height: 5px;
    background-color: #26aa82;
    position: absolute;
    bottom: 0px;
    display: none;
  }

  .main-header-nav > .main-wrapper > div:hover > div {
    display: block;
  }

  .main-header-nav a,
  .main-header-top a,
  .main-header-icon a {
    text-decoration: none;
    color: black;
  }

  .dropdown {
    position: relative;
    display: inline-block;
  }

  .dropdown-content {
    width: 100%;
    display: none;
    position: absolute;
    top: 57px;
    z-index: 1; /*다른 요소들보다 앞에 배치*/
    font-weight: 400;
    background-color: #f9f9f9fb;
    min-width: 200px;
  }

  .dropdown-content a {
    display: block;
    text-decoration: none;
    color: rgb(37, 37, 37);
    font-size: 14px;
    padding: 12px 20px;
    text-align: center;
  }

  .dropdown-content a:hover {
    background-color: #ececec;
  }

  .dropdown:hover .dropdown-content {
    display: block;
  }
  
  /* 로그인, 아이디 찾기 팝업 */
  #login-popup,
  #find-id-popup,
  #find-pwd-popup{
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
}

.popup-btn{
  font-weight: bold;
  border: none;
  background-color: transparent;
  cursor: pointer;
}

/* 로그인, 아이디 찾기 팝업 */
#login-popup > .login-popup > .login-popup-middle > div,
#find-id-popup > .login-popup-middle > div,
#find-pwd-popup > .login-popup > login-popup-middle > div{
	font-family: "S-CoreDream-3Light";
}


#login-popup.hide,
#find-id-popup.hide,
#find-pwd-popup.hide{
  display: none;	/* 아예 코드도 사라짐 */
}

#login-popup.has-filter,
#find-id-popup.has-filter,
#find-pwd-popup.has-filter{
  backdrop-filter: blur(4px);
  -webkit-backdrop-filter: blur(4px);
}

#login-popup .login-popup,
#find-id-popup .login-popup,
#find-pwd-popup .login-popup{
  width: 477px;
  height: 634px;
  display: grid;
  grid-template-rows: 42px 470px 122px;
  background: #fff;
  border-radius: 10px;
  box-shadow: 1px 1px 3px rgba(0, 0, 0, .3);
}

#login-popup .login-popup-header,
#find-id-popup .login-popup-header,
#find-pwd-popup .login-popup-header{
  border-radius: 10px 10px 0px 0px;
  background-color: rgba(217, 217, 217, 1);
}

#login-popup .login-popup-btn,
#find-id-popup .login-popup-btn,
#find-pwd-popup .login-popup-btn{
  width: 30px;
  height: 30px;
  margin-top: 5px;
  margin-left: 92%;
  cursor: pointer;
}

.login-header{
  font-size: 25px;
  font-weight: bold;
  margin-left: 25px;
  margin-top: 40px;
}

.login-input{
  margin-left: 20%;
  margin-top: 13%;
  font-size: 18px;
}

.email,
.confmNum{
	margin-top: 10px
}

.login-pwd{
  margin-top: 20px;
}

.login-btn{
  width: 199px;
  height: 42px;
  font-size: 18px;
  margin-left: 28%;
  margin-top: 30px;
  border: none;
  border-radius: 5px;
  color: white;
  background-color: rgba(163, 215, 165, 1);
  cursor: pointer;
}

input:focus {outline: none;} /* 클릭 시 입력창 테두리 진해짐 off */

.login-popup-button{
  width: 320px;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  margin-left: 15%;
}

.login-popup-button a{
  text-decoration: none;
  color: black;
  cursor: pointer;
}

.join-btn,
.id-find-btn,
.pwd-find-btn{
  border: none;
  font-size: 16px;
  background-color: transparent;
}

/* 회원가입 성공 */
.login-success{
  font-weight: lighter;
}

.login-success a{
  font-weight: bold;
}

</style>

<header class="main-header">

<%if(loginMember == null && proLoginMember == null){%>
<!-- 로그인 OFF -->
  <div class="main-header-top-bg">
  	<div class="main-header-top">
	  	<div class="main-wrapper main-wrapper-right">
	  		<span><a href="<%=root%>/aboutUs">회사소개</a></span>
	  	</div>
	    <div class="main-wrapper">
	      <span><a href="<%=root%>/sseudam/join">회원가입</a></span>
	      <span><a href="javascript:void(0);" onclick="loginPopup(true)">로그인</a></span>
	    </div>
    </div>
  </div>
  <div class="main-header-title">
    <div class="main-wrapper main-header-title-wrapper">
      <div class="main-header-logo">
        <a href="<%=root%>/main"
          ><img src="<%= root %>/resources/img/header/logo.png" alt=""/></a>
      </div>
      <div class="main-header-icons">
        <div class="main-header-icon">
          <a href=""><i class="fa-solid fa-heart"></i><span>저장</span></a>
        </div>
        <div class="main-header-icon">
          <a href="<%=root%>/views/mypage/main.jsp"
            ><i class="fa-regular fa-user"></i><span>마이</span></a>
        </div>
      </div>
    </div>
  </div>
  <div class="main-header-nav">
    <div class="main-wrapper">
      <div>
             <a id="test-btn" onclick="loginPopup(true)">스트레스 테스트</a>
          	<%if(loginMember!=null){ %>
          	<script>
            const wirteBtn = document.querySelector('#test-btn');
            testBtn.addEventListener('click',function() {
              location.href='<%=root%>/stress/stressTest';
            })
          	</script>
          <%} %>
        <div class="main-header-nav-color"></div>
      </div>
      <div class="dropdown">
        <a href="">힐링하기</a>
        <div class="main-header-nav-color"></div>
        <div class="dropdown-content">
          <a href="<%=root%>/healing/nyam">혼자서 냠냠</a>
          <a href="<%=root%>/healing/outside">밖에서 뚜벅뚜벅</a>
          <a href="<%=root%>/healing/inside">안에서 뒹굴뒹굴</a>
        </div>
      </div>
      <div>
        <a href="<%=root%>/counsel/list?pno=1">상담하기</a>
        <div class="main-header-nav-color"></div>
      </div>
      <div class="dropdown">
        <a href="">게시판</a>
        <div class="main-header-nav-color"></div>
        <div class="dropdown-content">
			<a href="<%=root%>/board/freeBoardList?pno=1"
            >자유게시판</a>
          	<a href="<%=root%>/board/reviewBoardList?pno=1"
            >후기게시판</a>
        </div>
      </div>
      <div>
        <a href="<%=root%>/faq">고객센터</a>
        <div class="main-header-nav-color"></div>
      </div>
    </div>
  </div>

  <!-- 로그인 팝업 -->
  <form action="/sseudam/login" name="memberLoginForm" method="post">
	    <div id="login-popup" class="hide">
	    <div class="login-popup">
	      <div class="login-popup-header">
	        <img src="<%=root%>/resources/img/join/close.png" class="login-popup-btn" onclick="closeLoginPopup()">
	      </div>
	      <div class="login-popup-middle">
	          <div class="login-header">쓰담쓰담 로그인</div>
	          <div class="login-input">
	            <div class="login-in" >아이디</div>
	            <div>
	            	<input type="text" id="login-id" name="memberId" style="width: 75%; font-size: 18px; border: none; border-bottom: 1px solid black;">
	            </div>
	            <div class="login-pwd">비밀번호</div>
	            <div>
	                <input type="password" id="login-pwd" name="memberPwd" style="width: 75%; font-size: 18px; border: none; border-bottom: 1px solid black;">
	                <input type="hidden" name="abc" value="" id="ttt">
	            </div>
	          </div>
	            <div>
	              <br><a><input type="submit" value="로그인" onclick="return login();" class="login-btn" style="font-family: 'S-CoreDream-3Light';"></a>
	            </div>
	      </div>
	      
	      <div class="login-popup-button" style="font-family: 'S-CoreDream-3Light';">
	        <div><a href='<%=root%>/views/common/join.jsp' >회원가입</a></div>
	        <div><a onclick="return idFind()">아이디 찾기</a></div>
	        <div><a onclick="return pwdFind()">비밀번호 찾기</a></div>
	      </div>
	      
	    </div>
	  </div>
  </form>
  
    <!-- 아이디 찾기 팝업 -->
  <form action="/sseudam/findId" name="idFindForm" method="post">
	    <div id="find-id-popup" class="hide">
	    <div class="login-popup">
	      <div class="login-popup-header">
	        <img src="<%=root%>/resources/img/join/close.png" class="login-popup-btn" onclick="closeFindIdPopup()">
	      </div>
	      <div class="login-popup-middle">
	          <div class="login-header" style="font-family: 'S-CoreDream-3Light';">아이디 찾기</div>
	          <div class="login-input">
	            <div style="font-family: 'S-CoreDream-3Light';">이름</div>
	            <div>
	            	<input type="text" id="memberName" name="memberName" style="width: 75%; font-size: 18px; border: none; border-bottom: 1px solid black; required">
	            </div>
	            <div class="email" style="font-family: 'S-CoreDream-3Light';">이메일</div>
	            <div>
	                <input type="email" id="memberEmail" name="memberEmail" style="width: 75%; font-size: 18px; border: none; border-bottom: 1px solid black; required">
	            </div>
	          </div>
	          	<div>
	            <br><button type="button" onclick="idFound();" class="login-btn" style="font-family: 'S-CoreDream-3Light';">아이디 찾기</button>
	            <div id="idResult" style="text-align: center; margin-top: 30px;"></div>
	            </div>
	      </div>
	      
	    </div>
	  </div>
  </form> 
  
      <!-- 비밀번호 찾기 팝업 -->
  <form action="/sseudam/findId" name="pwdFindForm" method="post">
	    <div id="find-pwd-popup" class="hide">
	    <div class="login-popup">
	      <div class="login-popup-header">
	        <img src="<%=root%>/resources/img/join/close.png" class="login-popup-btn" onclick="closeFindPwdPopup()">
	      </div>
	      <div class="login-popup-middle">
	          <div class="login-header" style="font-family: 'S-CoreDream-3Light';">비밀번호 찾기</div>
	          <div class="login-input">
	            <div style="font-family: 'S-CoreDream-3Light';">이름</div>
	            <div>
	            	<input type="text" id="findPwdUserName" name="findPwdUserName" style="width: 75%; font-size: 18px; border: none; border-bottom: 1px solid black; required ">
	            </div>
	            <div style="margin-top: 10px; font-family: 'S-CoreDream-3Light';">아이디</div>
	            <div>
	            	<input type="text" id="findPwdUserId" name="findPwdUserId" style="width: 75%; font-size: 18px; border: none; border-bottom: 1px solid black; required">
	            </div>
	            <div class="email" style="font-family: 'S-CoreDream-3Light';">이메일</div>
	            <div>
	                <input type="email" id="findPwdUserEmail" name="findPwdUserEmail" style="width: 75%; font-size: 18px; border: none; border-bottom: 1px solid black; required">
	            </div>
	          </div>
	          	<div>
	            <br><button type="button" onclick="pwdFound();" class="login-btn" style="font-family: 'S-CoreDream-3Light';">비밀번호 찾기</button>
	            <div id="pwdResult" style="text-align: center; margin-top: 30px;"></div>
	            </div>
	      </div>
	      
	    </div>
	  </div>
  </form> 

  <%}else if(loginMember != null){%>
  <div class="main-header-top-bg">
    <div class="main-header-top">
	    <div class="main-wrapper main-wrapper-right">
	  		<span><a href="<%=root%>/aboutUs">회사소개</a></span>
	  	</div>
	    <div class="main-wrapper">
	      <span><div class="login-success"><a href="<%=root%>/views/mypage/main.jsp"><%= loginMember.getName() %></a> 님, 환영합니다.</div></span>
	      <span><div><a href="<%= root %>/member/logout">로그아웃</a></div></span>
	    </div>
  </div>
  </div>
  <div class="main-header-title">
    <div class="main-wrapper main-header-title-wrapper">
      <div class="main-header-logo">
        <a href="<%=root%>/main"
          ><img src="<%= root %>/resources/img/header/logo.png" alt=""
        /></a>
      </div>
      <div class="main-header-icons">
        <div class="main-header-icon">
          <a href=""><i class="fa-solid fa-heart"></i><span>저장</span></a>
        </div>
        <div class="main-header-icon">
          <a href="<%=root%>/views/mypage/main.jsp"
            ><i class="fa-regular fa-user"></i><span>마이</span></a
          >
        </div>
      </div>
    </div>
  </div>
  <div class="main-header-nav">
    <div class="main-wrapper">
      <div>
		<a href="<%=root%>/stress/stressTest">스트레스 테스트</a>
        <div class="main-header-nav-color"></div>
      </div>
      <div class="dropdown">
        <a href="">힐링하기</a>
        <div class="main-header-nav-color"></div>
        <div class="dropdown-content">
          <a href="<%=root%>/healing/nyam">혼자서 냠냠</a>
          <a href="<%=root%>/healing/outside">밖에서 뚜벅뚜벅</a>
          <a href="<%=root%>/healing/inside">안에서 뒹굴뒹굴</a>
        </div>
      </div>
      <div>
        <a href="<%=root%>/counsel/list?pno=1">상담하기</a>
        <div class="main-header-nav-color"></div>
      </div>
      <div class="dropdown">
        <a href="">게시판</a>
        <div class="main-header-nav-color"></div>
        <div class="dropdown-content">
			<a href="<%=root%>/board/freeBoardList?pno=1"
            >자유게시판</a>
          	<a href="<%=root%>/board/reviewBoardList?pno=1"
            >후기게시판</a>
        </div>
      </div>
      <div>
        <a href="<%=root%>/faq">자주묻는 질문</a>
        <div class="main-header-nav-color"></div>
      </div>
    </div>
  </div>
  
  <%}else{%>
  <div class="main-header-top-bg">
      <div class="main-header-top">
      	<div class="main-wrapper main-wrapper-right">
	  		<span><a href="<%=root%>/aboutUs">회사소개</a></span>
	  	</div>     
	    <div class="main-wrapper">
	      <span><div class="login-success"><a href="<%=root%>/views/mypage/main.jsp"><%= proLoginMember.getName() %></a> 님, 환영합니다.</div></span>
	      <span><div><a href="<%= root %>/member/logout">로그아웃</a></div></span>
	    </div>
  </div>
  </div>
  <div class="main-header-title">
    <div class="main-wrapper main-header-title-wrapper">
      <div class="main-header-logo">
        <a href="<%=root%>/sseudam/main"
          ><img src="<%= root %>/resources/img/header/logo.png" alt=""
        /></a>
      </div>
      <div class="main-header-icons">
        <div class="main-header-icon">
          <a href=""><i class="fa-solid fa-heart"></i><span>저장</span></a>
        </div>
        <div class="main-header-icon">
          <a href="<%=root%>/mypage/starupdate"
            ><i class="fa-regular fa-user"></i><span>마이</span></a>
        </div>
      </div>
    </div>
  </div>
  <div class="main-header-nav">
    <div class="main-wrapper">
      <div>
        <a href="<%=root%>/stress/stressTest">스트레스 테스트</a>
        <div class="main-header-nav-color"></div>
      </div>
      <div class="dropdown">
        <a href="">힐링하기</a>
        <div class="main-header-nav-color"></div>
        <div class="dropdown-content">
          <a href="<%=root%>/healing/nyam">혼자서 냠냠</a>
          <a href="<%=root%>/healing/outside">밖에서 뚜벅뚜벅</a>
          <a href="<%=root%>/healing/inside">안에서 뒹굴뒹굴</a>
        </div>
      </div>
      <div>
        <a href="<%=root%>/counsel/list?pno=1">상담하기</a>
        <div class="main-header-nav-color"></div>
      </div>
      <div class="dropdown">
        <a href="">게시판</a>
        <div class="main-header-nav-color"></div>
        <div class="dropdown-content">
			<a href="<%=root%>/board/freeBoardList?pno=1"
            >자유게시판</a>
          	<a href="<%=root%>/board/reviewBoardList?pno=1"
            >후기게시판</a>
        </div>
      </div>
      <div>
        <a href="<%=root%>/views/mypage/customercenter.jsp">고객센터</a>
        <div class="main-header-nav-color"></div>
      </div>
    </div>
  </div>
  <%}%>  

</header>

<script
  src="https://kit.fontawesome.com/939838bb27.js"
  crossorigin="anonymous"
></script>


<script type="text/javascript">
	// 아이디 찾기
	function idFound(){
		var getName = document.idFindForm.memberName.value;
		var getEmail = document.idFindForm.memberEmail.value;
		
		if(getName == ""){
			alert("이름을 입력해 주세요")
			document.idFindForm.memberName.focus();
			return false;
		}
		
		if(getEmail == ""){
			alert("이메일을 입력해 주세요")
			document.idFindForm.memberEmail.focus();
			return false;
		}
		
		$.ajax({
			url : "/sseudam/findId",
			method : "GET",
			data :
				{
					"userName" : $('#memberName').val(),
					"userEmail" : $('#memberEmail').val()
				},
			success : function(x){
				console.log(x);
				$('#idResult').text(x);
			},
			error : function(y){
				alert("아이디 찾기 실패");
				console.log(y);
			}
		});
	}

</script>

<script type="text/javascript">
	// 비밀번호 찾기
	function pwdFound(){
		var getName = document.pwdFindForm.findPwdUserName.value;
		var getId = document.pwdFindForm.findPwdUserId.value;
		var getEamil = document.pwdFindForm.findPwdUserEmail.value;
		
		if(getName == ""){
			alert("이름을 입력해 주세요")
			document.pwdFindForm.findPwdUserName.focus();
			return false;
		}
		
		if(getId == ""){
			alert("아이디를 입력해 주세요")
			document.pwdFindForm.findPwdUserId.focus();
			return false;
		}
		
		if(getEamil == ""){
			alert("이메일을 입력해 주세요")
			document.pwdFindForm.findPwdUserEmail.focus();
			return false;
		}
		
		$.ajax({
			url : "/sseudam/findPwd",
			method : "GET",
			data :
				{
					"userName" : $('#findPwdUserName').val(),
					"userId" : $('#findPwdUserId').val(),
					"userEmail" : $('#findPwdUserEmail').val()
				},
			success : function(x){
				console.log(x);
				$('#pwdResult').text(x);
			},
			error : function(y){
				alert("비밀번호 찾기 실패");
				console.log(y);
			}
		});
	}
	
</script>

<script>
	//로그인 체크
	function login(){
		var getId = document.memberLoginForm.memberId.value;
		var getPwd = document.memberLoginForm.memberPwd.value;
		
		if(getId == ""){
			alert("아이디를 입력해 주세요")
			document.memberLoginForm.memberId.focus();
			return false;
		}
		
		if(getPwd == ""){
			alert("비밀번호를 입력해 주세요")
			document.memberLoginForm.memberPwd.focus();
			return false;
		}
		
	}

    // (1) 로그인 팝업
    function loginPopup(hasFilter) {
    	const loginpopup = document.querySelector('#login-popup');
    
	    if (hasFilter) {
	    	loginpopup.classList.add();
	    }
	    loginpopup.classList.remove('hide');
  	}
	// (1-1)로그인 팝업 닫기
  	function closeLoginPopup() {
	    const popup = document.querySelector('#login-popup');
	    popup.classList.add('hide');
  	}
  
  	// (2) 아이디 찾기 팝업
  	function idFind(hasFilter){
		//로그인 팝업부터 닫아줘야 함
	    const closePopup = document.querySelector('#login-popup');
	    closePopup.classList.add('hide');
    
	    //아이디 찾기 팝업 ON
	    const popup = document.querySelector('#find-id-popup');
	    
	    if (hasFilter) {
	      popup.classList.add();
	    }
	    popup.classList.remove('hide');
	    
	  }
  
  	// (2-1) 아이디 찾기 팝업 닫기
  	function closeFindIdPopup() {
	    const popup = document.querySelector('#find-id-popup');
	    popup.classList.add('hide');
	  }
  	
  	// (3) 비밀번호 찾기 팝업
  	function pwdFind(hasFilter){
		//로그인 팝업부터 닫아줘야 함
	    const closePopup = document.querySelector('#login-popup');
	    closePopup.classList.add('hide');
    
	    //비밀번호 찾기 팝업 ON
	    const popup = document.querySelector('#find-pwd-popup');
	    
	    if (hasFilter) {
	      popup.classList.add();
	    }
	    popup.classList.remove('hide');
	    
	  }
  
  	// (3-1) 비밀번호 찾기 팝업 닫기
  	function closeFindPwdPopup() {
	    const popup = document.querySelector('#find-pwd-popup');
	    popup.classList.add('hide');
	  }
 
  	// 현재 있는 페이지 url
  	document.querySelector('#ttt').value = window.location.href;
  	

</script>

