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
      href="/sseudamPrj/resources/css/admin/pro/list.css?ver=3"
    />
    <link
      rel="stylesheet"
      href="/sseudamPrj/resources/css/admin/common/component.css?ver=2"
    />
    <style>
      .grid-col3 {
        grid-template-rows: repeat(13, 50px);
      }
    </style>
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header flex-between">
        <h1>전문가 정보 수정</h1>
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
            <div>번호</div>
            <div>1</div>
            <div></div>
            <div>이름</div>
            <div>한혜원</div>
            <div></div>
            <div>아이디</div>
            <div>user01</div>
            <div>
              <input type="submit" value="중복확인" class="check-btn" />
            </div>
            <div>비밀번호</div>
            <div>1234</div>
            <div></div>
            <div>상담분야</div>
            <div>청소년상담</div>
            <div></div>
            <div>이메일</div>
            <div>hyewon@naver.com</div>
            <div></div>
            <div>전화번호</div>
            <div>010-1234-5678</div>
            <div></div>
            <div>최종학력</div>
            <div>서울대학교 심리학과</div>
            <div></div>
            <div>상담금액</div>
            <div>50000</div>
            <div></div>
            <div>프로필사진</div>
            <div><input type="file" value="업로드" class="upload-btn" /></div>
            <div></div>
            <div>계정상태</div>
            <div>일반회원</div>
            <div>
              <input type="submit" value="전문가승인" class="check-btn" />
            </div>
            <div>가입일</div>
            <div>2022-10-10 12:12:12</div>
            <div></div>
            <div>정보수정일자</div>
            <div>2022-10-10 12:12:12</div>
            <div></div>
          </div>
          <input type="button" value="회원탈퇴" class="delete-btn" />
        </div>
        <div class="admin-main-wrapper admin-pro-certificate">
          <div>자격증이름</div>
          <div>자격번호</div>
          <div>자격증첨부파일</div>
          <%for(int i=1; i<=5; i++) {%>
          <div>상담심리지도사1급</div>
          <div>1234-1234</div>
          <div>certificate.jpg</div>
          <%}%>
          <div>
            <input
              type="text"
              placeholder="이름을 입력해주세요"
              class="admin-input"
            />
          </div>
          <div>
            <input
              type="text"
              placeholder="자격번호를 입력해주세요"
              class="admin-input"
            />
          </div>
          <div><input type="file" value="업로드" class="upload-btn" /></div>
          <input type="submit" value="추가" class="small-add-btn pro-add-btn" />
        </div>
      </section>
    </main>
  </body>
</html>
