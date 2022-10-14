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
        left: 341px;
        top: 169px;
        margin: auto;
        /* white */

        background: #FFFFFF;
        /* border */

        border: 1px solid #DFDFDF;
    }
    #left{
        position: absolute;
        width: 550px;
        height: 851px;
        background: #FFFFFF;
       box-shadow : 3px 0 0 rgba(0, 0, 0, 0.25);
    }
    #profile{
        width: 167px;
        height: 160px;   
       margin-left: 35%;
       border-radius: 50px;
       margin-top: 5%;
    }
    #ment{
        width: 348px;
        height: 57px;
        border: 1px solid #87C57D;
        background-color: #C8FFDE ;
        color: #1EA811;
        display: flex;
        justify-content: center;
        align-items: center;
        margin-left: 20%;
        border-radius: 20px;
        font-weight: bolder;
    }
    #leftbot{
        margin-top: 10%;
        margin-left: 17%;
    }
    #leftmenu{
        font-size: 30px;
        font-weight: bold;
        line-height: 50px;
        
    }
    #right1{
        width: 530px;
        height: 286px;
        margin-left: 600px;
        margin-top: 100px;
        filter: drop-shadow(0px 4px 20px rgba(0, 0, 0, 0.25));
    }
    #righttop{
        font-size: 24px;
        background-color: #87C57D;
        color: white;
        border-top-left-radius: 20px;
        border-top-right-radius: 20px;
        text-align: left;
    }
    #rightbot{
        width: 100%;
        font-size: 20px;
        font-weight: lighter;
        background-color: white;
        text-align: left;
        line-height: 35px;
    }
    #rightbot1{
        width: 100%;
        font-size: 20px;
        font-weight: lighter;
        background-color: white;
        text-align: left;
        line-height: 35px;
        border-bottom-left-radius: 20px;
        border-bottom-right-radius: 20px;
    }
    #icon{
        width: 20px;
        height: 20px;
        margin-left: 10px;
    }
    #editbnt{
        position: fixed;
        left: 460px;
        top: 8px;
    }
    #right4{
        width: 530px;
        height: 129px;
        margin-left: 600px;
        margin-top: 20px;
        filter: drop-shadow(0px 4px 20px rgba(0, 0, 0, 0.25)); 
    }

</style>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<div id="wrap">
    <div id="main">
        <div id="left">
            <div id="leftftop">
                <div><h1 align="center">마이페이지</h1></div>
                <div><img id="profile" src="/sseudam/resources/프로필.png" alt="프로필사진"></div>
                <div><h2 align="center">이름</h2></div>
                <div><h3 align="center">닉네임</h3></div>
                <div><h3 align="center">나의 별점</h3></div>
                <div id="ment">아이디님 좋은 하루되세요.</div>
            </div>
            <div id="leftbot">
                <table>
                    <tr>
                        <th id="leftmenu">내프로필</th>
                        <td></td>
                    </tr>
                    <tr>
                        <th id="leftmenu">상담예약</th>
                        <td></td>
                    </tr>
                </table>
            </div>
        </div>

        <div id="right1">
            <table>
                <tr>
                    <th id="righttop">&nbsp;&nbsp;&nbsp;&nbsp;내프로필 <button id="editbnt" href="" >수정</button></th>
                    <td></td>
                </tr>
                <tr>
                    <th id="rightbot"><img  id ="icon" src="/sseudam/resources/전화기.png" alt="전화기">&nbsp;&nbsp;전화번호</th>
                    <td></td>
                </tr>
                <tr>
                    <th id="rightbot"><img  id ="icon" src="/sseudam/resources/닉네임.png" alt="닉네임">&nbsp;&nbsp;닉네임</th>
                    <td></td>
                </tr>
                <tr>
                    <th id="rightbot"><img  id ="icon" src="/sseudam/resources/이메일.png" alt="이메일">&nbsp;&nbsp;이메일</th>
                    <td></td>
                </tr>
                <tr>
                    <th id="rightbot"><img  id ="icon" src="/sseudam/resources/비밀번호.png" alt="비밀번호">&nbsp;&nbsp;비밀번호</th>
                    <td></td>
                </tr>
                <tr>
                    <th id="rightbot"><img  id ="icon" src="/sseudam/resources/회원.png" alt="회원">&nbsp;&nbsp;소개글</th>
                    <td></td>
                </tr>
                <tr>
                    <th id="rightbot1"><img  id ="icon" src="/sseudam/resources/결제.png" alt="결제">&nbsp;&nbsp;계좌번호</th>
                    <td></td>
                </tr>
            </table>
        </div>
        <div id="right4">
            <table>
                <tr>
                    <th id="righttop">&nbsp;&nbsp;&nbsp;&nbsp;상담예약</th>
                    <td></td>
                </tr>
                <tr>
                    <th id="rightbot"><img  id ="icon" src="/sseudam/resources/상담예약.png" alt="상담예약">&nbsp;&nbsp;상담예약내역<button id="editbnt" href="" >조회</th>
                    <td></td>
                </tr>
                <tr>
                    <th id="rightbot1"><img  id ="icon" src="/sseudam/resources/결제2.png" alt="결제2">&nbsp;&nbsp;수익조회 <button id="editbnt" href="" >조회</button></th>
                    <td></td>
                </tr>
            </table>
        </div>
    </div>
</div>
   
<%@ include file="/views/common/footer.jsp" %>
</body>
</html>