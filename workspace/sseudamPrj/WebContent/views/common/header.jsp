<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
	}
	
	.main-wrapper {
	  width: 1200px;
	  height: 100%;
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

</style>    

<header class="main-header">
      <div class="main-header-top">
        <div class="main-wrapper">
          <span><a href="">회원가입</a></span>
          <span><a href="">로그인</a></span>
        </div>
      </div>
      <div class="main-header-title">
        <div class="main-wrapper main-header-title-wrapper">
          <div class="main-header-logo">
            <a href=""><img src="./img/logo.png" alt="" /></a>
          </div>
          <div class="main-header-icons">
            <div class="main-header-icon">
              <a href=""><i class="fa-solid fa-heart"></i><span>저장</span></a>
            </div>
            <div class="main-header-icon">
              <a href=""><i class="fa-regular fa-user"></i><span>마이</span></a>
            </div>
          </div>
        </div>
      </div>
      <div class="main-header-nav">
        <div class="main-wrapper">
          <div>
            <a href="">스트레스 테스트</a>
            <div class="main-header-nav-color"></div>
          </div>
          <div>
            <a href="">힐링하기</a>
            <div class="main-header-nav-color"></div>
          </div>
          <div>
            <a href="">상담하기</a>
            <div class="main-header-nav-color"></div>
          </div>
          <div>
            <a href="">게시판</a>
            <div class="main-header-nav-color"></div>
          </div>
          <div>
            <a href="">고객센터</a>
            <div class="main-header-nav-color"></div>
          </div>
        </div>
      </div>
    </header>
    <script
      src="https://kit.fontawesome.com/939838bb27.js"
      crossorigin="anonymous"
    ></script>