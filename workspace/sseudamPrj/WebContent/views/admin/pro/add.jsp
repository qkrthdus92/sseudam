<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String root1 = request.getContextPath(); String pno =
(String)request.getAttribute("pno"); String status =
(String)request.getAttribute("status"); String search =
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
      href="<%=root1%>/resources/css/admin/pro/list.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css?ver=2"
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
        action="<%=root1%>/admin/pro/add?pno=<%=pno %>&status=<%=status %>&search=<%=search%>"
        method="post"
        enctype="multipart/form-data"
      >
        <header class="admin-main-header flex-between">
          <h1>전문가 추가</h1>
          <div class="btn-set">
            <input
              class="cancel-btn"
              type="button"
              value="취소"
              onclick="location.href='<%=root%>/admin/pro/list?pno=<%=pno %>&status=<%=status %>&search=<%=search%>'"
            />
            <input
              class="save-btn"
              type="submit"
              value="저장"
              onclick="return checkId();"
            />
          </div>
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
              <div>상담분야</div>
              <div>
                <select name="counselType" id="" class="admin-input-select">
                  <option value="none">상담분야선택</option>
                  <option value="1">청소년상담</option>
                  <option value="2">가족심리상담</option>
                  <option value="3">우울증상담</option>
                  <option value="4">취업/진로상담</option>
                </select>
              </div>
              <div></div>
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
              <div>성별</div>
              <div>
                <select name="gender" id="" class="admin-input-select">
                  <option value="none">성별선택</option>
                  <option value="M">남자</option>
                  <option value="F">여자</option>
                </select>
              </div>
              <div></div>
              <div>최종학력</div>
              <div>
                <input
                  type="text"
                  placeholder="최종학력을 입력해주세요"
                  class="upload-name"
                  name="education"
                />
              </div>
              <div></div>
              <div>프로필사진</div>
              <div><input type="file" name="f" /></div>
              <div></div>
              <div>소개글</div>
              <div>
                <input
                  type="text"
                  name="introduce"
                  class="upload-name"
                  placeholder="소개글을 입력해주세요"
                />
              </div>
              <div></div>
            </div>
          </div>
        </section>
      </form>
    </main>
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
  </body>
</html>
