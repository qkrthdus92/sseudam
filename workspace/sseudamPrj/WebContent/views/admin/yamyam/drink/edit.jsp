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
      href="<%=root1%>/resources/css/common/variables.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/yamyam/drink/list.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css?ver=1"
    />
    <style>
      .grid-col3 {
        grid-template-rows: repeat(10, 50px);
      }
    </style>
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header flex-between">
        <h1>혼자서 냠냠 - 혼술 정보 수정</h1>
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
            <div>번호</div>
            <div>1</div>
            <div></div>
            <div>이름</div>
            <div>포비</div>
            <div></div>
            <div>주소</div>
            <div>서울특별시 종로구 종로3길 17</div>
            <div></div>
            <div>전화번호</div>
            <div>010-1234-5678</div>
            <div></div>
            <div>좋아요</div>
            <div>100</div>
            <div></div>
            <div>링크</div>
            <div>link</div>
            <div></div>
            <div>대표사진</div>
            <div><input type="file" value="업로드" class="upload-btn" /></div>
            <div></div>
            <div>게시여부</div>
            <div>게시완료</div>
            <div></div>
            <div>등록일자</div>
            <div>2022-10-10 12:12:12</div>
            <div></div>

            <div>정보수정일자</div>
            <div>2022-10-10 12:12:12</div>
            <div></div>
          </div>
          <input type="button" value="게시취소" class="delete-btn" />
        </div>
      </section>
    </main>
  </body>
</html>
