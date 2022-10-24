<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MypageReserVo  MypageReserList = (MypageReserVo)request.getAttribute("MypageReserList");	
NoticeVo vo = (NoticeVo)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
        text-align: center;
    }
    #detail_top{
		font-size: 30px;
        margin-top: 30px;    
    }
    #box_wrap{
    	width: 30%;
    	height: 40%;
    	border: 1px solid lightgray;
    	display: grid;
    	grid-template-columns: 2fr 3fr;
    	grid-template-rows: 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr ;
    	margin: auto;
    	margin-top: 60px; 
    	border-radius: 20px;
    }
</style>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>	
	<div id="wrap">
		<div id="main">
		<div id="detail_top">예약상세</div>
			<div id="box_wrap">
				

			
			</div>
		</div>
	</div>
<%@ include file="/views/common/footer.jsp" %>	
</body>
</html>