<%@page import="com.kh.sseudam.counsel.pro.vo.CertificateVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.sseudam.counsel.pro.vo.ProVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<% String root5 = request.getContextPath();%>
<%ProVo vo = (ProVo)request.getAttribute("vo"); %>
<%List<CertificateVo> cerList = (List<CertificateVo>)request.getAttribute("cerList"); %>
  
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>전문가 상세 :: 쓰담쓰담</title>
    <link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" />
    <link rel="stylesheet" href="<%= root5 %>/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="<%= root5 %>/resources/css/counsel/detail.css?ver=3"
    />
    <link
      rel="stylesheet"
      href="<%= root5 %>/resources/css/common/variables.css"
    />
    <style>
    
    </style>
  </head>
  <body>
    <%@ include file="/views/common/header.jsp" %>
    <main id="counsel-detail-main">
      <div class="main-wrapper counsel-detail-main-wrapper">
        <div class="counsel-detail-top">
          <div class="counsel-detail-pro-img">
            <img src="<%= root5 %>/resources/upload/pro/<%= vo.getImg() %>" alt="" />
          </div>
          <div class="counsel-detail-pro-summary">
            <div class="counsel-pro-name"><%= vo.getName() %></div>
            <div class="counsel-pro-type"><%= vo.getCounselType() %></div>
            <div class="counsel-pro-introduce">
              <%= vo.getIntroduce() %>
            </div>
            <div class="counsel-pro-review">
              <i class="fa-solid fa-star"></i>
              <div><%= vo.getAvgStar() %></div>
              <div>(<%= vo.getCounselCnt() %>)</div>
            </div>
            <div class="counsel-pro-price">
              <div>1회상담</div>
              <div><%= vo.getPrice() %></div>
            </div>
            <div class="counsel-detail-appoint-btn">
              <!-- <a href="<%=root%>/counsel/pay?bno=<%=vo.getNo()%>">상담받기</a> -->
              <%if(loginMember==null){ %>
              <button id="reserve-counsel-btn" class="popup-btn" onclick="loginPopup(true)" >상담받기</button>
              <%}else{ %>
              <button id="reserve-counsel-btn" >상담받기</button>
              <%} %>
            </div>
            <%if(loginMember!=null){ %>
            <script>
              const reserveCounselBtn = document.querySelector('#reserve-counsel-btn');
              reserveCounselBtn.addEventListener('click',function() {
                location.href='<%=root%>/counsel/pay?bno=<%=vo.getNo()%>';
              })
            </script>
            <%} %>
          </div>
          <div class="counsel-detail-notice">
            <div class="counsel-detail-notice-title">
              <img
                src="<%=root %>/resources/img/counsel/Chat_alt_3_light.png"
                alt=""
              /><span>알려드립니다!</span>
            </div>
            <ul>
              <li>
                <div>·</div>
                <span
                  >쓰담쓰담은 상담 결제 후 전문가와 일정을 조율하여 예약
                  상담으로 진행됩니다.</span
                >
              </li>
              <li>
                <div>·</div>
                <span>결제 후 예약 확인 정보를 문자로 보내드립니다.</span>
              </li>
              <li>
                <div>·</div>
                <span>결제 후 바로 상담이 불가능할 수 있습니다.</span>
              </li>
              <li>
                <div>·</div>
                <span>결제 후 환불이 불가합니다.</span>
              </li>
            </ul>
          </div>
        </div>
        <div class="counsel-detail-border"></div>
        <div class="counsel-detail-introduce">
          <div class="counsel-detail-introduce-title">
            <span>전문가 소개</span>
          </div>
          <div class="counsel-detail-introduce-certificate">
            <div><i class="fa-solid fa-award"></i><span>자격증</span></div>
            <ul>
            <% for(int i=0; i<cerList.size(); i++) { %>
            	<li><%= cerList.get(i).getName() %></li>
            <%} %>
            </ul>
          </div>
          <div class="counsel-detail-introduce-edu">
            <div>
              <i class="fa-solid fa-graduation-cap"></i><span>학력</span>
            </div>
            <ul>
              <li><%=vo.getEducation() %></li>
            </ul>
          </div>
        </div>
      </div>
    </main>

    <%@ include file="/views/common/footer.jsp" %>
  </body>
</html>
