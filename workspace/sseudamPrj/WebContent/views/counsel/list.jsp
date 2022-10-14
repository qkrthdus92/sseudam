<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="/sseudamPrj/resources/css/common/reset.css" />
    <link rel="stylesheet" href="/sseudamPrj/resources/css/counsel/list.css" />
    <link
      rel="stylesheet"
      href="/sseudamPrj/resources/css/common/variables.css"
    />
    <script src="/sseudamPrj/resources/js/counsel/list.js"></script>
  </head>
  <body>
    <%@ include file="/views/common/header.jsp" %>
    <main id="counsel-main">
      <div class="main-wrapper counsel-main-wrapper">
        <aside class="counsel-aside">
          <div class="counsel-search">
            <input
              class="border"
              type="text"
              placeholder="상담사 이름을 검색해주세요"
            />
            <i class="fa-solid fa-magnifying-glass"></i>
          </div>
          <div class="counsel-type border">
            <div class="counsel-type-header">
              <img
                src="../../resources/img/counsel/Folder_search_duotone_line.png"
                alt=""
              />

              <span>상담분야</span>
            </div>
            <ul class="counsel-type-list">
              <li>
                <label>
                  <input type="checkbox" class="counsel-type-checkbox" />

                  <img
                    class="check-icon color-gray"
                    src="../../resources/img/counsel/Check_fill.png"
                    alt=""
                  />
                  <span>청소년 상담</span>
                </label>
              </li>
            </ul>
          </div>
          <div class="counsel-choice"></div>
        </aside>
        <section class="counsel-section"></section>
      </div>
    </main>
    <%@ include file="/views/common/footer.jsp" %>
  </body>
</html>
