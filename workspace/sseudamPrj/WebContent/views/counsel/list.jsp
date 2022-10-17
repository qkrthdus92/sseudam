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
      href="/sseudamPrj/resources/css/counsel/list.css?ver=3"
    />
    <link
      rel="stylesheet"
      href="/sseudamPrj/resources/css/common/variables.css"
    />
    <script src="/sseudamPrj/resources/js/counsel/list.js"></script>
  </head>
  <body>
    <%@ include file="/views/common/header.jsp" %>
    <main id="counsel-main">
      <div class="main-wrapper counsel-main-wrapper">
        <form action="">
          <aside class="counsel-aside">
            <div class="counsel-search">
              <input
                class="border"
                type="text"
                placeholder="전문가 이름을 검색하세요"
              />
              <a href=""><i class="fa-solid fa-magnifying-glass"></i></a>
            </div>
            <div class="counsel-type border">
              <div class="counsel-type-header">
                <img
                  src="../../resources/img/counsel/Folder_search_duotone_line.png"
                  alt=""
                />

                <span>상담 분야</span>
              </div>
              <ul class="counsel-type-list">
                <li>
                  <label>
                    <input
                      type="checkbox"
                      class="counsel-type-checkbox hidden"
                      name="counselType"
                      value="teenager"
                    />

                    <i class="fa-solid fa-circle-check check-icon hidden"></i>
                    <i class="fa-regular fa-circle-check check-icon"></i>
                    <span>청소년 상담</span>
                  </label>
                </li>
                <li>
                  <label>
                    <input
                      type="checkbox"
                      class="counsel-type-checkbox hidden"
                      name="counselType"
                      value="family"
                    />

                    <i
                      class="fa-solid fa-circle-check check-icon check-icon-black hidden"
                    ></i>
                    <i
                      class="fa-regular fa-circle-check check-icon check-icon-white"
                    ></i>
                    <span>가족 심리 상담</span>
                  </label>
                </li>
                <li>
                  <label>
                    <input
                      type="checkbox"
                      class="counsel-type-checkbox hidden"
                      name="counselType"
                      value="depressed"
                    />

                    <i
                      class="fa-solid fa-circle-check check-icon check-icon-black hidden"
                    ></i>
                    <i
                      class="fa-regular fa-circle-check check-icon check-icon-white"
                    ></i>
                    <span>우울증 상담</span>
                  </label>
                </li>
                <li>
                  <label>
                    <input
                      type="checkbox"
                      class="counsel-type-checkbox hidden"
                      name="counselType"
                      value="career"
                    />

                    <i
                      class="fa-solid fa-circle-check check-icon check-icon-black hidden"
                    ></i>
                    <i
                      class="fa-regular fa-circle-check check-icon check-icon-white"
                    ></i>
                    <span>취업/진로 상담</span>
                  </label>
                </li>
              </ul>
            </div>

            <div class="counsel-type counsel-type2 border">
              <div class="counsel-type-header">
                <img src="../../resources/img/counsel/Filter.png" alt="" />

                <span>상세 조건</span>
              </div>
              <div class="counsel-pro-level counsel-type-box">
                <span>상담사 등급</span>
                <ul class="counsel-type-list counsel-level-list">
                  <li>
                    <label>
                      <input
                        type="checkbox"
                        class="counsel-type-checkbox hidden"
                      />

                      <i class="fa-solid fa-circle-check check-icon hidden"></i>
                      <i class="fa-regular fa-circle-check check-icon"></i>
                      <span>마스터 상담사</span>
                    </label>
                  </li>
                  <li>
                    <label>
                      <input
                        type="checkbox"
                        class="counsel-type-checkbox hidden"
                      />

                      <i
                        class="fa-solid fa-circle-check check-icon check-icon-black hidden"
                      ></i>
                      <i
                        class="fa-regular fa-circle-check check-icon check-icon-white"
                      ></i>
                      <span>전문 상담사</span>
                    </label>
                  </li>
                  <li>
                    <label>
                      <input
                        type="checkbox"
                        class="counsel-type-checkbox hidden"
                      />

                      <i
                        class="fa-solid fa-circle-check check-icon check-icon-black hidden"
                      ></i>
                      <i
                        class="fa-regular fa-circle-check check-icon check-icon-white"
                      ></i>
                      <span>일반 상담사</span>
                    </label>
                  </li>
                </ul>
              </div>
              <div class="counsel-pro-gender counsel-type-box">
                <span>상담사 성별</span>
                <div class="counsel-radioBtn">
                  <input
                    type="radio"
                    id="g1"
                    name="gender"
                    value="both"
                    checked
                  /><label for="g1">무관</label>
                  <input
                    type="radio"
                    id="g2"
                    name="gender"
                    value="male"
                  /><label for="g2">남자</label>
                  <input
                    type="radio"
                    id="g3"
                    name="gender"
                    value="female"
                  /><label for="g3">여자</label>
                </div>
              </div>
              <div class="counsel-pro-certificate counsel-type-box">
                <span>상담사 자격증</span>
                <div class="counsel-radioBtn">
                  <input
                    type="radio"
                    id="c1"
                    name="certificate"
                    value="both"
                    checked
                  /><label for="c1">무관</label>
                  <input
                    type="radio"
                    id="c2"
                    name="certificate"
                    value="2"
                  /><label for="c2">2급</label>
                  <input
                    type="radio"
                    id="c3"
                    name="certificate"
                    value="1"
                  /><label for="c3">1급</label>
                </div>
              </div>
            </div>
            <div class="counsel-choice">
              <input type="submit" value="조회" />
            </div>
          </aside>
        </form>

        <section class="counsel-section">
          <ul class="counsel-filter">
            <li><a href="">기본정렬</a></li>
            <li><a href="">최근등록순</a></li>
            <li><a href="">평점순</a></li>
            <li><a href="">후기많은순</a></li>
            <li><a href="">높은가격순</a></li>
            <li><a href="">낮은가격순</a></li>
          </ul>
          <div class="counsel-pro-list">
            <div class="counsel-pro-detail">
              <div>
                <a href="<%=root%>/views/counsel/detail.jsp"
                  ><img
                    src="../../resources/img/counsel/Rectangle 4019.png"
                    alt=""
                /></a>
              </div>
              <div>
                <div class="counsel-pro-name">
                  <a href="<%=root%>/views/counsel/detail.jsp">주연희</a>
                </div>
                <div class="counsel-pro-type">청소년 상담</div>
                <div class="counsel-pro-introduce">
                  <a href="<%=root%>/views/counsel/detail.jsp"
                    >마음의 평안과 진정한 나를 찾아 떠나는 여행으로
                    초대합니다.</a
                  >
                </div>
                <div class="counsel-pro-review">
                  <i class="fa-solid fa-star"></i>
                  <div>4.9</div>
                  <div>(86)</div>
                </div>
                <div class="counsel-pro-price">
                  <div>1회상담</div>
                  <div>50,000</div>
                </div>
              </div>
            </div>
            <div class="counsel-pro-detail">
              <div>
                <a href="<%=root%>/views/counsel/detail.jsp"
                  ><img
                    src="../../resources/img/counsel/Rectangle 4019.png"
                    alt=""
                /></a>
              </div>
              <div>
                <div class="counsel-pro-name">
                  <a href="<%=root%>/views/counsel/detail.jsp">주연희</a>
                </div>
                <div class="counsel-pro-type">청소년 상담</div>
                <div class="counsel-pro-introduce">
                  <a href="<%=root%>/views/counsel/detail.jsp"
                    >마음의 평안과 진정한 나를 찾아 떠나는 여행으로
                    초대합니다.</a
                  >
                </div>
                <div class="counsel-pro-review">
                  <i class="fa-solid fa-star"></i>
                  <div>4.9</div>
                  <div>(86)</div>
                </div>
                <div class="counsel-pro-price">
                  <div>1회상담</div>
                  <div>50,000</div>
                </div>
              </div>
            </div>
            <div class="counsel-pro-detail">
              <div>
                <a href="<%=root%>/views/counsel/detail.jsp"
                  ><img
                    src="../../resources/img/counsel/Rectangle 4019.png"
                    alt=""
                /></a>
              </div>
              <div>
                <div class="counsel-pro-name">
                  <a href="<%=root%>/views/counsel/detail.jsp">주연희</a>
                </div>
                <div class="counsel-pro-type">청소년 상담</div>
                <div class="counsel-pro-introduce">
                  <a href="<%=root%>/views/counsel/detail.jsp"
                    >마음의 평안과 진정한 나를 찾아 떠나는 여행으로
                    초대합니다.</a
                  >
                </div>
                <div class="counsel-pro-review">
                  <i class="fa-solid fa-star"></i>
                  <div>4.9</div>
                  <div>(86)</div>
                </div>
                <div class="counsel-pro-price">
                  <div>1회상담</div>
                  <div>50,000</div>
                </div>
              </div>
            </div>
            <div class="counsel-pro-detail">
              <div>
                <a href="<%=root%>/views/counsel/detail.jsp"
                  ><img
                    src="../../resources/img/counsel/Rectangle 4019.png"
                    alt=""
                /></a>
              </div>
              <div>
                <div class="counsel-pro-name">
                  <a href="<%=root%>/views/counsel/detail.jsp">주연희</a>
                </div>
                <div class="counsel-pro-type">청소년 상담</div>
                <div class="counsel-pro-introduce">
                  <a href="<%=root%>/views/counsel/detail.jsp"
                    >마음의 평안과 진정한 나를 찾아 떠나는 여행으로
                    초대합니다.</a
                  >
                </div>
                <div class="counsel-pro-review">
                  <i class="fa-solid fa-star"></i>
                  <div>4.9</div>
                  <div>(86)</div>
                </div>
                <div class="counsel-pro-price">
                  <div>1회상담</div>
                  <div>50,000</div>
                </div>
              </div>
            </div>
            <div class="counsel-pro-detail">
              <div>
                <a href="<%=root%>/views/counsel/detail.jsp"
                  ><img
                    src="../../resources/img/counsel/Rectangle 4019.png"
                    alt=""
                /></a>
              </div>
              <div>
                <div class="counsel-pro-name">
                  <a href="<%=root%>/views/counsel/detail.jsp">주연희</a>
                </div>
                <div class="counsel-pro-type">청소년 상담</div>
                <div class="counsel-pro-introduce">
                  <a href="<%=root%>/views/counsel/detail.jsp"
                    >마음의 평안과 진정한 나를 찾아 떠나는 여행으로
                    초대합니다.</a
                  >
                </div>
                <div class="counsel-pro-review">
                  <i class="fa-solid fa-star"></i>
                  <div>4.9</div>
                  <div>(86)</div>
                </div>
                <div class="counsel-pro-price">
                  <div>1회상담</div>
                  <div>50,000</div>
                </div>
              </div>
            </div>
            <div class="counsel-pro-detail">
              <div>
                <a href="<%=root%>/views/counsel/detail.jsp"
                  ><img
                    src="../../resources/img/counsel/Rectangle 4019.png"
                    alt=""
                /></a>
              </div>
              <div>
                <div class="counsel-pro-name">
                  <a href="<%=root%>/views/counsel/detail.jsp">주연희</a>
                </div>
                <div class="counsel-pro-type">청소년 상담</div>
                <div class="counsel-pro-introduce">
                  <a href="<%=root%>/views/counsel/detail.jsp"
                    >마음의 평안과 진정한 나를 찾아 떠나는 여행으로
                    초대합니다.</a
                  >
                </div>
                <div class="counsel-pro-review">
                  <i class="fa-solid fa-star"></i>
                  <div>4.9</div>
                  <div>(86)</div>
                </div>
                <div class="counsel-pro-price">
                  <div>1회상담</div>
                  <div>50,000</div>
                </div>
              </div>
            </div>
          </div>
          <div class="counsel-pro-list-page">1 2 3</div>
        </section>
      </div>
    </main>
    <%@ include file="/views/common/footer.jsp" %>
  </body>
</html>
