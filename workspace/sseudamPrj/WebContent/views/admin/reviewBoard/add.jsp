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
      href="<%=root1%>/resources/css/admin/reviewBoard/list.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css?ver=3"
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

      .admin-main-board-detail textarea {
        margin: 20px 20px;
        height: 500px;
      }

      input {
        border: none;
        outline: none;
        width: 100%;
        margin-left: 20px;
        font-size: 15px;
      }

      textarea {
        border: none;
        outline: none;
      }

      .file-upload {
      }
    </style>
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header flex-between">
        <h1>후기게시판 작성</h1>
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
            <div>제목</div>
            <div><input type="text" placeholder="제목을 입력해주세요" /></div>
            <div>관리자</div>
          </div>
          <div class="admin-main-board-detail">
            <div>
              <textarea
                name=""
                id=""
                cols="30"
                rows="10"
                placeholder="내용을 입력해주세요"
              ></textarea>
            </div>
            <div class="reply-header">
              <i class="fa-solid fa-image"></i>
              <span>첨부파일</span>
              <!-- <span>3</span> -->
            </div>
            <div class="file-upload">
              <input type="file" value="업로드" class="upload-btn" />
            </div>
          </div>
        </div>
      </section>
    </main>
  </body>
</html>
