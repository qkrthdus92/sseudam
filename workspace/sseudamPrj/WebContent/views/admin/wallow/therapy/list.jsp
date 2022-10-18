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
      href="/sseudamPrj/resources/css/admin/common/component.css?ver=3"
    />
    <link
      rel="stylesheet"
      href="/sseudamPrj/resources/css/admin/wallow/therapy/list.css?ver=1"
    />
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header">
        <select name="" id="" onchange="window.open(value,'_self');">
          <option value="<%=root%>/views/admin/wallow/therapy/list.jsp">
            안에서 뒹굴뒹굴 - 명상
          </option>
          <option value="<%=root%>/views/admin/wallow/book/list.jsp">
            안에서 뒹굴뒹굴 - 독서
          </option>
          <option value="<%=root%>/views/admin/wallow/music/list.jsp">
            안에서 뒹굴뒹굴 - 음악
          </option>
          <option value="<%=root%>/views/admin/wallow/movie/list.jsp">
            안에서 뒹굴뒹굴 - 영화
          </option>
        </select>
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
              value="명상 추가"
              onclick="location.href='<%=root%>/views/admin/wallow/therapy/add.jsp'"
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
            <div>썸네일</div>
            <div>제목</div>
            <!-- <div>아티스트명</div> -->
            <!-- <div>앨범명</div> -->
            <div>스트레스지수</div>
            <div>등록일자</div>
            <div>최종수정일자</div>
            <div>게시여부</div>
            <div>좋아요</div>
            <div>edit</div>

            <%for(int i=1; i<=5; i++) {%>
            <div>5</div>
            <div>
              <img
                src="../../../../resources/img/admin/476078_1662402070214584.jpg"
                alt=""
              />
            </div>
            <div>생각비우기 명상</div>
            <!-- <div>Houses On The Hill</div> -->
            <!-- <div>Just Do It</div> -->
            <div>10</div>
            <div>2022-10-05 12:12:12</div>
            <div>2022-10-05 12:12:12</div>
            <div>게시완료</div>
            <div>100</div>
            <div>
              <a href="<%=root%>/views/admin/wallow/therapy/edit.jsp"
                ><i class="fa-solid fa-pen-to-square"></i
              ></a>
            </div>

            <%}%>
          </div>
        </div>
      </section>
    </main>
  </body>
</html>
