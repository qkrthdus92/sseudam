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
      href="<%=root1%>/resources/css/admin/member/list.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css?ver=1"
    />
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header flex-between">
        <h1>사용자 정보 수정</h1>
        <div class="btn-set">
          <input
            class="cancel-btn"
            type="button"
            value="취소"
            onclick="history.back()"
          />
          <input class="save-btn" type="submit" value="저장" />
        </div>
      </header>
      <section class="admin-main-section">
        <div class="admin-main-wrapper">
          <div class="admin-main-board grid-col3">
            <div>번호</div>
            <div>1</div>
            <div></div>
            <div>이름</div>
            <div>한혜원</div>
            <div></div>
            <div>아이디</div>
            <div>user01</div>
            <div>
              <input type="submit" value="중복확인" class="check-btn" />
            </div>
            <div>비밀번호</div>
            <div>1234</div>
            <div></div>
            <div>닉네임</div>
            <div>nick01</div>
            <div></div>
            <div>전화번호</div>
            <div>010-1234-5678</div>
            <div></div>
            <div>이메일</div>
            <div>hyewon@naver.com</div>
            <div></div>
            <div>테스트점수</div>
            <div>20</div>
            <div></div>
            <div>가입일</div>
            <div>2022-10-10 12:12:12</div>
            <div></div>
            <div>계정상태</div>
            <div>일반회원</div>
            <div></div>
            <div>정보수정일자</div>
            <div>2022-10-10 12:12:12</div>
            <div></div>
          </div>
          <input type="button" value="회원탈퇴" class="delete-btn" />
        </div>
      </section>
    </main>
  </body>
</html>
