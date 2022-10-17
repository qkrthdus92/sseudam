﻿<% String root = request.getContextPath();%>
<style>
  @import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap");

  /* 공통 */

  body {
    font-family: "Noto Sans KR", sans-serif;
    background-color: var(--base);
  }

  div,
  header,
  aside,
  section,
  main {
    box-sizing: border-box;
  }

  input,
  select {
    outline: none;
  }

  /* 쓰담쓰담 제목 부분 */

  .admin-menu {
    width: 280px;
    /* height: 1024px; */
    background-color: var(--adminMenu);
    position: fixed;
    left: 0;
    top: 0;
    bottom: 0;
  }

  .admin-menu-header {
    height: 60px;
    border-bottom: 1px solid #808080;
    font-size: 28px;
    font-weight: 600;
    color: white;
    display: flex;
    justify-content: center;
    align-items: center;
  }

  /* 메뉴 부분 */

  .admin-menu-main {
    padding: 30px 30px;
    -ms-overflow-style: none;
  }

  .admin-menu-main::-webkit-scrollbar {
    width: 8px;
  }

  .admin-menu-main::-webkit-scrollbar-thumb {
    background: rgb(110, 110, 110);
    height: 50px;
    border-radius: 10px;
  }

  .admin-menu-main::-webkit-scrollbar-track {
    background: rgb(34, 34, 34);
  }

  .admin-menu-main div {
    margin-bottom: 35px;
  }
  .admin-menu-main div h1 {
    color: var(--adminMenuTitle);
    font-size: 19px;
    margin-bottom: 10px;
    font-weight: 600;
  }

  .admin-menu-main div li a {
    color: var(--adminMenuDetail);
    font-size: 17px;
  }

  .admin-menu-main div li a:hover {
    color: var(--adminMenuHover);
  }

  .admin-menu-main div li {
    padding: 8px 0px;
  }

  /* 로그아웃 부분 */

  .admin-menu-logout {
    position: absolute;
    bottom: 0;
    height: 50px;
    width: 100%;
    background-color: black;
    display: flex;
    justify-content: flex-start;
    align-items: center;
    font-size: 18px;
    padding-left: 30px;
  }

  .admin-menu-logout i {
    color: #666666;
    margin-right: 10px;
  }

  .admin-menu-logout span {
    color: white;
  }

  .overflow {
    overflow: auto;
  }
</style>

<aside class="admin-menu">
  <header class="admin-menu-header">쓰담쓰담</header>
  <main class="admin-menu-main overflow">
    <div class="admin-menu-main-user">
      <h1>회원 관리</h1>
      <ul>
        <li><a href="<%=root%>/views/admin/member/list.jsp">사용자</a></li>
        <li><a href="<%=root%>/views/admin/pro/list.jsp">전문가</a></li>
        <li><a href="<%=root%>/views/admin/admin/list.jsp">관리자</a></li>
      </ul>
    </div>
    <div class="admin-menu-main-content">
      <h1>컨텐츠 관리</h1>
      <ul>
        <li>
          <a href="<%=root%>/views/admin/yamyam/bob/list.jsp">혼자서 냠냠</a>
        </li>
        <li>
          <a href="<%=root%>/views/admin/tiptap/culture/list.jsp"
            >밖에서 뚜벅뚜벅</a
          >
        </li>
        <li>
          <a href="<%=root%>/views/admin/wallow/music/list.jsp"
            >안에서 뒹굴뒹굴</a
          >
        </li>
      </ul>
    </div>
    <div class="admin-menu-main-board">
      <h1>게시판 관리</h1>
      <ul>
        <li>
          <a href="<%=root%>/views/admin/freeBoard/list.jsp">자유게시판</a>
        </li>
        <li>
          <a href="<%=root%>/views/admin/reviewBoard/list.jsp">후기게시판</a>
        </li>
      </ul>
    </div>
    <div class="admin-menu-main-test">
      <h1>테스트 관리</h1>
      <ul>
        <li>
          <a href="<%=root%>/views/admin/test/list.jsp">스트레스 테스트</a>
        </li>
      </ul>
    </div>
    <div class="admin-menu-main-counsel">
      <h1>전문가 상담 관리</h1>
      <ul>
        <li>
          <a href="<%=root%>/views/admin/counselPay/list.jsp">결제 내역</a>
        </li>
      </ul>
    </div>
    <div class="admin-menu-main-notice">
      <h1>고객센터 관리</h1>
      <ul>
        <li>
          <a href="<%=root%>/views/admin/faq/list.jsp">자주 묻는 질문 (FAQ)</a>
        </li>
      </ul>
    </div>
  </main>
  <div class="admin-menu-logout">
    <i class="fa-solid fa-right-from-bracket"></i><span>로그아웃</span>
  </div>
</aside>
<script
  src="https://kit.fontawesome.com/939838bb27.js"
  crossorigin="anonymous"
></script>
<script>
  window.addEventListener("resize", function () {
    console.log(window.innerHeight);
    const menu = document.querySelector(".admin-menu-main");
    menu.style.height = window.innerHeight - 110 + "px";
    console.log(menu.style.height);
  });
  console.log(window.innerHeight);
  const menu = document.querySelector(".admin-menu-main");
  menu.style.height = window.innerHeight - 110 + "px";
  console.log(menu.style.height);
</script>