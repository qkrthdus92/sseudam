<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
        body {
        padding: 0;
        margin: 0;
    }
    #wrap{
        background-color: #F5F5F5;
    }
    #wrap > *{
        width: 100vw;
        height: 1200px;
        box-sizing: border-box;
        background-color: #FFFFFF;
        
    }
    #header{
        width: 100vw;
        height: 170px;
    }
    #main{
        border-top: 1px solid #dfdfdf;
        width: 1200px;
        height: 850px;
        margin: auto;
    }
    #title{
        width: 100%;
        height: 10%;
        padding-left: 80px;
        line-height: 80px;
        font-size: 230%;
        font-weight: 800;
        color: #26AA82;
        text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
    }
    #write-box{
        width: 90%;
        height: 85%;
        background-color: #F5F5F5;
        display: grid;
        grid-template-rows: 1fr 3fr 1fr;
        margin: 0 auto;
        align-content: center;
        padding: 20px;
    }
    #write-title, #write-content{
        font-size: 1.1rem;
        margin: auto;
    }
    #btn{
        margin: auto;
    }
    #ok-btn{
        width: 60px;
        height: 30px;
        background-color: rgba(151, 210, 153, 0.7);
        border: 0px;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
    }
    #no-btn{
        width: 60px;
        height: 30px;
        background-color: #a0a0a0;
        border: 0px;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
    }
    #footer{
        width: 100vw;
        height: 180px;
    }
</style>
</body>
    <div id="wrap">
        <div id="header">
            <%@ include file="/views/common/header.jsp" %>
        </div>
        <div id="main">
            <div id="title">자유게시판</div>
            <div id="write-box">
                <div id="write-title">제목<br><input type="text" size="130" style="height:25px" placeholder="제목을 입력하세요."></div>
                <div id="write-content">내용<br><textarea name="content" cols="132%" rows="30" style="resize:none;" placeholder="내용을 입력하세요."></textarea></div>
                <div id="btn">
                    <input type="submit" value="등록" id="ok-btn">
                    &nbsp;&nbsp;
                    <button id="no-btn" onclick="location.href='<%=root%>/views/board/freeBoard/freeBoardList.jsp'">취소</button></div>
            </div>
        </div>
        <div id="footer">
            <%@ include file="/views/common/footer.jsp" %>
        </div>
</html>