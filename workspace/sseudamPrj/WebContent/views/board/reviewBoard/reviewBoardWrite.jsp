<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기게시판 글쓰기 :: 쓰담쓰담</title>
</head>
<link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" />
<body>
<style>
body {
	padding: 0;
	margin: 0;
}

#wrap {
	background-color: #F5F5F5;
}

#wrap>* {
	width: 100vw;
	--height: 1800px;
	box-sizing: border-box;
	background-color: #FFFFFF;
}

#header {
	width: 100vw;
	height: 170px;
}

#main {
	position: relative;
	border-top: 1px solid #dfdfdf;
	width: 1200px;
	--height: 850px;
	margin: auto;
}

#title {
	width: 100%;
	height: 10%;
	padding-left: 80px;
	line-height: 80px;
	font-size: 230%;
	font-weight: 800;
	color: #26AA82;
	text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
}

#write-box {
	width: 90%;
	--height: 85%;
	background-color: #F5F5F5;
	display: grid;
	grid-template-rows: 1fr 3fr 0.5fr 2fr;
	margin: 0 auto;
	margin-bottom: 20px;
	align-content: center;
	padding: 20px;
}

#write-title, #write-content {
	font-size: 1.1rem;
	margin: auto;
}

#file-upload {
	display: flex;
	margin-left: 60px;
	font-size: 1.1rem;
	margin-top: 10px;
}

.upload-list {
	margin-left: 50px;
	grid-template-rows: repeat(3, 1fr);
	width: 100%;
	--height: 100%;
}

.upload-list>div {
	width: 50%;
	border: 1px solid #ffffff;
	height: 15%;
	background-color: #dfdfdf;
}

#upload-list {
	display: grid;
	grid-template-columns: 10fr 1fr 1fr;
	width: 75%;
}

#fileName1, #fileName2, #fileName3, #fileName4, #fileName5 {
	border: 0px;
	background-color: #dfdfdf;
	padding: 10px;
}

#upload-btn {
	margin-left: 215%;
	margin-top: 7px;
	width: 80px;
	height: 30px;
	background-color: #dfdfdf;
	border: 0px;
	box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
	cursor : pointer;
	--padding-left: 10px;
}

#btn {
	margin-top: 30px;
	margin-left: 40%;
	cursor : pointer;
}

#ok-btn {
	width: 60px;
	height: 30px;
	background-color: rgba(151, 210, 153, 0.7);
	border: 0px;
	box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
	cursor : pointer;
}

#no-btn {
	width: 60px;
	height: 30px;
	background-color: #a0a0a0;
	border: 0px;
	box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
	cursor : pointer;
}

#footer {
	width: 100vw;
	height: 180px;
}
</style>
</body>
<div id="wrap">
	<div id="header">
		<%@ include file="/views/common/header.jsp"%>
	</div>
	<form action="" method="post" enctype="multipart/form-data">
		<div id="main">
			<div id="title">후기게시판</div>
			<div id="write-box">

				<div id="write-title">
					제목<br> <input type="text" size="130" style="height: 25px"
						placeholder="제목을 입력하세요." name="title" required>
				</div>
				<div id="write-content">
					내용<br>
					<textarea name="content" cols="132%" rows="30"
						style="resize: none;" placeholder="내용을 입력하세요." name="content"
						required></textarea>
				</div>


				<div id="file-upload">이미지 첨부 (이미지파일 최대 5장)</div>

				<div class="upload-list">
					<div id="upload-list">
						<input type="text" id="fileName1" required>
						<!-- <button id="delete">삭제</button> -->
						<label id="upload-btn"> 파일선택<input type="file" name="f"
							style="display: none"
							onchange="javascript:document.getElementById('fileName1').value = this.value">
						</label>
					</div>

					<div id="upload-list">
						<input type="text" id="fileName2"> <label id="upload-btn">
							파일선택<input type="file" name="f" style="display: none"
							onchange="javascript:document.getElementById('fileName2').value = this.value">
						</label>
					</div>

					<div id="upload-list">
						<input type="text" id="fileName3"> <label id="upload-btn">
							파일선택<input type="file" name="f" style="display: none"
							onchange="javascript:document.getElementById('fileName3').value = this.value">
						</label>
					</div>

					<div id="upload-list">
						<input type="text" id="fileName4"> <label id="upload-btn">
							파일선택<input type="file" name="f" style="display: none"
							onchange="javascript:document.getElementById('fileName4').value = this.value">
						</label>
					</div>

					<div id="upload-list">
						<input type="text" id="fileName5"> <label id="upload-btn">
							파일선택<input type="file" name="f" style="display: none"
							onchange="javascript:document.getElementById('fileName5').value = this.value">
						</label>
					</div>

				</div>

				<div id="btn">
					<input type="submit" value="등록" id="ok-btn"> &nbsp;&nbsp;
					<button id="no-btn" onclick="history.back()">취소</button>
				</div>
			</div>

		</div>
	</form>
	<div id="footer">
		<%@ include file="/views/common/footer.jsp"%>
	</div>
</html>