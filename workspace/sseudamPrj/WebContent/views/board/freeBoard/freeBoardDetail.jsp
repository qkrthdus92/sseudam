<%@page import="com.kh.sseudam.common.PageVo"%>
<%@page import="com.kh.sseudam.board.vo.FreeBoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	FreeBoardVo vo = (FreeBoardVo)request.getAttribute("vo");
	String s = (String)session.getAttribute("alertMsg");
	session.removeAttribute("alertMsg");
	PageVo pv = (PageVo)request.getAttribute("pv");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
        height: 2000px;
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
        height: 1650px;
        display: grid;
        grid-template-rows: 1.5fr 1fr 0.5fr 10fr 0.5fr 8fr 2fr;
        margin: 0 auto;
        align-content: center;
    }
    #title{
        width: 100%;
        height: 10%;
        padding-left: 40px;
        padding-top: 25px;
        line-height: 80px;
        font-size: 230%;
        font-weight: 800;
        color: #26AA82;
        text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
    }
    #board-title{
        display: grid;
        grid-template-columns: 1fr 5fr 3fr 3fr 1fr;
        border-bottom: 1px solid #747474;
        margin-left: 20px;
        margin-right: 20px;
    }
    #board-title > *{
        text-align: center;
        margin: auto;
    }
    #hit{
        display: flex;
    }
    #hit > img{
        margin-right: 10px; 
    }
    #board-edit{
        display: flex;
        justify-content: right;
        margin-right: 20px;
    }
    a{
        text-decoration: none;
        color: black;
    }
    #board-content{
        margin-left: 20px;
        margin-right: 20px;
        padding: 20px;
        width: 1160px;
        height: 650px;
        white-space: pre-wrap;
        border-bottom: 1px solid #747474;
    }
    #cmt-cnt{
        margin-top: 30px;
        margin-left: 50px;
        margin-right: 30px;
        display: flex;
    }
    #cmt-cnt > img{
        margin-right: 10px; 
    }
    #cmt-box{
        margin-top: 10px;
        margin-left: 50px;
        margin-right: 50px;
        background-color: #F5F5F5;
        grid-template-rows: 1fr 1fr 1fr 1fr 1fr;
    }
    #cmt{
        border-bottom: 1px solid #747474;
        padding-top: 10px;
        margin-left: 10px;
        margin-right: 10px;
    }
    #cmt-id{
        float: left;
    }
    #cmt-date{
        float: right;
    }
    #cmt-content{
        position: relative;
        margin-top: 10px;
        white-space: pre-wrap;  
    }
    #cmt-write{
       margin: 20px;
       display: flex;
    }
    #cmt-btn{
        margin-left: 20px;
        width: 80px;
        height: 80px;
        background-color: rgba(151, 210, 153, 0.7);
        border: 0px;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
    }
    #list-btn{
        width: 70px;
        height: 30px;
        background-color: rgba(151, 210, 153, 0.7);
        border: 0px;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
    }
    #list-btn-div{
        margin: auto;
    }
    #footer{
        width: 100vw;
        height: 180px;
    }
</style>
</head>
<body>
    <div id="wrap">
        <div id="header">
            <%@ include file="/views/common/header.jsp" %>
        </div>
        <div id="main">
            <div id="title">자유게시판</div>
            <div id="board-title">
                <div><%= vo.getNo() %></div>
                <div><%= vo.getTitle() %></div>
                <div><%= vo.getWriterNo() %></div>
                <div><%= vo.getWriteDate() %></div>
                <div id="hit">
                    <img src="<%=root%>/resources/img/board/View.svg">
                    <div><%= vo.getViews() %></div>
                </div>
            </div>
            <div id="board-edit">
                <div>최종수정일자 : <%= vo.getModifyDate() %></div>
                <div>&nbsp;|&nbsp;</div>
                <div><a href="/sseudam/board/freeBoardEdit?no=<%= vo.getNo() %>">수정하기</a></div>
                <div>&nbsp;|&nbsp;</div>
                <div><a href="/sseudam/board/freeBoardDelete?no=<%= vo.getNo() %>">삭제하기</a></div>
            </div>
            <div id="board-content"><%= vo.getContent() %></div>
            <div id="cmt-cnt">
                <img src="<%=root%>/resources/img/board/Chat.svg">
                <div>댓글 x개</div>
            </div>
            <div id="cmt-box">
                <div id="cmt">
                    <div id="cmt-info">
                        <div id="cmt-id">user01</div>
                        <div id="cmt-date">2022-10-01</div>
                    </div>
                    <br>
                    <div id="cmt-content">댓글내용이 보여지는 곳입니다. 댓글내용이 보여지는 곳입니다. 댓글내용이 보여지는 곳입니다.
                    </div>
                </div>
                <div id="cmt">
                    <div id="cmt-info">
                        <div id="cmt-id">user01</div>
                        <div id="cmt-date">2022-10-01</div>
                    </div>
                    <br>
                    <div id="cmt-content">댓글내용이 보여지는 곳입니다.
                    </div>
                </div>
                <div id="cmt">
                    <div id="cmt-info">
                        <div id="cmt-id">user01</div>
                        <div id="cmt-date">2022-10-01</div>
                    </div>
                    <br>
                    <div id="cmt-content">댓글내용이 보여지는 곳입니다.
                    </div>
                </div>
                <div id="cmt">
                    <div id="cmt-info">
                        <div id="cmt-id">user01</div>
                        <div id="cmt-date">2022-10-01</div>
                    </div>
                    <br>
                    <div id="cmt-content">댓글내용이 보여지는 곳입니다. 댓글내용이 보여지는 곳입니다. 댓글내용이 보여지는 곳입니다.
                    </div>
                </div>
                <div id="cmt">
                    <div id="cmt-info">
                        <div id="cmt-id">user01</div>
                        <div id="cmt-date">2022-10-01</div>
                    </div>
                    <br>
                    <div id="cmt-content">댓글내용이 보여지는 곳입니다. 댓글내용이 보여지는 곳입니다. 댓글내용이 보여지는 곳입니다.
                    </div>
                </div>
                <div id="cmt-write">
                    <div>
                        <textarea cols="135%" rows="5" style="resize:none;" placeholder="댓글 내용을 입력하세요."></textarea>
                    </div>
                    <div>
                        <button id="cmt-btn">등록</button>
                    </div>
                </div>
            </div>
            <div id="list-btn-div"><button type="button" id="list-btn" onclick = "history.back()">목록</button></div>
        </div>
        <div id="footer">
            <%@ include file="/views/common/footer.jsp" %>
        </div>
    </div>
</body>
</html>