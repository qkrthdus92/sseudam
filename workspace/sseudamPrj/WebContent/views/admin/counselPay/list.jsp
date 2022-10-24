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
      href="<%=root1%>/resources/css/admin/counselPay/list.css"
    />
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header">
        <h1>상담 결제 내역</h1>
      </header>
      <section class="admin-main-section">
        <div class="admin-main-section-top">
          <div class="admin-search">
            <input type="text" placeholder="내용을 입력해주세요" />
            <i class="fa-solid fa-magnifying-glass"></i>
          </div>

          <!-- <div class="add-btn"><input type="button" value="게시글 작성" /></div> -->
        </div>
        <div class="admin-main-wrapper">
          <div class="admin-main-board-top">
            <div class="total-num-info">
              <span>전체 결제 내역</span><span>10</span>
            </div>
            <div class="main-select-btn">
              <select name="" id="">
                <option value="">모든 상담 조회</option>
                <option value="">상담완료 조회</option>
                <option value="">상담대기 조회</option>
              </select>
            </div>
          </div>
          <div class="admin-main-board">
            <div>번호</div>
            <div>상담날짜</div>
            <div>결제날짜</div>
            <div>전문가아이디</div>
            <div>전문가이름</div>
            <div>회원아이디</div>
            <div>회원이름</div>
            <div>결제금액</div>
            <div>결제수단</div>
            <div>별점</div>
            <div>상담상태</div>

            <%for(int i=1; i<=10; i++) {%>
            <div>1</div>
            <div>2022-10-16</div>
            <div>2022-10-16 12:12:12</div>
            <div>hyewon</div>
            <div>한혜원</div>
            <div>bonghee</div>
            <div>봉달희</div>
            <div>50000</div>
            <div>휴대폰</div>
            <div>3</div>
            <div>상담완료</div>

            <%}%>
          </div>
        </div>
      </section>
    </main>
  </body>
</html>
