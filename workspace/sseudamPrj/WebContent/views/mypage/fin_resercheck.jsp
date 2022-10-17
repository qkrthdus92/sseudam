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
#review_bnt{
    margin-top: 5px;
    margin-left: 110px;
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
	 .star {
    position: relative;
    font-size: 2rem;
    color: #ddd;
    }
  
   .star input {
    width: 100%;
    height: 100%;
    position: absolute;
    left: 0;
    opacity: 0;
    cursor: pointer;
    }
  
  .star span {
    width: 0;
    position: absolute; 
    left: 0;
    color: red;
    overflow: hidden;
    pointer-events: none;
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
                    <span><img id="profil2" src="/sseudamPrj/WebContent/resources/img/프로필.png" alt=""></span> 
                    <div id="proname">
                        <span>전문가 <br> 심투용</span> 
                    </div>             
                    <div id="bor-top"><label>에약일시</label></div>
                    <div id="noborder"><label>22/10/04/13:30</label></div>
                    <div id="bor-top"><label>에약번호</label></div>
                    <div id="noborder"><label>0113</label></div>
                </div>
                <div><button id="review_bnt" onclick="showPopup(true)">별점주기</button></div>
            </div>
                
    </div>
    		<div id="popup" class="hide">
		  <div class="content">
				<div class="popup-head">
					<div  ><img id="popup-logo" src="../../resources/img/header/logo.png" alt=""></div>
					<div class="head-title">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;예약번호0113의 <br> &nbsp;&nbsp;&nbsp;&nbsp;상담은 어떠셨나요?</div>
				</div>
				<div class="popup-body">
					<span class="star">
						 ★★★★★
						<span>★★★★★</span>
						<input type="range" oninput="drawStar(this)" value="1" step="1" min="0" max="10">
					</span>
				</div>
				<div class="popup-foot">
					<!-- 별점주는 컨트롤러로 이동 -->
					<button class="pop-btn" id="confirm" onclick="location.href='';" >확인</button> 
					<button class="pop-btn" id="close" onclick="closePopup()" >창 닫기</button>
				</div>
		  </div>
		</div>
    
</div>
<%@ include file="/views/common/footer.jsp" %>	

<script type="text/javascript">
	function showPopup(multipleFilter) {
		const popup = document.querySelector('#popup');
	  
	  if (multipleFilter) {
	  	popup.classList.add('multiple-filter');
	  } else {
	  	popup.classList.remove('multiple-filter');
	  }
	  
	  popup.classList.remove('hide');
	}
	
	function closePopup() {
		const popup = document.querySelector('#popup');
	  popup.classList.add('hide');
	}
</script>
<script type="text/javascript">
	const drawStar = (target) => {
    document.querySelector(`.star span`).style.width = `${target.value * 10}%`;
  	}
</script>

</body>
</html>