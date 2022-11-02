<%@page import="com.kh.sseudam.common.AttachmentVo"%>
<%@page import="com.kh.sseudam.admin.freeBoard.vo.AdminFreeBoardCmtVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.sseudam.admin.freeBoard.vo.AdminFreeBoardVo"%>
<%@page import="com.kh.sseudam.common.PageVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<% 
	String root1 = request.getContextPath();

	String pno = (String)request.getAttribute("pno");
	String search = (String)request.getAttribute("search");
	String searchType = (String)request.getAttribute("searchType");
	String status = (String)request.getAttribute("status");
	String bno = (String)request.getAttribute("bno");
	String dno = (String)request.getAttribute("dno");
	PageVo pv = (PageVo)request.getAttribute("pv");
	
	AdminFreeBoardVo freeBoardVo = (AdminFreeBoardVo)request.getAttribute("freeBoardVo");
	List<AdminFreeBoardCmtVo> list = (List<AdminFreeBoardCmtVo>)request.getAttribute("freeBoardCmtList");
	List<AttachmentVo> imgList = (List)request.getAttribute("imgList");
	
	String pno2 = (String)session.getAttribute("pno2");
	String bno2 = (String)session.getAttribute("bno2");
	String search2 = (String)session.getAttribute("search2");
	String searchType2 = (String)session.getAttribute("searchType2");
	String status2 = (String)session.getAttribute("status2");
	String dno2 = (String)session.getAttribute("dno2");
	
	if((pno2 != null) && (bno2 != null) && (search2 != null) && (searchType2 != null) && (status2 != null) && (dno2 != null)) {
		System.out.println("세션값으로 대체됨!");
		pno = pno2;
		search = search2;
		searchType = searchType2;
		status = status2;
		bno = bno2;
		dno = dno2;
		
		session.removeAttribute("pno2");
		session.removeAttribute("bno2");
		session.removeAttribute("dno2");
		session.removeAttribute("search2");
		session.removeAttribute("searchType2");
		session.removeAttribute("status2");
		
	}


