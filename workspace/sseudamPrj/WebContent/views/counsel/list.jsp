<%@page import="com.kh.sseudam.common.PageVo"%>
<%@page import="com.kh.sseudam.counsel.pro.vo.ProVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<% String root1 = request.getContextPath();%>
<% List<ProVo> proList = (List<ProVo>)request.getAttribute("proList"); %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="<%=root1%>/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/counsel/list.css?ver=6"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/common/variables.css"
    />
    <script src="<%=root1%>/resources/js/counsel/list.js?ver=2"></script>
  </head>
  <body>
    <%@ include file="/views/common/header.jsp" %>
    <main id="counsel-main">
      <div class="main-wrapper counsel-main-wrapper">
        <form id="form-search-pro-name" action="<%=root %>/counsel/list" method="get" onsubmit="return false">
        <aside class="counsel-aside">
              <div class="counsel-search">
              <input
                class="border"
                type="text"
                placeholder="전문가 이름을 검색하세요"
                name="proName"
        
              />
              <i class="fa-solid fa-magnifying-glass"></i>
              
              </div>
            </form>
            
            <form action="<%=root%>/counsel/list" method="post">
              <div class="counsel-type border">
                <div class="counsel-type-header">
                  <img
                    src="<%= root %>/resources/img/counsel/Folder_search_duotone_line.png"
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
                        value="청소년상담"
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
                        value="가족심리상담"
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
                        value="우울증상담"
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
                        value="취업/진로상담"
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
                  <img src="<%=root %>/resources/img/counsel/Filter.png" alt="" />
  
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
                          name="proLevel"
                          value="level3"
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
                          name="proLevel"
                          value="level2"
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
                          name="proLevel"
                          value="level1"
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
                      value="M"
                    /><label for="g2">남자</label>
                    <input
                      type="radio"
                      id="g3"
                      name="gender"
                      value="F"
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
            </form>
            
          </aside>
   

        <section class="counsel-section">
          <ul class="counsel-filter">
            <li><a href="<%=root%>/counsel/list?order=normal&pno=1">기본정렬</a></li>
            <li><a href="<%=root%>/counsel/list?order=latest&pno=1">최근등록순</a></li>
            <li><a href="<%=root%>/counsel/list?order=star&pno=1">평점순</a></li>
            <li><a href="<%=root%>/counsel/list?order=review&pno=1">후기많은순</a></li>
            <li><a href="<%=root%>/counsel/list?order=maxPrice&pno=1">높은가격순</a></li>
            <li><a href="<%=root%>/counsel/list?order=minPrice&pno=1">낮은가격순</a></li>
          </ul>
          <div class="counsel-pro-list">
          
          	<%for(int i=0; i<proList.size(); i++) {%>
	            <div class="counsel-pro-detail">
	              <div>
	                <a href="<%=root%>/views/counsel/detail.jsp"
	                  ><img
	                    src="<%=root %>/resources/upload/pro/<%= proList.get(i).getImg() %>"
	                    alt=""
	                /></a>
	              </div>
	              <div>
	                <div class="counsel-pro-name">
	                  <a href="<%=root%>/views/counsel/detail.jsp"><%= proList.get(i).getName() %></a>
	                </div>
	                <div class="counsel-pro-type"><%=proList.get(i).getCounselType() %></div>
	                <div class="counsel-pro-introduce">
	                  <a href="<%=root%>/views/counsel/detail.jsp"
	                    ><%= proList.get(i).getIntroduce() %></a
	                  >
	                </div>
	                <div class="counsel-pro-review">
	                  <i class="fa-solid fa-star"></i>
	                  <div><%= proList.get(i).getAvgStar() %></div>
	                  <div>(<%= proList.get(i).getCounselCnt() %>)</div>
	                </div>
	                <div class="counsel-pro-price">
	                  <div>1회상담</div>
	                  <div><%= proList.get(i).getPrice() %></div>
	                </div>
	              </div>
	            </div>
            <%} %>
            

          </div>
         <%--  <div class="counsel-pro-list-page">
          <%if(pv.getStartPage()!=1) {%>
      		<a href="<%= root %>/counsel/list?pno=<%=pv.getStartPage()-1 %>" class="btn btn-primary btn-sm">이전</a>
      	  <%}%>
	      <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
	      	<a href="<%= root %>/counsel/list?pno=<%=i %>" class="btn btn-primary btn-sm"><%=i %></a>
	      <%}%>
	      <%if(pv.getEndPage() != pv.getMaxPage()) { %>
	       <a href="<%= root %>/counsel/list?pno=<%=pv.getEndPage()+1 %>" class="btn btn-primary btn-sm">다음</a>
	      <%}%>
          </div> --%>
        </section>
      </div>
    </main>
    <%@ include file="/views/common/footer.jsp" %>
  </body>
</html>
