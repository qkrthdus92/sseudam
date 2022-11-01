<%@page import="com.kh.sseudam.admin.freeBoard.vo.AdminFreeBoardVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.sseudam.common.PageVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<% 
	String root1 = request.getContextPath();
	String pno = (String)request.getAttribute("pno");
	String status = (String)request.getAttribute("status");
	String search = (String)request.getAttribute("search");
	String searchType = (String)request.getAttribute("searchType");
	PageVo pv = (PageVo)request.getAttribute("pv");
	String listCount = (String)request.getAttribute("listCount");
	List<AdminFreeBoardVo> freeBoardList = (List<AdminFreeBoardVo>)request.getAttribute("freeBoardList");
	boolean isSearchTypeAll = searchType.equals("title") || searchType.equals("content") || searchType.equals("writer");
	
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="<%=root1%>/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/common/variables.css?ver=3"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css?ver=1"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/reviewBoard/list.css?ver=1"
    />
    <style>
       .search-area {
        display: flex;
      }

      .search-area select {
        width: 100px;
        padding: 0px 2px;
        border: none;
        border: 1px solid #b0b0b0;
        cursor: pointer;
        font-size: 15px;
      }
    </style>
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header">
       <h1><a
          href="<%=root%>/admin/reviewBoard/list?pno=1&status=all&searchType=title"
          >후기게시판</a
        ></h1>
      </header>
      <section class="admin-main-section">
         <form action="<%=root1%>/admin/reviewBoard/list" method="get" class="admin-freeBoard-form">
        <div class="admin-main-section-top">
        <input type="hidden" name="pno" value="1">
          <div class="search-area">
              <div class="admin-search">
                <input type="text" placeholder="내용을 입력해주세요" name="search"/>
                <i class="fa-solid fa-magnifying-glass" ></i>
              </div>
              <select name="searchType" id="">
                <option value="title">제목</option>
                <option value="content">내용</option>
                <option value="writer">작성자</option>
              </select>
            </div>

          <div class="add-btn">
            <input
              type="button"
              value="게시글 작성"
              onclick="location.href='<%=root%>/admin/reviewBoard/write?pno=<%=pno%>&status=<%=status%>&search=<%=search%>&searchType=<%=searchType%>'"
            />
          </div>
        </div>
        <div class="admin-main-wrapper">
          <div class="admin-main-board-top">
            <div class="total-num-info">
              <span>전체 게시글</span><span><%=listCount %></span>
            </div>
            <div class="main-select-btn">
              <select name="status" id="">
                <option value="all">모든 게시글 조회</option>
                <option value="F">게시 완료 조회</option>
                <option value="C">게시 취소 조회</option>
              </select>
            </div>
          </div>
          <script>
            const inputSearchIcon = document.querySelector('input[name=search]+i');
            const selectStatus = document.querySelector('select[name=status]');
            inputSearchIcon.addEventListener('click', function() {
              const inputSearchForm = document.querySelector('.admin-freeBoard-form');
              inputSearchForm.submit();
            })

            selectStatus.addEventListener('change',function() {
              const inputSearchForm = document.querySelector('.admin-freeBoard-form');
              inputSearchForm.submit();
            })
          </script>
                    <script>
            //검색어, 검색타입, status 검색후에도 유지시키기

            //검색어
            const searchInput = document.querySelector('input[name=search]');

            const reqSearch = "<%= search%>";
           
            if('<%=search%>' != 'null') {
              searchInput.value = "<%= search%>";
            }

            //검색타입

            const searchTypeArr = document.querySelectorAll('select[name=searchType] option');
            const reqSearchType = "<%=searchType%>";
            for(let i=0; i<searchTypeArr.length; i++) {
              const x = searchTypeArr[i].value;
              if(x == reqSearchType) {
                searchTypeArr[i].selected = true;
              }
            }

            //status
            const statusArr = document.querySelectorAll('select[name=status] option');
            const reqStatusType = "<%=status%>";
            for(let i=0; i<statusArr.length; i++) {
              const x = statusArr[i].value;
              if(x == reqStatusType) {
                statusArr[i].selected = true;
              }
            }

           
          </script>
          <div class="admin-main-board">
            <div>번호</div>
            <div>썸네일</div>
            <div>제목</div>
            <div>작성자</div>
            <div>작성일시</div>
            <div>조회수</div>
            <div>댓글수</div>
            <div>최종수정일자</div>
            <div>게시여부</div>

            <%for(int i=0; i<freeBoardList.size(); i++) {%>
            <div><%=freeBoardList.get(i).getNo() %></div>
            <div><img alt="" src="<%=root1%>/resources/upload/afterBoard/<%=freeBoardList.get(i).getImg() %>"></div>
            <div>
              <a href="<%=root%>/admin/reviewBoard/detail?dno=1&bno=<%=freeBoardList.get(i).getNo() %>&pno=<%=pno %>&status=<%=status %>&search=<%=search %>&searchType=<%=searchType %>"
                ><%=freeBoardList.get(i).getTitle() %></a
              >
            </div>
            <div><%=freeBoardList.get(i).getNick() %></div>
            <div><%=freeBoardList.get(i).getEnrollDate() %></div>
            <div><%=freeBoardList.get(i).getView() %></div>
            <div><%=freeBoardList.get(i).getCmtCnt() %></div>
            <div><%=freeBoardList.get(i).getModifyDate() %></div>
            <%if(freeBoardList.get(i).getDeleteYn().equals("N")){ %>
            <div>게시완료</div>
            <%}else { %>
            <div>게시취소</div>
			<%} %>
            <%}%>
          </div>
                    <!-- 모든 게시글 조회 -->
          	<% if(status.equals("all") && search.equals("") && isSearchTypeAll) { %>
	          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/reviewBoard/list?status=all&pno=<%=pv.getStartPage()-1 %>&searchType=title&search=" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/reviewBoard/list?status=all&pno=<%=i %>&searchType=title&search=" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/reviewBoard/list?status=all&pno=<%=pv.getEndPage()+1 %>&searchType=title&search=" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
	          </div>
          	<%} %>
          <!-- 게시 완료 조회 -->
          	<% if(status.equals("F") && search.equals("") && isSearchTypeAll) { %>
          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/reviewBoard/list?status=F&pno=<%=pv.getStartPage()-1 %>&searchType=title&search=" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/reviewBoard/list?status=F&pno=<%=i %>&searchType=title&search=" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/reviewBoard/list?status=F&pno=<%=pv.getEndPage()+1 %>&searchType=title&search=" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
          </div>
          	<%} %>
          <!-- 게시 취소 조회 -->
          	<% if(status.equals("C") && search.equals("") && isSearchTypeAll) { %>
          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/reviewBoard/list?status=C&pno=<%=pv.getStartPage()-1 %>&searchType=title&search=" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/reviewBoard/list?status=C&pno=<%=i %>&searchType=title&search=" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/reviewBoard/list?status=C&pno=<%=pv.getEndPage()+1 %>&searchType=title&search=" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
          </div>
          	<%} %>
          <!-- 제목+모든 조회 -->
          	<% if(status.equals("all") && !search.equals("") && searchType.equals("title")) { %>
          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/reviewBoard/list?status=all&pno=<%=pv.getStartPage()-1 %>&searchType=title&search=<%=search %>" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/reviewBoard/list?status=all&pno=<%=i %>&searchType=title&search=<%=search %>" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/reviewBoard/list?status=all&pno=<%=pv.getEndPage()+1 %>&searchType=title&search=<%=search %>" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
          </div>
          	<%} %>
          <!-- 제목+완료 조회 -->
          	<% if(status.equals("F") && !search.equals("") && searchType.equals("title")) { %>
          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/reviewBoard/list?status=F&pno=<%=pv.getStartPage()-1 %>&searchType=title&search=<%=search %>" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/reviewBoard/list?status=F&pno=<%=i %>&searchType=title&search=<%=search %>" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/reviewBoard/list?status=F&pno=<%=pv.getEndPage()+1 %>&searchType=title&search=<%=search %>" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
          </div>
          	<%} %>
          <!-- 제목+취소 조회 -->
          	<% if(status.equals("C") && !search.equals("") && searchType.equals("title")) { %>
          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/reviewBoard/list?status=C&pno=<%=pv.getStartPage()-1 %>&searchType=title&search=<%=search %>" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/reviewBoard/list?status=C&pno=<%=i %>&searchType=title&search=<%=search %>" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/reviewBoard/list?status=C&pno=<%=pv.getEndPage()+1 %>&searchType=title&search=<%=search %>" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
          </div>
          	<%} %>
          <!-- 내용+모든 조회 -->
          	<% if(status.equals("all") && !search.equals("") && searchType.equals("content")) { %>
          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/reviewBoard/list?status=all&pno=<%=pv.getStartPage()-1 %>&searchType=content&search=<%=search %>" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/reviewBoard/list?status=all&pno=<%=i %>&searchType=content&search=<%=search %>" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/reviewBoard/list?status=all&pno=<%=pv.getEndPage()+1 %>&searchType=content&search=<%=search %>" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
          </div>
          	<%} %>
          <!-- 내용+완료 조회 -->
          	<% if(status.equals("F") && !search.equals("") && searchType.equals("content")) { %>
          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/reviewBoard/list?status=F&pno=<%=pv.getStartPage()-1 %>&searchType=content&search=<%=search %>" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/reviewBoard/list?status=F&pno=<%=i %>&searchType=content&search=<%=search %>" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/reviewBoard/list?status=F&pno=<%=pv.getEndPage()+1 %>&searchType=content&search=<%=search %>" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
          </div>
          	<%} %>
          <!-- 내용+취소 조회 -->
          	<% if(status.equals("C") && !search.equals("") && searchType.equals("content")) { %>
          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/reviewBoard/list?status=C&pno=<%=pv.getStartPage()-1 %>&searchType=content&search=<%=search %>" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/reviewBoard/list?status=C&pno=<%=i %>&searchType=content&search=<%=search %>" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/reviewBoard/list?status=C&pno=<%=pv.getEndPage()+1 %>&searchType=content&search=<%=search %>" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
          </div>
          	<%} %>
          <!-- 작성자+모든 조회 -->
          	<% if(status.equals("all") && !search.equals("") && searchType.equals("writer")) { %>
          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/reviewBoard/list?status=all&pno=<%=pv.getStartPage()-1 %>&searchType=writer&search=<%=search %>" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/reviewBoard/list?status=all&pno=<%=i %>&searchType=writer&search=<%=search %>" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/reviewBoard/list?status=all&pno=<%=pv.getEndPage()+1 %>&searchType=writer&search=<%=search %>" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
          </div>
          	<%} %>
          <!-- 작성자+완료 조회 -->
          	<% if(status.equals("F") && !search.equals("") && searchType.equals("writer")) { %>
          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/reviewBoard/list?status=F&pno=<%=pv.getStartPage()-1 %>&searchType=writer&search=<%=search %>" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/reviewBoard/list?status=F&pno=<%=i %>&searchType=writer&search=<%=search %>" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/reviewBoard/list?status=F&pno=<%=pv.getEndPage()+1 %>&searchType=writer&search=<%=search %>" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
          </div>
          	<%} %>
          <!-- 작성자+취소 조회 -->
          	<% if(status.equals("C") && !search.equals("") && searchType.equals("writer")) { %>
          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/reviewBoard/list?status=C&pno=<%=pv.getStartPage()-1 %>&searchType=writer&search=<%=search %>" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/reviewBoard/list?status=C&pno=<%=i %>&searchType=writer&search=<%=search %>" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/reviewBoard/list?status=C&pno=<%=pv.getEndPage()+1 %>&searchType=writer&search=<%=search %>" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
          </div>
          	<%} %>
        </div>
         </form>
      </section>
    </main>
  </body>
</html>
