<%@page import="com.kh.sseudam.common.AttachmentVo"%>
<%@page import="com.kh.sseudam.admin.freeBoard.vo.AdminFreeBoardCmtVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.sseudam.admin.freeBoard.vo.AdminFreeBoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<% 

	String root1 = request.getContextPath();
	String bno = (String)request.getAttribute("bno");
	String pno = (String)request.getAttribute("pno");
  String dno = (String)request.getAttribute("dno");
	String status = (String)request.getAttribute("status");
	String search = (String)request.getAttribute("search");
	String searchType = (String)request.getAttribute("searchType");
	
	String cno = (String)request.getAttribute("cno");
	
	AdminFreeBoardVo freeBoardVo = (AdminFreeBoardVo)request.getAttribute("freeBoardVo");
	List<AdminFreeBoardCmtVo> list = (List<AdminFreeBoardCmtVo>)request.getAttribute("freeBoardCmtList");
	List<AttachmentVo> imgList = (List)request.getAttribute("imgList");

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쓰담쓰담 관리자 | 후기게시판 | 댓글수정</title>
<link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" />
    <link rel="stylesheet" href="<%=root1%>/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/common/variables.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/freeBoard/list.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css?ver=5"
    />
    <style>
      .grid-col8 {
        display: grid;
        grid-template-columns: 1fr 10fr 2fr 2fr 1fr 1fr 1fr 1fr;
        grid-template-rows: 1fr;
      }

      .grid-col8 div {
        border-right: 1px solid var(--border);
        height: 40px;
      }

      .reviewImg {
      width: 300px;
      height:350px;
      }

      .reply-header {
        border-top: 1px solid var(--border);
        height: 50px;
        display: flex;
        align-items: center;
        padding-left: 20px;
        font-size: 18px;
      }

      .reply-header span:nth-child(2) {
        margin: 0px 5px;
      }

      .reply-header span:nth-child(3) {
        color: var(--main);
      }
      .reply-header span:nth-child(3)::after {
        content: "개";
        color: black;
      }

      .reply-detail {
        display: grid;
        grid-template-columns: 2fr 6fr 2fr 2fr 1fr 1fr 1fr;
      }

      .reply-detail div,
      .admin-reply-form div {
        height: 44px;
        display: flex;
        align-items: center;
        justify-content: center;
      }

      .reply-detail div {
        border-bottom: 1px solid var(--border);
      }

      .reply-detail div:nth-child(-n + 7) {
        background-color: #dedbdb;
        justify-content: center;
      }

      .admin-reply-form {
        display: grid;
        grid-template-columns: 1fr 6fr 1fr;
      }

      .admin-reply-form div:nth-child(2) {
        justify-content: flex-start;
      }

      .admin-main-board {
        display: grid;
        grid-template-columns: 0.7fr 10fr 1.5fr 2fr 0.7fr 0.7fr 0.7fr 0.7fr;
   
      }

      .admin-main-board-detail {
        height: 100% !important;
      }

      .admin-menu-main-board li:last-child a {
        color: var(--adminMenuHover);
        font-size: 17px;
      }

    </style>
</head>
<body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <form action="<%=root1%>/admin/reviewBoard/editCmt" method="post">
        <input type="hidden" name="bno" value="<%=bno%>">
        <input type="hidden" name="pno" value="<%=pno%>">
        <input type="hidden" name="status" value="<%=status%>">
        <input type="hidden" name="search" value="<%=search%>">
        <input type="hidden" name="searchType" value="<%=searchType%>">
        <input type="hidden" name="cno" value="<%=cno%>">
        <input type="hidden" name="dno" value="<%=dno%>">
        <header class="admin-main-header flex-between">
          <h1>후기게시판 수정</h1>
          <div class="btn-set">
            <input
              class="cancel-btn"
              type="button"
              value="취소"
              onclick="history.back()"
            />
            <input class="save-btn" type="submit" value="저장" />
          </div>
        </header>
        <section class="admin-main-section">
          <div class="admin-main-wrapper">
            <div class="admin-main-board grid-col8">
              <div><%= freeBoardVo.getNo() %></div>
              <div><%= freeBoardVo.getTitle()%></div>
             
              <div><%= freeBoardVo.getNick() %></div>
  
              <div><%= freeBoardVo.getEnrollDate() %></div>
              <div><i class="fa-regular fa-eye margin-right"></i><span><%= freeBoardVo.getView() %></span></div>
              <div><i class="fa-solid fa-comment-dots margin-right"></i><span><%= freeBoardVo.getCmtCnt() %></span></div>
              <div>
                <i class="fa-solid fa-pen-to-square icon-block"></i
                >
              </div>
              <div>
                <i class="fa-solid fa-trash-can icon-block"></i>
              </div>
            </div>
            <div class="admin-main-board-detail">
             <% for(int i=0; i<imgList.size(); i++){ %>
       
	          <img class="reviewImg" alt="" src="<%=root1%>/resources/upload/afterBoard/<%=imgList.get(i).getChangeName()%>">
	          <%} %>
              <textarea class="freeBoard-content freeBoard-content-edit" spellcheck="false" name="content" id="" cols="30" rows="17" disabled><%= freeBoardVo.getContent() %></textarea>
            </div>
            <div class="reply-header">
              <i class="fa-solid fa-comment-dots"></i>
              <span>댓글</span>
              <span><%= freeBoardVo.getCmtCnt() %></span>
            </div>
            <div class="reply-detail">
              <div>작성자</div>
              <div>댓글내용</div>
              <div>작성날짜</div>
              <div>최종수정일시</div>
              <div>삭제여부</div>
              <div></div>
              <div></div>
  
              <%for(int i=0; i<list.size(); i++) {%>
              <div><%= list.get(i).getNick() %></div>
              <% if(list.get(i).getNo().equals(cno)) { %>
              <textarea name="cmt" id="" cols="30" rows="1"  class="board-cmt-edit"><%= list.get(i).getCmt()%></textarea>
              <%}else { %>
              <div class="flex-start"><%= list.get(i).getCmt()%></div>
              <%} %>
              <div><%= list.get(i).getEnrollDate() %></div>
              <div><%= list.get(i).getModifyDate() %></div>
              <% if(list.get(i).getDeleteYn().equals("N")){ %>
              <div>게시완료</div>
              <%}else { %>
              <div>게시취소</div>
              <%} %>
              <div>
                <i class="fa-solid fa-pen-to-square icon-block"></i
                >
              </div>
              <div>
                <i class="fa-solid fa-trash-can icon-block"></i>
              </div>
              <%}%>
            </div>
          </div>
        </section>
      </form>
 
    </main>
</body>
</html>