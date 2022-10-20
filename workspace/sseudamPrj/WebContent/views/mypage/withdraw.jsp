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
    background: rgba(217, 217, 217, 0.5);
    border-color: rgba(0, 0, 0, 0.6);
    border-radius: 30px 30px 0px 0px;
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
    border-width: 1px 1px 0px 1px;
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
#datechoice{
	margin-left: 650px;	
}
#allselect{
    margin-left: 20px;
    margin-top: 20px;
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
	#popup-text{
		font-size: 20px;
        margin-top: 10px;
	}
    #pop_text2{
        margin-top: 50px;
    }
    #moneyinfo{
        margin-top: 15px;
        margin-left: 150px;
        width: 900px;
        height: 100px;
        display: grid;
        grid-template-columns: 2fr 2fr 1fr;
        grid-template-rows: 1fr 2fr;
        background-color: #8ED1B1;
        border-radius: 20px;
    }
    #moneyinfo>div{
        color: #FFFFFF;
    }
    #moneyinfotext{
        margin-top: 10px;
        margin-left: 20px;
    }
    #moneyinfotext2{
        margin-top: 10px;
        margin-left: 60px;
        font-size: 30px;
    }
    #moneyinfotext3{
        margin-left: 70px;
        cursor: pointer;
    } 
    #moneylist{
        width: 900px;
        margin-left: 150px;
    }
    #moneylisttop{
        margin-top: 15px;
        display: grid;
        grid-template-columns: 1fr 1fr 5fr 1fr;
        align-content: center;
        text-align: center;
        border-bottom:1px solid rgb(177, 175, 175) ;
        border-top:1px solid rgb(177, 175, 175) ;
    }
    #moneylistinfo{
        height: 60px;
        display: grid;
        grid-template-columns: 1fr 1fr 5fr 1fr;
        align-content: center;
        text-align: center;
        border-bottom:1px solid rgb(177, 175, 175) ;
        font-size: 20px;
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
            <div id="dominfo" onclick="location.href='/sseudam/views/mypage/proresercheck.jsp';">상담예약</div>
        </div>
        <div id="dom2">
            <div id="dominfo2">수익조회</div>
        </div>
        <div id="dom3">
            <div id="dominfo3"></div>
        </div>
        <div id="editbar">
            <button id="allselect" ><img id="checkbox" src="/sseudam/WebContent/resources/img/체크.png" alt="체크"> 전체선택</button>
            <button id="delete">삭제</button>
        	<span id="datechoice">
	            <input id="date" type="date" value="2022-10-12">
	            <span>~</span>
	            <input id="date" type="date" value="2022-10-12">
                <button> 조회</button>
        	</span>
        </div>
        <div id="moneyinfo">
            <div id="moneyinfotext">아이디님의 총 수익</div>
            <div id="moneyinfotext">아이디님의 출금 가능 금액</div>
            <div></div>
            <div id="moneyinfotext2">2000,000원</div>
            <div id="moneyinfotext2">100,000원</div>
            <div id="moneyinfotext3" onclick="showPopup(true)" >출금하기 > </div>
        </div>

        <div id="moneylist">
            <div id="moneylisttop">
                <div></div>
                <div>예약번호</div>
                <div>예약일시</div>
                <div>금액</div>
            </div>
            <div id="moneylistinfo">
                <div><input type="checkbox" id="chk1" name="chk"></div>
                <div>0113</div>
                <div>2022.10.12</div>
                <div>50,000</div>
            </div>
            <div id="moneylistinfo">
                <div><input type="checkbox" id="chk1" name="chk"></div>
                <div>0113</div>
                <div>2022.10.12</div>
                <div>50,000</div>
            </div>
            <div id="moneylistinfo">
                <div><input type="checkbox" id="chk1" name="chk"></div>
                <div>0113</div>
                <div>2022.10.12</div>
                <div>50,000</div>
            </div>
        </div>

    </div>

    <div id="popup" class="hide">
        <div class="content">
              <div class="popup-head">
                  <div  ><img id="popup-logo" src="../../resources/img/header/logo.png" alt=""></div>
                  <div class="head-title">&nbsp;&nbsp;&nbsp;&nbsp;출금하시겠습니까?</div>
              </div>
              <div class="popup-body">
                  <div>
                      <div>
                          <label id="popup-text"> 은행 :</label>
                            <select id="pop_text2">
                              <option value="신한">신한</option>
                              <option value="국민">국민</option>
                              <option value="우리">우리</option>
                              <option value="기업">기업</option>
                              <option value="농협">농협</option>
                              <option value="카카오뱅크">카카오뱅크</option>
                              <option value="SC제일">SC제일</option>
                              <option value="케이뱅크">케이뱅크</option>
                            </select>
                      </div>  
                      <label id="popup-text"> 계좌번호 :</label>
                      <input id="popup-text" type="password">
                  </div>
              </div>
              <div class="popup-foot">
                  <!-- 출금완료페이지로 이동 -->
                  <button class="pop-btn" id="confirm" onclick="location.href='/sseudam/views/mypage/promoneycheck.jsp';" >확인</button> 
                  <button class="pop-btn" id="close" onclick="location.href='/sseudam/views/mypage/promoneycheck.jsp';" >창 닫기</button>
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

</body>
</html>