<%@page import="com.kh.sseudam.member.vo.MemberVo"%>
<%@page import="com.kh.sseudam.common.PageVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String root1 = request.getContextPath();%>
<% 
	List<MemberVo> memberList = (List<MemberVo>)request.getAttribute("memberList"); 
	PageVo pv = (PageVo)request.getAttribute("pv");
	String quitYn = (String)request.getAttribute("quitYn");
	String search = (String)request.getAttribute("search");
	String pno = (String)request.getAttribute("pno");
	String listCount = (String)request.getAttribute("listCount");
  

%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>쓰담쓰담 관리자 | 사용자 | 목록</title>
    <link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" />
    <link rel="stylesheet" href="<%=root1%>/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/common/variables.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/member/list.css?ver=3"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css?ver=5"
    />
    <style>
      .admin-menu-main-user li:first-child a {
        color: var(--adminMenuHover);
        font-size: 17px;
      }
      .admin-main-board {
        display: grid;
        grid-template-columns: 0.7fr 1fr 1fr 1fr 1.2fr 1.2fr 1fr 1fr 0.7fr;
        grid-template-rows: repeat(11, 50px);
      }

    </style>
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header">
        <h1><a href="<%=root%>/admin/member/list?pno=1&quitYn=both">사용자</a></h1>
        
      </header>
      <section class="admin-main-section">
        <div class="admin-main-section-top">
          <form action="<%=root1%>/admin/member/list" id="member-search-form">
            <div class="admin-search">
              <input type="text" class="hidden" name="pno" value="1">
             
              <input
                type="text"
                onkeyup="if(window.event.keyCode==13){document.getElementById('member-search-form').submit();}"
                placeholder="사용자 이름 또는 아이디를 입력해주세요"
                name = "search"
                
              />
              <i class="fa-solid fa-magnifying-glass" onclick="document.getElementById('member-search-form').submit();"></i>
            </div>

          </form>

          <div class="add-btn">
            <input
              type="button"
              value="사용자 추가"
              onclick="location.href='<%=root%>/admin/member/add'"
            />
          </div>
        </div>
        <div class="admin-main-wrapper">
          <div class="admin-main-board-top">
            <div class="total-num-info">
              <span>전체 사용자</span>
              <span><%=listCount %></span>
              <%-- <%if(memberList == null) {%>
              <span>0</span>
              <%} else {%>
              
              <span><%= memberList.size() %></span>
              <%} %> --%>
            </div>
            <form action="<%=root1%>/admin/member/list" method="get">
            <input type="text" class="hidden" name="pno" value="1">
              <div class="main-select-btn">
                <select name="quitYn" id="" onchange="this.form.submit();">
                	<% if(quitYn.equals("both")) { %>
                	<option value="both" selected>모든 회원 조회</option>
                	<% }else { %>
	                  <option value="both" >모든 회원 조회</option>
                	
                	<%} %>
                	<% if(quitYn.equals("N")) { %>
                	<option value="N" selected>일반 회원 조회</option>
                	<% }else { %>
	                  <option value="N" >일반 회원 조회</option>
                	
                	<%} %>
                	<% if(quitYn.equals("Y")) { %>
                	<option value="Y" selected>탈퇴 회원 조회</option>
                	<% }else { %>
	                  <option value="Y" >탈퇴 회원 조회</option>
                	
                	<%} %>
              
                </select>
              </div>

            </form>
          </div>
          <div class="admin-main-board">
            <div>번호</div>
            <div>이름</div>
            <div>아이디</div>
            <div>닉네임</div>
            <div>전화번호</div>
            <div>이메일</div>
            <div>테스트점수</div>
            <div>계정상태</div>
            <div>edit</div>
            <%for(int i=0; i<memberList.size(); i++) {%>
            <div><%= memberList.get(i).getNo() %></div>
            <div><%= memberList.get(i).getName() %></div>
            <div><%= memberList.get(i).getId() %></div>
            <div><%= memberList.get(i).getNick() %></div>
            <div><%= memberList.get(i).getPhone() %></div>
            <div><%= memberList.get(i).getEmail() %></div>
            <div><%= memberList.get(i).getTestScore() %></div>
            <% if(memberList.get(i).getQuitYn().equals("N")){ %>
            <div>일반회원</div>
            <% }else { %>
            <div>탈퇴회원</div>
            <%} %>
            <div>
              <a href="<%=root%>/admin/member/edit?mno=<%=memberList.get(i).getNo() %>&pno=<%=pno %>&quitYn=<%=quitYn %>&search=<%=search%>"
                ><i class="fa-solid fa-pen-to-square"></i
              ></a>
            </div>
            <%}%>
          </div>
          <div id="page-area" class="page-area">
          
          <% if(quitYn.equals("both") && search == null) { %>
            <%if(pv.getStartPage()!=1) {%>
            <a href="<%=root1%>/admin/member/list?quitYn=both&pno=<%=pv.getStartPage()-1 %>" class="btn btn-primary btn-sm"><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
            <%}%>
	          <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
	            <a href="<%=root1%>/admin/member/list?quitYn=both&pno=<%=i %>" class="btn btn-primary btn-sm"><span><%=i %></span> </a>
	          <%}%>
	          <%if(pv.getEndPage() != pv.getMaxPage()) { %>
	           <a href="<%=root1%>/admin/member/list?quitYn=both&pno=<%=pv.getEndPage()+1 %>" class="btn btn-primary btn-sm"><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
	          <%}%>
          
          <%} %>
          <% if(quitYn.equals("N") && search == null) { %>
            <%if(pv.getStartPage()!=1) {%>
            <a href="<%=root1%>/admin/member/list?quitYn=N&pno=<%=pv.getStartPage()-1 %>" class="btn btn-primary btn-sm"><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
            <%}%>
	          <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
	            <a href="<%=root1%>/admin/member/list?quitYn=N&pno=<%=i %>" class="btn btn-primary btn-sm"><span><%=i %></span></a>
	          <%}%>
	          <%if(pv.getEndPage() != pv.getMaxPage()) { %>
	           <a href="<%=root1%>/admin/member/list?quitYn=N&pno=<%=pv.getEndPage()+1 %>" class="btn btn-primary btn-sm"><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
	          <%}%>
          
          <%} %>
          <% if(quitYn.equals("Y") && search == null) { %>
            <%if(pv.getStartPage()!=1) {%>
            <a href="<%=root1%>/admin/member/list?quitYn=Y&pno=<%=pv.getStartPage()-1 %>" class="btn btn-primary btn-sm"><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
            <%}%>
	          <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
	            <a href="<%=root1%>/admin/member/list?quitYn=Y&pno=<%=i %>" class="btn btn-primary btn-sm"><span><%=i %></span></a>
	          <%}%>
	          <%if(pv.getEndPage() != pv.getMaxPage()) { %>
	           <a href="<%=root1%>/admin/member/list?quitYn=Y&pno=<%=pv.getEndPage()+1 %>" class="btn btn-primary btn-sm"><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
	          <%}%>
          
          <%} %>
          
          <% if(search!=null) { %>
            <%if(pv.getStartPage()!=1) {%>
            <a href="<%=root1%>/admin/member/list?search=<%=search %>&pno=<%=pv.getStartPage()-1 %>" class="btn btn-primary btn-sm"><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
            <%}%>
	          <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
	            <a href="<%=root1%>/admin/member/list?search=<%=search %>&pno=<%=i %>" class="btn btn-primary btn-sm"><span><%=i %></span></a>
	          <%}%>
	          <%if(pv.getEndPage() != pv.getMaxPage()) { %>
	           <a href="<%=root1%>/admin/member/list?search=<%=search %>&pno=<%=pv.getEndPage()+1 %>" class="btn btn-primary btn-sm"><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
	          <%}%>
          
          <%} %>
        </div>
        </div>
      </section>
    </main>
  </body>
</html>
