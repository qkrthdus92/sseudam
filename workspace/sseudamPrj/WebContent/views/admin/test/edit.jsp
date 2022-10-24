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
      href="<%=root1%>/resources/css/admin/test/list.css?ver=1"
    />
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header flex-between">
        <h1>스트레스 테스트 수정</h1>
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
        <div class="admin-main-section-top">
          <div class="admin-search">
            <input type="text" placeholder="내용을 입력해주세요" />
            <i class="fa-solid fa-magnifying-glass"></i>
          </div>

          <div class="add-btn"><input type="button" value="질문 작성" /></div>
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
              <a href=""
                ><i class="fa-solid fa-pen-to-square icon-block"></i
              ></a>
            </div>
            <div>
              <a href=""><i class="fa-regular fa-trash-can icon-block"></i></a>
            </div>

            <%}%>
          </div>
        </div>
      </section>
    </main>
  </body>
</html>
