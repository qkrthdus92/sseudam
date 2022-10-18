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
      href="/sseudamPrj/resources/css/admin/test/list.css?ver=1"
    />
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header">
        <h1>스트레스 테스트</h1>
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
              value="질문 작성"
              onclick="location.href='<%=root%>/views/admin/test/add.jsp'"
            />
          </div>
        </div>
        <div class="admin-main-wrapper">
          <div class="admin-main-board-top">
            <div class="total-num-info">
              <span>전체 게시글</span><span>10</span>
            </div>
            <!-- <div class="main-select-btn">
              <select name="" id="">
                <option value="">모든 게시글 조회</option>
                <option value="">게시 완료 조회</option>
                <option value="">게시 취소 조회</option>
              </select>
            </div> -->
          </div>
          <div class="admin-main-board">
            <div>번호</div>
            <div>질문</div>
            <div>수정</div>
            <div>삭제</div>

            <%for(int i=1; i<=10; i++) {%>
            <div>1</div>
            <div>
              <a href=""
                >당신이 통제할 수 없는 일 때문에 화가 난 경험이 많은편입니까?</a
              >
            </div>
            <div>
              <a href="<%=root%>/views/admin/test/edit.jsp"
                ><i class="fa-solid fa-pen-to-square"></i
              ></a>
            </div>
            <div>
              <a href=""><i class="fa-regular fa-trash-can"></i></a>
            </div>

            <%}%>
          </div>
        </div>
      </section>
    </main>
  </body>
</html>
