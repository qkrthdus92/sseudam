<%@page import="com.kh.sseudam.admin.pro.vo.ProCounselListVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.sseudam.admin.pro.vo.ProCounselVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String root1 = request.getContextPath();%>

<%
	ProCounselVo pcv = (ProCounselVo)request.getAttribute("pcv");
	List<ProCounselListVo> list = (List<ProCounselListVo>)request.getAttribute("counselList");
	String pno = (String)request.getAttribute("pno");
	String status = (String)request.getAttribute("status");
	String search = (String)request.getAttribute("search");

%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>쓰담쓰담 관리자 | 전문가 | 상담현황</title>
    <link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" />
    <link rel="stylesheet" href="<%=root1%>/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/common/variables.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/pro/counsel.css?ver=5"
    />

    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css?ver=2"
    />
    <style>
      .pro-counsel-detail-list {
        grid-template-columns: 0.8fr 1.5fr 1.5fr 1fr 1fr 0.6fr 1fr;
        margin-top: 0px;
      }
    </style>
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header flex-between">
        <h1>전문가 상담 현황</h1>
        <div class="btn-set">
          <input
            class="cancel-btn"
            type="button"
            value="취소"
            onclick="history.back()"
          />
        </div>
      </header>
      <section class="admin-main-section">
        <div class="admin-main-wrapper pro-counsel-info">
          <div class="admin-info-title">
            <i class="fa-solid fa-chart-line"></i><span>상담현황</span>
          </div>

          <ul>
            <li>
              <div>누적수익</div>
              <div class="counsel-profit"><%= pcv.getProfit() %></div>
            </li>
            <li>
              <div>평균별점</div>
              <div class="counsel-avg-score"><%= pcv.getAvgStar() %></div>
            </li>
            <li>
              <div>상담완료</div>
              <div class="counsel-finish-num"><%= pcv.getFinishCnt() %></div>
            </li>
            <li>
              <div>상담대기</div>
              <div class="counsel-wait-num"><%= pcv.getWaitCnt() %></div>
            </li>
          </ul>
        </div>
        <div class="admin-main-wrapper pro-counsel-detail">
          <div class="admin-info-title">
            <i class="fa-solid fa-list"></i><span>상담내역</span
            ><span class="counsel-num"><%= Integer.parseInt(pcv.getFinishCnt()) +Integer.parseInt(pcv.getWaitCnt())  %></span>
          </div>
          <div class="admin-pro-certificate pro-counsel-detail-list">
            <div>번호</div>
            <div>상담날짜</div>
            <div>결제날짜</div>
            <div>회원아이디</div>
            <div>결제금액</div>
            <div>별점</div>
            <div>상담상태</div>
            <%for(int i=0; i<list.size(); i++) {%>
            <div><%= list.get(i).getNo() %></div>
            <div><%= list.get(i).getAdviceDate() %></div>
            <div><%= list.get(i).getPayDate() %></div>
            <div><%= list.get(i).getId() %></div>
            <div><%= list.get(i).getPrice() %></div>
            
            <%if(list.get(i).getStar()==null){%>
            <div>-</div>
            <%}else { %>
            <div><%= list.get(i).getStar() %></div>
            <%} %>
            
            <div><%= list.get(i).getStatus() %></div>

            <%}%>
          </div>
        </div>
      </section>
    </main>
  </body>
</html>
