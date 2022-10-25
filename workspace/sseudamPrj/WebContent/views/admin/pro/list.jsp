<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String root1 = request.getContextPath();%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="<%=root1%>/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/common/variables.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/pro/list.css?ver=3"
    />
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header">
        <h1><a href="<%=root%>/admin/pro/list?pno=1&status=all">전문가</a></h1>
      </header>
      <section class="admin-main-section">
        <div class="admin-main-section-top">
          <div class="admin-search">
            <input
              type="text"
              placeholder="전문가 이름 또는 아이디를 입력해주세요"
            />
            <i class="fa-solid fa-magnifying-glass"></i>
          </div>

          <div class="add-btn">
            <input
              type="button"
              value="전문가 추가"
              onclick="location.href='<%=root%>/views/admin/pro/add.jsp'"
            />
          </div>
        </div>
        <div class="admin-main-wrapper">
          <div class="admin-main-board-top">
            <div class="total-num-info">
              <span>전체 전문가</span><span>10</span>
            </div>
            <div class="main-select-btn">
              <select name="" id="">
                <option value="">모든 회원 조회</option>
                <option value="">승인대기 회원 조회</option>
                <option value="">승인완료 회원 조회</option>
                <option value="">탈퇴 회원 조회</option>
              </select>
            </div>
          </div>
          <div class="admin-main-board">
            <div>번호</div>
            <div>이름</div>
            <div>성별</div>
            <div>아이디</div>
            <div>상담분야</div>
            <div>이메일</div>
            <div>전화번호</div>
            <div>최종학력</div>
            <div>상담금액</div>
            <div>계정상태</div>
            <div>상담현황</div>
            <div>edit</div>
            <%for(int i=1; i<=10; i++) {%>
            <div>1</div>
            <div>한혜원</div>
            <div>여</div>
            <div>pro01</div>
            <div>가족심리상담</div>
            <div>hyewon@naver.com</div>
            <div>010-1234-5678</div>
            <div>가톨릭대학교 상담심리대학원 상담학 전공 석사 졸업</div>
            <div>50000</div>
            <div>승인완료</div>
            <div>
              <a href="<%=root%>/views/admin/pro/counsel.jsp"
                ><i class="fa-solid fa-magnifying-glass"></i
              ></a>
            </div>
            <div>
              <a href="<%=root%>/views/admin/pro/edit.jsp"
                ><i class="fa-solid fa-pen-to-square"></i
              ></a>
            </div>
            <%}%>
          </div>
        </div>
      </section>
    </main>
  </body>
</html>
