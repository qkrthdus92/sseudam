<%@page import="com.kh.sseudam.board.vo.ReviewBoardCmtVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.sseudam.common.PageVo"%>
<%@page import="com.kh.sseudam.board.vo.ReviewBoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	ReviewBoardVo rvo = (ReviewBoardVo)request.getAttribute("rvo");
	PageVo pv = (PageVo)request.getAttribute("pv");
	PageVo cmtPv = (PageVo)request.getAttribute("cmtPv");
	List<ReviewBoardCmtVo> cmtVo = (List<ReviewBoardCmtVo>)request.getAttribute("cmtVo");
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
        height: 1500px;
        display: grid;
        grid-template-rows: 1fr 0.5fr 0.5fr 5fr 0.5fr 5fr 1fr;
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
        background-color: #F5F5F5;
    }
    #cmt-id{
        float: left;
        
    }
    #cmt-date{
        float: right;
        margin-right: 1%;
    }
    #cmt-content{
        margin-top: 10px;
        white-space: pre-wrap;
        display: flex;
    }
    #cmt-cmt{
    	width: 85%;
    	margin-bottom: 10px;
    }
    #cmt-edit{
    	display:flex;
    	float: right;
    	--margin-left : 70%;
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
            <div id="title">후기게시판</div>
            <div id="board-title">
                <div><%= rvo.getNo() %></div>
                <div><%= rvo.getTitle() %></div>
                <div><%= rvo.getWriterNo() %></div>
                <div><%= rvo.getWriteDate() %></div>
                <div id="hit">
                    <img src="<%=root%>/resources/img/board/View.svg">
                    <div><%= rvo.getViews() %></div>
                </div>
            </div>
            <div id="board-edit">
                <div>최종수정일자 :  <%= rvo.getModifyDate() %></div>
                <div>&nbsp;|&nbsp;</div>
                <div><a href="/sseudam/board/reviewBoardEdit?no=<%= rvo.getNo() %>">수정하기</a></div>
                <div>&nbsp;|&nbsp;</div>
                <div><a href="/sseudam/board/reviewBoardDelete?no=<%= rvo.getNo()%>">삭제하기</a></div>
            </div>
                <div>
                    <img src="<%=root%>/resources/img/main/러버덕.jpg"> <!--rvo.이미지 받아오는곳 -->
          		  <div class="board-content"> <%= rvo.getContent() %> </div>  
            	</div>
            
            
            
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
                    <div id="cmt-content"><div id="cmt-cmt"><%=cmtVo.get(i).getCmt()%></div>
                    <form id="cmt-edit">
                    <div><a href="/sseudam/board/reviewBoardDetail?bno=<%=rvo.getNo()%>&cmtNo=<%= cmtVo.get(i).getNo()%>">수정하기</a></div>
                    <div>&nbsp;|&nbsp;</div>
                    <div><a href="/sseudam/board/reviewBoardCmtDelete?bno=<%=rvo.getNo()%>&cmtNo=<%= cmtVo.get(i).getNo()%>&cmtPno=1">삭제하기</a></div> </form>                    
                    </div>

                </div>
                <%}%>
                
         <div id="page">
        		<a href="/sseudam/board/reviewBoardDetail?bno=<%=rvo.getNo()%>&cmtPno=<%=cmtPv.getStartPage()-1%>"> < </a>	        		
       		 <%for(int i = cmtPv.getStartPage(); i <= cmtPv.getEndPage(); ++i){%>
        		<a href="/sseudam/board/reviewBoardDetail?bno=<%=rvo.getNo()%>&cmtPno=<%=i%>"><%=i%></a>
       		 <%}%>       
        		<a href="/sseudam/board/reviewBoardDetail?bno=<%=rvo.getNo()%>&cmtPno=<%=cmtPv.getEndPage()+1%>"> > </a>	        		  	      
        </div>
                <div id="cmt-write">
                    <form action="/sseudam/board/reviewBoardDetail?bno=<%=rvo.getNo()%>&cmtPno=1" method="post">
                    <div>
                        <textarea cols="135%" rows="5" style="resize:none;" placeholder="댓글 내용을 입력하세요." name="cmtContent"></textarea>
                    </div>
                    <div>
                        <input type="submit" value="등록" id="cmt-btn">
                    </div>
                    </form>
                </div>
              </div> 
            <div id="list-btn-div"><button type="button" id="list-btn" onclick ="location.href='<%=root%>/board/reviewBoardList?pno=1'">목록</button></div>
                
            </div>
        </div>
        <div id="footer">
            <%@ include file="/views/common/footer.jsp" %>
        </div>
    </div>
</body>
</html>