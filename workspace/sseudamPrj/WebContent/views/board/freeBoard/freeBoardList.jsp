<%@page import="com.kh.sseudam.common.PageVo"%>
<%@page import="com.kh.sseudam.board.vo.FreeBoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<FreeBoardVo> voList = (List<FreeBoardVo>)request.getAttribute("voList");
	PageVo pv = (PageVo)request.getAttribute("pv");
	PageVo cmtPv = (PageVo)request.getAttribute("cmtPv");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" />
<meta charset="UTF-8">
<title>자유게시판 :: 쓰담쓰담</title>
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
        width: 1200px;
        height: 850px;
        display: grid;
        grid-template-columns: 1fr 5fr 3fr 3fr 1fr;
        grid-template-rows: repeat(15, 5fr);
        margin: 0 auto;
        align-content: center;
        padding: 20px;

    }
    #title{
        grid-column: span 5;
        margin-top: 10px;
        margin-left: 20px;
        font-size: 230%;
        font-weight: 800;
        color: #26AA82;
        text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
    }
    #write{
        grid-column: span 5;
        margin-left: 20px;
        margin-right: 20px; 
    }
    #write > *{
        display:flex;
        align-items:center;
        justify-content: center;
        margin-left: 95%;
        width: 70px;
        height: 30px;
        background-color: rgba(151, 210, 153, 0.7);
        border: 0px;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
        cursor : pointer;
    }
    .board-top{
        text-align: center;
        border-top: 1px solid #747474;
        border-bottom: 1px solid #747474;
        line-height: 50px;
    }
    .board-list{
        text-align: center;
        border-bottom: 1px solid #747474;
        line-height: 50px;
    }
    a{
        text-decoration: none;
        color: black;
    }
/*      #current{
    	color: black;
    	pointer-events:
    }
    #current:visited{
    	color: #26AA82;
    } */
    #cmts{
    	--font-size: 230%;
        font-weight: 800;
        color: #26AA82;
    }
    #page{
        grid-row: span 2;
        grid-column: span 5;
        margin: auto;
        text-align: center;
        font-size: 1.2rem;
    }
    #search{
        grid-column: span 5;
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
            <div id="title">자유게시판</div>
            <div id="write"><button id="write-btn" onclick="loginPopup(true)">글쓰기</button></div>
            <%if(loginMember!=null){ %>
            <script>
              const wirteBtn = document.querySelector('#write-btn');
              wirteBtn.addEventListener('click',function() {
                location.href='<%=root%>/board/freeBoardWrite';
              })
            </script>
            <%} %>
            
            
            <div class="board-top">번호</div>
            <div class="board-top">제목</div>
            <div class="board-top">작성자</div>
            <div class="board-top">작성일자</div>
            <div class="board-top">조회수</div>
            
        <%for(int i = 0; i < voList.size(); ++i){%>
	        <div class="board-list"><%=voList.get(i).getNo()%></div>
	        <div class="board-list"><a href="<%=root%>/board/freeBoardDetail?bno=<%=voList.get(i).getNo() %>&cmtPno=1"><%=voList.get(i).getTitle() %>
	        						&nbsp;<span id="cmts">[<%=voList.get(i).getCmtCount() %>]</span></a></div>
	        <div class="board-list"><%=voList.get(i).getWriterNo()%></div>
	        <div class="board-list"><%=voList.get(i).getWriteDate()%></div>
	        <div class="board-list"><%=voList.get(i).getViews()%></div>
        <%}%>

        <div id="page">
                  
          <%if(pv.getStartPage() != 1){%>  
        	<a href="/sseudam/board/freeBoardList?pno=<%=pv.getStartPage()-1%>">< </a>	
        	<%}%>	        		
        	
        <%
        	for(int i = pv.getStartPage(); i <= pv.getEndPage(); ++i){%>
        		<a id="current" href="/sseudam/board/freeBoardList?pno=<%=i%>"><%=i%></a>
        <%}%>
        
         <%if(pv.getEndPage() != pv.getMaxPage()){%>
        	<a href="/sseudam/board/freeBoardList?pno=<%=pv.getEndPage()+1%>"> ></a>	        		
			<%}%>  
        </div>
            <%-- <div id="search">
                <div>
                <form method="post" action="/sseudam/board/freeBoardSearch" onsubmit="">
                    <select name="search">
                        <option value="title">제목</option>
                        <option value="content">내용</option>
                        <option value="writer">작성자</option>
                    </select>
                </div>
                <div><input type="text"></div>
                <div id="search-icon"><img src="<%=root%>/resources/img/board/Vector.svg" onclick="submit"></div>
  
                </form>
            </div> --%>
        </div>
        <div id="footer">
            <%@ include file="/views/common/footer.jsp" %>
        </div>
    </div>
    <script>
<%if(alertMsg != null){%>
	alert('<%= alertMsg %>'); 
<%}%>
</script>
</body>
</html>