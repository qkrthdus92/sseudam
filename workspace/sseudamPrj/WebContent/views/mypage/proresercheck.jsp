<%@page import="com.kh.sseudam.common.PageVo"%>
<%@page import="com.kh.sseudam.mypage.board.vo.MypageProreserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	List<MypageProreserVo> MypageProreserList = (List<MypageProreserVo>)request.getAttribute("MypageProreserList");	
 	PageVo pv = (PageVo)request.getAttribute("pv");
%>   
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" />
<meta charset="UTF-8">
<title>전문가회원 예약 조회 :: 쓰담쓰담</title>
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
     margin-top: 5px;
}
#dom{
    box-sizing: border-box;
    width: 177px;
    height: 59.04px;
    position: absolute;
    margin-top: 30px;
    background:  rgba(217, 217, 217, 0.5);
    border-width: 1px 1px 0px 1px;
    border-style: solid;
    border-color: rgba(0, 0, 0, 0.6);
    border-radius: 30px 30px 0px 0px;
    cursor: pointer;
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
    cursor: pointer;
}
#dominfo2{     
    position: absolute;
    width: 177.44px;
    height: 58.63px;
    top: 20px;
    left: 55px;
    line-height: 19px;
}
#dom3{
    box-sizing: border-box;
    width: 177px;
    height: 59.04px;
    margin-top: 30px;
    margin-left: 354px;
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

#allselect{
    margin-left: 20px;
    margin-top: 20px;
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
    grid-template-columns: 240px 240px 240px 240px 240px;
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
    margin-left: 20px;
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
    margin-top: 20px;
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
    margin-left: 20px;
}
#noborder{
    margin-left: 20px;
}
#datechoice{
	margin-left: 650px;
}
#datechoice{
	margin-left: 880px;
	padding-top: 15px;
}



</style>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>	
	<div id="wrap">
    <div id="main">
        <div id="boardinfo">
            <div><img id="profile" src="/sseudam/resources/upload/pro/<%=proLoginMember.getImg() %>"alt="프로필사진"></div>
            <div id="hm1">총 결제내역</div>
            <div id="hm"><%=MypageProreserList.size() %>건</div>
            <div id="hm1"></div>
            <div idg="hm"></div>
        </div>
    
        <div id="dom">
            <div id="dominfo" onclick="location.href='/sseudam/mypage/proresercheck?pno=1'">상담예약</div>
        </div>
        <div id="dom2">
            <div id="dominfo2" onclick="location.href='/sseudam/mypage/promoneycheck?pno=1'">수익조회</div>
        </div>
        <div id="dom3">
            <div id="dominfo3"></div>
        </div>
        <div id="editbar">
   
        </div>

        <div id="pro-box-wrap">
        
        	<%for(int i = 0 ; i < MypageProreserList.size(); ++i){%>
                <div id="pro-box"> 
                    <span><img id="profil2" src="/sseudam/resources/img/mypage/프로필.png" alt=""></span> 
                    <div id="proname">
                        <span><%= MypageProreserList.get(i).getName()%></span> 
                    </div>             
                    <div id="bor-top"><label>전화번호</label></div>
                    <div id="noborder"><label><%= MypageProreserList.get(i).getPhone()%></label></div>
                    <div id="bor-top"><label>결제일시</label></div>
                    <div id="noborder"><label><%= MypageProreserList.get(i).getPay_date()%></label></div>
                    <div id="bor-top"><label>예약번호</label></div>
                    <div id="noborder"><label><%= MypageProreserList.get(i).getNo()%></label></div>
                </div>
			 <%}%> 
         </div>
    	 <div id="page-area">
        
        <%if(pv.getStartPage() !=1){%>
		        <a href="/sseudam/mypage/resercheck?pno=<%=pv.getStartPage()-1%>" class="btn btn-primary btn-sm">PRE</a> 
        	<%}%>
        
        
        <%for(int i =pv.getStartPage(); i <= pv.getEndPage(); ++i){%>
       		<a href="/sseudam/mypage/resercheck?pno=<%=i %>" class="btn btn-primary btn-sm"><%=i %></a> 
       	<%}%>
       	
       	<%if(pv.getEndPage() != pv.getMaxPage()){%>
    		<a href="/sseudam/mypage/resercheck?pno=<%=pv.getEndPage()+1%>" class="btn btn-primary btn-sm">NEXT</a> 
   		<%}%>
       	
       	
        </div>
    </div>
</div>
<%@ include file="/views/common/footer.jsp" %>	
</body>
</html>