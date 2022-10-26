<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String root1 = request.getContextPath();%>
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
      href="<%=root1%>/resources/css/admin/common/component.css?ver=1"
    />
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <form
        action="<%=root1%>/admin/pro/add"
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
              onclick="history.back()"
            />
            <input class="save-btn" type="submit" value="저장" />
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
                  class="admin-input"
                  name="name"
                />
              </div>
              <div></div>
              <div>아이디</div>
              <div>
                <input
                  type="text"
                  placeholder="아이디를 입력해주세요"
                  class="admin-input"
                  name="id"
                />
              </div>
              <div>
                <input type="submit" value="중복확인" class="check-btn" />
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
                  class="admin-input"
                  name="email"
                />
              </div>
              <div></div>
              <div>비밀번호</div>
              <div>
                <input
                  type="text"
                  placeholder="비밀번호를 입력해주세요"
                  class="admin-input"
                  name="pwd"
                />
              </div>
              <div></div>
              <div>전화번호</div>
              <div>
                <input
                  type="text"
                  placeholder="전화번호를 입력해주세요"
                  class="admin-input"
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
                  class="admin-input"
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
                  class="admin-input-select"
                  placeholder="소개글을 입력해주세요"
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
