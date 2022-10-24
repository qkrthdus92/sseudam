window.onload = function () {
  const form = document.querySelector("form");
  const pw = document.querySelector("select[name=payway]");
  const bank = document.querySelector("select[name=bank]");
  const payCard = document.querySelector(".counsel-pay-card");
  const payPhone = document.querySelector(".counsel-pay-phone");
  pw.addEventListener("change", (e) => {
    const choose = e.currentTarget.selectedIndex;

    const value = e.currentTarget[choose].value;

    if (value == "card") {
      bank.classList.remove("hidden");
      payCard.classList.remove("hidden");
      payPhone.classList.add("hidden");
    }

    if (value == "phone") {
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
    const counselYear = selectYear.options[selectYear.selectedIndex].value;
    const counselMonth = selectMonth.options[selectMonth.selectedIndex].value;
    const counselDate = selectDate.options[selectDate.selectedIndex].value;

    Swal.fire({
      title: `상담날짜 : ${counselYear}/${counselMonth}/${counselDate}`,
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
  });

  let today = new Date();
  let year = today.getFullYear(); //년도
  let month = today.getMonth() + 1; // 월
  let date = today.getDate(); // 날짜
  let day = today.getDay(); // 요일

  let threeMonthLater = new Date(today.setMonth(today.getMonth() + 3));
  let newYear = threeMonthLater.getFullYear();
  let newMonth = threeMonthLater.getMonth() + 1;
  let newDate = threeMonthLater.getDate();

  const selectYear = document.querySelector("select[name=year]");
  const selectMonth = document.querySelector("select[name=month]");
  const selectDate = document.querySelector("select[name=date]");

  const optionYear = document.querySelector(
    "select[name=year] option:first-child"
  );
  optionYear.innerHTML = year + "년";
  optionYear.setAttribute("value", year);

  if (month >= 10) {
    let newOptionYear = document.createElement("option");
    newOptionYear.innerHTML = year + 1 + "년";
    newOptionYear.setAttribute("value", year + 1);
    selectYear.appendChild(newOptionYear);
  }

  const optionMonth = document.querySelector(
    "select[name=month] option:first-child"
  );
  optionMonth.innerHTML = month + "월";
  optionMonth.setAttribute("value", month);

  if (month <= 10) {
    let newOptionMonth2 = document.createElement("option");
    let newOptionMonth3 = document.createElement("option");
    newOptionMonth2.innerHTML = month + 1 + "월";
    newOptionMonth2.setAttribute("value", month + 1);
    selectMonth.appendChild(newOptionMonth2);

    newOptionMonth3.innerHTML = month + 2 + "월";
    newOptionMonth3.setAttribute("value", month + 2);
    selectMonth.appendChild(newOptionMonth3);
  }

  if (month == 11) {
    let newOptionMonth2 = document.createElement("option");
    newOptionMonth2.innerHTML = month + 1 + "월";
    newOptionMonth2.setAttribute("value", month + 1);
    selectMonth.appendChild(newOptionMonth2);
  }

  const lastMonth = month + 3 - 12;
  function showMonth() {
    const value = selectYear.options[selectYear.selectedIndex].value;
    if (value > year) {
      while (selectMonth.hasChildNodes()) {
        selectMonth.removeChild(selectMonth.firstChild);
      }

      for (let i = 1; i <= lastMonth; i++) {
        let newOptionMonth = document.createElement("option");
        newOptionMonth.innerHTML = i + "월";
        newOptionMonth.setAttribute("value", i);
        selectMonth.appendChild(newOptionMonth);
      }
    } else {
      while (selectMonth.hasChildNodes()) {
        selectMonth.removeChild(selectMonth.firstChild);
      }

      const lastMonth = 12;
      for (let i = month; i <= lastMonth; i++) {
        let newOptionMonth = document.createElement("option");
        newOptionMonth.innerHTML = i + "월";
        newOptionMonth.setAttribute("value", i);
        selectMonth.appendChild(newOptionMonth);
      }
    }
  }

  function showDate() {
    let lastDate;
    const value = selectMonth.options[selectMonth.selectedIndex].value;
    const value2 = selectYear.options[selectYear.selectedIndex].value;
    if (value != month) {
      startDate = 1;
    }
    if (value == month) {
      startDate = date + 1;
    }

    lastDate = new Date(value2, value, 0).getDate();

    if (value == lastMonth) {
      lastDate = newDate + 1;
    }
    while (selectDate.hasChildNodes()) {
      selectDate.removeChild(selectDate.firstChild);
    }

    for (let i = startDate; i <= lastDate; i++) {
      let newOptionDate = document.createElement("option");
      newOptionDate.innerHTML = i + "일";
      newOptionDate.setAttribute("value", i);
      selectDate.appendChild(newOptionDate);
    }
  }

  selectYear.addEventListener("change", showMonth);
  selectYear.addEventListener("change", showDate);
  selectMonth.addEventListener("change", showDate);

  let lastDate;
  const value = selectMonth.options[selectMonth.selectedIndex].value;
  const value2 = selectYear.options[selectYear.selectedIndex].value;
  if (value != month) {
    startDate = 1;
  }
  if (value == month) {
    startDate = date + 1;
  }
  lastDate = new Date(value2, value, 0).getDate();

  while (selectDate.hasChildNodes()) {
    selectDate.removeChild(selectDate.firstChild);
  }

  for (let i = startDate; i <= lastDate; i++) {
    let newOptionDate = document.createElement("option");
    newOptionDate.innerHTML = i + "일";
    newOptionDate.setAttribute("value", i);
    selectDate.appendChild(newOptionDate);
  }
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
  }
};
