<%@page import="com.kh.sseudam.member.vo.MemberVo"%>
<%@page import="com.kh.sseudam.common.PageVo"%>
<%@page import="com.kh.sseudam.healing.vo.HealingVo"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<HealingVo> list = (List<HealingVo>) request.getAttribute("insideList");
	PageVo pv = (PageVo)request.getAttribute("pv");
	String sort = (String)request.getAttribute("sort");
	String type = (String)request.getAttribute("type");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뒹굴뒹굴</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/healing/healing.css"
	type="text/css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">

</head>

<body>
	<%@ include file="/views/common/header.jsp"%>
	<div class=topBtn onclick="window.scrollTo(0,0);">TOP</div>
	<nav class="inside-color">
		<div class="head-in">
			<div class="ment1">밖은 좀 시끄러우니까</div>
			<div class="ment2">안에서 뒹굴뒹굴</div>
			<div class="head-slider-img">
				<img src="<%=root%>/resources/img/healing/침대.png">
			</div>
		</div>
	</nav>
	<main>
		<section class="other-healing">
			<a href="<%=root%>/healing/outside"><div>< 뚜벅뚜벅</div></a>
			<a href="<%=root%>/healing/nyam"><div>냠냠 ></div></a>
		</section>
		<section class="order-by">
			<div class="order-by-type">
				<div class="order-drop">
					<button class="order-btn">뒹굴</button>
					<div class="order-drop-content">
						<a href="<%=root%>/healing/inside?pno=1&type=music">음악</a>
						<a href="<%=root%>/healing/inside?pno=1&type=movie">영화</a>
						<a href="<%=root%>/healing/inside?pno=1&type=therapy">명상</a>
						<a href="<%=root%>/healing/inside?pno=1&type=book">독서</a>
					</div>
				</div>
			</div>
		
			<div class="order-by-type">
				<a href="<%=root%>/healing/inside?pno=1">
					<div>등록순</div>
				</a>
				<a href="<%=root%>/healing/inside?pno=1&sort=like"> 
					<div>저장순</div>
				</a>
				<a href="<%=root%>/healing/inside?pno=1&sort=title">
					<div>이름순</div>
				</a>
				<a href="<%=root%>/healing/inside?pno=1&sort=random">
					<div>무작위순</div>
				</a>
			</div>
					
		</section>
		<section class="contents">
			<%
			for (int i = 0; i < list.size(); i++) {
				String no = list.get(i).getNo();
				String cnt = list.get(i).getLiked();
				String memberLike = list.get(i).getMemberLike();				
			%>
			<article>
			<%
			if(loginMember != null){
				String mNo = loginMember.getNo();
			%>
				<a class="like-btn" href="javascript:likeBtn(<%=no%>,<%=i%>,<%=mNo%>)">
			<%}else{ %>
				<a class="popup-btn" onclick="loginPopup(true)">
			<%} %>
					<%if(memberLike.equals("0")){%>
						<div class="healing-heart inside-heart<%=i%>">
							<img src="<%=root%>/resources/img/healing/하트.png">
							<div class="like-count<%=i%> like-cnt"><%=cnt%></div>
						</div>
					<%}else{ %>
						<div class="healing-heart inside-heart  inside-heart<%=i%>">
							<img src="<%=root%>/resources/img/healing/하트.png">
							<div class="like-count<%=i%> like-cnt"><%=cnt%></div>						
						</div>
					<%} %>
				</a>
				<div class="healing-pic-outline">
					<a class="pop-open" href="javascript:openPop(<%=i%>)"> 
						<img class="healing-pic" src="<%=root%>/resources/upload/inside/<%=list.get(i).getImgPath()%>">
						<div class="healing-name"><%=list.get(i).getcNum()%></div>
					</a>
				</div>
			</article>

			<div class="popup_layer" id="pop<%=i%>">
				<div class="popup_box h1">
					<div class="popup_head">
						<a class="pop-close" href="javascript:closePop(<%=i%>)">x</a>
					</div>
					<div class="popup_body inside-color">
						<div class="popup_pic">
							<img src="<%=root%>/resources/upload/inside/<%=list.get(i).getImgPath()%>">
						</div>
						<div class="popup_name"><%=list.get(i).getcNum()%></div>

					</div>
					<div class="popup_detail">
						<div>
							<img class="imti" src="<%=root%>/resources/img/healing/책.png"><%=list.get(i).getTitle()%>
						</div>
						<div>
							<img class="imti" src="<%=root%>/resources/img/healing/사람.png"><%=list.get(i).getInfoA()%>
						</div>
						<div>
							<img class="imti" src="<%=root%>/resources/img/healing/내용.png"><%=list.get(i).getInfoB()%>
						</div>
						<div>
							<img class="imti" src="<%=root%>/resources/img/healing/돋보기.png">
							<a class="detail-link" href="<%=list.get(i).getLink()%>">더 알아보기</a>
						</div>

					</div>
					<div class="diagonal-1-1 inside-border-color"></div>
					<div class="diagonal-1-2"></div>
					<div class="diagonal-2-1 inside-border-color"></div>
					<div class="diagonal-2-2"></div>

				</div>
			</div>
			
			<%
			}
			%>
		</section>
		<%
			String nowPage = (String)request.getQueryString();
			int pi = 0;
			int pageNum = 1;
			if(nowPage != null){
				pi = nowPage.indexOf("pno");
				pageNum = Integer.parseInt(nowPage.substring(pi+4, pi+5));
			}		
		%>

		
		<section class="page">
			<%if(pv.getStartPage() != 1){ %>	        
				<div>
			        	<a class="other-pages" href="<%=root%>/healing/inside?pno=<%=pv.getStartPage() - 1 %><%=sort%><%=type%>"><</a>        
				</div>
        	<%} %>  
			<% 
				for(int j = pv.getStartPage(); j<=pv.getEndPage() ;j++){
			%>
				<div>
						<%if(pageNum == j){%>	
			            	<a class="current-page" >
		            	<%}else{ %>
		            		<a href="<%=root%>/healing/inside?pno=<%=j%><%=sort%><%=type%>" class="other-pages" >
		            	<%}%> <%=j %>
	           				</a> 
				</div>			
	        <%} %>
			<%if(pv.getEndPage() != pv.getMaxPage()){ %>	        
				<div>
		        	<a class="other-pages" href="<%=root%>/healing/inside?pno=<%=pv.getEndPage() + 1 %><%=sort%><%=type%>">></a>        
	        	</div>
        	<%} %>
		</section>
		
	</main>
	<%@ include file="/views/common/footer.jsp"%>


	<script type="text/javascript">
		// 팝업
		function openPop(i) {
			document.getElementById("pop"+i).style.display = "block";
		}
		function closePop(i) {
			document.getElementById("pop"+i).style.display = "none";
		}

	</script>
	
	<script type="text/javascript">
		
		function likeBtn(no,i,mNo){

			const root = "${pageContext.request.contextPath}";
			
			$.ajax({
				url: root+"/healing/insideLike",
                type: "post",
                data: 
                {
                    "no": no,
                    "mNo" : mNo
                },
                dataType : "json",
                success : function(x){                	
                	
                	const check = x.likeCheck;
                	const count = x.likeCount;
         	
                	if(check == 0){               		
                		$('.like-count'+i).text(count);
                		$('.inside-heart'+i).css("border-color","#b1d39b");
                	}else{
                		$('.like-count'+i).text(count);
                		$('.inside-heart'+i).css("border-color","rgb(221, 221, 221)");
                	}
                	
				},
				error : function(){
					alert("에러발생");
				}
            });
		}

	</script>
	
</body>
</html>