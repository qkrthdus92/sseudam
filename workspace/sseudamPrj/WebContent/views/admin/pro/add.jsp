<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="/sseudamPrj/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="/sseudamPrj/resources/css/common/variables.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="/sseudamPrj/resources/css/admin/pro/list.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="/sseudamPrj/resources/css/admin/common/component.css?ver=1"
    />
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
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
              />
            </div>
            <div></div>
            <div>아이디</div>
            <div>
              <input
                type="text"
                placeholder="아이디를 입력해주세요"
                class="admin-input"
              />
            </div>
            <div>
              <input type="submit" value="중복확인" class="check-btn" />
            </div>
            <div>상담분야</div>
            <div>
              <select name="" id="" class="admin-input-select">
                <option value="">상담분야선택</option>
                <option value="">청소년상담</option>
                <option value="">가족심리상담</option>
                <option value="">우울증상담</option>
                <option value="">취업/진로상담</option>
              </select>
            </div>
            <div></div>
            <div>이메일</div>
            <div>
              <input
                type="text"
                placeholder="이메일을 입력해주세요"
                class="admin-input"
              />
            </div>
            <div></div>
            <div>비밀번호</div>
            <div>
              <input
                type="text"
                placeholder="비밀번호를 입력해주세요"
                class="admin-input"
              />
            </div>
            <div></div>
            <div>성별</div>
            <div>
              <select name="" id="" class="admin-input-select">
                <option value="">성별선택</option>
                <option value="">남자</option>
                <option value="">여자</option>
              </select>
            </div>
            <div></div>
            <div>최종학력</div>
            <div>
              <input
                type="text"
                placeholder="최종학력을 입력해주세요"
                class="admin-input"
              />
            </div>
            <div></div>
            <div>프로필사진</div>
            <div><input type="file" value="업로드" /></div>
            <div></div>
          </div>
        </div>
      </section>
    </main>
  </body>
</html>
