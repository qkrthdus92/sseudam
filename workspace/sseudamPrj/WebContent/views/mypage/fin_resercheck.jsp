<%@page import="com.kh.sseudam.common.PageVo"%>
<%@page import="com.kh.sseudam.mypage.board.vo.MypageFinreserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<MypageFinreserVo> MypageFinreserList = (List<MypageFinreserVo>)request.getAttribute("MypageFinreserList");	
	PageVo pv = (PageVo)request.getAttribute("pv");
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
    background: rgba(217, 217, 217, 0.5);
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
#review_bnt{
    margin-top: 5px;
    margin-left: 85px;
    background-color: #97D299;
    color:black;
    border-color: #FFFFFF;
    border-radius: 10px;
    cursor: pointer;
}
#bor-top>label{
    margin-left: 10px;
}
#noborder{
    margin-left: 10px;
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
	
	#popup.hide {
	  display: none;
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
	#myform input[type=radio]{
	    display: none; /* 라디오박스 감춤 */
	}
	#myform label{
	    font-size: 2.5em; /* 이모지 크기 */
	    color: transparent; /* 기존 이모지 컬러 제거 */
	    text-shadow: 0 0 0 #f0f0f0; /* 새 이모지 색상 부여 */
	}
    #myform label:hover{
    text-shadow: 0 0 0 #87C57D; /* 마우스 호버 */
	}
	#myform label:hover ~ label{
	    text-shadow: 0 0 0 #87C57D; /* 마우스 호버 뒤에오는 이모지들 */
	}
	#myform fieldset{
    display: inline-block; /* 하위 별점 이미지들이 있는 영역만 자리를 차지함.*/
    direction: rtl; /* 이모지 순서 반전 */
    border: 0; /* 필드셋 테두리 제거 */
	}
	#myform input[type=radio]:checked ~ label{
    text-shadow: 0 0 0 #87C57D; /* 마우스 클릭 체크 */
	}
	#viewstar{
	width: 100%;
	padding-top: 60px;
	padding-left: 20px;
	}
	
</style>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>	
	<div id="wrap">
    <div id="main">
        <div id="boardinfo">
            <div><img id="profile" src="../../resources/img/mypage/프로필.png" alt="프로필사진"></div>
            <div id="hm1">상담완료</div>
            <div id="hm"><%=MypageFinreserList.size() %>건</div>
            <div id="hm1"></div>
            <div id="hm"></div>
        </div>
    
        <div id="dom">
            <div id="dominfo" onclick="location.href='/sseudam/mypage/resercheck?pno=1'">상담예약</div>
        </div>
        <div id="dom2">
            <div id="dominfo2" onclick="location.href='/sseudam/mypage/fin_resercheck?pno=1'">상담완료된예약</div>
        </div>
        <div id="dom3">
            <div id="dominfo3" onclick="location.href='/sseudam/mypage/reserpay?pno=1'">결제내역</div>
        </div>
        <div id="editbar">
           
        </div>

        <div id="pro-box-wrap">
        <%for(int i = 0 ; i < MypageFinreserList.size(); ++i){%>
            <div id="pro-box-all">
                <div id="pro-box"> 
                    <span><img id="profil2" src="/sseudam/WebContent/resources/img/프로필.png" alt=""></span> 
                    <div id="proname">
                        <span>전문가 <br> <%= MypageFinreserList.get(i).getName()%></span> 
                    </div>             
                    <div id="bor-top"><label>에약일시</label></div>
                    <div id="noborder"><label> <%= MypageFinreserList.get(i).getAdvice_date()%></label></div>
                    <div id="bor-top"><label>에약번호</label></div>
                    <div id="noborder"><label> <%= MypageFinreserList.get(i).getA_no()%></label></div>
                </div>
                <div><button id="review_bnt" onclick="showPopup(true,<%=i%>)">별점주기</button></div> <!--i를 어떻게 자바스크립트로 넘길것인지.?-->
            </div>
    		<div id="popup" class="hide">
		  <div class="content">
				<div class="popup-head">
					<div  ><img id="popup-logo" src="../../resources/img/header/logo.png" alt=""></div>
					<div class="head-title">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;예약번호<%= MypageFinreserList.get(i).getA_no()%>의 <br> &nbsp;&nbsp;&nbsp;&nbsp;상담은 어떠셨나요?</div>
				</div>
				<div class="popup-body">
					<div id="viewstar">
						<form name="myform" id="myform" method="post" action="./save">
						    <fieldset>
						        <input type="radio" name="rating" value="1" id="rate1"><label for="rate1">⭐</label>
						        <input type="radio" name="rating" value="2" id="rate2"><label for="rate2">⭐</label>
						        <input type="radio" name="rating" value="3" id="rate3"><label for="rate3">⭐</label>
						        <input type="radio" name="rating" value="4" id="rate4"><label for="rate4">⭐</label>
						        <input type="radio" name="rating" value="5" id="rate5"><label for="rate5">⭐</label>
						    </fieldset>
						</form>
					</div>
				</div>
				<div class="popup-foot">
					<!-- 별점주는 컨트롤러로 이동 -->
					<button class="pop-btn" id="confirm" onclick="location.href=''" >확인</button> 
					<button class="pop-btn" id="close" onclick="closePopup(<%=i %>)" >창 닫기</button>
				</div>
		  </div>
		</div>
 	  <%}%>  
              
	</div>
         <div id="page-area">
        
        <%if(pv.getStartPage() !=1){%>
		        <a href="/sseudam/mypage/fin_resercheck?pno=<%=pv.getStartPage()-1%>" class="btn btn-primary btn-sm">PRE</a> 
        	<%}%>
        
        
        <%for(int i =pv.getStartPage(); i <= pv.getEndPage(); ++i){%>
       		<a href="/sseudam/mypage/fin_resercheck?pno=<%=i %>" class="btn btn-primary btn-sm"><%=i %></a> 
       	<%}%>
       	
       	<%if(pv.getEndPage() != pv.getMaxPage()){%>
    		<a href="/sseudam/mypage/fin_resercheck?pno=<%=pv.getEndPage()+1%>" class="btn btn-primary btn-sm">NEXT</a> 
   		<%}%>
       	
       	
        </div>
</div>
<%@ include file="/views/common/footer.jsp" %>	

<script type="text/javascript">

	function showPopup(multipleFilter,i) {
		const popupArr = document.querySelectorAll('#popup');
	  
	  if (multipleFilter) {
		  popupArr[i].classList.add('multiple-filter');
	  } else {
		  popupArr[i].classList.remove('multiple-filter');
	  }
	  
	  popupArr[i].classList.remove('hide');
	}
	
	function closePopup(i) {
		const popupArr = document.querySelectorAll('#popup');
		popupArr[i].classList.add('hide');
	}
</script>

<script type="text/javascript">
	const drawStar = (target) => {
    document.querySelector(`.star span`).style.width = `${target.value * 10}%`;
  	}
</script>

<!-- <script type="text/javascript">

	document.getElementById('confirm').onclick = function() {
	    var radios = document.getElementsByName("rating");
	    var selected = Array.from(radios).find(radio => radio.checked);
	    alert(selected.value);
	}
	console.log(selected);

</script> -->

</body>
</html>