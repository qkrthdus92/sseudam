<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%><% String root1 = request.getContextPath();%>
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
      href="<%=root1%>/resources/css/admin/common/component.css?ver=3"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/yamyam/drink/list.css?ver=2"
    />
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header">
        <select name="" id="" onchange="window.open(value,'_self');">
          <option value="<%=root%>/views/admin/yamyam/drink/list.jsp">
            혼자서냠냠 - 혼술
          </option>
          <option value="<%=root%>/views/admin/yamyam/bob/list.jsp">
            혼자서냠냠 - 혼밥
          </option>
          <option value="<%=root%>/views/admin/yamyam/cafe/list.jsp">
            혼자서냠냠 - 혼카페
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
              value="혼술 추가"
              onclick="location.href='<%=root%>/views/admin/yamyam/drink/add.jsp'"
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
            <div>이름</div>
            <div>주소</div>
            <div>전화번호</div>
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
            <div>포비</div>
            <div>서울특별시 종로구 종로3길 17</div>
            <div>010-1234-5678</div>
            <div>2022-10-04 12:12:12</div>
            <div>2022-10-04 12:12:12</div>
            <div>게시완료</div>
            <div>100</div>
            <div>
              <a href="<%=root%>/views/admin/yamyam/drink/edit.jsp"
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
