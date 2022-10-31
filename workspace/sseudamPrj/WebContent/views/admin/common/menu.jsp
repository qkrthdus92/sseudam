<%@page import="com.kh.sseudam.admin.common.AdminVo"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions" %> <% String root =
request.getContextPath();%> <% String alertMsg =
(String)session.getAttribute("alertMsg"); session.removeAttribute("alertMsg");
AdminVo loginAdmin = (AdminVo)session.getAttribute("loginAdmin"); %>
<link
  rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css"
/>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
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
    height: 100px;
    /* border-bottom: 1px solid #808080; */
    font-size: 28px;
    font-weight: 600;

    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }

  .admin-menu-header a {
    color: white;
    margin-bottom: 10px;
  }

  /* 메뉴 부분 */

  .admin-menu-main {
    padding: 40px 30px;
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
    margin-bottom: 45px;
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

  .admin-menu-logout a {
    color: white;
  }

  .overflow {
    overflow: auto;
  }
  .welcome {
    font-size: 14px;
    margin-top: 3px;
    color: #26aa82;
  }
</style>

<aside class="admin-menu">
  <header class="admin-menu-header">
    <a href="<%=root%>/main" target="_blank">쓰담쓰담</a>
    <div class="welcome"><%=loginAdmin.getId()%>님 환영합니다</div>
  </header>
  <main class="admin-menu-main overflow">
    <div class="admin-menu-main-user">
      <h1>회원 관리</h1>
      <ul>
        <li>
          <a href="<%=root%>/admin/member/list?pno=1&quitYn=both">사용자</a>
        </li>
        <li><a href="<%=root%>/admin/pro/list?pno=1&status=all">전문가</a></li>
        <!-- <li><a href="<%=root%>/views/admin/admin/list.jsp">관리자</a></li> -->
      </ul>
    </div>
    <div class="admin-menu-main-content">
      <h1>컨텐츠 관리</h1>
      <ul>
        <li>
          <a href="<%=root%>/admin/nyam">혼자서 냠냠</a>
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
          <a
            href="<%=root%>/admin/freeBoard/list?pno=1&status=all&searchType=title&search="
            >자유게시판</a
          >
        </li>
        <li>
          <a href="<%=root%>/views/admin/reviewBoard/list.jsp">후기게시판</a>
        </li>
      </ul>
    </div>
    <!-- <div class="admin-menu-main-test">
      <h1>테스트 관리</h1>
      <ul>
        <li>
          <a href="<%=root%>/views/admin/test/list.jsp">스트레스 테스트</a>
        </li>
      </ul>
    </div> -->
    <div class="admin-menu-main-counsel">
      <h1>전문가 상담 관리</h1>
      <ul>
        <li>
          <a href="<%=root%>/admin/counselPay/list">결제 내역</a>
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
    <i class="fa-solid fa-right-from-bracket"></i
    ><a href="<%=root%>/admin/logout">로그아웃</a>
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
<script>
      <%if(alertMsg != null) {%>
        Swal.fire({
    position: 'top-end',
    icon: 'success',
    title: '<%= alertMsg%>',
    showConfirmButton: false,
    timer: 1500
  })


      <%}%>
</script>
