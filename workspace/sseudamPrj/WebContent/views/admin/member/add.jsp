<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="/sseudamPrj/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="/sseudamPrj/resources/css/common/variables.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="/sseudamPrj/resources/css/admin/member/list.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="/sseudamPrj/resources/css/admin/common/component.css?ver=1"
    />
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header flex-between">
        <h1>사용자 추가</h1>
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
            <div>이름</div>
            <div>이름을 입력해주세요</div>
            <div></div>
            <div>아이디</div>
            <div>아이디를 입력해주세요</div>
            <div>
              <input type="submit" value="중복확인" class="check-btn" />
            </div>
            <div>닉네임</div>
            <div>닉네임을 입력해주세요</div>
            <div></div>
            <div>이메일</div>
            <div>이메일을 입력해주세요</div>
            <div></div>
            <div>비밀번호</div>
            <div>비밀번호를 입력해주세요</div>
            <div></div>
            <div>전화번호</div>
            <div>전화번호를 입력해주세요</div>
            <div></div>
          </div>
        </div>
      </section>
    </main>
  </body>
</html>
