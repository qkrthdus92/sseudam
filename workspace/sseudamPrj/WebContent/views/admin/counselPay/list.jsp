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

    <style>
      .flex-start {
        justify-content: flex-start;
      }

      select[name="searchType"] {
        cursor: pointer;
        width: 100px;
        border: 1px solid #b0b0b0;
        padding: 0px 2px;
        font-size: 15px;
      }

      .flex {
        display: flex;
        align-items: center;
      }

      .total-num-info {
        margin-right: 30px;
      }

      #range {
        border: 2px solid rgb(191, 225, 206);
        padding-left: 15px;
        height: 20px;
        border-radius: 5px;
        font-size: 15px;
      }
    </style>
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <form
        action="<%=root1%>/admin/counselPay/list"
        method="get"
        class="admin-counselPay-form"
      >
        <header class="admin-main-header">
          <h1>상담 결제 내역</h1>
        </header>
        <section class="admin-main-section">
          <div class="admin-main-section-top flex-start">
            <div class="admin-search">
              <input
                type="text"
                placeholder="이름 또는 아이디를 입력해주세요"
                name="search"
              />
              <i class="fa-solid fa-magnifying-glass"></i>
            </div>
            <select name="searchType" id="">
              <option value="memberInfo">회원정보</option>
              <option value="proInfo">전문가정보</option>
            </select>

            <!-- <div class="add-btn"><input type="button" value="게시글 작성" /></div> -->
          </div>
          <div class="admin-main-wrapper">
            <div class="admin-main-board-top">
              <div class="flex">
                <div class="total-num-info">
                  <span>전체 결제 내역</span><span>10</span>
                </div>
                <input type="text" id="range" name="range" value="" />
              </div>
              <div class="main-select-btn">
                <select name="status" id="">
                  <option value="all">모든 상담 조회</option>
                  <option value="F">상담완료 조회</option>
                  <option value="C">상담대기 조회</option>
                </select>
              </div>
            </div>
            <script>
              const inputSearchIcon = document.querySelector(
                "input[name=search]+i"
              );
              const selectStatus = document.querySelector(
                "select[name=status]"
              );
              inputSearchIcon.addEventListener("click", function () {
                const inputSearchForm = document.querySelector(
                  ".admin-counselPay-form"
                );
                inputSearchForm.submit();
              });

              selectStatus.addEventListener("change", function () {
                const inputSearchForm = document.querySelector(
                  ".admin-counselPay-form"
                );
                inputSearchForm.submit();
              });
            </script>
            <script>
              $(function () {
                $("#range").daterangepicker(
                  {
                    locale: {
                      format: "YYYY-MM-DD",
                      separator: " ~ ",
                      applyLabel: "확인",
                      cancelLabel: "취소",
                      fromLabel: "From",
                      toLabel: "To",
                      customRangeLabel: "Custom",
                      weekLabel: "W",
                      daysOfWeek: ["일", "월", "화", "수", "목", "금", "토"],
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
                      ],
                    },
                    startDate: "2022-08-01",
                    endDate: new Date(),

                    // drops: "auto",
                  },
                  function (start, end, label) {
                    console.log(
                      "New date range selected: " +
                        start.format("YYYY-MM-DD") +
                        " to " +
                        end.format("YYYY-MM-DD") +
                        " (predefined range: " +
                        label +
                        ")"
                    );
                  }
                );
              });
            </script>
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
      </form>
    </main>

    <script
      type="text/javascript"
      src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"
    ></script>
    <script
      type="text/javascript"
      src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"
    ></script>
    <script
      type="text/javascript"
      src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"
    ></script>
    <link
      rel="stylesheet"
      type="text/css"
      href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"
    />
  </body>
</html>
