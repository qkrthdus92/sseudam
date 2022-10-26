<%@page import="com.kh.sseudam.common.PageVo"%>
<%@page import="com.kh.sseudam.mypage.board.vo.MypageLikeVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<MypageLikeVo> MypageLikeList = (List<MypageLikeVo>)request.getAttribute("MypageLikeList");	
	PageVo pv = (PageVo)request.getAttribute("pv");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
    width: 177px;
    height: 59.04px;
    position: absolute;
    margin-top: 30px;
    background: rgba(217, 217, 217, 0.5);
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
    left: 50px;
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
    background: #FFFFFF;
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
#dom3{
    box-sizing: border-box;
    width: 177px;
    height: 59.04px;
    margin-top: 30px;
    margin-left: 354px;
    background: #FFFFFF;
    border-width: 1px 1px 0px 1px;
    border-style: solid;
    border-color: rgba(0, 0, 0, 0.6);
    border-radius: 30px 30px 0px 0px;
}
#dominfo3{ 
    width: 177.44px;
    height: 58.63px;
    margin-top: 20px;
    margin-left: 35px;
    line-height: 19px;
    cursor: pointer;
}
 #editbar{
    width: 1200px;
    height: 63px;
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
    height: 40px;
    display: grid;
    grid-template-columns: 1fr 1fr 5fr 2fr 2fr;
    align-content: center;
    text-align: center;
    border-bottom: 1px solid grey;
    font-size: 20px;
}
#cb1{
    width: 15px;
	height: 15px;
	border: 2px solid #bcbcbc;
	cursor: pointer; 
}
#detail_btn{
	cursor: pointer;
}
</style>
<body>
<%@ include file="/views/common/header.jsp" %>	
	<div id="wrap">
	<div id="main">
	    <div id="boardinfo">
	       <div><img id="profile" src="/sseudam/resources/img/mypage/프로필.png" alt="프로필사진"></div>
	       <div id="hm1">나의 좋아요</div>
	       <div id="hm"><%= MypageLikeList.size() %>개</div>
	       <div id="hm1"></div>
	       <div id="hm"></div>
	    </div>
	    
	    <div id="dom">
	        <div id="dominfo" onclick="location.href='';">혼자서냠냠</div>
	    </div>
	    <div id="dom2">
	        <div id="dominfo2" onclick="location.href='/sseudam/mypage/likecheckhome?pno=1';">안에서뒹굴뒹굴</div>
	    </div>
	    <div id="dom3">
	        <div id="dominfo3" onclick="location.href='/sseudam/mypage/likecheckout?pno=1';">밖에서뚜벅뚜벅</div>
	    </div>
	    <div id="editbar">
	        <button id="allselect" ><img id="checkbox" src="/sseudam/resources/img/mypage/체크.png" alt="체크"> 전체선택</button>
	        <button id="delete">삭제</button>
	    </div>
	    <div id="edittop">
	        <div></div>
	        <div>글번호</div>
	        <div>내용</div>
	        <div>게시판</div>
	        <div>작성일</div>
	    </div>
	    <%for(int i = 0 ; i < MypageLikeList.size(); ++i){%>
		    <div id="editlist">
		        <div><input type="checkbox" id="cb1"></div>
		        <div><%= MypageLikeList.get(i).getNo()%></div>
		        <div id="detail_btn" onclick="location.href='/sseudam/mypage/yumdetail?no=<%=MypageLikeList.get(i).getNo()%>'"><%= MypageLikeList.get(i).getName()%></div>
		        <div>혼자서냠냠</div>
		        <div><%= MypageLikeList.get(i).getWrite_date()%></div>
		    </div>
		 <%}%>
		  <div id="page-area">
        
        <%if(pv.getStartPage() !=1){%>
		        <a href="/sseudam/mypage/likeyum?pno=<%=pv.getStartPage()-1%>" class="btn btn-primary btn-sm">PRE</a> 
        	<%}%>
        
        
        <%for(int i =pv.getStartPage(); i <= pv.getEndPage(); ++i){%>
       		<a href="/sseudam/mypage/likeyum?pno=<%=i %>" class="btn btn-primary btn-sm"><%=i %></a> 
       	<%}%>
       	
       	<%if(pv.getEndPage() != pv.getMaxPage()){%>
    		<a href="/sseudam/mypage/likeyum?pno=<%=pv.getEndPage()+1%>" class="btn btn-primary btn-sm">NEXT</a> 
   		<%}%>
       	
       	
        </div>
	    </div>
	</div>
<%@ include file="/views/common/footer.jsp" %>
</body>
</html>