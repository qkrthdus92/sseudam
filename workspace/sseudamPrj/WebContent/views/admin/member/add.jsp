<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String root1 = request.getContextPath();%> <% String
pno = (String)request.getAttribute("pno"); String quitYn =
(String)request.getAttribute("quitYn"); %> <% String search =
(String)request.getAttribute("search"); %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="<%=root1%>/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/common/variables.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/member/list.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css?ver=1"
    />
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <form action="<%=root1%>/admin/member/add" method="post">
        <header class="admin-main-header flex-between">
          <h1>사용자 추가</h1>
          <div class="btn-set">
            <input
              class="cancel-btn"
              type="button"
              value="취소"
              onclick="history.back();"
            />
            <input
              class="save-btn"
              type="submit"
              value="저장"
              onclick="return checkId();"
            />
          </div>
          <script>
            function checkId() {
              let checkId = $("#printDupId").text();

              console.log(checkId);

              if (checkId.includes("현재") || checkId.includes("사용가능한")) {
                return true;
              } else {
                Swal.fire("아이디 중복체크해주세요!");
                return false;
              }
            }
          </script>
        </header>
        <section class="admin-main-section">
          <div class="admin-main-wrapper">
            <div class="admin-main-board grid-col3">
              <div>이름</div>
              <input
                type="text"
                placeholder="이름을 입력해주세요"
                class="input-edit"
                name="name"
              />
              <div></div>
              <div>아이디</div>
              <input
                type="text"
                placeholder="아이디를 입력해주세요"
                class="input-edit"
                name="id"
                id="targetId"
              />
              <div>
                <input
                  type="button"
                  value="중복확인"
                  class="check-btn"
                  onclick="checkDupId();"
                />
                <div id="printDupId"></div>
              </div>
              <script>
                let id = document.querySelector("#targetId").value;
                console.log(id);
                function checkDupId() {
                  console.log("여기여기");
                  $.ajax({
                    url: "<%=root1%>/admin/addMember/checkDupId",
                    type: "get",
                    data: {
                      id: $("#targetId").val(),
                    },
                    success: function (x) {
                      $("#printDupId").html(x);
                    },
                    error: function () {
                      alert("통신에러발생~");
                    },
                  });
                }
              </script>
              <div>닉네임</div>
              <input
                type="text"
                placeholder="닉네임을 입력해주세요"
                class="input-edit"
                name="nick"
              />
              <div></div>
              <div>이메일</div>
              <input
                type="text"
                placeholder="이메일을 입력해주세요"
                class="input-edit"
                name="email"
              />
              <div></div>
              <div>비밀번호</div>
              <input
                type="text"
                placeholder="비밀번호를 입력해주세요"
                class="input-edit"
                name="pwd"
              />
              <div></div>
              <div>전화번호</div>
              <input
                type="text"
                placeholder="전화번호를 입력해주세요"
                class="input-edit"
                name="phone"
              />
              <div></div>
            </div>
          </div>
        </section>
      </form>
    </main>
  </body>
</html>
