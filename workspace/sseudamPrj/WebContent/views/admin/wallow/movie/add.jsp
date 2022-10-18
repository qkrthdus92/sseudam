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
      href="/sseudamPrj/resources/css/admin/wallow/movie/list.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="/sseudamPrj/resources/css/admin/common/component.css?ver=2"
    />
    <style>
      .grid-col3 {
        grid-template-rows: repeat(6, 50px);
      }
    </style>
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header flex-between">
        <h1>안에서 뒹굴뒹굴 - 영화 추가</h1>
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
            <div>대표사진</div>
            <div>
              <input type="file" value="업로드" class="upload-btn" />
            </div>
            <div></div>
            <div>제목</div>
            <div>제목을 입력해주세요</div>
            <div></div>
            <div>출연진</div>
            <div>출연진을 입력해주세요</div>
            <div></div>

            <div>스트레스지수</div>
            <div>스트레스지수를 입력해주세요</div>
            <div></div>
            <div>링크</div>
            <div>링크를 입력해주세요</div>
            <div></div>
          </div>
        </div>
      </section>
    </main>
  </body>
</html>
