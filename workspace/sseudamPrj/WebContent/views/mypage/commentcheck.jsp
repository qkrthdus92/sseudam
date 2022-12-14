<%@page import="com.kh.sseudam.board.vo.ReviewBoardVo"%>
<%@page import="com.kh.sseudam.board.vo.FreeBoardVo"%>
<%@page import="com.kh.sseudam.common.PageVo"%>
<%@page import="com.kh.sseudam.mypage.board.vo.MypageCommentVo2"%>
<%@page import="com.kh.sseudam.mypage.board.vo.MypageBoardVo"%>
<%@page import="com.kh.sseudam.mypage.board.vo.MypageCommentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<%
	//FreeBoardVo vo1 = (FreeBoardVo)request.getAttribute("vo");
	//ReviewBoardVo vo2 = (ReviewBoardVo)request.getAttribute("vo");
	List<MypageCommentVo> MypageCommentList = (List<MypageCommentVo>)request.getAttribute("MypageCommentList");	
	List<MypageCommentVo2> MypageCommentList2 = (List<MypageCommentVo2>)request.getAttribute("MypageCommentList2");	
	PageVo pv = (PageVo)request.getAttribute("pv");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" />
<meta charset="UTF-8">
<title>내가 쓴 댓글 조회 :: 쓰담쓰담</title>
</head>
<style>
    #wrap{
        position: relative;
        background: #F5F5F5;
    }
    #main{
        width: 1200px;
        height: 851px;
        left: 350px;
        top: 169px;
        margin: auto;

        /* white */

        background: #FFFFFF;
        /* border */

        border: 1px solid #DFDFDF;
    }
        #main > #page-area{
        grid-column: span 5;
        text-align: center;
        margin-top: 20px;
        border-bottom: none;
    }
    #boardinfo{
        width: 1100px;
        height: 80px;
        margin-top: 50px;
        margin-left: 50px;
        border: 1px solid grey;
        display: grid;
        grid-template-columns: 2fr 2fr 2fr 2fr 2fr 3fr;
        align-content: center;
    }
    #hm{
        margin-top: 40px;
        font-weight: bold;
        font-size: 18px;
    }
    #hm1{
        margin-top: 40px;
        font-weight: bold;
        font-size: 18px;
        margin-left: 40px;
    }
    #profile{
        width: 70px;
        height: 70px;
        border-radius: 30px;
        border: 1px solid rgba(0, 0, 0, 0.3);
        margin-left: 30px;
    }
    #dom{
        box-sizing: border-box;
        position: absolute;
        width: 177px;
        height: 59.04px;
        margin-top: 30px;
        background: #FFFFFF;
        border-width: 1px 1px 0px 1px;
        border-style: solid;
        border-color: rgba(0, 0, 0, 0.6);
        border-radius: 30px 30px 0px 0px;
    }
    #dominfo{     
        position: absolute;
        width: 177.44px;
        height: 58.63px;
        top: 20px;
        left: 30px;
        line-height: 19px;
        cursor: pointer;
    }
    #dom2{
        box-sizing: border-box;
        position: absolute;
        width: 177px;
        height: 59.04px;
        margin-top: 30px;
        margin-left : 177px;
        border-width: 1px 1px 0px 1px;
        border-style: solid;
        background: rgba(217, 217, 217, 0.5);
        border-color: rgba(0, 0, 0, 0.6);
        border-radius: 30px 30px 0px 0px;
    }
    #dominfo2{     
        position: absolute;
        width: 177.44px;
        height: 58.63px;
        top: 20px;
        left: 35px;
        line-height: 19px;
        cursor: pointer;
    }
    #editbar{
        width: 1200px;
        height: 63px;
        margin-top : 89px;
        background: rgba(217, 217, 217, 0.5);
    }
    #checkbox{
        width: 18px;
        height: 16px;
    }
    #allselect{
        margin-left: 20px;
        margin-top: 20px;
    }
    #edittop{
        width: 1200px;
        height: 42.54px;
        left: 0px;
        border-bottom: 1px solid black;
        border-top: 1px solid black;
    }
    #edittop{
        display: grid;
        grid-template-columns: 1fr 1fr 5fr 2fr 2fr;
        align-content: center;
        text-align: center;
    }
    #editlist{
        height:30px;
        display: grid;
        grid-template-columns: 1fr 1fr 5fr 2fr 2fr;
        align-content: center;
        text-align: center;
        border-bottom: 1px solid grey;
        font-size: 20px;
    }
    #cb1{
    width: 13px;
	height: 13px;
	border: 1px solid #bcbcbc;
	cursor: pointer; 
}
#comlocation{
 cursor: pointer; 
}
</style>
<body>
	<%@ include file="/views/common/header.jsp" %>	
		<div id="wrap">
		<div id="main">
		    <div id="boardinfo">
		       <div><img id="profile" src="/sseudam/resources/img/mypage/프로필.png" alt="프로필사진"></div>
		       <div id="hm1">총 댓글</div>
		       <div id="hm"><%=pv.getListCount() %>개</div>
		    </div>
		
		    <div id="dom">
		        <div id="dominfo" onclick="location.href='/sseudam/mypage/boardcheck?pno=1';">내가 쓴 게시글</div>
		    </div>
            <div id="dom2">
                <div id="dominfo2"">내가 쓴 댓글</div>
            </div>
		    <div id="editbar">
		      
		    </div>
		    <div id="edittop">
		        <div></div>
		        <div>글번호</div>
		        <div>내용</div>
		        <div>게시판</div>
		        <div>작성일</div>
		    </div>
		    <%for(int i = 0 ; i < MypageCommentList.size(); ++i){%>
			    <div id="editlist">
			        <div><input type="checkbox" id="cb1"></div>
			        <div><%= MypageCommentList.get(i).getNo()%></div>
			        <div  id="comlocation" onclick="location.href='<%=root%>/board/freeBoardDetail?bno=<%=MypageCommentList.get(i).getFree_board_no() %>&cmtPno=1'"><%= MypageCommentList.get(i).getCmt()%></div>
			        <div><%= MypageCommentList.get(i).getType()%></div>
			        <div><%= MypageCommentList.get(i).getModify_date()%></div>
			    </div>
		    <%}%>
		   		    <%for(int i = 0 ; i < MypageCommentList2.size(); ++i){%>
			    <div id="editlist">
			        <div><input type="checkbox" id="cb1"></div>
			        <div><%= MypageCommentList2.get(i).getNo()%></div>
			        <div onclick="location.href='<%=root%>/board/reviewBoardDetail?bno=<%=MypageCommentList.get(i).getReview_board_no() %>&cmtPno=1'"><%= MypageCommentList2.get(i).getCmt()%></div>
			        <div><%= MypageCommentList2.get(i).getType()%></div>
			        <div><%= MypageCommentList2.get(i).getModify_date()%></div>
			    </div>
		    <%}%>
		    
   		    <div id="page-area">
		        <%if(pv.getStartPage() !=1){%>
				        <a href="/sseudam/mypage/commentcheck?pno=<%=pv.getStartPage()-1%>" class="btn btn-primary btn-sm">PRE</a> 
		        	<%}%>
		        
		        
		        <%for(int i =pv.getStartPage(); i <= pv.getEndPage(); ++i){%>
		       		<a href="/sseudam/mypage/commentcheck?pno=<%=i %>" class="btn btn-primary btn-sm"><%=i %></a> 
		       	<%}%>
		       	
		       	<%if(pv.getEndPage() != pv.getMaxPage()){%>
		    		<a href="/sseudam/mypage/commentcheck?pno=<%=pv.getEndPage()+1%>" class="btn btn-primary btn-sm">NEXT</a> 
		   		<%}%>
        </div>
		    
		</div>
	</div>
<%@ include file="/views/common/footer.jsp" %>	
</body>
</html>