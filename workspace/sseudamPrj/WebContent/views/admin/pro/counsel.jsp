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
      href="<%=root1%>/resources/css/admin/pro/counsel.css?ver=4"
    />

    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css?ver=2"
    />
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header flex-between">
        <h1>전문가 상담 현황</h1>
        <div class="btn-set">
          <input
            class="cancel-btn"
            type="button"
            value="취소"
            onclick="history.back()"
          />
        </div>
      </header>
      <section class="admin-main-section">
        <div class="admin-main-wrapper pro-counsel-info">
          <div class="admin-info-title">
            <i class="fa-solid fa-chart-line"></i><span>상담현황</span>
          </div>

          <ul>
            <li>
              <div>누적수익</div>
              <div class="counsel-profit">120000</div>
            </li>
            <li>
              <div>평균별점</div>
              <div class="counsel-avg-score">3.0</div>
            </li>
            <li>
              <div>상담완료</div>
              <div class="counsel-finish-num">4</div>
            </li>
            <li>
              <div>상담대기</div>
              <div class="counsel-wait-num">1</div>
            </li>
          </ul>
        </div>
        <div class="admin-main-wrapper pro-counsel-detail">
          <div class="admin-info-title">
            <i class="fa-solid fa-list"></i><span>상담내역</span
            ><span class="counsel-num">5</span>
          </div>
          <div class="admin-pro-certificate pro-counsel-detail-list">
            <div>번호</div>
            <div>상담날짜</div>
            <div>결제날짜</div>
            <div>회원아이디</div>
            <div>결제금액</div>
            <div>별점</div>
            <div>상담상태</div>
            <%for(int i=1; i<=5; i++) {%>
            <div>1</div>
            <div>2022-10-04</div>
            <div>2022-10-04</div>
            <div>user01</div>
            <div>30000</div>
            <div>3</div>
            <div>미완료</div>

            <%}%>
          </div>
        </div>
      </section>
    </main>
  </body>
</html>
