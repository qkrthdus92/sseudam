<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String root1 = request.getContextPath();%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>쓰담쓰담 관리자 | 뒹굴뒹굴 | 추가</title>
    <link rel="stylesheet" href="<%=root1%>/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/common/variables.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/wallow/list.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css?ver=2"
    />
    <style>
.grid-col3 {
        grid-template-rows: repeat(7, 50px);
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

.filebox label {
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
    <form action="" method="post" enctype="multipart/form-data">
    <main class="admin-main">   
      <header class="admin-main-header flex-between">
        <h1>뒹굴뒹굴 - 추가</h1>
        <div class="btn-set">
          <input
            class="cancel-btn"
            type="button"
            value="취소"
            onclick="history.back()"
          />
          <input class="save-btn" type="submit" value="저장" >
        </div>
      </header>
      <section class="admin-main-section">
        <div class="admin-main-wrapper">
          <div class="admin-main-board grid-col3">
            <div>이름</div>
            <div><input class="upload-name" type = "text" name = "title" placeholder="제목을 입력하세요" required></div>
            <div></div>
            
            <div>타입</div>
            <div>
            	<input type = "radio" name = "cNum" value = "4" checked>음악
            	<input type = "radio" name = "cNum" value = "5">영화
            	<input type = "radio" name = "cNum" value = "6">명상
            	<input type = "radio" name = "cNum" value = "7">책
            </div>
            <div></div>
            
            <div>상세정보1</div>
            <div><input class="upload-name" type = "text" name = "infoA" placeholder="가수, 출연진, 작가 등"></div>
            <div></div>
            
            <div>상세정보2</div>
            <div><input class="upload-name" type = "text" name = "infoB" placeholder="장르, 출판사 등"></div>
            <div></div>
            
            <div>링크</div>
            <div><input class="upload-name" type = "text" name = "link" placeholder="링크를 입력하세요" required></div>
            <div></div>
            
            <div>스트레스 지수</div>
            <div><input class="upload-name" type = "number" name = "stress" placeholder="스트레스 수치를 입력하세요" required></div>
            <div></div>
            
            <div>대표사진</div>            
            <div class = "filebox">
	            <input class="upload-name file-upload-name" placeholder="첨부된 파일">							
				<label for="file">파일첨부</label> 
				<input type="file" id="file" name="file"/>
            </div>
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
