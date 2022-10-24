window.onload = function () {
  const searchProNameBtn = document.querySelector("#form-search-pro-name i");
  const form = document.querySelector("#form-search-pro-name");
  const nameInput = document.querySelector(".search-name-input");
  searchProNameBtn.addEventListener("click", checkFormSearchProName);
  nameInput.addEventListener("keypress", checkFormSearchProName2);

  function checkFormSearchProName() {
    const input = document.querySelector(".counsel-search .search-name-input");
    const input2 = input.value.replace(/\s/g, "");
    console.log("인풋2는 " + input2 + "입니다");
    if (input2 == "") {
      alert("전문가 이름을 입력해주세요");
      return false;
    }

    console.log(input.value);

    form.method = "get";
    form.target = "_self";
    form.action = "/sseudam/counsel/list?proName=" + input2.value + "&pno=1";
    form.submit();
  }

  function checkFormSearchProName2(e) {
    const input2 = nameInput.value.replace(/\s/g, "");

    if (e.key === "Enter") {
      console.log("인풋2는 " + input2 + "입니다");
      if (input2 == "") {
        alert("전문가 이름을 입력해주세요");
      } else {
        form.method = "get";
        form.target = "_self";
        form.action =
          "/sseudam/counsel/list?proName=" + input2.value + "&pno=1";
        form.submit();
      }
    }
  }

  const filter1 = document.querySelector(".counsel-filter li:nth-child(1) a");
};
