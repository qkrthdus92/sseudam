<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            height: 1750px;
            box-sizing: border-box;
            background-color: #FFFFFF;
            
        }
        #header{
            width: 100vw;
            height: 170px;
        }
        #main{
        width: 1200px;
		height: 1400px;
		display: grid;
		grid-template-rows: 3fr 4.5fr 4.5fr 2fr;
		margin: 0 auto;
		align-content: center;
        }
        #title{
            font-size: 300%;
            font-weight: 800;
            text-align: center;
            color: #26AA82;
            text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
            display: flex;
            align-items: center;
            justify-content: center;
        }
        fieldset{
            text-align: center;
            margin: auto;
            width: 80%;
            height: 70%;
            border: 1px dashed;
            border-radius: 50px;
        }
        .grade{
            height: 30%;
        }
        #footer{
            width: 100vw;
            height: 180px;
        }
    </style>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
	<div id="wrap">
       <div id="main">
           <div id="title">테스트 결과<br>Nick님의 스트레스 지수는 __점 입니다.</div>
           <div>
               <fieldset>
                   <legend>스트레스 지수에 따른 등급은 아래와 같이 평가됩니다.</legend>
                   <div class="grade">1</div>
                   <div class="grade">2</div>
                   <div class="grade">3</div>
                   <div>테스트 결과는 마이페이지에서 확인 가능합니다.</div>
               </fieldset>
           </div>
           <div></div>
           <div></div>
       </div>
       <div id="footer">
           <%@ include file="/views/common/footer.jsp" %>
       </div>
   </div>
</body>
</body>
</html>