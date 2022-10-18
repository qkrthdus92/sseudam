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
      href="/sseudamPrj/resources/css/admin/faq/list.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="/sseudamPrj/resources/css/admin/common/component.css?ver=2"
    />
    <style>
      .grid-col7 {
        display: grid;
        grid-template-columns: 1fr 10fr 2fr 2fr 1fr 1fr 1fr;
        grid-template-rows: 1fr;
      }

      .grid-col7 div {
        border-right: 1px solid var(--border);
        height: 40px;
      }

      .admin-main-board-detail {
        padding: 20px 20px;
        height: 500px;
      }
    </style>
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header flex-between">
        <h1>FAQ 상세조회</h1>
        <div class="btn-set">
          <input
            class="cancel-btn"
            type="button"
            value="목록"
            onclick="history.back()"
          />
          <input class="save-btn" type="submit" value="저장" />
        </div>
      </header>
      <section class="admin-main-section">
        <div class="admin-main-wrapper">
          <div class="admin-main-board grid-col7">
            <div>10</div>
            <div>제가 누른 좋아요를 보고싶어요. 어디서 확인할 수 있나요?</div>
            <div>admin01</div>

            <div>2022-10-08 12:12:12</div>
            <div><i class="fa-regular fa-eye"></i><span>100</span></div>
            <div>
              <a href="<%=root%>/views/admin/faq/edit.jsp"
                ><i class="fa-solid fa-pen-to-square"></i
              ></a>
            </div>
            <div>
              <a href="#"><i class="fa-solid fa-trash-can"></i></a>
            </div>
          </div>
          <div class="admin-main-board-detail">
            <div>로그인 후 이용가능합니다</div>
          </div>
        </div>
      </section>
    </main>
  </body>
</html>
