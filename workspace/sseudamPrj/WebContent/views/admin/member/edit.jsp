<%@page import="com.kh.sseudam.member.vo.MemberVo"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <% String root1 =
request.getContextPath();%> <% MemberVo vo =
(MemberVo)request.getAttribute("vo"); %> <% String pno =
(String)request.getAttribute("pno"); String quitYn =
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
      href="<%=root1%>/resources/css/admin/common/component.css?ver=5"
    />
    <style>
      .grid-col3 {
        grid-template-columns: 1fr 1fr 6fr;
        grid-template-rows: repeat(11, 50px);
      }
    </style>
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <form
        action="<%=root1 %>/admin/member/edit?mno=<%=vo.getNo() %>&pno=<%=pno %>&quitYn=<%=quitYn %>&search=<%=search%>"
        method="post"
      >
        <header class="admin-main-header flex-between">
          <h1>사용자 정보 수정</h1>
          <div class="btn-set">
            <input
              class="cancel-btn"
              type="button"
              value="취소"
              onclick="location.href='<%=root%>/admin/member/list?pno=<%=pno %>&quitYn=<%=quitYn %>'"
            />

            <input
              class="save-btn"
              type="submit"
              value="저장"
              onclick="return checkIdNick();"
            />
          </div>
          <script>
            function checkIdNick() {
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
              <div>번호</div>
              <div><%= vo.getNo() %></div>
              <div></div>

              <div>이름</div>
              <input
                type="text"
                value="<%= vo.getName() %>"
                class="input-edit"
                name="name"
              />
              <div></div>

              <div>아이디</div>
              <input
                type="text"
                value="<%= vo.getId() %>"
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
                	console.log('여기여기');
                  $.ajax({
                    url: "<%=root1%>/admin/checkDup",
                    type: "get",
                    data: {
                      id: $('#targetId').val(),
                      mno : <%=vo.getNo()%>
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
              <div>비밀번호</div>
              <input
                type="text"
                value="<%= vo.getPwd() %>"
                class="input-edit"
                name="pwd"
              />
              <div></div>
              <div>닉네임</div>
              <input
                type="text"
                value="<%= vo.getNick() %>"
                class="input-edit"
                name="nick"
                id="targetNick"
              />
              <div>
                <input
                  type="button"
                  value="중복확인"
                  class="check-btn"
                  onclick="checkDupNick();"
                />
                <div id="printDupNick"></div>
              </div>
              <script>
                let nick = document.querySelector("#targetNick").value;

                function checkDupNick() {

                  $.ajax({
                    url: "<%=root1%>/admin/checkDupNick",
                    type: "get",
                    data: {
                      nick: $('#targetNick').val(),
                      mno : <%=vo.getNo()%>
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
              <div>전화번호</div>
              <input
                type="text"
                value="<%= vo.getPhone() %>"
                class="input-edit"
                name="phone"
              />
              <div></div>
              <div>이메일</div>
              <input
                type="text"
                value="<%= vo.getEmail() %>"
                class="input-edit"
                name="email"
              />
              <div></div>
              <div>테스트점수</div>
              <input
                type="text"
                value="<%= vo.getTestScore() %>"
                class="input-edit"
                name="test"
              />
              <div></div>
              <div>가입일</div>
              <div><%= vo.getJoinDate()%></div>
              <div></div>
              <div>계정상태</div>
              <%if(vo.getQuitYn().equals("N")) {%>
              <div>일반회원</div>
              <%}else { %>
              <div>탈퇴회원</div>
              <%} %>
              <div></div>
              <div>정보수정일자</div>
              <div><%= vo.getModifyDate() %></div>
              <div></div>
            </div>

            <input
              type="button"
              value="회원탈퇴"
              class="delete-btn"
              onclick="quit();"
            />

            <script>
              function quit() {
                Swal.fire({
                  title: <%=vo.getNo()%>+"번 회원 탈퇴",
                  text: "정말로 탈퇴처리 하시겠습니까?",
                  icon: "warning",
                  showCancelButton: true,
                  confirmButtonColor: "#26aa82",
                  cancelButtonColor: "#f85a2a",
                  confirmButtonText: "탈퇴",
                  cancelButtonText: "취소"
                }).then((result) => {
                  if (result.isConfirmed) {
                    location.href='<%=root%>/admin/member/quit?mno=<%=vo.getNo()%>&pno=<%=pno %>&quitYn=<%=quitYn %>';
                  }
                });
              }
            </script>
          </div>
        </section>
      </form>
    </main>
  </body>
</html>
