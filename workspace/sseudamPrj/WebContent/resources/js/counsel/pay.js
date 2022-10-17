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
      e.preventDefault();
    }
    if (choose == 1) {
      if (bankVal == 0) {
        alert("카드를 선택해주세요.");
        e.preventDefault();
      }
      if (bankVal != 0) {
        if (cardNum.value == "") {
          alert("카드번호를 입력해주세요.");
          e.preventDefault();
        }
        if (cardMonDay.value == "") {
          alert("카드 유효 기간을 입력해주세요.");
          e.preventDefault();
        }
        if (cardCvc.value == "") {
          alert("CVC 코드를 입력해주세요.");
          e.preventDefault();
        }
      }
    }
    if (choose == 2) {
      if (phoneNum.value == "") {
        alert("휴대폰 번호를 입력해주세요.");
        e.preventDefault();
      }
      if (certificateNum.value == "") {
        alert("인증번호를 입력해주세요.");
        e.preventDefault();
      }
    }
  });
};