%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="<%=root1%>/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/common/variables.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/reviewBoard/list.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css?ver=3"
    />
    <style>
 
     

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

      .admin-main-board-detail {
        padding-left: 20px !important;
        padding-top: 20px !important;
        padding-right: 0px !important;
       
        height: 100%;
        overflow-y: auto;
      }
      .freeBoard-content2 {
        width: 99%;
        height: 400px;
        resize: none;
        border: none;
        background-color: white;
        font-size: 15px;
        line-height: 25px;
        font-family: "Noto Sans KR", sans-serif;
        /* overflow: auto; */
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
      <header class="admin-main-header flex-between">
        <h1>후기게시판 상세조회</h1>
        <div class="btn-set">
          <input
            class="cancel-btn"
            type="button"
            value="목록"
             onclick="location.href='<%=root%>/admin/reviewBoard/list?pno=<%=pno%>&status=<%=status%>&search=<%=search%>&searchType=<%=searchType%>'"

          />
          <!-- <input class="save-btn" type="submit" value="저장" /> -->
        </div>
      </header>
      <section class="admin-main-section">
        <div class="admin-main-wrapper">
             <div class="admin-main-board grid-col8">
            <div><%= freeBoardVo.getNo() %></div>
            <div><%= freeBoardVo.getTitle() %></div>
            <div><%= freeBoardVo.getNick() %></div>

            <div><%= freeBoardVo.getEnrollDate() %></div>
            <div><i class="fa-regular fa-eye margin-right"></i><span><%= freeBoardVo.getView() %></span></div>
            <div><i class="fa-solid fa-comment-dots margin-right"></i><span><%= freeBoardVo.getCmtCnt() %></span></div>
            <div>
              <a href="<%=root%>/admin/reviewBoard/edit?bno=<%=bno %>&pno=<%=pno %>&dno=<%=dno %>&status=<%=status %>&search=<%=search %>&searchType=<%=searchType %>"
                ><i class="fa-solid fa-pen-to-square"></i
              ></a>
            </div>
            <div>
              <i class="fa-solid fa-trash-can cursor" onclick="dbDeleteBoard();"></i>
            </div>
          </div>
          
              <script>
      
            function dbDeleteBoard() {
              Swal.fire({
                title: "후기게시판 게시글 삭제",
                text: "정말로 삭제 하시겠습니까?",
                icon: "warning",
                showCancelButton: true,
                confirmButtonColor: "#26aa82",
                cancelButtonColor: "#f85a2a",
                confirmButtonText: "삭제",
                cancelButtonText: "취소"
              }).then((result) => {
                if (result.isConfirmed) {
                  location.href='<%=root%>/admin/reviewBoard/delete?bno=<%=bno %>&pno=<%=pno %>&dno=<%=dno %>&status=<%=status %>&search=<%=search %>&searchType=<%=searchType %>';
                }
              });
            }
          </script>
          
          <div class="admin-main-board-detail">
          
          <% for(int i=0; i<imgList.size(); i++){ %>
       
          <img class="reviewImg" alt="" src="<%=root1%>/resources/upload/afterBoard/<%=imgList.get(i).getChangeName()%>">
          <%} %>
            <textarea class="freeBoard-content2" name="" id="" cols="30" rows="10" disabled><%= freeBoardVo.getContent() %></textarea>
            
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
         
             
            <div><%=  list.get(i).getNick()%></div>
            <% if(list.get(i).getDeleteYn().equals("N")){ %>
              <div class="flex-start"><%=  list.get(i).getCmt()%></div>
              <%}else { %>
                <div class="flex-start light-color"><%=  list.get(i).getCmt()%></div>
              <%} %>
            <div><%=  list.get(i).getEnrollDate()%></div>
            <div><%=  list.get(i).getModifyDate()%></div>
            <% if(list.get(i).getDeleteYn().equals("N")){ %>
            <div>게시완료</div>
            <%}else { %>
            <div>게시취소</div>
            <%} %>
            <div>
              <a href="<%=root%>/admin/reviewBoard/editCmt?cno=<%=list.get(i).getNo() %>&bno=<%=bno %>&pno=<%=pno %>&dno=<%=dno %>&status=<%=status %>&search=<%=search %>&searchType=<%=searchType %>"
                ><i class="fa-solid fa-pen-to-square"></i
              ></a>
            </div>
            <div>
              <i id='<%=list.get(i).getNo() %>' class="fa-solid fa-trash-can cursor" onclick="dbDeleteCmt(this);"></i>
             <script>
      
            function dbDeleteCmt(e) {
            	var cmtNo = $(e).attr('id');
            	
              Swal.fire({
                title: "후기게시판 댓글 삭제",
                text: "정말로 삭제 하시겠습니까?",
                icon: "warning",
                showCancelButton: true,
                confirmButtonColor: "#26aa82",
                cancelButtonColor: "#f85a2a",
                confirmButtonText: "삭제",
                cancelButtonText: "취소"
              }).then((result) => {
                if (result.isConfirmed) {
                  location.href='<%=root%>/admin/reviewBoard/deleteCmt?cno='+cmtNo+'&bno=<%=bno %>&pno=<%=pno %>&dno=<%=dno %>&status=<%=status %>&search=<%=search %>&searchType=<%=searchType %>';
                }
              });
            }
          </script>
            </div>
            <%}%>
          </div>
          
               <!-- 댓글 페이징 -->
    
          <div class="page-area">
            <%if(pv.getStartPage()!=1) {%>
            <a href="<%=root1%>/admin/reviewBoard/detail?status=<%=status %>&bno=<%=bno %>&pno=<%=pno %>&dno=<%=pv.getStartPage()-1 %>&searchType=<%=searchType %>&search=<%=search %>" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
            <%}%>
	        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
	          <a href="<%=root1%>/admin/reviewBoard/detail?status=<%=status %>&bno=<%=bno %>&pno=<%=pno %>&dno=<%=i %>&searchType=<%=searchType %>&search=<%=search %>" class=""><span><%=i %></span></a>
	        <%}%>
	        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
	         <a href="<%=root1%>/admin/reviewBoard/detail?status=<%=status %>&bno=<%=bno %>&pno=<%=pno %>&dno=<%=pv.getEndPage()+1 %>&searchType=<%=searchType %>&search=<%=search %>" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
	        <%}%>
         
          </div>
          
          <form action="<%=root1%>/admin/reviewBoard/writeCmt" method="post">
            <input type="hidden" name="bno" value="<%=bno%>">
            <input type="hidden" name="pno" value="<%=pno%>">
            <input type="hidden" name="status" value="<%=status%>">
            <input type="hidden" name="search" value="<%=search%>">
            <input type="hidden" name="searchType" value="<%=searchType%>">
            <input type="hidden" name="dno" value="<%=dno%>">
            <div class="admin-reply-form">
              <div>관리자</div>
              <div>
                <input
                  type="text"
                  placeholder="댓글을 입력해주세요"
                  class="admin-input"
                  name="cmt"
                />
              </div>
              <div>
                <input type="submit" value="등록" class="small-add-btn" />
              </div>
            </div>

          </form>
        </div>
      </section>
    </main>
  </body>
</html>
