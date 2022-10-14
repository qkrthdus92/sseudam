<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
        position: absolute;
        width: 177px;
        height: 59.04px;
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
        left: 30px;
        line-height: 19px;
    }
    #editbar{
        width: 1200px;
        height: 63px;
        margin-top : 89px;
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
        grid-template-columns: 1fr 2fr 5fr 1fr 1fr;
        align-content: center;
        text-align: center;
    }
    #editlist{
        height: 60px;
        display: grid;
        grid-template-columns: 1fr 2fr 5fr 1fr 1fr;
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
</style>
<body>
	<%@ include file="/views/common/header.jsp" %>	
		<div id="wrap">
		<div id="main">
		    <div id="boardinfo">
		       <div><img id="profile" src="/sseudamPrj/WebContent/resources/img/프로필.png" alt="프로필사진"></div>
		       <div id="hm1">총 게시글</div>
		       <div id="hm">19개</div>
		       <div id="hm1">총 댓글</div>
		       <div id="hm">19개</div>
		    </div>
		
		    <div id="dom">
		        <div id="dominfo">내가 쓴 게시글</div>
		    </div>
		    <div id="editbar">
		        <button id="allselect" ><img id="checkbox" src="/sseudamPrj/WebContent/resources/img/체크.png" alt="체크"> 전체선택</button>
		        <button id="delete">삭제</button>
		    </div>
		    <div id="edittop">
		        <div></div>
		        <div>글번호</div>
		        <div>내용</div>
		        <div>게시판</div>
		        <div>작성일</div>
		    </div>
		    <div id="editlist">
		        <div><input type="checkbox" id="cb1"></div>
		        <div>1</div>
		        <div>안녕하세요</div>
		        <div>자유게시판</div>
		        <div>2022.10.12</div>
		
		    </div>
		    <div id="editlist">
		        <div><input type="checkbox" id="cb1"></div>
		        <div>1</div>
		        <div>안녕하세요</div>
		        <div>자유게시판</div>
		        <div>2022.10.12</div>
		
		    </div>
		    <div id="editlist">
		        <div><input type="checkbox" id="cb1"></div>
		        <div>1</div>
		        <div>안녕하세요</div>
		        <div>자유게시판</div>
		        <div>2022.10.12</div>
		    </div>
		</div>
	</div>
<%@ include file="/views/common/footer.jsp" %>	
</body>
</html>