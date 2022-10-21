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
      href="/sseudamPrj/resources/css/counsel/detail.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="/sseudamPrj/resources/css/common/variables.css"
    />
  </head>
  <body>
    <%@ include file="/views/common/header.jsp" %>
    <main id="counsel-detail-main">
      <div class="main-wrapper counsel-detail-main-wrapper">
        <div class="counsel-detail-top">
          <div class="counsel-detail-pro-img">
            <img src="../../resources/img/counsel/Rectangle 4019.png" alt="" />
          </div>
          <div class="counsel-detail-pro-summary">
            <div class="counsel-pro-name">주연희</div>
            <div class="counsel-pro-type">청소년 상담</div>
            <div class="counsel-pro-introduce">
              마음의 평안과 진정한 나를 찾아 떠나는 여행으로 초대합니다.
            </div>
            <div class="counsel-pro-review">
              <i class="fa-solid fa-star"></i>
              <div>4.9</div>
              <div>(86)</div>
            </div>
            <div class="counsel-pro-price">
              <div>1회상담</div>
              <div>50,000</div>
            </div>
            <div class="counsel-detail-appoint-btn">
              <a href="<%=root%>/views/counsel/pay.jsp">상담받기</a>
            </div>
          </div>
          <div class="counsel-detail-notice">
            <div class="counsel-detail-notice-title">
              <img
                src="../../resources/img/counsel/Chat_alt_3_light.png"
                alt=""
              /><span>알려드립니다!</span>
            </div>
            <ul>
              <li>
                <div>·</div>
                <span
                  >쓰담쓰담은 상담 결제 후 전문가와 일정을 조율하여 예약
                  상담으로 진행됩니다.</span
                >
              </li>
              <li>
                <div>·</div>
                <span>결제 후 예약 확인 정보를 문자로 보내드립니다.</span>
              </li>
              <li>
                <div>·</div>
                <span>결제 후 바로 상담이 불가능할 수 있습니다.</span>
              </li>
              <li>
                <div>·</div>
                <span>결제 후 환불이 불가합니다.</span>
              </li>
            </ul>
          </div>
        </div>
        <div class="counsel-detail-border"></div>
        <div class="counsel-detail-introduce">
          <div class="counsel-detail-introduce-title">
            <span>전문가 소개</span>
          </div>
          <div class="counsel-detail-introduce-certificate">
            <div><i class="fa-solid fa-award"></i><span>자격증</span></div>
            <ul>
              <li>상담심리사 2급</li>
              <li>상담심리사 2급</li>
              <li>상담심리사 2급</li>
            </ul>
          </div>
          <div class="counsel-detail-introduce-edu">
            <div>
              <i class="fa-solid fa-graduation-cap"></i><span>학력</span>
            </div>
            <ul>
              <li>가톨릭대학교 상담심리대학원 상담학 전공 석사 졸업</li>
            </ul>
          </div>
        </div>
      </div>
    </main>

    <%@ include file="/views/common/footer.jsp" %>
  </body>
</html>
