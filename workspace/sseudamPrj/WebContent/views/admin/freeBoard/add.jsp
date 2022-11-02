<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String root1 = request.getContextPath(); String pno =
(String)request.getAttribute("pno"); String status =
(String)request.getAttribute("status"); String search =
(String)request.getAttribute("search"); String searchType =
(String)request.getAttribute("searchType"); %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>쓰담쓰담 관리자 | 자유게시판 | 글쓰기</title>
    <link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" />
    <link rel="stylesheet" href="<%=root1%>/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/common/variables.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/freeBoard/list.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css?ver=5"
    />
    <style>
      .grid-col3 {
        display: grid;
        grid-template-columns: 1fr 10fr 2fr;
        grid-template-rows: 1fr;
      }

      .grid-col3 div {
        border-right: 1px solid var(--border);
        height: 40px;
        padding-left: 0px;
        font-size: 15px;
      }

      .grid-col3 div:first-child {
        display: flex;
        justify-content: center;
        align-items: center;
      }

      .grid-col3 div:last-child {
        display: flex;
        justify-content: center;
        align-items: center;
      }

      input {
        border: none;
        outline: none;
        width: 100%;
        margin-left: 20px;
        font-size: 15px;
      }
    </style>
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <form action="<%=root1%>/admin/freeBoard/write" method="post">
        <header class="admin-main-header flex-between">
          <h1>자유게시판 작성</h1>
          <div class="btn-set">
            <input
              class="cancel-btn"
              type="button"
              value="취소"
              onclick="location.href='<%=root%>/admin/freeBoard/list?pno=<%=pno%>&status=<%=status%>&search=<%=search%>&searchType=<%=searchType%>'"
            />
            <input class="save-btn" type="submit" value="저장" />
          </div>
        </header>
        <section class="admin-main-section">
          <div class="admin-main-wrapper">
            <div class="admin-main-board grid-col3">
              <div>제목</div>
              <div>
                <input
                  type="text"
                  placeholder="제목을 입력해주세요"
                  name="title"
                />
              </div>
              <div>관리자</div>
            </div>
            <div class="admin-main-board-detail">
              <div>
                <textarea
                  class="freeBoard-content freeBoard-content-edit"
                  name="content"
                  id=""
                  cols="30"
                  rows="17"
                  placeholder="내용을 입력해주세요"
                ></textarea>
              </div>
            </div>
          </div>
        </section>
      </form>
    </main>
  </body>
</html>
