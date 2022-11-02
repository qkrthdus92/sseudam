<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String root1 = request.getContextPath();%> <% String
pno = (String)request.getAttribute("pno"); String quitYn =
(String)request.getAttribute("quitYn"); %> <% String search =
(String)request.getAttribute("search"); %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>쓰담쓰담 관리자 | 사용자 | 추가</title>
    <link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" />
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
      href="<%=root1%>/resources/css/admin/common/component.css?ver=2"
    />
    <style>
      .grid-col3 {
        grid-template-columns: 0.2fr 0.4fr 1fr;
      }

      .padding-left0 {
        padding-left: 0px !important;
      }

      .admin-menu-main-user li:first-child a {
        color: var(--adminMenuHover);
        font-size: 17px;
      }
    </style>
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
              let checkNick = $("#printDupNick").text();
              console.log(checkId);
              console.log(checkNick);
              if (
                (checkId.includes("현재") || checkId.includes("사용가능한")) &&
                (checkNick.includes("현재") || checkNick.includes("사용가능한"))
              ) {
                return true;
              } else {
                Swal.fire("아이디/닉네임 중복체크해주세요!");
                return false;
              }
            }
          </script>
        </header>
        <section class="admin-main-section">
          <div class="admin-main-wrapper">
            <div class="admin-main-board grid-col3">
              <div>이름</div>
              <div>
                <input
                  type="text"
                  placeholder="이름을 입력해주세요"
                  class="upload-name"
                  name="name"
                />
              </div>
              <div></div>
              <div>아이디</div>
              <div>
                <input
                  type="text"
                  placeholder="아이디를 입력해주세요"
                  class="upload-name"
                  name="id"
                  id="targetId"
                />
              </div>
              <div class="padding-left0">
                <input
                  type="button"
                  value="중복확인"
                  class="label-btn border-none"
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
              <div>
                <input
                  type="text"
                  placeholder="닉네임을 입력해주세요"
                  class="upload-name"
                  name="nick"
                  id="targetNick"
                />
              </div>
              <div class="padding-left0">
                <input
                  type="button"
                  value="중복확인"
                  class="label-btn border-none"
                  onclick="checkDupNick();"
                />
                <div id="printDupNick"></div>
              </div>
              <script>
                let nick = document.querySelector("#targetNick").value;

                function checkDupNick() {
                  $.ajax({
                    url: "<%=root1%>/admin/addMember/checkDupNick",
                    type: "get",
                    data: {
                      nick: $("#targetNick").val(),
                    },
                    success: function (x) {
                      $("#printDupNick").html(x);
                    },
                    error: function () {
                      alert("통신에러발생~");
                    },
                  });
                }
              </script>
              <div>이메일</div>
              <div>
                <input
                  type="text"
                  placeholder="이메일을 입력해주세요"
                  class="upload-name"
                  name="email"
                />
              </div>
              <div></div>
              <div>비밀번호</div>
              <div>
                <input
                  type="text"
                  placeholder="비밀번호를 입력해주세요"
                  class="upload-name"
                  name="pwd"
                />
              </div>
              <div></div>
              <div>전화번호</div>
              <div>
                <input
                  type="text"
                  placeholder="전화번호를 입력해주세요"
                  class="upload-name"
                  name="phone"
                />
              </div>
              <div></div>
            </div>
          </div>
        </section>
      </form>
    </main>
  </body>
</html>
