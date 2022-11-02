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
	AdminFreeBoardVo freeBoardVo = (AdminFreeBoardVo)request.getAttribute("freeBoardVo");
	List<AdminFreeBoardCmtVo> list = (List<AdminFreeBoardCmtVo>)request.getAttribute("freeBoardCmtList");
	List<AttachmentVo> imgList = (List)request.getAttribute("imgList");

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
      href="<%=root1%>/resources/css/admin/common/component.css?ver=2"
    />
    <style>
      .admin-menu-main-board li:last-child a {
        color: var(--adminMenuHover);
        font-size: 17px;
      }


      .grid-col8 div {
        border-right: 1px solid var(--border);
        height: 40px;
      }

      .admin-main-board-detail {
        padding-right: 0px !important;
   
        border-bottom: 1px solid var(--border);
      }

      .reply-header {
        /* border-top: 1px solid var(--border); */
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


      .border-none {
        border: none;
      }

      textarea {
        height: 300px;
      }

      .file-upload {
        display: flex;
        flex-direction: column;
        margin-left: 20px;
        margin-bottom: 20px;
      }

      .file-upload input {
        margin-bottom: 5px;
      }

      .admin-add-img {
        margin-left: 20px;
      }

      .admin-origin-img {
        margin-left: 20px;
      }

      .margin-bottom {
        margin-bottom: 20px;
      }

      .margin-bottom10 {
        margin-bottom: 10px;
      }

      .admin-main-board-detail {
        padding-left: 20px !important;
        padding-top: 20px !important;
        height: 100%;
        overflow-y: auto;
      }
      .freeBoard-content2 {
        width: 99%;
        height: 100% !important;
        resize: none;
        border: none;
        background-color: white;
        font-size: 15px;
        line-height: 25px;
        font-family: "Noto Sans KR", sans-serif;
        /* overflow: auto; */
      }
    </style>
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
        <form action="<%=root1%>/admin/reviewBoard/edit" method="post" enctype="multipart/form-data" class="reviewEditForm">
        <input type="hidden" name="bno" value="<%=bno%>">
        <input type="hidden" name="pno" value="<%=pno%>">
        <input type="hidden" name="status" value="<%=status%>">
        <input type="hidden" name="search" value="<%=search%>">
        <input type="hidden" name="searchType" value="<%=searchType%>">
        <input type="hidden" name="dno" value="<%=dno%>">
        <header class="admin-main-header flex-between">
          <h1>후기게시판 수정</h1>
          <div class="btn-set">
            <input
              class="cancel-btn"
              type="button"
              value="취소"
              onclick="location.href='<%=root%>/admin/reviewBoard/detail?dno=<%=dno %>&bno=<%=bno %>&pno=<%=pno %>&status=<%=status %>&search=<%=search %>&searchType=<%=searchType %>'"
            />
            <input class="save-btn" type="submit" value="저장" class="review-submit-btn" />
          </div>
        </header>
        <section class="admin-main-section">
          <div class="admin-main-wrapper">
            <div class="admin-main-board grid-col8">
              <div><%= freeBoardVo.getNo() %></div>
              
              <input class="board-title-edit" type="text" value="<%= freeBoardVo.getTitle()%>" name="title">
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
              <textarea class="freeBoard-content2 freeBoard-content-edit" spellcheck="false" name="content" id="" cols="30" rows="17"><%= freeBoardVo.getContent() %></textarea>
            
            </div>
             <div class="reply-header border-none">
              <i class="fa-solid fa-image"></i>
              <span>첨부파일</span>
              <!-- <span>3</span> -->
            </div>
            <div class="admin-origin-img margin-bottom">
              <%for(int i=0; i<imgList.size(); i++) {%>
              
              <div class="margin-bottom10 ">
                <span> <%= imgList.get(i).getOriginName()%></span>
                <i class='fa-solid fa-square-xmark x-btn' onclick='dbDeleteCer(this);'></i>
                <input type="hidden" class="hidden-change-name" value="<%= imgList.get(i).getChangeName()%>">
              </div>
              <%}%>
            
            
       
          </div>
            <div class="file-upload file-target">
              
             
        
            </div>
           <div class="admin-add-img margin-bottom">
            <div>
              <input type="button" value="추가" class="small-add-btn " onclick="cerAd();"/>
           
            </div>
           
            
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
              <div class="flex-start"><%= list.get(i).getCmt()%></div>
              <div><%= list.get(i).getEnrollDate() %></div>
              <div><%= list.get(i).getModifyDate() %></div>
              <% if(list.get(i).getDeleteYn().equals("N")){ %>
              <div>게시완료</div>
              <%}else { %>
              <div>게시취소</div>
              <%} %>
              <div><i class="fa-solid fa-pen-to-square icon-block"></i>
                
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
     <script>
      
      function dbDeleteCer(x) {
        const num1 = document.querySelectorAll('.admin-origin-img span').length;
        const num2 = document.querySelectorAll('.file-target input').length;
        
        if((num1+num2) == 1) {
          alert('이미지 첨부는 필수입니다');
          e.preventDefault();
        }


        const parent = x.parentNode;
        
        const target = parent.childNodes[5].value;

        Swal.fire({
          title: "이미지 삭제",
          text: "정말로 삭제 하시겠습니까?",
          icon: "warning",
          showCancelButton: true,
          confirmButtonColor: "#26aa82",
          cancelButtonColor: "#f85a2a",
          confirmButtonText: "삭제",
          cancelButtonText: "취소"
        }).then((result) => {
        	if (result.isConfirmed) {
                location.href='<%=root%>/admin/reviewBoard/deleteImg?bno=<%=bno%>&pno=<%=pno %>&dno=<%=dno%>&search=<%=search%>&searchType=<%=searchType%>&status=<%=status %>&img='+target; 
              }
        });
      }
    </script>
    <script>
      function cerAd(e) {

        const originCnt = document.querySelector('.admin-origin-img').childElementCount;
        const targetCnt = document.querySelector('.file-target').childElementCount;
        if((originCnt+targetCnt)==5) {
          alert('이미지 첨부는 5장까지만 가능합니다');
          e.preventDefault();
        }
      
        const cerTarget = document.querySelector('.file-target');
        const newDiv0 = document.createElement('div');

      
        const newDiv1 = document.createElement('div');
        newDiv1.innerHTML = "<input type='file' class='upload-btn' name='f'  multiple/><i class='fa-solid fa-square-xmark x-btn' onclick='deleteCer(this);'></i>";

        newDiv0.appendChild(newDiv1);


        cerTarget.appendChild(newDiv0);
       


      }
    </script>
    <script>
      function deleteCer(x) {
      
        var parent = x.parentNode.parentNode;
        parent.remove();

      }
    </script>
    <script>
      const reviewEditForm = document.querySelector('.reviewEditForm');
      reviewEditForm.addEventListener('submit', function(event) {
        const num1 = document.querySelectorAll('.admin-origin-img span').length;
        let cnt = 0;
        if(num1 == 0) {
          const num2 = document.querySelectorAll('.file-target input').length;
          console.log('이프문들어옴!');
          for(let i=0; i<num2; i++) {
            const isFile = document.querySelectorAll('.file-target input')[i].value;
            if(isFile!="") {
              cnt = cnt+1;
              console.log('카운트됨!');
            }
          }

          if(cnt == 0) {
            alert('이미지 첨부는 필수입니다');
            event.preventDefault();
       
          }
        }
      })

    </script>
  </body>
</html>
