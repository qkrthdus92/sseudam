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
      href="<%=root1%>/resources/css/admin/yamyam/bob/list.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css?ver=2"
    />
    <style>
      .grid-col3 {
        grid-template-rows: repeat(5, 50px);
      }
    </style>
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <form action="" method="post" enctype="multipart/form-data">
    <main class="admin-main">   
      <header class="admin-main-header flex-between">
        <h1>혼자서 냠냠 - 혼밥 추가</h1>
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
            <div><input type = "text" name = "name" size="100" placeholder="이름을 입력하세요" required></div>
            <div></div>
            
            <div>타입</div>
            <div>
            	<input type = "radio" name = "cNum" value = "1" checked>맛집 
            	<input type = "radio" name = "cNum" value = "2">카페
            	<input type = "radio" name = "cNum" value = "3">술집
            </div>
            <div></div>
            
            <div>주소</div>
            <div><input type = "text" name = "addr" size="100" placeholder="주소을 입력하세요"></div>
            <div></div>
            
            <div>전화번호</div>
            <div><input type = "text" name = "phone" size="100" placeholder="번호를 입력하세요"></div>
            <div></div>
            
            <div>링크</div>
            <div><input type = "text" name = "link" size="100" placeholder="링크를 입력하세요"></div>
            <div></div>
            
            <div>대표사진</div>            
            <div><input type="file" value="upload" class="upload-btn" name="file"></div>
            <div></div>
            
          </div>
        </div>
      </section>
    </main>
    </form>
  </body>
</html>
