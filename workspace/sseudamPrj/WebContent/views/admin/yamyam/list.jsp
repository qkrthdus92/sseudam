<%@page import="com.kh.sseudam.common.PageVo"%>
<%@page import="com.kh.sseudam.healing.vo.HealingVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<% String root1 = request.getContextPath();%>
<!DOCTYPE html>
<%
	List<HealingVo> list = (List<HealingVo>) request.getAttribute("nyamList");
	PageVo pv = (PageVo)request.getAttribute("pv");
	String sort = (String)request.getAttribute("sort");
	String type = (String)request.getAttribute("type");
%>

<%
	String nowPage = (String)request.getQueryString();
	int pi = 0;
	int pageNo = 1;
	int tNo = 1;
	if(nowPage != null){
		pi = nowPage.indexOf("pno");
		pageNo = Integer.parseInt(nowPage.substring(pi+4, pi+5));
	}	
	
	if(nowPage != null){
		pi = nowPage.indexOf("type");
		tNo = Integer.parseInt(nowPage.substring(pi+5, pi+6));
	}
	String typeName = "";
	if(type.equals("&type=1")){typeName = "혼밥";}
	else if(type.equals("&type=2")){typeName = "혼카페";}
	else{typeName = "혼술";}
	
	String sortName = "모든 게시글 조회";
	if(sort.equals("&sort=2")){sortName = "게시 완료 조회";}
	else if(sort.equals("&sort=3")){sortName = "게시 취소 조회";}

%>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>쓰담쓰담 관리자 | 혼자서냠냠 | 목록</title>
    <link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" />
    <link rel="stylesheet" href="<%=root1%>/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/common/variables.css?ver=3"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css?ver=3"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/yamyam/list.css?ver=2"
    />
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header">
        <select name="" id="" onchange="window.open(value,'_self');">
          <option style="display:none;">
            혼자서냠냠 - <%=typeName %>
          </option>
          <option value="<%=root%>/admin/nyam?pno=1&type=1">
            혼자서냠냠 - 혼밥
          </option>
          <option value="<%=root%>/admin/nyam?pno=1&type=2">
            혼자서냠냠 - 혼카페
          </option>
          <option value="<%=root%>/admin/nyam?pno=1&type=3">
            혼자서냠냠 - 혼술
          </option>
        </select>
      </header>
      <section class="admin-main-section">
        <div class="admin-main-section-top">
          <div class="admin-search">
          	<form action="">
	          	<input type="hidden" name="pno" value="1"/>
				<input type="hidden" name="type" value="<%=tNo%>"/>
	            <input type="text" name="search" placeholder="내용을 입력해주세요" />
	            <input type="submit" id="btnSubmit" style="display:none;" />
				<label for="btnSubmit"><i class="fa-solid fa-magnifying-glass"></i></label>	            
            </form>
          </div>

          <div class="add-btn">
            <input
              type="button"
              value="냠냠 추가"
              onclick="location.href='<%=root%>/admin/nyam/add'"
            />
          </div>
        </div>
        <div class="admin-main-wrapper">
          <div class="admin-main-board-top">
            <div class="total-num-info">
              <span>전체 게시글</span><span><%=pv.getListCount() %></span>
            </div>
            <div class="main-select-btn">
              <select name="" id=""  onchange="window.open(value,'_self');">
                <option style="display:none;"><%=sortName %></option>
                <option value="<%=root%>/admin/nyam?pno=1<%=type %>&sort=1">모든 게시글 조회</option>
                <option value="<%=root%>/admin/nyam?pno=1<%=type %>&sort=2">게시 완료 조회</option>
                <option value="<%=root%>/admin/nyam?pno=1<%=type %>&sort=3">게시 취소 조회</option>
              </select>
            </div>
          </div>
          <div class="admin-main-board">
            <div>번호</div>
            <div>썸네일</div>
            <div>이름</div>
            <div>주소</div>
            <div>전화번호</div>
            <div>등록일자</div>
            <div>최종수정일자</div>
            <div>삭제여부</div>
            <div>좋아요</div>
            <div>edit</div>

			
            <%for (int i = 0; i < list.size(); i++) {%>
            <div><%=list.get(i).getNo()%></div>
            <div>
              <img src="<%=root%>/resources/upload/nyam/<%=list.get(i).getImgPath()%>">
            </div>
            <div><%=list.get(i).getTitle()%></div>
            <div><%=list.get(i).getInfoA()%></div>
            <div><%=list.get(i).getInfoB()%></div>
            <div><%=list.get(i).getWriteDate()%></div>
            <div><%=list.get(i).getModifyDate()%></div>
            <div><%=list.get(i).getDeleteYn()%></div>
            <div><%=list.get(i).getLiked()%></div>
            <div>
              <a href="<%=root%>/admin/nyam/edit?no=<%=list.get(i).getNo()%>">
            		<i class="fa-solid fa-pen-to-square"></i>
              </a>
            </div>

            <%}%>
            
            <div class="page">
			<%if(pv.getStartPage() != 1){ %>	        
				<div>
			        	<a class="other-pages" href="<%=root%>/admin/nyam?pno=<%=pv.getStartPage() - 1 %><%=sort%><%=type%>"><</a>        
				</div>
        	<%} %>  
			<% 
				for(int j = pv.getStartPage(); j<=pv.getEndPage() ;j++){
			%>
				<div>
						<%if(pageNo == j){%>	
			            	<a class="current-page" >
		            	<%}else{ %>
		            		<a href="<%=root%>/admin/nyam?pno=<%=j%><%=sort%><%=type%>" class="other-pages" >
		            	<%}%> <%=j %>
	           				</a> 
				</div>			
	        <%} %>
			<%if(pv.getEndPage() != pv.getMaxPage()){ %>	        
				<div>
		        	<a class="other-pages" href="<%=root%>/admin/nyam?pno=<%=pv.getEndPage() + 1 %><%=sort%><%=type%>">></a>        
	        	</div>
        	<%} %>
		</section>
    </main>
  </body>
</html>
