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
      href="/sseudamPrj/resources/css/common/variables.css?ver=3"
    />
    <link
      rel="stylesheet"
      href="/sseudamPrj/resources/css/admin/common/component.css"
    />
    <link
      rel="stylesheet"
      href="/sseudamPrj/resources/css/admin/freeBoard/list.css?ver=2"
    />
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header">
        <h1>자유게시판</h1>
      </header>
      <section class="admin-main-section">
        <div class="admin-main-section-top">
          <div class="admin-search">
            <input type="text" placeholder="내용을 입력해주세요" />
            <i class="fa-solid fa-magnifying-glass"></i>
          </div>

          <div class="add-btn"><input type="button" value="게시글 작성" /></div>
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
            <div>댓글수</div>
            <div>최종수정일자</div>
            <div>게시여부</div>

            <%for(int i=1; i<=10; i++) {%>
            <div>1</div>
            <div><a href="">여행가고싶다~</a></div>
            <div>한혜원</div>
            <div>2022-10-16 23:36:30</div>
            <div>100</div>
            <div>2</div>
            <div>2022-10-16 23:36:30</div>
            <div>게시완료</div>

            <%}%>
          </div>
        </div>
      </section>
    </main>
  </body>
</html>
