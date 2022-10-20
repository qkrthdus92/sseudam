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
        border-top: 1px solid #dfdfdf;
        width: 1200px;
		height: 1400px;
		display: grid;
		grid-template-rows: 3fr 4.5fr 1.5fr 4fr 1fr;
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
        legend{
            font-size: 1.2rem;
        }
        fieldset{
            text-align: center;
            margin: auto;
            width: 70%;
            height: 85%;
            border: 1px dashed;
            border-radius: 50px;
        }
        .grade{
            height: 25%;
            width: 60%;
            margin: auto;
        }
        .grade > div{
            height: 100%;
            display: flex;
            text-align: left;
            align-items: center;
        }
        #content{
            margin: auto;   
            border-top: 1px solid #b3b3b3;
            border-bottom: 1px solid #b3b3b3;
            width: 100%;
            height: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
     
        }
        #suggest{
            width: 20%;
            height: 70%;
            margin: 10px;
            grid-template-columns: 5fr 5fr 5fr 5fr;
            border-radius: 10px;
            box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2); 
        }
        #suggest > img{
            width: 100%;
            height: 85%;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }
        #suggest > *{
            
        }
        #btn{
            margin: 10px;
            
        }
        #retry{
            display:flex;
            align-items:center;
            justify-content: center;
            margin: auto;
            width: 130px;
            height: 40px;
            background-color: rgba(151, 210, 153, 0.7);
            border: 0px;
            box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
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
                   <div class="grade">
                        <div>
                            <img src="<%=root%>/resources/img/stress//Happy.svg">
                            &nbsp;&nbsp;&nbsp;0~6점 : 낮음
                            <br>
                            &nbsp;&nbsp;&nbsp;스트레스 없는 행복한 삶을 살고계시는군요. 축하합니다!
                        </div>
                    </div>
                    <div class="grade">
                       <div>
                            <img src="<%=root%>/resources/img/stress//Lol.svg">
                            &nbsp;&nbsp;&nbsp;7 ~16점 : 보통
                            <br>
                            &nbsp;&nbsp;&nbsp;일상생활에서 겪는 보통수준의 스트레스입니다.
                       </div>
                    </div>
                    <div class="grade">
                        <div>
                            <img src="<%=root%>/resources/img/stress//Sad.svg">
                            &nbsp;&nbsp;&nbsp;17~26점 : 높음
                            <br>
                            &nbsp;&nbsp;&nbsp;심각한 스트레스를 받고 있습니다.
                            <br>
                            &nbsp;&nbsp;&nbsp;쓰담쓰담을 통해 스트레스를 해소해 보세요!
                        </div>
                    </div>
                       
                   <div><br><br>테스트 결과는 마이페이지에서 확인 가능합니다.</div>
               </fieldset> 
           </div>
            <div id="title"><br>Nick님에게 추천하는 힐링컨텐츠</div>
            <div id="content">
                <div id="btn"><img src="<%=root%>/resources/img/stress//left_btn.svg"></div>
                <div id="suggest"><img src="<%=root%>/resources/img/main/러버덕.jpg">추천컨텐츠</div>
                <div id="suggest"><img src="<%=root%>/resources/img/main/러버덕.jpg">추천컨텐츠</div>
                <div id="suggest"><img src="<%=root%>/resources/img/main/러버덕.jpg">추천컨텐츠</div>
                <div id="suggest"><img src="<%=root%>/resources/img/main/러버덕.jpg">추천컨텐츠</div>
                <div id="btn"><img src="<%=root%>/resources/img/stress//right_btn.svg"></div>
            </div>
           
        <div><br><input type="submit" value="테스트 다시하기" id="retry">
            
        </div>
       </div>
       <div id="footer">
           <%@ include file="/views/common/footer.jsp" %>
       </div>
   </div>
</body>
</body>
</html>