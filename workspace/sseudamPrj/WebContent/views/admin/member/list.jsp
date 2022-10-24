<%@page import="com.kh.sseudam.common.PageVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String root1 = request.getContextPath();%>
<% 
	List memberList = (List)request.getAttribute("memberList"); 
	PageVo pv = (PageVo)request.getAttribute("pv");

%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>쓰담쓰담 | 상담하기</title>
    <link rel="stylesheet" href="<%=root1%>/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/common/variables.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/member/list.css?ver=3"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css?ver=2"
    />
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header">
        <h1>사용자</h1>
      </header>
      <section class="admin-main-section">
        <div class="admin-main-section-top">
          <div class="admin-search">
            <input
              type="text"
              placeholder="사용자 이름 또는 아이디를 입력해주세요"
            />
            <i class="fa-solid fa-magnifying-glass"></i>
          </div>

          <div class="add-btn">
            <input
              type="button"
              value="사용자 추가"
              onclick="location.href='<%=root%>/views/admin/member/add.jsp'"
            />
          </div>
        </div>
        <div class="admin-main-wrapper">
          <div class="admin-main-board-top">
            <div class="total-num-info">
              <span>전체 사용자</span><span>10</span>
            </div>
            <div class="main-select-btn">
              <select name="" id="">
                <option value="">모든 회원 조회</option>
                <option value="">일반 회원 조회</option>
                <option value="">탈퇴 회원 조회</option>
              </select>
            </div>
          </div>
          <div class="admin-main-board">
            <div>번호</div>
            <div>이름</div>
            <div>아이디</div>
            <div>닉네임</div>
            <div>전화번호</div>
            <div>이메일</div>
            <div>테스트점수</div>
            <div>계정상태</div>
            <div>edit</div>
            <%for(int i=0; i<memberList.size(); i++) {%>
            <div>1></div>
            <div>한혜원</div>
            <div>user01</div>
            <div>nick01</div>
            <div>010-1234-5678</div>
            <div>hyewon@naver.com</div>
            <div>10</div>
            <div>일반회원</div>
            <div>
              <a href="<%=root%>/views/admin/member/edit.jsp"
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
