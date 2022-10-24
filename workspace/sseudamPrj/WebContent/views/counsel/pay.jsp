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
      href="<%= root1 %>/resources/css/counsel/pay.css?ver=9"
    />
    <link
      rel="stylesheet"
      href="<%= root1 %>/resources/css/common/variables.css"
    />

    <!-- <script src="<%= root1 %>/resources/js/counsel/pay2.js?ver=2"></script> -->
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

            const form = document.querySelector("#counsel-pay-form");
            console.log(form);
            const pw = document.querySelector("select[name=payway]");
            const bank = document.querySelector("select[name=bank]");
            const payCard = document.querySelector(".counsel-pay-card");
            const payPhone = document.querySelector(".counsel-pay-phone");

            pw.addEventListener("change", (e) => {
              console.log("여기용");
              const choose = e.currentTarget.selectedIndex;

              const value = e.currentTarget[choose].value;

              if (value == "카드") {
                bank.classList.remove("hidden");
                payCard.classList.remove("hidden");
                payPhone.classList.add("hidden");
              }

              if (value == "휴대폰") {
                bank.classList.add("hidden");
                payCard.classList.add("hidden");
                payPhone.classList.remove("hidden");
              }
            });

            form.addEventListener("submit", function check(e) {
              const choose = pw.selectedIndex;
              const bankVal = bank.selectedIndex;
              const cardNum = payCard.querySelector("div:nth-child(1) input");
              const cardMonDay = payCard.querySelector("div:nth-child(2) input");
              const cardCvc = payCard.querySelector("div:nth-child(3) input");
              const phoneNum = payPhone.querySelector("div:nth-child(1) input");
              const certificateNum = payPhone.querySelector("div:nth-child(2) input");
              if (choose == 0) {
                alert("결제수단을 선택해주세요.");
                return;
              }
              if (choose == 1) {
                if (bankVal == 0) {
                  alert("카드를 선택해주세요.");
                  return;
                }
                if (bankVal != 0) {
                  if (cardNum.value == "") {
                    alert("카드번호를 입력해주세요.");
                    return;
                  }
                  if (cardMonDay.value == "") {
                    alert("카드 유효 기간을 입력해주세요.");
                    return;
                  }
                  if (cardCvc.value == "") {
                    alert("CVC 코드를 입력해주세요.");
                    return;
                  }
                }
              }
              if (choose == 2) {
                if (phoneNum.value == "") {
                  alert("휴대폰 번호를 입력해주세요.");
                  return;
                }
                if (certificateNum.value == "") {
                  alert("인증번호를 입력해주세요.");
                  return;
                }
              }
              const counselDate = document.querySelector(".chooseDate").value;
              console.log(counselDate);
              Swal.fire({
                title: "상담날짜 : " + counselDate,
                text: "결제 후 환불이 불가합니다",
                icon: "warning",

                showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
                confirmButtonColor: "#26aa82", // confrim 버튼 색깔 지정
                cancelButtonColor: "#ff4000", // cancel 버튼 색깔 지정
                confirmButtonText: "결제", // confirm 버튼 텍스트 지정
                cancelButtonText: "취소", // cancel 버튼 텍스트 지정

                reverseButtons: true, // 버튼 순서 거꾸로
              }).then((result) => {
                // 만약 Promise리턴을 받으면,
                if (result.isConfirmed) {
                  // 만약 모달창에서 confirm 버튼을 눌렀다면
                  form.submit();
                }
              });
            }); //form submit

            //휴대폰 인증 타이머
            var timer = null;
            var isRunning = false;
            const certifiBtn = document.querySelector("#certifiBtn");
            certifiBtn.addEventListener("click", function () {
              const phoneNum = document.querySelector("#phoneNum");
              if (phoneNum.value == "") {
                alert("휴대폰 번호를 입력해주세요");
              } else {
                certifiBtn.setAttribute("value", "재요청");
                var display = $(".time");
                // 유효시간 설정
                var leftSec = 120;

                // 버튼 클릭 시 시간 연장
                if (isRunning) {
                  clearInterval(timer);
                  display.html("");
                  startTimer(leftSec, display);
                } else {
                  startTimer(leftSec, display);
                }
              }
            });

            function startTimer(count, display) {
              var minutes, seconds;
              timer = setInterval(function () {
                minutes = parseInt(count / 60, 10);
                seconds = parseInt(count % 60, 10);

                minutes = minutes < 10 ? "0" + minutes : minutes;
                seconds = seconds < 10 ? "0" + seconds : seconds;

                const div = $("#countDown");
                div.html(minutes + ":" + seconds);

                // 타이머 끝
                if (--count < 0) {
                  clearInterval(timer);
                  alert("시간초과");
                  div.html("시간초과");
                  $("button").attr("disabled", true);
                  isRunning = false;
                }
              }, 1000);
              isRunning = true;
            } //타이머
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
    <script></script>

    <%@ include file="/views/common/footer.jsp" %>
  </body>
</html>
