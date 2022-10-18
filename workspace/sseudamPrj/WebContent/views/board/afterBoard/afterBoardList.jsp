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
        height: 1200px;
        box-sizing: border-box;
        background-color: #FFFFFF;
        
    }
    #header{
        width: 100vw;
        height: 170px;
    }
    #main{
        border-top: 1px solid #dfdfdf;
        width: 1200px;
        height: 850px;
        display: grid;
        grid-template-rows: 1fr 0.8fr 4fr 4fr 0.8fr 0.8fr;
        margin: 0 auto;
        padding: 20px;
        align-content: center;
    }
    #title{
        margin-top: 20px;
        margin-left: 20px;
        font-size: 230%;
        font-weight: 800;
        color: #26AA82;
        text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
    }
    #write{ 
        margin-left: 20px;
        margin-right: 20px; 
        border-bottom: 1px solid #747474;
    }
    #write > *{
        display:flex;
        align-items:center;
        justify-content: center;
        margin-left: 95%;
        width: 70px;
        height: 30px;
        background-color: rgba(151, 210, 153, 0.7);
        border: 0px;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2);
    }
    a{
        text-decoration: none;
        color: black;
    }
    .board-list{
        margin: auto;   
        width: 100%;
        height: 100%;
        display: flex;
        align-items: center;
        justify-content: center;
        column-gap: 35px;
        margin-top: 10px;

    }
    .board-list > div{
        width: 20%;
        height: 95%;
        margin: 10px;
        grid-template-columns: 5fr 5fr 5fr 5fr;
        border-radius: 10px;
        border: 1px solid #454545;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.2); 
        }
    .board-list > *{
        width: 20%;
        height: 50%;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
        padding: 10px;
    }
    img{
        width: 100%;
        height: 83%;
        border-radius: 10px;

    }
    .list-info{
        font-size: 0.8rem;
        display: flex;
        margin: auto;
    }
    .view{
        width: 10%;
        height: 10%;
        padding-bottom: 20px;
    }
    #page{
        border-top: 1px solid #454545;
        margin-top: 20px;
        text-align: center;
        padding-top: 15px;
    }
    #search{
        margin: auto;
        display: flex;
    }
    #search > div{
        margin: 3px;
        vertical-align: middle;
    }
    #search-icon{
        padding-top: 3px;
    }
    #footer{
        width: 100vw;
        height: 180px;
    }
</style>
</head>
<body>
    <div id="wrap">
        <div id="header">
            <%@ include file="/views/common/header.jsp" %>
        </div>
        <div id="main">
            <div id="title">후기게시판</div>
            <div id="write"><button onclick="location.href='<%=root%>/views/board/afterBoard/afterBoardWrite.jsp'">글쓰기</button></div>
            <div class="board-list">
                <div class="board-photo">
                    <a href="<%=root%>/views/board/afterBoard/afterBoardDetail.jsp">
                        <img src="<%=root%>/resources/img/main/러버덕.jpg">후기게시판 리스트
                    </a>
                    <div class="list-info">no | user08 | 2022-10-17 |
                        <div class="view">
                            <img src="<%=root%>/resources/img2/View.svg">
                        </div>150
                    </div>
                </div>
                <div class="board-photo">
                    <a href="<%=root%>/views/board/afterBoard/afterBoardDetail.jsp">
                        <img src="<%=root%>/resources/img/main/러버덕.jpg">후기게시판 리스트
                    </a>
                    <div class="list-info">no | user08 | 2022-10-17 |
                        <div class="view">
                            <img src="<%=root%>/resources/img2/View.svg">
                        </div>150
                    </div>
                </div>
                <div class="board-photo">
                    <a href="<%=root%>/views/board/afterBoard/afterBoardDetail.jsp">
                        <img src="<%=root%>/resources/img/main/러버덕.jpg">후기게시판 리스트
                    </a>
                    <div class="list-info">no | user08 | 2022-10-17 |
                        <div class="view">
                            <img src="<%=root%>/resources/img2/View.svg">
                        </div>150
                    </div>
                </div>
                <div class="board-photo">
                    <a href="<%=root%>/views/board/afterBoard/afterBoardDetail.jsp">
                        <img src="<%=root%>/resources/img/main/러버덕.jpg">후기게시판 리스트
                    </a>
                    <div class="list-info">no | user08 | 2022-10-17 |
                        <div class="view">
                            <img src="<%=root%>/resources/img2/View.svg">
                        </div>150
                    </div>
                </div>
            </div>



            <div class="board-list">
                <div class="board-photo">
                    <a href="<%=root%>/views/board/afterBoard/afterBoardDetail.jsp">
                        <img src="<%=root%>/resources/img/main/러버덕.jpg">후기게시판 리스트
                    </a>
                    <div class="list-info">no | user08 | 2022-10-17 |
                        <div class="view">
                            <img src="<%=root%>/resources/img2/View.svg">
                        </div>150
                    </div>
                </div>
                <div class="board-photo">
                    <a href="<%=root%>/views/board/afterBoard/afterBoardDetail.jsp">
                        <img src="<%=root%>/resources/img/main/러버덕.jpg">후기게시판 리스트
                    </a>
                    <div class="list-info">no | user08 | 2022-10-17 |
                        <div class="view">
                            <img src="<%=root%>/resources/img2/View.svg">
                        </div>150
                    </div>
                </div>
                <div class="board-photo">
                    <a href="<%=root%>/views/board/afterBoard/afterBoardDetail.jsp">
                        <img src="<%=root%>/resources/img/main/러버덕.jpg">후기게시판 리스트
                    </a>
                    <div class="list-info">no | user08 | 2022-10-17 |
                        <div class="view">
                            <img src="<%=root%>/resources/img2/View.svg">
                        </div>150
                    </div>
                </div>
                <div class="board-photo">
                    <a href="<%=root%>/views/board/afterBoard/afterBoardDetail.jsp">
                        <img src="<%=root%>/resources/img/main/러버덕.jpg">후기게시판 리스트
                    </a>
                    <div class="list-info">no | user08 | 2022-10-17 |
                        <div class="view">
                            <img src="<%=root%>/resources/img2/View.svg">
                        </div>150
                    </div>
                </div>
            </div>
            <div id="page">< 1 2 3 4 5 6 7 8 9 10 ></div>
            <div id="search">
                <div>
                    <select name="board-search" form="">
                        <option value="title">제목</option>
                        <option value="content">내용</option>
                        <option value="writer">작성자</option>
                    </select>
                </div>
                <div><input type="text"></div>
                <div id="search-icon"><img src="<%=root%>/resources/img2/Vector.svg"></div>
            </div>
        </div>
        <div id="footer">
            <%@ include file="/views/common/footer.jsp" %>
        </div>
    </div>
</body>
</html>