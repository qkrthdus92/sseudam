window.onload = function () {
  console.log("되나??");
  const searchProNameBtn = document.querySelector("#form-search-pro-name i");
  const form = document.querySelector("#form-search-pro-name");
  searchProNameBtn.addEventListener("click", checkFormSearchProName);
  form.addEventListener("submit", checkFormSearchProName2);

  function checkFormSearchProName() {
    const input = document.querySelector(".counsel-search input[type=text]");
    const input2 = input.value.replace(/\s/g, "");
    console.log("인풋2는 " + input2 + "입니다");
    if (input2 == "") {
      alert("전문가 이름을 입력해주세요");
      return false;
    }

    console.log(input.value);
    form.submit();
  }

  function checkFormSearchProName2(e) {
    const input = document.querySelector(".counsel-search input[type=text]");
    const input2 = input.value.replace(/\s/g, "");
    console.log("인풋2는 " + input2 + "입니다");
    if (input2 == "") {
      alert("전문가 이름을 입력해주세요");
      e.preventDefault();
    }

    console.log(input.value);
    form.submit();
  }
};
