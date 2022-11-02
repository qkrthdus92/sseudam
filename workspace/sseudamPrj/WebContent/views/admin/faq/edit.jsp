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
      .grid-col3 {
			grid-template-rows: repeat(9, 50px);
		}

      .admin-main-board-detail {
        padding: 20px 20px;
        height: 300px;
      }
.upload-name {
	display: inline-block;
	height: 30px;
	padding: 0 10px;
	vertical-align: middle;
	border: 1px solid #dddddd;
	width: 300px;
	color: #1B1A17;
	margin-right: 10px;
}
.upload-content-head{
	grid-row: span 3;
}
.upload-content{
	grid-column:span 2;
	grid-row: span 3;
	

}
.upload-content>input{
	width:300px;
	height:130px;	
	display: inline-block;
	padding: 0 10px;
	vertical-align: middle;
	border: 1px solid #dddddd;
	color: #1B1A17;
	margin-right: 10px;
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
	          <div class="admin-main-board grid-col3">
	            <div>번호</div>
	            <div>
	            	<input class="upload-name" type="text" name="no" value="<%=vo.getNo()%>" readonly>
	            </div>
	            <div></div>
	            
	            <div>질문</div>
	            <div>
	            	<input class="upload-name" type="text" name="title" value="<%=vo.getTitle()%>" required>
	            </div>
	            <div></div>
	            
	            <div>관리자</div>
	            <div>
	            	<input class="upload-name" type="text" name="adminId" value="<%=vo.getAdminId()%>" required>
	            </div>
	            <div></div>
	            
	            <div>등록일자</div>
	            <div>
	            	<input class="upload-name" type="text" name="writeDate" value="<%=vo.getWriteDate()%>" readonly>
	            </div>
	            <div></div>
	            
	            <div>게시여부</div>
	            <div id="delete-yn-check">
					<input type="radio" name="deleteYn" value="N" <%=checkN%> ><label>O</label>  
					<input type="radio" name="deleteYn" value="Y" <%=checkY%> ><label>X</label> 
				</div>
				<div></div>
				
				<div class="upload-content-head">내용</div>
				<div class="upload-content">
					<input type="text" name="content" value="<%=vo.getContent()%>" required>
	            </div>	            
				
	            <div><input type="button" value="데이터 삭제" class="save-btn" onclick="del(this.form, '<%=root1 %>');"></div>	            
	            <div></div>
	            <div></div>
	          </div>
	        </div>
	      </section>
	    </main>
    </form>
    
    <script>
    
/*     	function del(f,r){
    		 if (confirm("삭제하시겠습니까?") == true){  
   			 	f.action= r+'/admin/faq/delete';
   				f.submit();
    		 }else{
    		     return false;
    		 }
    	}
    	 */
    	function del(f,r) {
            Swal.fire({
              text: "정말로 삭제 하시겠습니까?",
              icon: "warning",
              showCancelButton: true,
              confirmButtonColor: "#26aa82",
              cancelButtonColor: "#f85a2a",
              confirmButtonText: "삭제",
              cancelButtonText: "취소"
            }).then((result) => {
              if (result.isConfirmed) {
            	  f.action= r+'/admin/faq/delete';
     				f.submit();
              }
            });
          }
    	
    	
    </script>
  </body>
</html>
