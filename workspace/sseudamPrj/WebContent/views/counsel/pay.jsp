<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="/sseudamPrj/resources/css/common/reset.css" />
    <link rel="stylesheet" href="../../resources/css/counsel/pay.css?ver=5" />
    <link
      rel="stylesheet"
      href="/sseudamPrj/resources/css/common/variables.css"
    />
    <script src="../../resources/js/counsel/pay.js?ver=2"></script>
  </head>
  <body>
    <%@ include file="/views/common/header.jsp" %>
    <main class="counsel-pay-main">
      <form action="<%=root%>/views/counsel/list.jsp">
        <div class="main-wrapper counsel-pay-main-wrapper">
          <div class="counsel-pay-title">전문가 정보</div>
          <div class="counsel-pay-pro-info">
            <img src="../../resources/img/counsel/Rectangle 4019.png" alt="" />
            <div class="counsel-pay-pro-info-detail">
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
            </div>
          </div>
          <div class="counsel-pay-title">날짜 선택</div>
          <div class="counsel-pay-select-date">
            <div>2022년</div>
            <select name="month">
              <option value="oct">10월</option>
              <option value="nov">11월</option>
              <option value="dec">12월</option>
            </select>
            <select name="day">
              <option value="15">15일</option>
              <option value="16">16일</option>
              <option value="17">17일</option>
              <option value="18">18일</option>
              <option value="19">19일</option>
            </select>
          </div>
          <div class="counsel-pay-title">결제 수단 선택</div>
          <div class="counsel-pay-select-payment">
            <select name="payway">
              <option value="">결제 수단 선택</option>
              <option value="card">신용/체크카드</option>
              <option value="phone">휴대폰 결제</option>
            </select>
            <select name="bank" class="hidden">
              <option value="">카드 선택</option>
              <option value="">국민</option>
              <option value="">비씨</option>
              <option value="">신한</option>
              <option value="">현대</option>
              <option value="">삼성</option>
              <option value="">롯데</option>
              <option value="">외환</option>
              <option value="">NH</option>
              <option value="">하나</option>
              <option value="">우리</option>
              <option value="">광주</option>
              <option value="">씨티</option>
              <option value="">전북</option>
              <option value="">카카오뱅크</option>
              <option value="">케이뱅크</option>
            </select>
          </div>
          <div class="counsel-pay-card hidden">
            <div>
              <label
                >카드 번호<input type="text" /><span
                  >*카드번호를 입력해주세요('-'제외)</span
                ></label
              >
            </div>
            <div>
              <label
                >유효 기간<input type="month" placeholder="월/연도" /><span
                  >*카드 만료일을 입력해주세요</span
                ></label
              >
            </div>
            <div>
              <label
                >CVC 코드<input type="text" /><span
                  >*3자리 또는 4자리 숫자 보안코드를 입력해주세요</span
                ></label
              >
            </div>
          </div>
          <div class="counsel-pay-phone hidden">
            <div>
              <label>
                휴대폰 번호 <input type="text" />
                <span>*휴대폰 번호를 입력해주세요('-'제외)</span>
              </label>
            </div>
            <div>
              <label
                >인증 번호
                <input type="text" />
              </label>
              <input type="button" value="인증번호 요청" />
            </div>
          </div>

          <div class="counsel-pay-title total-price">
            <div>총 결제금액</div>
            <div>50000</div>
          </div>
          <div class="counsel-pay-agree">
            <span>위 내용을 모두 확인하였으며, 결제에 동의합니다.</span>
          </div>
          <input type="submit" value="결제하기" class="counsel-pay-btn" />
        </div>
      </form>
    </main>

    <%@ include file="/views/common/footer.jsp" %>
  </body>
</html>
