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
      href="<%=root1%>/resources/css/common/variables.css?ver=3"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/faq/list.css?ver=3"
    />
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header">
        <h1>FAQ</h1>
      </header>
      <section class="admin-main-section">
        <div class="admin-main-section-top">
          <div class="admin-search">
            <input type="text" placeholder="내용을 입력해주세요" />
            <i class="fa-solid fa-magnifying-glass"></i>
          </div>

          <div class="add-btn">
            <input
              type="button"
              value="게시글 작성"
              onclick="location.href='<%=root%>/views/admin/faq/add.jsp'"
            />
          </div>
        </div>
        <div class="admin-main-wrapper">
          <div class="admin-main-board-top">
            <div class="total-num-info">
              <span>전체 게시글</span><span>10</span>
            </div>
            <div class="main-select-btn">
              <select name="" id="">
                <option value="">모든 게시글 조회</option>
                <option value="">게시 완료 조회</option>
                <option value="">게시 취소 조회</option>
              </select>
            </div>
          </div>
          <div class="admin-main-board">
            <div>번호</div>
            <div>제목</div>
            <div>작성자</div>
            <div>작성일시</div>
            <div>조회수</div>
            <div>최종수정일자</div>
            <div>게시여부</div>

            <%for(int i=1; i<=10; i++) {%>
            <div>1</div>
            <div>
              <a href="<%=root%>/views/admin/faq/detail.jsp"
                >제가 누른 좋아요를 보고싶어요. 어디서 확인할 수 있나요?</a
              >
            </div>
            <div>admin01</div>
            <div>2022-10-16 23:36:30</div>
            <div>100</div>
            <div>2022-10-16 23:36:30</div>
            <div>게시완료</div>

            <%}%>
          </div>
        </div>
      </section>
    </main>
  </body>
</html>
