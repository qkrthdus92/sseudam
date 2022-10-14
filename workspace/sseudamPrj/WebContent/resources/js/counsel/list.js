window.onload = function () {
  const counselTypeCheckbox = document.querySelector(".counsel-type-checkbox");
  const checkIcon = document.querySelector(".check-icon");

  counselTypeCheckbox.addEventListener("click", function () {
    if (counselTypeCheckbox.checked == true) {
      console.log("체크됨");
      checkIcon.classList.toggle("color-gray");
    } else {
      console.log("체크안됨");
      checkIcon.classList.toggle("color-gray");
    }
  });
};
