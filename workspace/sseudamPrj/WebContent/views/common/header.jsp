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

  .main-header-top {
    height: 30px;
    background-color: #f5f5f5;
    display: flex;
    justify-content: center;

    border-bottom: 1px solid #dfdfdf;
    font-size: 13px;
    font-weight: 600;
  }

  .main-header-top > .main-wrapper > span:last-child {
    margin-left: 10px;
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

  #login-popup {
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

/* 로그인 팝업 */

#login-popup.hide {
  display: none;	/* 아예 코드도 사라짐 */
}

#login-popup.has-filter {
  backdrop-filter: blur(4px);
  -webkit-backdrop-filter: blur(4px);
}

#login-popup .login-popup {
  width: 477px;
  height: 634px;
  display: grid;
  grid-template-rows: 42px 470px 122px;
  background: #fff;
  border-radius: 10px;
  box-shadow: 1px 1px 3px rgba(0, 0, 0, .3);
}

#login-popup .login-popup-header{
  border-radius: 10px 10px 0px 0px;
  background-color: rgba(217, 217, 217, 1);
}

#login-popup .login-popup-btn{
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
  <div class="main-header-top">
    <div class="main-wrapper">
      <span><a href="<%=root%>/sseudam/join">회원가입</a></span>
      <span><button class="popup-btn" onclick="loginPopup(true)">로그인</button></span>
    </div>
  </div>
  <div class="main-header-title">
    <div class="main-wrapper main-header-title-wrapper">
      <div class="main-header-logo">
        <a href="<%=root%>/views/main/main.jsp"
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
          	<a href="<%=root%>/views/board/reviewBoard/reviewBoardList.jsp"
            >후기게시판</a>
        </div>
      </div>
      <div>
        <a href="<%=root%>/views/mypage/customercenter.jsp">고객센터</a>
        <div class="main-header-nav-color"></div>
      </div>
    </div>
  </div>

  <!-- 로그인 팝업 -->
  <form action="/sseudam/login" method="post">
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
	            	<input type="text" name="memberId" style="width: 75%; font-size: 18px; border: none; border-bottom: 1px solid black;">
	            </div>
	            <div class="login-pwd">비밀번호</div>
	            <div>
	                <input type="password" name="memberPwd" style="width: 75%; font-size: 18px; border: none; border-bottom: 1px solid black;">
	            </div>
	          </div>
	            <div>
	              <br><a href=''><input type="submit" value="로그인" class="login-btn" ></a>
	            </div>
	      </div>
	      
	      <div class="login-popup-button">
	        <div><a href='<%=root%>/views/common/join.jsp'>회원가입</a></div>
	        <div><a href=''>아이디 찾기</a></div>
	        <div><a href=''>비밀번호 찾기</a></div>
	      </div>
	      
	    </div>
	  </div>
  </form>
  
  <%}else if(loginMember != null){%>
    <div class="main-header-top">
    <div class="main-wrapper">
      <span><div class="login-success"><a href="<%=root%>/views/mypage/main.jsp"><%= loginMember.getName() %></a> 님, 환영합니다.</div></span>
      <span><div><a href="<%= root %>/member/logout">로그아웃</a></div></span>
    </div>
  </div>
  <div class="main-header-title">
    <div class="main-wrapper main-header-title-wrapper">
      <div class="main-header-logo">
        <a href="<%=root%>/views/main/main.jsp"
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
          	<a href="<%=root%>/views/board/reviewBoard/reviewBoardList.jsp"
            >후기게시판</a>
        </div>
      </div>
      <div>
        <a href="<%=root%>/views/mypage/customercenter.jsp">고객센터</a>
        <div class="main-header-nav-color"></div>
      </div>
    </div>
  </div>
  
  <%}else{%>
      <div class="main-header-top">
    <div class="main-wrapper">
      <span><div class="login-success"><a href="<%=root%>/views/mypage/main.jsp"><%= proLoginMember.getName() %></a> 님, 환영합니다.</div></span>
      <span><div><a href="<%= root %>/member/logout">로그아웃</a></div></span>
    </div>
  </div>
  <div class="main-header-title">
    <div class="main-wrapper main-header-title-wrapper">
      <div class="main-header-logo">
        <a href="<%=root%>/views/main/main.jsp"
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
          	<a href="<%=root%>/views/board/reviewBoard/reviewBoardList.jsp"
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

<script>
    // 로그인 팝업
    function loginPopup(hasFilter) {
    const popup = document.querySelector('#login-popup');
    
    if (hasFilter) {
      popup.classList.add();
    }
    popup.classList.remove('hide');
  }

  function closeLoginPopup() {
    const popup = document.querySelector('#login-popup');
    popup.classList.add('hide');
  }
</script>

