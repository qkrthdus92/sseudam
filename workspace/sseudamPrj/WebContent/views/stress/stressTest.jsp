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
            height: 3750px;
            box-sizing: border-box;
            background-color: #FFFFFF;
            
        }
        #main{
        border-top: 1px solid #dfdfdf;
        width: 1200px;
		height: 3400px;
		display: grid;
		grid-template-rows: 3fr 4fr 2fr repeat(14, 200px);
		margin: 0 auto;
		align-content: center;
        }
        #title{
            font-size: 300%;
            font-weight: 800;
            color: #26AA82;
            text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
            display: flex;
            align-items: center;
            justify-content: center;
        }
        #info{
            display: flex;
            align-items: center;
            justify-content: center;
            padding-right: 5%;
            padding-left: 5%;
        }
        #info > * {
            width: 100%;
            height: 80%;
            margin-left: 3%;
            margin-right: 3%;
            width: 50%;
            text-align: center;
            font-size: 1.2rem; 
            border-radius: 10px;
            box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        }
        #info1 > img{
            width: 45%;
            height: 45%;
            display: flex;
            margin-top: 10%;
            margin-bottom: 13%;
            margin-left: 28%;
            filter: opacity(0.5) drop-shadow(0 0 0 #747474);
        }
        #info2 > img{
            width: 50%;
            height: 50%;
            display: flex;
            margin-top: 5%;
            margin-bottom: 8%;
            margin-left: 25%;
            filter: opacity(0.5) drop-shadow(0 0 0 #747474);
        }
        #info3 > img{
            width: 40%;
            height: 40%;
            display: flex;
            margin-top: 13%;
            margin-bottom: 5%;
            margin-left: 30%;
            filter: opacity(0.5) drop-shadow(0 0 0 #747474); 
        }
        #info1{
            background: rgba(38, 170, 130, 0.7);
        }
        #info2{
            background: rgba(125, 197, 179, 0.7);
        }
        #info3{
            background: rgba(151, 210, 153, 0.7);
        }

        fieldset{
            margin: auto;
            width: 60%;
            height: 50%;
            border: 1px dashed;
            border-radius: 50px;
        }
        .radio-y{
            margin-left: 25%;
            margin-right: 3%;
            accent-color:#21a67e;
        }
        .radio-o{
            display: inline;
            margin-top: 5%;
            margin-left: 10%;
            margin-right: 3%;
            accent-color: rgb(41, 148, 67);
        }
        .radio-n{
            display: inline;
            margin-top: 5%;
            margin-left: 10%;
            margin-right: 3%;
            accent-color:rgb(80, 165, 75);
        }
        #btn{
            display:flex;
            align-items:center;
            justify-content: center;
            margin: auto;
            width: 90px;
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
           <div id="title">스트레스 지수 테스트</div>
           <div id="info">
               <div id="info1">
                   <img src="<%=root%>/resources/icon/clock-regular.svg">
                   총 검사 시간은 3분 내외입니다.
               </div>
               <div id="info2">
                   <img src="<%=root%>/resources/icon/xmark-solid.svg">
                   가능하면 답변 시<br>'보통'을 선택하지 마십시오.
               </div>
               <div id="info3">
                   <img src="<%=root%>/resources/icon/list-ol-solid.svg">
                   네 : 2점<br>보통 : 1점<br>아니요 : 0점
               </div>
           </div>
           <div></div>
           <div>
               <fieldset aria-required="true">
                   <legend>1. 당신이 통제할 수 없는 일 때문에 화가 난 경험이 많은편입니까?</legend>
                   <label for="test1-y"><input type="radio" class="radio-y" name="test1" id="test1-y" value=2>네</label>
                   <label for="test1-o"><input type="radio" class="radio-o" name="test1" id="test1-o" value=1  >보통</label>
                   <label for="test1-n"><input type="radio" class="radio-n" name="test1" id="test1-n" value=0  >아니요</label>
               </fieldset>
           </div>
           <div>
               <fieldset>
                   <legend>2. 일상의 일들이 당신의 생각대로 잘 진행되고 있다고 생각하십니까?</legend>
                       <label for="test2-y"><input type="radio" class="radio-y" name="test2" id="test2-y" value=2>네</label>
                       <label for="test2-o"><input type="radio" class="radio-o" name="test2" id="test2-o" value=1>보통</label>
                       <label for="test2-n"><input type="radio" class="radio-n" name="test2" id="test2-n" value=0>아니요</label>
               </fieldset>
           </div>
           <div>
               <fieldset>
                   <legend>3. 일정 시간 동안 정신을 집중하는데 어려움이 있습니까?</legend>
                       <label for="test3-y"><input type="radio" class="radio-y" name="test3" id="test3-y" value=2>네</label>
                       <label for="test3-o"><input type="radio" class="radio-o" name="test3" id="test3-o" value=1>보통</label>
                       <label for="test3-n"><input type="radio" class="radio-n" name="test3" id="test3-n" value=0>아니요</label>
               </fieldset>
           </div>
           <div>
               <fieldset>
                   <legend>4. 아주 사소한 결정도 잘 내리지 못하는 편입니까?</legend>
                       <label for="test4-y"><input type="radio" class="radio-y" name="test4" id="test4-y" value=2>네</label>
                       <label for="test4-o"><input type="radio" class="radio-o" name="test4" id="test4-o" value=1>보통</label>
                       <label for="test4-n"><input type="radio" class="radio-n" name="test4" id="test4-n" value=0>아니요</label>
               </fieldset>
           </div>
           <div>
               <fieldset>
                   <legend> 5. 잠드는데 어려움이 있으며 밤중에 깨어나 안절부절 못할때가 많습니까?</legend>
                       <label for="test5-y"><input type="radio" class="radio-y" name="test5" id="test5-y" value=2>네</label>
                       <label for="test5-o"><input type="radio" class="radio-o" name="test5" id="test5-o" value=1>보통</label>
                       <label for="test5-n"><input type="radio" class="radio-n" name="test5" id="test5-n" value=0>아니요</label>
               </fieldset>
           </div>
           <div>
               <fieldset>
                   <legend> 6. 가치 있는 것은 아무것도 없는 것 같고, 나 자신이 참으로 못났다고 생각합니까?</legend>
                       <label for="test6-y"><input type="radio" class="radio-y" name="test6" id="test6-y" value=2>네</label>
                       <label for="test6-o"><input type="radio" class="radio-o" name="test6" id="test6-o" value=1>보통</label>
                       <label for="test6-n"><input type="radio" class="radio-n" name="test6" id="test6-n" value=0>아니요</label>
               </fieldset>
           </div>
           <div>
               <fieldset>
                   <legend>7. 잦은 두통으로 고생을 하십니까?</legend>
                       <label for="test7-y"><input type="radio" class="radio-y" name="test7" id="test7-y" value=2>네</label>
                       <label for="test7-o"><input type="radio" class="radio-o" name="test7" id="test7-o" value=1>보통</label>
                       <label for="test7-n"><input type="radio" class="radio-n" name="test7" id="test7-n" value=0>아니요</label>
               </fieldset>
           </div>
           <div>
               <fieldset>
                   <legend>8. 때로는 매우 격앙되고, 때로는 우울해지는 등 심한 감정 동요가 자주 있습니까?</legend>
                       <label for="test8-y"><input type="radio" class="radio-y" name="test8" id="test8-y" value=2>네</label>
                       <label for="test8-o"><input type="radio" class="radio-o" name="test8" id="test8-o" value=1>보통</label>
                       <label for="test8-n"><input type="radio" class="radio-n" name="test8" id="test8-n" value=0>아니요</label>
               </fieldset>
           </div>
           <div>
               <fieldset>
                   <legend> 9. 매사에 걱정이 많은 편이십니까?</legend>
                       <label for="test9-y"><input type="radio" class="radio-y" name="test9" id="test9-y" value=2>네</label>
                       <label for="test9-o"><input type="radio" class="radio-o" name="test9" id="test9-o" value=1>보통</label>
                       <label for="test9-n"><input type="radio" class="radio-n" name="test9" id="test9-n" value=0>아니요</label>
               </fieldset>
           </div>
           <div>
               <fieldset>
                   <legend>10. 어려운 일들이 너무 많이 쌓여서 극복하지 못할 것 같은 느낌을 자주 경험하십니까?</legend>
                       <label for="test10-y"><input type="radio" class="radio-y" name="test10" id="test10-y" value=2>네</label>
                       <label for="test10-o"><input type="radio" class="radio-o" name="test10" id="test10-o" value=1>보통</label>
                       <label for="test10-n"><input type="radio" class="radio-n" name="test10" id="test10-n" value=0>아니요</label>
               </fieldset>
           </div>
           <div>
               <fieldset>
                   <legend>11. 아침에 일어날 때 피로감과 무기력함을 자주 느끼십니까?</legend>
                   <label for="test11-y"><input type="radio" class="radio-y" name="test11" id="test11-y" value=2>네</label>
                   <label for="test11-o"><input type="radio" class="radio-o" name="test11" id="test11-o" value=1>보통</label>
                   <label for="test11-n"><input type="radio" class="radio-n" name="test11" id="test11-n" value=0>아니요</label>
               </fieldset>
           </div>
           <div>
               <fieldset>
                   <legend>12. 대체로 기진맥진해하고 몸이 불편하다고 자주 느끼십니까?</legend>
                   <label for="test12-y"><input type="radio" class="radio-y" name="test12" id="test12-y" value=2>네</label>
                   <label for="test12-o"><input type="radio" class="radio-o" name="test12" id="test12-o" value=1>보통</label>
                   <label for="test12-n"><input type="radio" class="radio-n" name="test12" id="test12-n" value=0>아니요</label>
               </fieldset>
           </div>
           <div>
               <fieldset>
                   <legend>13. 사소한 것에 대해서도 공포/공황상태를 느끼며, 더 이상 대처할 능력이 없다고 느끼십니까?</legend>
                   <label for="test13-y"><input type="radio" class="radio-y" name="test13" id="test13-y" value=2>네</label>
                   <label for="test13-o"><input type="radio" class="radio-o" name="test13" id="test13-o" value=1>보통</label>
                   <label for="test13-n"><input type="radio" class="radio-n" name="test13" id="test13-n" value=0>아니요</label>
               </fieldset>
           </div>
           <div>
               <form action="<%=root%>/views/stress/stressResult.jsp" method="post">
                   <input type="submit" value="결과보기" id="btn">
               </form>
           </div>
       </div>
       <div id="footer">
           <%@ include file="/views/common/footer.jsp" %>
       </div>
   </div>
</body>
</html>