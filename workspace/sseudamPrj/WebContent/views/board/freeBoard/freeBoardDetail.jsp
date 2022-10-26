<%@page import="com.kh.sseudam.board.vo.FreeBoardCmtVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.sseudam.common.PageVo"%>
<%@page import="com.kh.sseudam.board.vo.FreeBoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	FreeBoardVo vo = (FreeBoardVo)request.getAttribute("vo");
	PageVo pv = (PageVo)request.getAttribute("pv");
	PageVo cmtPv = (PageVo)request.getAttribute("cmtPv");
	List<FreeBoardCmtVo> cmtVo = (List<FreeBoardCmtVo>)request.getAttribute("cmtVo");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
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
        grid-template-rows: 1.5fr 0.5fr 0.5fr 5fr 0.5fr 5fr 1fr;
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
        --background-color: #F5F5F5;
        grid-template-rows: 1fr 1fr 1fr 1fr 1fr;
    }
    #cmt{
        border-bottom: 1px solid #747474;
        padding-top: 10px;
        padding-left: 10px;
        padding-right: 10px;
        --margin-left: 10px;
        --margin-right: 10px;
        background-color: #F5F5F5;
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
    #cmt-write > *{
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
    #page{
    text-align: center;
    width : 150px;
    height : 20px;
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
                <div><a href="/sseudam/board/freeBoardDelete?no=<%= vo.getNo()%>">삭제하기</a></div>
            </div>
            <div id="board-content"><%= vo.getContent() %></div>
            <div id="cmt-cnt">
                <img src="<%=root%>/resources/img/board/Chat.svg">
                <div>댓글 <%=cmtPv.getListCount()%>개</div>
            </div>
            <div id="cmt-box">
                
               <%for(int i = 0; i < cmtVo.size(); i++){%> <!-- 댓글부분 5개씩 페이지 넘겨서 보여주게 하기 -->
                <div id="cmt">
                    <div id="cmt-info">
                        <div id="cmt-id"><%=cmtVo.get(i).getWriterNo()%></div>
                        <div id="cmt-date"><%=cmtVo.get(i).getModifyDate()%></div>
                    </div>
                    <br>
                    <div id="cmt-content"><%=cmtVo.get(i).getCmt()%>
                    </div>
                </div>
                <%}%>
                
         <div id="page">
        		<a href="/sseudam/board/freeBoardDetail?bno=<%=vo.getNo()%>&cmtPno=<%=cmtPv.getStartPage()-1%>"> < </a>	        		
       		 <%for(int i = cmtPv.getStartPage(); i <= cmtPv.getEndPage(); ++i){%>
        		<a href="/sseudam/board/freeBoardDetail?cmtPno=<%=i%>&bno=<%=vo.getNo()%>"><%=i%></a>
       		 <%}%>       
        		<a href="/sseudam/board/freeBoardDetail?bno=<%=vo.getNo()%>&cmtPno=<%=cmtPv.getEndPage()+1%>"> > </a>	        		  	      
        </div>
        
 <%--        		<div id="ajax">
                       <%for(int i = 0; i < cmtVo.size(); i++){%> <!-- 댓글부분 5개씩 페이지 넘겨서 보여주게 하기 -->
                <div id="cmt">
                    <div id="cmt-info">
                        <div id="cmt-id"><%=cmtVo.get(i).getWriterNo()%></div>
                        <div id="cmt-date"><%=cmtVo.get(i).getModifyDate()%></div>
                    </div>
                    <br>
                    <div id="cmt-content"><%=cmtVo.get(i).getCmt()%>
                    </div>
                </div>
                <%}%>
                
         <div id="page">
        		<a href="#" onclick="before();"> < </a>	        		
       		 <%for(int i = cmtPv.getStartPage(); i <= cmtPv.getEndPage(); ++i){%>
        		<a href="/sseudam/board/freeBoardDetail?cmtPno=<%=i%>&bno=<%=vo.getNo()%>"><%=i%></a>
       		 <%}%>       
        		<a href="#" onclick="after();"> > </a>	        		  	      
        </div>
        </div>
        
        <script>
        function before(url){
        	        // ajax option
        	        var ajaxOption = {
        	                url : "/sseudam/board/freeBoardDetail?bno=<%=vo.getNo()%>&cmtPno=<%=cmtPv.getStartPage()-1%>",
        	                async : true,
        	                type : "POST",
        	                dataType : "html",
        	                cache : false
        	        };
        	        
        	        $.ajax(ajaxOption).done(function(data){
        	            // Contents 영역 삭제
        	            $('#ajax').children().remove();
        	            // Contents 영역 교체
        	            $('#ajax').html(data);
        	        });
        	    }

        
        </script> --%>
        
        
        
        
                     
                <div id="cmt-write">
                    <form>
                    <div>
                        <textarea cols="135%" rows="5" style="resize:none;" placeholder="댓글 내용을 입력하세요."></textarea>
                    </div>
                    <div>
                        <button id="cmt-btn">등록</button>
                    </div>
                    </form>
                </div>
              </div> 
            <div id="list-btn-div"><button type="button" id="list-btn" onclick = "location.href='/sseudam/board/freeBoardList?pno=1';">목록</button></div>
                
            </div>
        </div>
        <div id="footer">
            <%@ include file="/views/common/footer.jsp" %>
        </div>
    </div>
</body>
</html>