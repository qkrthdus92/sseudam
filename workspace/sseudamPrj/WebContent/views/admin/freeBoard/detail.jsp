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
      href="/sseudamPrj/resources/css/admin/freeBoard/list.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="/sseudamPrj/resources/css/admin/common/component.css?ver=2"
    />
    <style>
      .grid-col8 {
        display: grid;
        grid-template-columns: 1fr 10fr 2fr 2fr 1fr 1fr 1fr 1fr;
        grid-template-rows: 1fr;
      }

      .grid-col8 div {
        border-right: 1px solid var(--border);
        height: 40px;
      }

      .admin-main-board-detail {
        padding: 20px 20px;
        height: 500px;
      }

      .reply-header {
        border-top: 1px solid var(--border);
        height: 50px;
        display: flex;
        align-items: center;
        padding-left: 20px;
        font-size: 18px;
      }

      .reply-header span:nth-child(2) {
        margin: 0px 5px;
      }

      .reply-header span:nth-child(3) {
        color: var(--main);
      }
      .reply-header span:nth-child(3)::after {
        content: "개";
        color: black;
      }

      .reply-detail {
        display: grid;
        grid-template-columns: 2fr 6fr 2fr 2fr 1fr 1fr 1fr;
      }

      .reply-detail div,
      .admin-reply-form div {
        height: 44px;
        display: flex;
        align-items: center;
        justify-content: center;
      }

      .reply-detail div {
        border-bottom: 1px solid var(--border);
      }

      .reply-detail div:nth-child(-n + 7) {
        background-color: #dedbdb;
        justify-content: center;
      }

      .admin-reply-form {
        display: grid;
        grid-template-columns: 1fr 6fr 1fr;
      }

      .admin-reply-form div:nth-child(2) {
        justify-content: flex-start;
      }
    </style>
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header flex-between">
        <h1>자유게시판 상세조회</h1>
        <div class="btn-set">
          <input
            class="cancel-btn"
            type="button"
            value="목록"
            onclick="history.back()"
          />
          <!-- <input class="save-btn" type="submit" value="저장" /> -->
        </div>
      </header>
      <section class="admin-main-section">
        <div class="admin-main-wrapper">
          <div class="admin-main-board grid-col8">
            <div>10</div>
            <div>여행가고싶다~~</div>
            <div>한혜원</div>

            <div>2022-10-08 12:12:12</div>
            <div><i class="fa-regular fa-eye"></i><span>100</span></div>
            <div><i class="fa-solid fa-comment-dots"></i><span>3</span></div>
            <div>
              <a href="<%=root%>/views/admin/freeBoard/edit.jsp"
                ><i class="fa-solid fa-pen-to-square"></i
              ></a>
            </div>
            <div>
              <a href="#"><i class="fa-solid fa-trash-can"></i></a>
            </div>
          </div>
          <div class="admin-main-board-detail">
            <div>여행가고싶네여</div>
          </div>
          <div class="reply-header">
            <i class="fa-solid fa-comment-dots"></i>
            <span>댓글</span>
            <span>3</span>
          </div>
          <div class="reply-detail">
            <div>작성자</div>
            <div>댓글내용</div>
            <div>작성날짜</div>
            <div>최종수정일시</div>
            <div>삭제여부</div>
            <div></div>
            <div></div>

            <%for(int i=1; i<=3; i++) {%>
            <div>hyewon</div>
            <div>나도 가고싶다~~</div>
            <div>2022-10-08 12:12:12</div>
            <div>2022-10-08 12:12:12</div>
            <div>게시완료</div>
            <div>
              <a href="<%=root%>/views/admin/freeBoard/edit.jsp"
                ><i class="fa-solid fa-pen-to-square"></i
              ></a>
            </div>
            <div>
              <a href="#"><i class="fa-solid fa-trash-can"></i></a>
            </div>
            <%}%>
          </div>
          <div class="admin-reply-form">
            <div>관리자</div>
            <div>
              <input
                type="text"
                placeholder="댓글을 입력해주세요"
                class="admin-input"
              />
            </div>
            <div>
              <input type="submit" value="등록" class="small-add-btn" />
            </div>
          </div>
        </div>
      </section>
    </main>
  </body>
</html>
