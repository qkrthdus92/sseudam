<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String root2 = request.getContextPath();%> 

<style>
  /* 공통*/
  html,
  body {
    padding: 0;
    margin: 0;
  }

  div {
    box-sizing: border-box;
  }

  .main-footer {
    height: 180px;
    background-color: #f5f5f5;
    font-size: 13px;
    color: gray;
    display: flex;
    justify-content: center;
    border-top: 1px solid var(--border);
  }

  .main-footer-wrapper {
    width: 1200px;
    padding-left: 20px;
  }

  .main-footer-info:first-child {
    margin-top: 20px;
  }

  .main-footer-info:first-child div {
    display: inline-block;
    width: 10px;
    text-align: center;
  }

  .main-footer-info:nth-child(-n + 2) {
    margin-bottom: 18px;
  }

  .main-footer-info:nth-child(2) {
    display: flex;
  }

  .main-footer-info:nth-child(3) {
    display: flex;
  }

  .main-footer-info-detail {
    display: flex;
  }

  .main-footer-info-detail div:first-child {
    margin-right: 10px;
  }

  .main-footer-info-detail div:last-child {
    margin-right: 15px;
  }

  .main-footer-info a {
    color: gray;
    text-decoration: none;
  }

  .main-footer-logo {
    display: flex;
    align-items: center;
    margin-top: 10px;
  }

  .main-footer-logo div {
    margin-bottom: 3px;
  }

  .main-footer-logo > img {
    width: 20px;
    height: 20px;
    margin-right: 6px;
  }

  .main-footer-sns {
    margin-left: 60px;
    margin-top: 5px;
  }

  .main-footer-sns img {
    width: 35px;
    height: 35px;
  }
</style>
<footer class="main-footer">
  <div class="main-footer-wrapper">
    <div class="main-footer-info">
      <a href="">이용약관</a>
      <div>|</div>
      <a href="">개인정보취급방침</a>
      <div>|</div>
      <a href="">공지사항</a>
    </div>
    <div class="main-footer-info">
      <div class="main-footer-info-detail">
        <div>사업자 등록번호</div>
        <div>123-12-12345</div>
      </div>
      <div class="main-footer-info-detail">
        <div>통신판매업신고</div>
        <div>제2019-서울강남-01000호</div>
      </div>
      <div class="main-footer-info-detail">
        <div>대표</div>
        <div>김보경</div>
      </div>
      <div class="main-footer-info-detail">
        <div>주소</div>
        <div>서울특별시 강남구 테헤란로 130 호산빌딩</div>
      </div>
    </div>
    <div class="main-footer-info">
      <div class="main-footer-info-detail">
        <div>대표번호</div>
        <div>070-1234-5678</div>
      </div>
      <div class="main-footer-info-detail">
        <div>이메일</div>
        <div>cs@bitterly.com</div>
      </div>
      <div class="main-footer-info-detail">
        <div>운영시간</div>
        <div>평일10시~19시 | 휴무시간 13~14시 , 주말 및 공휴일</div>
      </div>
    </div>
    <div class="main-footer-logo">
      <img src="/sseudamPrj/resources/img/header/logo2.png" alt="" />
      <div>(주)쓰담쓰담</div>
      <div class="main-footer-sns">
        <a href=""
          ><img src="<%=root2 %>/resources/img/header/Facebook.png" alt=""
        /></a>
        <a href=""
          ><img src="<%=root2 %>/resources/img/header/Instagram.png" alt=""
        /></a>
        <a href=""
          ><img src="<%=root2 %>/resources/img/header/Twitter.png" alt=""
        /></a>
      </div>
    </div>
  </div>
</footer>
