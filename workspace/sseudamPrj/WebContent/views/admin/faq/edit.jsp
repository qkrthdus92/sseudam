<%@page import="com.kh.sseudam.faq.vo.FAQVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<% String root1 = request.getContextPath();%>

<%
	FAQVo vo = (FAQVo)request.getAttribute("faqDetailVo");
	String yn = vo.getDeleteYn();
	
	String checkY = "";
	String checkN = "";
	
	if(yn.equals("N")){checkN = "checked";}
	else{checkY = "checked";}

%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>FAQ 수정</title>
    <link rel="stylesheet" href="<%=root1%>/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/common/variables.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/faq/list.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css?ver=3"
    />
    <style>
      .grid-col7 {
        display: grid;
        grid-template-columns: 1fr 10fr 2fr 3fr 3fr 2fr 2fr;
        grid-template-rows: 2fr;
      }

      .grid-col7 div {
        border-right: 1px solid var(--border);
        padding-right:20px;
        padding-left:20px;
        height: 40px;
      }

      .admin-main-board-detail {
        padding: 20px 20px;
        height: 300px;
      }
       input {
        margin:0;
        width: 100%;
        font-size: 15px;
        text-align:center;        
        display: inline-block;
		border: 1px solid #dddddd;
		color: #1B1A17;
        
      }

      textarea {
      	
      	display: inline-block;
		border: 1px solid #dddddd;
		color: #1B1A17;
        border: 1px solid #dddddd;
        width: 100%;
        height: 250px;
        
      }

      #delete-yn-check>input{
      	width: 30px
      }
    
		
		      
    </style>
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <form method="post">
	    <main class="admin-main">
	      <header class="admin-main-header flex-between">
	        <h1>FAQ 수정</h1>
	        <div class="btn-set">
	          <input
	            class="cancel-btn"
	            type="button"
	            value="취소"
	            onclick="history.back()"
	          />
	          <input class="save-btn" type="submit" value="저장" onclick="javascript: form.action='';" />
	        </div>
	      </header>
	      <section class="admin-main-section">
	        <div class="admin-main-wrapper">
	          <div class="admin-main-board grid-col7">
	            <div>번호</div>
	            <div>질문</div>
	            <div>관리자</div>
	            <div>등록일자</div>
	            <div>최종수정일자</div>
	            <div>게시여부</div>
	            <div>데이터 삭제</div>
	            
	            <div>
	            	<input class="upload-name" type="text" name="no" value="<%=vo.getNo()%>" readonly>
	            </div>
	            <div>
	            	<input class="upload-name" type="text" name="title" value="<%=vo.getTitle()%>" required>
	            </div>
	            <div>
	            	<input class="upload-name" type="text" name="adminId" value="<%=vo.getAdminId()%>" required>
	            </div>
	            <div>
	            	<input class="upload-name" type="text" name="writeDate" value="<%=vo.getWriteDate()%>" readonly>
	            </div>
	            <div>
	            	<input class="upload-name" type="text"value="<%=vo.getModifyDate()%>" readonly>
	            </div>
	            <div id="delete-yn-check">
					<input type="radio" name="deleteYn" value="N" <%=checkN%> ><label>O</label>  
					<input type="radio" name="deleteYn" value="Y" <%=checkY%> ><label>X</label> 
				</div>
	            <div>
	            	<%-- <input type="submit" id="btnSubmit" onclick="javascript: form.action='<%=root1 %>/admin/faq/delete';" style="display:none;" /> --%>
	            	<input type="button" id="btnSubmit" onclick="del(this.form,<%=root1 %>)" style="display:none;" />
					<label for="btnSubmit"><i style="cursor:pointer;" class="fa-solid fa-trash-can icon-block"></i></label>
	            </div>
	          </div>
	          <div class="admin-main-board-detail">
	            <div>
	            	<textarea name="content"><%=vo.getContent()%></textarea>
	            </div>
	          </div>
	        </div>
	      </section>
	    </main>
    </form>
    
    <script type="text/javascript">
    	const btn = document.querySelector('#btnSubmit');
    	console.log(btn);
    	btn.addEventListener('submit',del(
       		 if (confirm("삭제하시겠습니까?") == true){  
				return true;
       		 }else{
       		     return false;
       		 }
    			
    	));
    	
    	
    	
    	function del(f,r){
    		alert(f,r);
    		console.log(f);
    		console.log(r);
    		 if (confirm("삭제하시겠습니까?") == true){  
   			 	f.action= '/admin/faq/delete';
   				f.submit();
    		 }else{
    		     return false;
    		 }
    	}
    </script>
  </body>
</html>
