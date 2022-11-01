<%@page import="com.kh.sseudam.faq.vo.FAQVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.sseudam.common.PageVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<% String root1 = request.getContextPath();%>
<%
	PageVo pv = (PageVo)request.getAttribute("pv");
	List<FAQVo> list = (List<FAQVo>)request.getAttribute("faqList");

	String nowPage = (String)request.getQueryString();
	int pi = 0;
	int pageNo = 1;
	if(nowPage != null){
		pi = nowPage.indexOf("pno");
		pageNo = Integer.parseInt(nowPage.substring(pi+4, pi+5));
	}	
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>관리자 FAQ</title>
    <link rel="stylesheet" href="<%=root1%>/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/common/variables.css?ver=3"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/faq/list.css?ver=3"
    />
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header">
        <h1>FAQ</h1>
      </header>
      <section class="admin-main-section">
        <div class="admin-main-section-top">
          <div class="admin-search">
          <form action="">
          		<input type="hidden" name="pno" value="<%=pageNo%>"/>
	            <input type="text" name="search" placeholder="내용을 입력해주세요" />
	            <input type="submit" id="btnSubmit" style="display:none;" />
				<label for="btnSubmit"><i class="fa-solid fa-magnifying-glass"></i></label>	
			</form>
          </div>

          <div class="add-btn">
            <input
              type="button"
              value="게시글 작성"
              onclick="location.href='<%=root%>/admin/faq/add'"
            />
          </div>
        </div>
        <div class="admin-main-wrapper">
          <div class="admin-main-board-top">
            <div class="total-num-info">
              <span>전체 게시글</span><span><%=pv.getListCount() %></span>
            </div>
          </div>
          <div class="admin-main-board">
            <div>번호</div>
            <div>제목</div>
            <div>작성자</div>
            <div>작성일시</div>
            <div>최종수정일자</div>
            <div>삭제여부</div>
            <div>edit</div>

            <%for (int i = 0; i < list.size(); i++) {%>
	            <div><%=list.get(i).getNo()%></div>
	            <div><%=list.get(i).getTitle()%></div>
	            <div><%=list.get(i).getAdminId()%></div>
	            <div><%=list.get(i).getWriteDate()%></div>
	            <div><%=list.get(i).getModifyDate()%></div>
	            <div><%=list.get(i).getDeleteYn()%></div>
	            <div>
	              <a href="<%=root%>/admin/faq/edit?no=<%=list.get(i).getNo()%>">
	            		<i class="fa-solid fa-pen-to-square"></i>
	              </a>
	            </div>
            <%}%>
            
            <div class="page">
			<%if(pv.getStartPage() != 1){ %>	        
				<div>
			        	<a class="other-pages" href="<%=root%>/admin/faq?pno=<%=pv.getStartPage() - 1 %>"><</a>        
				</div>
        	<%} %>  
			<% 
				for(int j = pv.getStartPage(); j<=pv.getEndPage() ;j++){
			%>
				<div>
						<%if(pageNo == j){%>	
			            	<a class="current-page" >
		            	<%}else{ %>
		            		<a href="<%=root%>/admin/faq?pno=<%=j%>" class="other-pages" >
		            	<%}%> <%=j %>
	           				</a> 
				</div>			
	        <%} %>
			<%if(pv.getEndPage() != pv.getMaxPage()){ %>	        
				<div>
		        	<a class="other-pages" href="<%=root%>/admin/faq?pno=<%=pv.getEndPage() + 1 %>">></a>        
	        	</div>
        	<%} %>
          </div>
        </div>
      </section>
    </main>
  </body>
</html>
