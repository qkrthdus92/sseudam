<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        background: #FFFFFF;
        border: 1px solid #DFDFDF;
    }
    #cstop{
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
        font-size: 30px;
        width: 100%;
        height: 60px;
        margin-top: 40px;
        margin-left: 50px;
        font-weight: bold;
    }
    #csqnabody{
        width: 1100px;
        height: 500px;
        border-top: 1px solid lightgrey;
        border-bottom: 1px solid lightgrey;
        margin-left: 50px;
        display: grid;
        grid-template-columns: 1fr 1fr 1fr;
        grid-template-rows: 1fr 1fr;
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
    }
    #csqna3{
        font-size: 16px;
        margin-top: 30px;
        border-bottom: 1px solid lightgray;
    }
    
    #csmainbot{
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
                <div id="csqnacontent">
                    <div id="csqna1">Q.</div>
                    <div id="csqna3">좋아요 확인은 어디서 하죠?</div>
                    <div  id="csqna1">A.</div>
                    <div  id="csqna2">로그인 후 마이페이지 > 좋아요 확인에서 하실 수 있습니다.</div>
                </div>
                <div id="csqnacontent">
                    <div id="csqna1">Q.</div>
                    <div id="csqna3">상담 금액 책정 기준이 뭔가요?</div>
                    <div  id="csqna1">A.</div>
                    <div  id="csqna2">전문 상담가의 자격증 갯수에 따라 책정됩니다.</div>
                </div>
                <div id="csqnacontent">
                    <div id="csqna1">Q.</div>
                    <div id="csqna3">개인정보 수정은 어디서 어떻게 해야하나요?</div>
                    <div  id="csqna1">A.</div>
                    <div  id="csqna2">로그인 후 마이페이지 > 내프로필 수정해서 할 수 있습니다.</div>
                </div>
                <div id="csqnacontent">
                    <div id="csqna1">Q.</div>
                    <div id="csqna3">컨텐츠의 선정기준은 뭔가요?</div>
                    <div  id="csqna1">A.</div>
                    <div  id="csqna2">다수의 데이터를 바탕으로 선정되며 광고는 포함되지 않습니다.</div>
                </div>
            </div>
            <div id="csmainbot">
                <div id="csmainbot_left">더 궁금한 점이 있으신가요?</div>
                <div id="csmainbot_right">
                    <div>contact</div>
                    <div></div>
                    <div id="temp"><img id="csimg" src="../../resources/img/mypage/메일.png" alt=""><span id="csmainbot_right_text">sseudam@naver.com</span></div>
                    <div id="temp"><img id="csimg" src="../../resources/img/mypage/카톡.png" alt=""><span id="csmainbot_right_text">ID: sseudam</span></div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="/views/common/footer.jsp" %>	
</body>
</html>