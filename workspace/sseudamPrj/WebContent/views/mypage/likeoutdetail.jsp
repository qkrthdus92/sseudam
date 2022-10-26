<%@page import="com.kh.sseudam.mypage.board.vo.MypageLikeoutVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 MypageLikeoutVo vo = (MypageLikeoutVo)request.getAttribute("vo");
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
    grid-template-columns: 1fr 2fr 5fr 2fr 1fr;
    align-content: center;
    text-align: center;
}
#editlist{
    height: 60px;
    display: grid;
    grid-template-columns: 1fr 2fr 5fr 2fr 1fr;
    align-content: center;
    text-align: center;
    border-bottom: 1px solid grey;
    font-size: 20px;
}
#cb1{
    width: 20px;
	height: 20px;
	border: 2px solid #bcbcbc;
	cursor: pointer; 
}
#popup {
	  display: flex;
	  justify-content: center;
	  align-items: center;
	  position: fixed;
	  top: 0;
	  left: 0;
	  width: 100%;
	  height: 100%;
	  background: rgba(0, 0, 0, .7);
	  z-index: 1;
	  backdrop-filter: blur(4px);
	  -webkit-backdrop-filter: blur(4px);
	}
	
	#popup.multiple-filter {
	  backdrop-filter: blur(4px) grayscale(90%);
	  -webkit-backdrop-filter: blur(4px) grayscale(90%);
	}
	
	#popup .content {
	  padding: 20px;
	  background: #fff;
	  border-radius: 5px;
	  box-shadow: 1px 1px 3px rgba(0, 0, 0, .3);
	  width: 400px;
	  height: 400px;
	} 

	.popup-head{
	width:100%;
	height:100px; 
	display:grid;
	grid-template-rows: 2fr 1fr 1fr;
	align-items:center;
	justify-content:center;
	}
	.head-title{
		margin-top: 30px;
		margin-left: 20px;
		font-size: 18px;
		font-weight: bold;
	}

	#popup-logo{
		width: 100%;
		height: 50px;
	}

	.popup-body{              
	width:100%;
	height: 220px;
	background-color:#ffffff; 
	display: grid;
	grid-template-columns: 1fr 1fr;
	grid-template-rows: 1fr 1fr 1fr 1fr 1fr;
	}

	.popup-foot{                      
	width:100%;
	height:50px;
	}
	.pop-btn{ 
	display:inline-flex;           
	width:50%;                      
	height:100%;                   
	justify-content:center;        
	align-items:center;            
	float:left;  
	background-color: #87C57D;                  
	color:#FFFFFF;                
	cursor:pointer;     
	border-style: none;           
	}
	#confirm{                
	border-right:1px solid #FFFFFF;
	}
	#popup-text{
		font-size: 20px;
		margin-top: 80px;
	}
</style>
<body>
<%@ include file="/views/common/header.jsp" %>	
	<div id="wrap">
	<div id="main">
	    <div id="boardinfo">
	       <div><img id="profile" src="/sseudam/resources/img/mypage/프로필.png" alt="프로필사진"></div>
	       <div id="hm1">나의 좋아요</div>
	   <%--    <div id="hm"><%= MypageLikeList.size() %>개</div> --%>
	       <div id="hm1"></div>
	       <div id="hm"></div>
	    </div>
	    
	    <div id="dom">
	        <div id="dominfo" onclick="location.href='';">혼자서냠냠</div>
	    </div>
	    <div id="dom2">
	        <div id="dominfo2" onclick="location.href='/sseudam/mypage/likecheckhome';">안에서뒹굴뒹굴</div>
	    </div>
	    <div id="dom3">
	        <div id="dominfo3" onclick="location.href='/sseudam/mypage/likecheckout';">밖에서뚜벅뚜벅</div>
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
	   <%--  <%for(int i = 0 ; i < MypageLikeList.size(); ++i){%>
		    <div id="editlist">
		        <div><input type="checkbox" id="cb1"></div>
		        <div><%= MypageLikeList.get(i).getNo()%></div>
		        <div><%= MypageLikeList.get(i).getName()%></div>
		        <div>혼자서냠냠</div>
		        <div><%= MypageLikeList.get(i).getWrite_date()%></div>
		    </div>
		 <%}%> --%>
	    </div>
	    
   		<div id="popup" class="hide">
		  <div class="content">
				<div class="popup-head">
					<div  ><img id="popup-logo" src="/sseudam/resources/img/header/logo.png" alt=""></div>
				</div>
				<div class="popup-body">
					<div>타이틀 :</div>
					<div><%=vo.getTitle() %></div>
					<div>좋아요선택날짜:</div>
					<div><%=vo.getWrite_date() %></div>
					<div>좋아요번호 : </div>
					<div><%=vo.getNo() %></div>
					<div>게시판 :</div>
					<div>밖에서 뚜벅뚜벅</div>
				</div>
				<div class="popup-foot">
					<!-- 삭제페이지로 이동 -->
					<button class="pop-btn" id="confirm" onclick="location.href='/sseudam/mypage/likeoutdelete?no=<%=vo.getNo() %>'" >삭제</button> 
					<button class="pop-btn" id="close" onclick="location.href='/sseudam/mypage/likecheckout?pno=1'" >창 닫기</button>
				</div>
		  </div>
		</div>
	    
	</div>
<%@ include file="/views/common/footer.jsp" %>
</body>
</html>