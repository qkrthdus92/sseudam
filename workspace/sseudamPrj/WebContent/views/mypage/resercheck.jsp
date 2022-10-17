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
    margin-left: 55px;
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
#cb1{
    width: 20px;
	height: 20px;
	border: 2px solid #bcbcbc;
	cursor: pointer; 
}
#pro-box-wrap{
    display: grid;
    grid-template-columns: 300px 300px 300px 300px;
    grid-template-rows: 245px 245px;
    justify-content: center;
    margin-top:15px; 
    width: 1200px; 
    height: 490px;
}
#pro-box{
    box-sizing: border-box;
    width: 200px;
    height: 204px;
    background: #FFFFFF;
    border: 1px solid rgba(0, 0, 0, 0.5);
    box-shadow: 0px 2px 15px rgba(0, 0, 0, 0.25);
    border-radius: 30px;
    margin-left: 50px;
}
#bor-top{
    border-top: 1px solid lightgray ;
    margin-top: 5px;
}
#profil2{
    margin-top: 15;
    width: 70px;
    height: 70px;
    border-radius: 100px;
    margin-left: 15px;
}
#proname{
    margin-right: 35px;
    margin-top:35px;
    float: right;
}
#bor-top>label{
    margin-left: 10px;
}
#noborder{
    margin-left: 10px;
}
</style>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>	
	<div id="wrap">
    <div id="main">
        <div id="boardinfo">
            <div><img id="profile" src="../../resources/img/mypage/프로필.png" alt="프로필사진"></div>
            <div id="hm1">총 상담내역</div>
            <div id="hm">5건</div>
            <div id="hm1"></div>
            <div id="hm"></div>
        </div>
    
        <div id="dom">
            <div id="dominfo" onclick="location.href='/sseudamPrj/views/mypage/resercheck.jsp';">상담예약</div>
        </div>
        <div id="dom2">
            <div id="dominfo2" onclick="location.href='/sseudamPrj/views/mypage/fin_resercheck.jsp';">상담완료된예약</div>
        </div>
        <div id="dom3">
            <div id="dominfo3" onclick="location.href='/sseudamPrj/views/mypage/reserpay.jsp';">결제내역</div>
        </div>
        <div id="editbar">
            <button id="allselect" ><img id="checkbox" src="/sseudamPrj/WebContent/resources/img/체크.png" alt="체크"> 전체선택</button>
            <button id="delete">삭제</button>
        </div>

        <div id="pro-box-wrap">

            <div id="pro-box-all">
                <div id="pro-box"> 
                    <span><img id="profil2" src="../../resources/img/main/강형욱.jpg" alt=""></span> 
                    <div id="proname">
                        <span>전문가 <br> 심투용</span> 
                    </div>             
                    <div id="bor-top"><label>에약일시</label></div>
                    <div id="noborder"><label>22/10/04/13:30</label></div>
                    <div id="bor-top"><label>에약번호</label></div>
                    <div id="noborder"><label>0113</label></div>
                </div>
            </div>
            <div id="pro-box-all">
                <div id="pro-box"> 
                    <span><img id="profil2" src="/sseudamPrj/WebContent/resources/img/프로필.png" alt=""></span> 
                    <div id="proname">
                        <span>전문가 <br> 심투용</span> 
                    </div>             
                    <div id="bor-top"><label>에약일시</label></div>
                    <div id="noborder"><label>22/10/04/13:30</label></div>
                    <div id="bor-top"><label>에약번호</label></div>
                    <div id="noborder"><label>0113</label></div>
                </div>
            </div>
            <div id="pro-box-all">
                <div id="pro-box"> 
                    <span><img id="profil2" src="/sseudamPrj/WebContent/resources/img/프로필.png" alt=""></span> 
                    <div id="proname">
                        <span>전문가 <br> 심투용</span> 
                    </div>             
                    <div id="bor-top"><label>에약일시</label></div>
                    <div id="noborder"><label>22/10/04/13:30</label></div>
                    <div id="bor-top"><label>에약번호</label></div>
                    <div id="noborder"><label>0113</label></div>
                </div>
            </div>
            <div id="pro-box-all">
                <div id="pro-box"> 
                    <span><img id="profil2" src="/sseudamPrj/WebContent/resources/img/프로필.png" alt=""></span> 
                    <div id="proname">
                        <span>전문가 <br> 심투용</span> 
                    </div>             
                    <div id="bor-top"><label>에약일시</label></div>
                    <div id="noborder"><label>22/10/04/13:30</label></div>
                    <div id="bor-top"><label>에약번호</label></div>
                    <div id="noborder"><label>0113</label></div>
                </div>
            </div>
            <div id="pro-box-all">
                <div id="pro-box"> 
                    <span><img id="profil2" src="/sseudamPrj/WebContent/resources/img/프로필.png" alt=""></span> 
                    <div id="proname">
                        <span>전문가 <br> 심투용</span> 
                    </div>             
                    <div id="bor-top"><label>에약일시</label></div>
                    <div id="noborder"><label>22/10/04/13:30</label></div>
                    <div id="bor-top"><label>에약번호</label></div>
                    <div id="noborder"><label>0113</label></div>
                </div>
            </div>
            <div id="pro-box-all">
                <div id="pro-box"> 
                    <span><img id="profil2" src="/sseudamPrj/WebContent/resources/img/프로필.png" alt=""></span> 
                    <div id="proname">
                        <span>전문가 <br> 심투용</span> 
                    </div>             
                    <div id="bor-top"><label>에약일시</label></div>
                    <div id="noborder"><label>22/10/04/13:30</label></div>
                    <div id="bor-top"><label>에약번호</label></div>
                    <div id="noborder"><label>0113</label></div>
                </div>
            </div>
    </div>
</div>
<%@ include file="/views/common/footer.jsp" %>	
</body>
</html>