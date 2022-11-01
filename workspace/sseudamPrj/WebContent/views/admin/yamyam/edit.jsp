<%@page import="com.kh.sseudam.healing.vo.HealingVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String root1 = request.getContextPath();
	HealingVo vo = (HealingVo) request.getAttribute("nyamDetailVo");
	
	int cn = Integer.parseInt(vo.getcNum());
	String yn = vo.getDeleteYn();
	
	String check1 = "";
	String check2 = "";
	String check3 = "";
	String checkY = "";
	String checkN = "";
	
	if(cn == 1){check1 = "checked";}
	else if(cn == 2){check2 = "checked";}
	else{check3 = "checked";}
	
	if(yn.equals("N")){checkN = "checked";}
	else{checkY = "checked";}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>냠냠 수정</title>
<link rel="stylesheet" href="<%=root1%>/resources/css/common/reset.css" />
<link rel="stylesheet"
	href="<%=root1%>/resources/css/common/variables.css?ver=2" />
<link rel="stylesheet"
	href="<%=root1%>/resources/css/admin/yamyam/bob/list.css?ver=2" />
<link rel="stylesheet"
	href="<%=root1%>/resources/css/admin/common/component.css?ver=1" />
<style>
.grid-col3 {
	grid-template-rows: repeat(10, 50px);
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
				<h1>혼자서 냠냠 - 정보 수정</h1>
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
							<input type="radio" name="cNum" value="1" <%=check1%>>맛집 
							<input type="radio" name="cNum" value="2" <%=check2%>>카페 
							<input type="radio" name="cNum" value="3" <%=check3%>>술집
						</div>
						<div></div>

						<div>주소</div>
						<div>
							<input class="upload-name" type="text" name="addr" value="<%=vo.getInfoA()%>">
						</div>
						<div></div>

						<div>전화번호</div>
						<div>
							<input class="upload-name" type="text" name="phone" value="<%=vo.getInfoB()%>">
						</div>
						<div></div>

						<div>링크</div>
						<div>
							<input class="upload-name" type="text" name="link" value="<%=vo.getLink()%>">
						</div>
						<div></div>

						<div>대표사진</div>
						<div class="filebox">
							<input class="upload-name" value="<%=vo.getImgPath() %>" name="currentFile" readonly/>
							<input class="upload-name file-upload-name" placeholder="변경 파일" name="changedFile">							
							<label class ="label-btn" for="file">파일변경</label> <input type="file" id="file" name="uploadFile"/>
						</div>
						<div></div>
						
						<div>링크</div>
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
						
						<div><input class="save-btn" type="submit" value="데이터 삭제" onclick="javascript: form.action='<%=root1%>/admin/nyam/delete';"></div>
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


</body>
</html>
