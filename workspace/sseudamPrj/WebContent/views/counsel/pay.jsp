<%@page import="com.kh.sseudam.counsel.pro.vo.ProVo"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <% String root1 =
request.getContextPath();%> <%ProVo vo = (ProVo)request.getAttribute("vo"); %>
<% String dateList = (String)request.getAttribute("dateList"); %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

    <script
      src="http://code.jquery.com/jquery-3.5.1.js"
      integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
      crossorigin="anonymous"
    ></script>

    <link
      rel="stylesheet"
      href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
      type="text/css"
    />

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

    <script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="<%= root1 %>/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="<%= root1 %>/resources/css/counsel/pay.css?ver=8"
    />
    <link
      rel="stylesheet"
      href="<%= root1 %>/resources/css/common/variables.css"
    />

    <script src="<%= root1 %>/resources/js/counsel/pay2.js?ver=2"></script>
  </head>
  <body>
    <%@ include file="/views/common/header.jsp" %>
    <main class="counsel-pay-main">
      <form
        id="counsel-pay-form"
        action="<%=root%>/counsel/pay?bno=<%=vo.getNo()%>"
        method="post"
        onsubmit="return false;"
      >
        <div class="main-wrapper counsel-pay-main-wrapper">
          <div class="counsel-pay-title">전문가 정보</div>

          <div class="counsel-pay-pro-info">
            <img
              src="<%= root1 %>/resources/upload/pro/<%= vo.getImg() %>"
              alt=""
            />
            <div class="counsel-pay-pro-info-detail">
              <div class="counsel-pro-name"><%= vo.getName() %></div>
              <div class="counsel-pro-type"><%= vo.getCounselType() %></div>
              <div class="counsel-pro-introduce"><%= vo.getIntroduce() %></div>
              <div class="counsel-pro-review">
                <i class="fa-solid fa-star"></i>
                <div><%= vo.getAvgStar() %></div>
                <div>(<%= vo.getCounselCnt() %>)</div>
              </div>
              <div class="counsel-pro-price">
                <div>1회상담</div>
                <div><%= vo.getPrice() %></div>
              </div>
            </div>
          </div>
          <div class="counsel-pay-title">날짜 선택</div>
          <input
            type="text"
            id="datepicker"
            class="chooseDate"
            name="counselDate"
          />
          <script>
              $(function () {
              //input을 datepicker로 선언
              console.log("되나");
              $("#datepicker").datepicker({
                dateFormat: "yy-mm-dd", //Input Display Format 변경
                beforeShowDay: disableDates,
                showOtherMonths: true, //빈 공간에 현재월의 앞뒤월의 날짜를 표시
                showMonthAfterYear: true, //년도 먼저 나오고, 뒤에 월 표시
                changeYear: false, //콤보박스에서 년 선택 가능
                changeMonth: false, //콤보박스에서 월 선택 가능
                showOn: "both", //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시
                buttonImage:
                  "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif", //버튼 이미지 경로
                buttonImageOnly: true, //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
                buttonText: "선택", //버튼에 마우스 갖다 댔을 때 표시되는 텍스트
                yearSuffix: "년", //달력의 년도 부분 뒤에 붙는 텍스트

                monthNamesShort: [
                  "1",
                  "2",
                  "3",
                  "4",
                  "5",
                  "6",
                  "7",
                  "8",
                  "9",
                  "10",
                  "11",
                  "12",
                ], //달력의 월 부분 텍스트
                monthNames: [
                  "1월",
                  "2월",
                  "3월",
                  "4월",
                  "5월",
                  "6월",
                  "7월",
                  "8월",
                  "9월",
                  "10월",
                  "11월",
                  "12월",
                ], //달력의 월 부분 Tooltip 텍스트
                dayNamesMin: ["일", "월", "화", "수", "목", "금", "토"], //달력의 요일 부분 텍스트
                dayNames: [
                  "일요일",
                  "월요일",
                  "화요일",
                  "수요일",
                  "목요일",
                  "금요일",
                  "토요일",
                ], //달력의 요일 부분 Tooltip 텍스트
                minDate: "+1D", //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
                maxDate: "+3M", //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)
              });

              //초기값을 오늘 날짜로 설정
              $("#datepicker").datepicker("setDate", "+1D"); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)

              //제외할 날짜

              function disableDates(date) {
                var bookedDays = [<%= dateList%>];

                var m = date.getMonth() + 1;
                var d = date.getDate();
                var y = date.getFullYear();

                for (let i = 0; i < bookedDays.length; i++) {
                  if ($.inArray(y + "-" + m + "-" + d, bookedDays) != -1) {
                    console.log(y);
                    console.log(m);
                    console.log(d);
                    return [false];
                  }
                }
                return [true];
              }
            });
          </script>

          <div class="counsel-pay-select-date"></div>
          <div class="counsel-pay-title">결제 수단 선택</div>
          <div class="counsel-pay-select-payment">
            <select name="payway">
              <option value="">결제 수단 선택</option>
              <option value="카드">신용/체크카드</option>
              <option value="휴대폰">휴대폰 결제</option>
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
                휴대폰 번호 <input type="text" id="phoneNum" />
                <span>*휴대폰 번호를 입력해주세요('-'제외)</span>
              </label>
            </div>
            <div>
              <label
                >인증 번호
                <input type="text" />
              </label>
              <input id="certifiBtn" type="button" value="인증번호 요청" />
              <span id="countDown"></span>
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
