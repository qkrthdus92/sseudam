<%@page import="com.kh.sseudam.common.PageVo"%>
<%@page import="com.kh.sseudam.healing.vo.HealingVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<% String root1 = request.getContextPath();%>
<!DOCTYPE html>
<%
	List<HealingVo> list = (List<HealingVo>) request.getAttribute("insideList");
	PageVo pv = (PageVo)request.getAttribute("pv");
	String sort = (String)request.getAttribute("sort");
	String type = (String)request.getAttribute("type");
%>

<%
	String nowPage = (String)request.getQueryString();
	int pi = 0;
	int pageNo = 1;
	int tNo = 4;
	if(nowPage != null){
		pi = nowPage.indexOf("pno");
		pageNo = Integer.parseInt(nowPage.substring(pi+4, pi+5));
	}	
	
	if(nowPage != null){
		pi = nowPage.indexOf("type");
		tNo = Integer.parseInt(nowPage.substring(pi+5, pi+6));
	}
	String typeName = "";
	if(type.equals("&type=4")){typeName = "음악";}
	else if(type.equals("&type=5")){typeName = "영화";}
	else if(type.equals("&type=6")){typeName = "명상";}
	else{typeName = "책";}
	
	String sortName = "모든 게시글 조회";
	if(sort.equals("&sort=2")){sortName = "게시 완료 조회";}
	else if(sort.equals("&sort=3")){sortName = "게시 취소 조회";}

%>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>쓰담쓰담 관리자 | 뒹굴뒹굴 | 목록</title>
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
      href="<%=root1%>/resources/css/admin/wallow/list.css?ver=2"
    />
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <header class="admin-main-header">
        <select name="" id="" onchange="window.open(value,'_self');">
          <option style="display:none;">
            안에서 뒹굴뒹굴 - <%=typeName %>
          </option>
          <option value="<%=root%>/admin/inside?pno=1&type=4">
            안에서 뒹굴뒹굴 - 음악
          </option>
          <option value="<%=root%>/admin/inside?pno=1&type=5">
            안에서 뒹굴뒹굴 - 영화
          </option>
          <option value="<%=root%>/admin/inside?pno=1&type=6">
            안에서 뒹굴뒹굴 - 명상
          </option>
          <option value="<%=root%>/admin/inside?pno=1&type=7">
            안에서 뒹굴뒹굴 - 책
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
              value="뒹굴 추가"
              onclick="location.href='<%=root%>/admin/inside/add'"
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
                <option value="<%=root%>/admin/inside?pno=1<%=type %>&sort=1">모든 게시글 조회</option>
                <option value="<%=root%>/admin/inside?pno=1<%=type %>&sort=2">게시 완료 조회</option>
                <option value="<%=root%>/admin/inside?pno=1<%=type %>&sort=3">게시 취소 조회</option>
              </select>
            </div>
          </div>
          <div class="admin-main-board">
            <div>번호</div>
            <div>썸네일</div>
            <div>제목</div>
            <% if(tNo == 4){ %><div>가수</div><div>장르</div>
            <%}else if(tNo == 5){ %><div>출연진</div><div>-</div>
            <%}else if(tNo == 6){ %><div>-</div><div>-</div>
            <%}else{ %><div>작가</div><div>출판사</div><%} %>            
            <div>등록일자</div>
            <div>최종수정일자</div>
            <div>삭제여부</div>
            <div>좋아요</div>
            <div>edit</div>

			
            <%for (int i = 0; i < list.size(); i++) {%>
            <div><%=list.get(i).getNo()%></div>
            <div>
              <img src="<%=root%>/resources/upload/inside/<%=list.get(i).getImgPath()%>">
            </div>
            <div><%=list.get(i).getTitle()%></div>
            <div><%=list.get(i).getInfoA()%></div>
            <div><%=list.get(i).getInfoB()%></div>
            <div><%=list.get(i).getWriteDate()%></div>
            <div><%=list.get(i).getModifyDate()%></div>
            <div><%=list.get(i).getDeleteYn()%></div>
            <div><%=list.get(i).getLiked()%></div>
            <div>
              <a href="<%=root%>/admin/inside/edit?no=<%=list.get(i).getNo()%>">
            		<i class="fa-solid fa-pen-to-square"></i>
              </a>
            </div>

            <%}%>
            
            <div class="page">
			<%if(pv.getStartPage() != 1){ %>	        
				<div>
			        	<a class="other-pages" href="<%=root%>/admin/inside?pno=<%=pv.getStartPage() - 1 %><%=sort%><%=type%>"><</a>        
				</div>
        	<%} %>  
			<% 
				for(int j = pv.getStartPage(); j<=pv.getEndPage() ;j++){
			%>
				<div>
						<%if(pageNo == j){%>	
			            	<a class="current-page" >
		            	<%}else{ %>
		            		<a href="<%=root%>/admin/inside?pno=<%=j%><%=sort%><%=type%>" class="other-pages" >
		            	<%}%> <%=j %>
	           				</a> 
				</div>			
	        <%} %>
			<%if(pv.getEndPage() != pv.getMaxPage()){ %>	        
				<div>
		        	<a class="other-pages" href="<%=root%>/admin/inside?pno=<%=pv.getEndPage() + 1 %><%=sort%><%=type%>">></a>        
	        	</div>
        	<%} %>
		</section>
    </main>
  </body>
</html>
