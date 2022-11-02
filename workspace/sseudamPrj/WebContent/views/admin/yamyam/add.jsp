<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String root1 = request.getContextPath();%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>쓰담쓰담 관리자 | 혼자서 냠냠 | 목록</title>
    <link rel="stylesheet" href="<%=root1%>/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/common/variables.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/yamyam/list.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css?ver=2"
    />
    <style>
      .grid-col3 {
        grid-template-rows: repeat(6, 50px);
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
        <h1>냠냠 - 추가</h1>
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
            <div><input class="upload-name" type = "text" name = "name" placeholder="이름을 입력하세요" required></div>
            <div></div>
            
            <div>타입</div>
            <div>
            	<input type = "radio" name = "cNum" value = "1" checked>맛집 
            	<input type = "radio" name = "cNum" value = "2">카페
            	<input type = "radio" name = "cNum" value = "3">술집
            </div>
            <div></div>
            
            <div>주소</div>
            <div><input class="upload-name" type = "text" name = "addr" placeholder="주소를 입력하세요"></div>
            <div></div>
            
            <div>전화번호</div>
            <div><input class="upload-name" type = "text" name = "phone" placeholder="번호를 입력하세요"></div>
            <div></div>
            
            <div>링크</div>
            <div><input class="upload-name" type = "text" name = "link" placeholder="링크를 입력하세요"></div>
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
