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
    left: 50px;
    line-height: 19px;
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
}
#dom3{
    box-sizing: border-box;
    width: 177px;
    height: 59.04px;
    margin-top: 30px;
    margin-left: 354px;
    background: rgba(217, 217, 217, 0.5);
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
    line-height: 19px
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
    margin-top: 5px;
    width: 40px;
    height: 40px;
    border-radius: 100px;
    margin-left: 15px;
}
#proname{
    float: right;
    margin-right: 50px;
    margin-top: 8px;
    font-size: 14px;
}
#star{
    margin-top: 5px;
    margin-left: 110px;
    background-color: #97D299;
    color:black;
    border-color: #FFFFFF;
    border-radius: 10px;
}
#bor-top>label{
    margin-left: 10px;
}
#noborder{
    margin-left: 10px;
}
#datechoice{
	margin-left: 850px;
	
}
#serch{
    margin-top: 20px;
}
#date{
    margin-top: 15px;
}

</style>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>	
	<div id="wrap">
    <div id="main">
        <div id="boardinfo">
            <div><img id="profile" src="../../resources/img/mypage/프로필.png" alt="프로필사진"></div>
            <div id="hm1">총 결제내역</div>
            <div id="hm">5건</div>
            <div id="hm1"></div>
            <div idg="hm"></div>
        </div>
    
        <div id="dom">
            <div id="dominfo">상담예약</div>
        </div>
        <div id="dom2">
            <div id="dominfo2">상담완료된예약</div>
        </div>
        <div id="dom3">
            <div id="dominfo3">결제내역</div>
        </div>
        <div id="editbar">
        	<div id="datechoice">
	            <input id="date" type="date" value="2022-10-12">
	            <span>~</span>
	            <input id="date" type="date" value="2022-10-12">
                <img id="serch" src="../../resources/img/mypage/조회.png" alt="">
        	</div>
        </div>

        <div id="pro-box-wrap">
                <div id="pro-box"> 
                    <span><img id="profil2" src="../../resources/img/mypage/프로필.png" alt=""></span> 
                    <div id="proname">
                        <span>예약일시<br> 22.10.13</span> 
                    </div>             
                    <div id="bor-top"><label>예약번호</label></div>
                    <div id="noborder"><label>0113</label></div>
                    <div id="bor-top"><label>결제일시</label></div>
                    <div id="noborder"><label>22/10/04/13:30</label></div>
                    <div id="bor-top"><label>결제수단</label></div>
                    <div id="noborder"><label>**카드</label></div>
                </div>
                
                 <div id="pro-box"> 
                    <span><img id="profil2" src="../../resources/img/mypage/프로필.png" alt=""></span> 
                    <div id="proname">
                        <span>예약일시<br> 22.10.13</span> 
                    </div>             
                    <div id="bor-top"><label>예약번호</label></div>
                    <div id="noborder"><label>0113</label></div>
                    <div id="bor-top"><label>결제일시</label></div>
                    <div id="noborder"><label>22/10/04/13:30</label></div>
                    <div id="bor-top"><label>결제수단</label></div>
                    <div id="noborder"><label>**카드</label></div>
                </div>
                
                <div id="pro-box"> 
                    <span><img id="profil2" src="../../resources/img/mypage/프로필.png" alt=""></span> 
                    <div id="proname">
                        <span>예약일시<br> 22.10.13</span> 
                    </div>             
                    <div id="bor-top"><label>예약번호</label></div>
                    <div id="noborder"><label>0113</label></div>
                    <div id="bor-top"><label>결제일시</label></div>
                    <div id="noborder"><label>22/10/04/13:30</label></div>
                    <div id="bor-top"><label>결제수단</label></div>
                    <div id="noborder"><label>**카드</label></div>
                </div>
                
                <div id="pro-box"> 
                    <span><img id="profil2" src="../../resources/img/mypage/프로필.png" alt=""></span> 
                    <div id="proname">
                        <span>예약일시<br> 22.10.13</span> 
                    </div>             
                    <div id="bor-top"><label>예약번호</label></div>
                    <div id="noborder"><label>0113</label></div>
                    <div id="bor-top"><label>결제일시</label></div>
                    <div id="noborder"><label>22/10/04/13:30</label></div>
                    <div id="bor-top"><label>결제수단</label></div>
                    <div id="noborder"><label>**카드</label></div>
                </div>

                 <div id="pro-box"> 
                    <span><img id="profil2" src="../../resources/img/mypage/프로필.png" alt=""></span> 
                    <div id="proname">
                        <span>예약일시<br> 22.10.13</span> 
                    </div>             
                    <div id="bor-top"><label>예약번호</label></div>
                    <div id="noborder"><label>0113</label></div>
                    <div id="bor-top"><label>결제일시</label></div>
                    <div id="noborder"><label>22/10/04/13:30</label></div>
                    <div id="bor-top"><label>결제수단</label></div>
                    <div id="noborder"><label>**카드</label></div>
                </div>

                <div id="pro-box"> 
                    <span><img id="profil2" src="../../resources/img/mypage/프로필.png" alt=""></span> 
                    <div id="proname">
                        <span>예약일시<br> 22.10.13</span> 
                    </div>             
                    <div id="bor-top"><label>예약번호</label></div>
                    <div id="noborder"><label>0113</label></div>
                    <div id="bor-top"><label>결제일시</label></div>
                    <div id="noborder"><label>22/10/04/13:30</label></div>
                    <div id="bor-top"><label>결제수단</label></div>
                    <div id="noborder"><label>**카드</label></div>
                </div>
                
         </div>
    
    </div>
</div>
<%@ include file="/views/common/footer.jsp" %>	
</body>
</html>