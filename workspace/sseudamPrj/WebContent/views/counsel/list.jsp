<%@page import="com.kh.sseudam.common.PageVo"%>
<%@page import="com.kh.sseudam.counsel.pro.vo.ProVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<% String root1 = request.getContextPath();%>
<% List<ProVo> proList = (List<ProVo>)request.getAttribute("proList"); %>
<%	PageVo pv = (PageVo)request.getAttribute("pv"); %>
<% String order = (String)request.getAttribute("order"); %>
<% String proName = (String)request.getAttribute("proName"); %>
<% String counselType = (String)request.getAttribute("counselType"); %>
<% String proLevel = (String)request.getAttribute("proLevel"); %>
<% String gender = (String)request.getAttribute("gender"); %>
<% String certificate = (String)request.getAttribute("certificate"); %>

<% String choose = (String)request.getAttribute("choose"); %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>쓰담쓰담 - 내 상황에 딱 맞는 전문 심리상담사 찾기</title>
    <link rel="stylesheet" href="<%=root1%>/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/counsel/list.css?ver=11"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/common/variables.css"
    />
    <script src="<%=root1%>/resources/js/counsel/list.js?ver=5"></script>
  </head>
  <body>
    <%@ include file="/views/common/header.jsp" %>
    <main id="counsel-main" class="counsel-main-font">
      <div class="main-wrapper counsel-main-wrapper">
        <form id="form-search-pro-name" action="<%=root %>/counsel/list?pno=1" method="get" onsubmit="return false">
        <aside class="counsel-aside">
              <div class="counsel-search">
                <input type="text" name="pno" value="1" class="hidden">
              <input
                class="border search-name-input"
                type="text"
                placeholder="전문가 이름을 검색하세요"
                name="proName"
        
              />
              <i class="fa-solid fa-magnifying-glass"></i>
              
              </div>
            </form>
            
            <form action="<%=root%>/counsel/list?pno=1" method="get">
            <input type="text" name="pno" value="1" class="hidden">
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
                  <span>상담사 등급<i class="fa-solid fa-circle-info counsel-pro-level-info"></i>
                  <div class="counsel-pro-level-info-detail hidden">
                    <div><span>마스터</span>: 1급자격증  보유, 평점 4.5 이상, 후기 10개 이상</div>
                    <div><span>전 문</span>: 1급자격증을 보유했거나 평점 4.5 이상, 후기 10개 이상</div>
                    <div><span>일 반</span>: 상담심리 관련 학사 졸업 이상</div>
                  </div>
                  </span>
                  <script>
                    const body = document.querySelector('body');
                    body.addEventListener('click', function(e) {
                      const info = document.querySelector('.counsel-pro-level-info-detail');
                      if(!e.target.className.includes('counsel-pro-level-info') && !e.target.className.includes('counsel-pro-level-info-detail')) {
                        info.classList.add('hidden');
                      }
                    })
                    const icon = document.querySelector('.counsel-pro-level-info');
                    icon.addEventListener('click',function() {
                      const info = document.querySelector('.counsel-pro-level-info-detail');
                      info.classList.toggle('hidden');
                    })
                  </script>
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
                <input type="submit" value="조회" class="cursor"/>
              </div>
            </form>
            
          </aside>

          <script>
            //상세조회 체크한거 유지시키기

            //상담분야
            const proCounselTypeArr = document.querySelectorAll('input[name=counselType]');
            const proCounselTypeStr = "<%= counselType%>";
            for(let i=0; i<proCounselTypeArr.length; i++) {
              const x = proCounselTypeArr[i].value;
              let result = proCounselTypeStr.search(x);
              if(result>=0) {
                proCounselTypeArr[i].checked = true;
              }
            }

            //전문가 등급
            const proLevelArr = document.querySelectorAll('input[name=proLevel]');
            const proLevelStr = "<%= proLevel%>";
            for(let i=0; i<proLevelArr.length; i++) {
              const x = proLevelArr[i].value;
              let result = proLevelStr.search(x);
              if(result>=0) {
                proLevelArr[i].checked = true;
              }
            }

            //성별
            const proGenderArr = document.querySelectorAll('input[name=gender]');
            const proGenderStr = "<%= gender%>";
            for(let i=0; i<proGenderArr.length; i++) {
              const x = proGenderArr[i].value;
              let result = proGenderStr.search(x);
              if(result>=0) {
                proGenderArr[i].checked = true;
              }
            }


            //몇급
            const proCerArr = document.querySelectorAll('input[name=certificate]');
            const proCerStr = "<%= certificate%>";
            for(let i=0; i<proCerArr.length; i++) {
              const x = proCerArr[i].value;
              let result = proCerStr.search(x);
              if(result>=0) {
                proCerArr[i].checked = true;
              }
            }
      
           
          </script>
   

        <section class="counsel-section">
          <ul class="counsel-filter">
            <!-- <li><a href="<%=root%>/counsel/list?order=normal&pno=1">기본정렬</a></li> -->

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
	                <a href="<%=root%>/counsel/detail?bno=<%=proList.get(i).getNo() %>"
	                  ><img
	                    src="<%=root %>/resources/upload/pro/<%= proList.get(i).getImg() %>"
	                    alt=""
	                /></a>
	              </div>
	              <div class="counsel-pro-detail__detail">
	                <div class="counsel-pro-name">
	                  <a href="<%=root%>/counsel/detail?bno=<%=proList.get(i).getNo() %>"><%= proList.get(i).getName() %></a>
	                </div>
	                <div class="counsel-pro-type"><%=proList.get(i).getCounselType() %></div>
	                <div class="counsel-pro-introduce">
	                  <a href="<%=root%>/counsel/detail?bno=<%=proList.get(i).getNo() %>"
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
          <%if(proName != null ) {%>
        	  <div class="counsel-pro-list-page">
	          <%if(pv.getStartPage()!=1) {%>
	      		<a href="<%= root %>/counsel/list?proName=<%=proName %>&pno=<%=pv.getStartPage()-1 %>" class="counsel-paging"><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	      	  <%}%>
		      <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		      	<a href="<%= root %>/counsel/list?proName=<%=proName %>&pno=<%=i %>" class="counsel-paging"><span><%=i %></span></a>
		      <%}%>
		      <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		       <a href="<%= root %>/counsel/list?proName=<%=proName %>&pno=<%=pv.getEndPage()+1 %>" class="counsel-paging"><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		      <%}%>
	          </div> 
          <%} %>
          
          <%if(order != null) {%>
	         <div class="counsel-pro-list-page">
	          <%if(pv.getStartPage()!=1) {%>
	      		<a href="<%= root %>/counsel/list?order=<%=order %>&pno=<%=pv.getStartPage()-1 %>" class="counsel-paging"><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	      	  <%}%>
		      <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		      	<a href="<%= root %>/counsel/list?order=<%=order %>&pno=<%=i %>" class="counsel-paging"><span><%=i %></span></a>
		      <%}%>
		      <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		       <a href="<%= root %>/counsel/list?order=<%=order %>&pno=<%=pv.getEndPage()+1 %>" class="counsel-paging"><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		      <%}%>
	          </div> 
          
          <%} %>
           <%if(choose != null) {%>
        	  <div class="counsel-pro-list-page">
	          <%if(pv.getStartPage()!=1) {%>
	      		<a href="<%= root %>/counsel/list?<%=counselType %>&<%=proLevel %>&gender=<%= gender %>&certificate=<%= certificate %>&pno=<%=pv.getStartPage()-1 %>" class="counsel-paging"><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	      	  <%}%>
		      <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		      	<a href="<%= root %>/counsel/list?<%=counselType %>&<%=proLevel %>&gender=<%= gender %>&certificate=<%= certificate %>&pno=<%=i %>" class="counsel-paging"><span><%=i %></span></a>
		      <%}%>
		      <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		       <a href="<%= root %>/counsel/list?<%=counselType %>&<%=proLevel %>&gender=<%= gender %>&certificate=<%= certificate %>&pno=<%=pv.getEndPage()+1 %>" class="counsel-paging counsel-paging-right"><i class="fa-solid fa-angles-right"></i></a>
		      <%}%>
	          </div> 
          <%} %> 
        </section>
      </div>
    </main>
    <%@ include file="/views/common/footer.jsp" %>
  </body>
</html>
