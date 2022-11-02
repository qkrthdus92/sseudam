<%@page import="com.kh.sseudam.common.PageVo"%>
<%@page import="com.kh.sseudam.board.vo.ReviewBoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	List<ReviewBoardVo> rvoList = (List<ReviewBoardVo>)request.getAttribute("rvoList");
	PageVo rpv = (PageVo)request.getAttribute("rpv");
	PageVo cmtPv = (PageVo)request.getAttribute("cmtPv");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" />
<meta charset="UTF-8">
<title>후기게시판 :: 쓰담쓰담</title>
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
        --height: 1200px;
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
        height: 1000px;
        display: grid;
        --grid-template-rows: 1fr 0.8fr 4fr 4fr 2fr 1fr;
        margin: 0 auto;
        padding: 20px;
        align-content: center;
    }
    #title{
        margin-top: 20px;
        margin-left: 20px;
        font-size: 230%;
        font-weight: 800;
        color: #26AA82;
        text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
    }
    #write{ 
        margin-left: 20px;
        margin-right: 20px; 
        padding-bottom: 20px;
        margin-bottom: 10px;
        border-bottom: 1px solid #747474;
    }
    #write-btn{
       	margin-left: 95%;
        width: 70px;
        height: 30px;
        background-color: rgba(151, 210, 153, 0.7);
        border: 0px;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
        cursor : pointer;
    }
    .board-photo{
    	font-size: 0.8rem;
    }
    a{
        text-decoration: none;
        color: black;
    }
    .board-list{
        --margin: auto;   
        --width: 100%;
        --height: 100%;
        display: grid;
        align-items: center;
        justify-content: center;
        column-gap: 10px;
        
        grid-template-columns: 1fr 1fr 1fr 1fr;
        grid-template-rows: 1fr 1fr;

    }
    .board-list > div{
        width: 95%;
        height: 80%;
        margin: 10px;
        margin-top: 30px;
        grid-template-columns: 5fr 5fr 5fr 5fr;
        border-radius: 10px;
        border: 1px solid #454545;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2); 
        }
    .board-list > *{
        
        width: 20%;
        height: 50%;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
        padding: 10px;
    }
    img{
        width: 100%;
        height: 80%;
        border-radius: 10px;

    }
     #cmts{
  	--font-size: 230%;
      font-weight: 800;
      color: #26AA82;
    }
    .list-info{
        font-size: 0.8rem;
        display: flex;
        margin: auto;
    }
    .view{
        width: 10%;
        height: 10%;
        padding-bottom: 20px;
    }
    #page{
        border-top: 1px solid #454545;
        margin-top: 20px;
        text-align: center;
        padding-top: 15px;
    }
    #search{
        margin: auto;
        display: flex;
    }
    #search > div{
        margin: 3px;
        vertical-align: middle;
    }
    #search-icon{
        padding-top: 3px;
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
            <span id="write"><button id="write-btn" onclick="loginPopup(true)">글쓰기</button></span>
            <%if(loginMember!=null){ %>
            <script>
              const wirteBtn = document.querySelector('#write-btn');
              wirteBtn.addEventListener('click',function() {
                location.href='<%=root%>/board/reviewBoardWrite';
              })
            </script>
            <%} %>
       
            <div class="board-list">
            
                <%for(int i = 0; i < rvoList.size(); ++i){%>
                <div class="board-photo">
                    <a href="<%=root%>/board/reviewBoardDetail?bno=<%=rvoList.get(i).getNo() %>&cmtPno=1">
                        <img src="<%=root%>/<%= rvoList.get(i).getFilePath() %>/<%=rvoList.get(i).getChangeName()%>"><%=rvoList.get(i).getTitle()%>
                        &nbsp;<span id="cmts">[<%=rvoList.get(i).getCmtCount() %>]</span>
                    </a>
                    <div class="list-info"><%=rvoList.get(i).getNo()%> | <%=rvoList.get(i).getWriterNo()%> | <%=rvoList.get(i).getWriteDate()%> |&nbsp;
                        <div class="view">
                            <img src="<%=root%>/resources/img/board/View.svg">
                        </div>&nbsp;<%=rvoList.get(i).getViews()%>
                    </div>
                </div>
                <%}%>
           
            </div>

         <%
			String nowPage = (String)request.getQueryString();
			int pi = 0;
			int pageNum = 1;
			if(nowPage != null){
				pi = nowPage.indexOf("pno");
				pageNum = Integer.parseInt(nowPage.substring(pi+4, pi+5));
			}		
		%>
            
            
        <div id="page">
                  
        	<a href="/sseudam/board/reviewBoardList?pno=<%=rpv.getStartPage()-1%>">< </a>	        		
        	
        <%
        	for(int i = rpv.getStartPage(); i <= rpv.getEndPage(); ++i){%>
        		<a id="current" href="/sseudam/board/reviewBoardList?pno=<%=i%>"><%=i%></a>
        <%}%>
        
        	<a href="/sseudam/board/reviewBoardList?pno=<%=rpv.getEndPage()+1%>"> ></a>	        		

        </div>
        
  <%--           <div id="search">
                <div>
                    <select name="board-search" form="">
                        <option value="title">제목</option>
                        <option value="content">내용</option>
                        <option value="writer">작성자</option>
                    </select>
                </div>
                <div><input type="text"></div>
                <div id="search-icon"><img src="<%=root%>/resources/img/board/Vector.svg"></div>
            </div> --%>
        </div>
        <div id="footer">
            <%@ include file="/views/common/footer.jsp" %>
        </div>
    </div>
</body>
</html>