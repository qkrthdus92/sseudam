<%@page import="com.kh.sseudam.healing.vo.HealingVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String root1 = request.getContextPath();
	HealingVo vo = (HealingVo) request.getAttribute("outsideDetailVo");
	
	int cn = Integer.parseInt(vo.getcNum());
	String yn = vo.getDeleteYn();
	
	String check8 = "";
	String check9 = "";
	String check10 = "";
	String checkY = "";
	String checkN = "";
	
	if(cn == 1){check8 = "checked";}
	else if(cn == 2){check9 = "checked";}
	else{check10 = "checked";}
	
	if(yn.equals("N")){checkN = "checked";}
	else{checkY = "checked";}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>쓰담쓰담 관리자 | 뚜벅뚜벅 | 수정</title>
<link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" />
<link rel="stylesheet" href="<%=root1%>/resources/css/common/reset.css" />
<link rel="stylesheet"
	href="<%=root1%>/resources/css/common/variables.css?ver=2" />
<link rel="stylesheet"
	href="<%=root1%>/resources/css/admin/tiptap/list.css?ver=2" />
<link rel="stylesheet"
	href="<%=root1%>/resources/css/admin/common/component.css?ver=1" />
<style>
.grid-col3 {
	grid-template-rows: repeat(12, 50px);
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

.label-btn{
	display: flex;
	color: #fff;
	justify-content: center;
	align-items:center;
	background-color: #999999;
	cursor: pointer;
	height: 30px;
	width: 80px;
}

.filebox input[type="file"] {
	position: absolute;
	width: 0;
	height: 0;
	padding: 0;
	overflow: hidden;
	border: 0;
}
</style>
</head>
<body>
	<%@ include file="/views/admin/common/menu.jsp"%>
	<form method="post" enctype="multipart/form-data">
		<main class="admin-main">
			<header class="admin-main-header flex-between">
				<h1>뚜벅뚜벅 - 정보 수정</h1>
				<div class="btn-set">
					<input class="cancel-btn" type="button" value="취소" onclick="history.back()"> 
					<input class="save-btn" type="submit" value="저장" onclick="javascript: form.action='';">
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

						<div>이름</div>
						<div>
							<input class="upload-name" type="text" name="name" value="<%=vo.getTitle()%>" required>
						</div>
						<div></div>

						<div>타입</div>
						<div>
							<input type="radio" name="cNum" value="8" <%=check8%>>문화 
							<input type="radio" name="cNum" value="9" <%=check9%>>산책 
							<input type="radio" name="cNum" value="10" <%=check10%>>등산
						</div>
						<div></div>

						<div>기간</div>
						<div>
							<input class="upload-name" type="text" name="infoA" value="<%=vo.getInfoA()%>">
						</div>
						<div></div>

						<div>주소</div>
						<div>
							<input class="upload-name" type="text" name="infoB" value="<%=vo.getInfoB()%>">
						</div>
						<div></div>
						
						<div>번호</div>
						<div>
							<input class="upload-name" type="text" name="infoC" value="<%=vo.getInfoC()%>">
						</div>
						<div></div>
						

						<div>링크</div>
						<div>
							<input class="upload-name" type="text" name="link" value="<%=vo.getLink()%>" required>
						</div>
						<div></div>
						
						<div>스트레스</div>
						<div>
							<input class="upload-name" type="number" name="stress" value="<%=vo.getStress()%>" required>
						</div>
						<div></div>

						<div>대표사진</div>
						<div class="filebox">
							<input class="upload-name" value="<%=vo.getImgPath() %>" name="currentFile" readonly/>
							<input class="upload-name file-upload-name" placeholder="변경 파일" name="changedFile">							
							<label class ="label-btn" for="file">파일변경</label> <input type="file" id="file" name="uploadFile"/>
						</div>
						<div></div>
						
						<div>등록일</div>
						<div>
							<input class="upload-name" type="text" name="writeDate" value="<%=vo.getWriteDate()%>" readonly>
						</div>
						<div></div>

						<div>게시여부</div>
						<div>
							<input type="radio" name="deleteYn" value="N" <%=checkN%> >게시  
							<input type="radio" name="deleteYn" value="Y" <%=checkY%> >미게시
						</div>
						<div></div>
						
						<div>
							<input type="button" value="데이터 삭제" class="save-btn" onclick="del(this.form, '<%=root1 %>');">
						</div>
						<div></div>
						<div></div>
					</div>
				</div>
			</section>
		</main>
	</form>
	
	<script type="text/javascript">
		var jq = jQuery.noConflict();

		jq("#file").on('change', function() {
			var fileName = jq("#file").val();
			jq(".file-upload-name").val(fileName);
		});
	</script>
	
	<script>
    	function del(f,r){
    		 if (confirm("삭제하시겠습니까?") == true){  
   			 	f.action= r+'/admin/outside/delete';
   				f.submit();
    		 }else{
    		     return false;
    		 }
    	}   	
    	
    </script>


</body>
</html>
