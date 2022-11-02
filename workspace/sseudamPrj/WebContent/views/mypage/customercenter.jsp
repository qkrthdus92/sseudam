<%@page import="com.kh.sseudam.faq.vo.FAQVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<FAQVo> list = (List<FAQVo>)request.getAttribute("FAQList");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" />
<meta charset="UTF-8">
<title>고객센터 :: 쓰담쓰담</title>
<style>
    #wrap{
        position: relative;
        background: #F5F5F5;
    }
    #main{
        width: 1200px;
        height: auto;
        left: 350px;
        top: 169px;
        margin: auto;
        background: #FFFFFF;
        border: 1px solid #DFDFDF;
    }
    #cstop{
    	position:relative;
        width: 100%;
        height: 170px;
        background-color: #8ED1B1;
        text-align: center;
    }
    #cstoptiltle{
        font-size: 46px;
        font-weight: bolder;
        color: #FFFFFF;
        padding-top: 30px;
    }
    #cstopsubtitle{
        font-size: 30px;
        font-weight: normal;
        color: #FFFFFF;
    }
    #csqnatop{
    	position:relative;
        font-size: 30px;
        width: 100%;
        height: 60px;
        margin-top: 40px;
        margin-left: 50px;
        font-weight: bold;
    }
    #csqnabody{
    	position:relative;
        width: 1100px;
        height: auto;
        border-top: 1px solid lightgrey;
        border-bottom: 1px solid lightgrey;
        margin-left: 50px;
        padding-bottom : 50px;
        display: grid;
        grid-template-columns: 1fr 1fr 1fr;
    }
    #csqnacontent{
        width: 300px;
        height: 180px;
        border-radius: 20px;
        border: 1px solid lightgray;
        box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25);
        margin-top: 30px;
        margin-left: 35px;
        padding-left: 10px;
        padding-right: 10px;
        display: grid;
        grid-template-columns: 1fr 5fr;
        grid-template-rows: 1fr 1fr;
        text-align: center;
    }
    #csqna1{
        font-size: 30px;
        margin-top: 15px;
        border-bottom: 1px solid lightgray;
    }
    #csqna2{
        font-size: 16px;
        margin-top: 20px;
        border-bottom: 1px solid lightgray;
        padding-right:20px;
    }
    #csqna3{
        font-size: 16px;
        margin-top: 30px;
        border-bottom: 1px solid lightgray;
        padding-right:20px;
    }
    
    #csmainbot{
    	position:relative;
        height: 80px;
        display: grid;
        grid-template-columns: 1fr 1fr;
        padding-left: 50px;
    }
    #csmainbot_left{
        font-size: 24px;
        text-align: center;
        padding-top: 20px;
        border-right: 1px solid lightgrey;
    }
    #csmainbot_right{
        display: grid;
        grid-template-columns: 1fr 1fr;
        grid-template-rows: 1fr 2fr;
        margin-left: 20px;
    }
    #csimg{
        width: 40px;
        height: 40px;
    }
    #csmainbot_right_text{
        font-size: 20px;
        margin-left: 10px;
        margin-top: 5px;
    }
    #temp{
        display: grid;
        grid-template-columns: 1fr 5fr;
    }
</style>
</head>
<body>
    <%@ include file="/views/common/header.jsp" %>	
    <div id="wrap">
        <div id="main">
            <div id="cstop">
                <div id="cstoptiltle">쓰담쓰담 고객센터</div>
                <div id="cstopsubtitle">어떤점이 궁금하신가요?</div>
            </div>
            <div id="csqnatop">자주 묻는 질문</div>
            <div id="csqnabody">
            
            	<%for(int i = 0;i<list.size();i++){ %>
            	
            	<div id="csqnacontent">
                    <div id="csqna1">Q.</div>
                    <div id="csqna3"><%=list.get(i).getTitle() %></div>
                    <div  id="csqna1">A.</div>
                    <div  id="csqna2"><%=list.get(i).getContent() %></div>
                </div>
            
            	<%} %>
            </div>
            <div id="csmainbot">
                <div id="csmainbot_left">더 궁금한 점이 있으신가요?</div>
                <div id="csmainbot_right">
                    <div>contact</div>
                    <div></div>
                    <div id="temp"><img id="csimg" src="<%=root %>/resources/img/mypage/메일.png" alt=""><span id="csmainbot_right_text">sseudam@naver.com</span></div>
                    <div id="temp"><img id="csimg" src="<%=root %>/resources/img/mypage/카톡.png" alt=""><span id="csmainbot_right_text">ID: sseudam</span></div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="/views/common/footer.jsp" %>	
</body>
</html>