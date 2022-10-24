window.onload = function () {
  const form = document.querySelector("form");
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

    Swal.fire({
      title: `상담날짜 : ${counselDate}`,
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
}; //window.onload
