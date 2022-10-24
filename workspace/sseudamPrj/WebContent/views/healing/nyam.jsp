<%@page import="java.util.List"%>
<%@page import="com.kh.sseudam.member.vo.MemberVo"%>
<%@page import="com.kh.sseudam.common.PageVo"%>
<%@page import="com.kh.sseudam.healing.vo.HealingVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<HealingVo> list = (List<HealingVo>) request.getAttribute("nyamList");
	PageVo pv = (PageVo)request.getAttribute("pv");
	String sort = (String)request.getAttribute("sort");
%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>냠냠</title>

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
	<%@ include file="/views/common/header.jsp" %>
	<div class=topBtn onclick="window.scrollTo(0,0);">TOP</div>
	<nav class="nyam-color">
        <div class="head-in">
			<div class="ment1">식사는 잡쉈어?</div>
			<div class="ment2">혼자서 냠냠</div>
			<div class="head-slider-img">
				<img src="<%=root%>/resources/img/healing/냠냠.png">
				</div>
        </div>
	</nav>
	
	<main>
		<section class="other-healing">
			<a href="<%=root%>/healing/outside"><div>< 뚜벅뚜벅</div></a>
			<a href="<%=root%>/healing/inside"><div>뒹굴뒹굴 ></div></a>
		</section>
		<section class="order-by">
			<a href="<%=root%>/healing/nyam?pno=1&sort=random">
			<div>무작위정렬</div>
			</a>
			<a href="<%=root%>/healing/nyam?pno=1&sort=like"> 
			<div>저장순</div>
			</a>
			<a href="<%=root%>/healing/nyam?pno=1&sort=title">
			<div>이름순</div>
			</a>
			<a href="<%=root%>/healing/nyam?pno=1">
			<div>최근등록순</div>
			</a>
		</section>
		<section class="contents">
			<%
			for (int i = 0; i < list.size(); i++) {
				String no = list.get(i).getNo();
				String cnt = list.get(i).getLiked();
				String memberLike = list.get(i).getMemberLike();
			%>
			<article>
			<% if(loginMember != null){
				String mNo = loginMember.getNo();
			%>
				<a class="like-btn" href="javascript:likeBtn(<%=no%>,<%=i%>,<%=mNo%>)">
			<%}else{ %>
				<a class="popup-btn" onclick="loginPopup(true)">
			<%} %>
					<%if(memberLike.equals("0")){%>
						<div class="healing-heart nyam-heart<%=i%>">
							<img src="<%=root%>/resources/img/healing/하트.png">
							<div class="like-count<%=i%> like-cnt"><%=cnt%></div>
						</div>
					<%}else{ %>
						<div class="healing-heart nyam-heart  nyam-heart<%=i%>">
							<img src="<%=root%>/resources/img/healing/하트.png">
							<div class="like-count<%=i%> like-cnt"><%=cnt%></div>						
						</div>
					<%} %>
				</a>
				<div class="healing-pic-outline">
					<script></script>
					<a class="pop-open" href="javascript:openPop(<%=i%>)"> 
						<img class="healing-pic" src="<%=root%>/resources/upload/nyam/<%=list.get(i).getImgPath()%>">
						<div class="healing-name"><%=list.get(i).getcNum()%></div>
					</a>
				</div>
			</article>
			
			<div class="popup_layer" id="pop<%=i%>">
				<div class="popup_box h1">
					<div class="popup_head">
						<a class="pop-close" href="javascript:closePop(<%=i%>)">x</a>
					</div>
					<div class="popup_body nyam-color">				
						<div class="popup_pic">
							<img src="<%=root%>/resources/upload/nyam/<%=list.get(i).getImgPath()%>">
						</div>
						<div class="popup_name">어느 카페</div>				
					</div>
					<div class="popup_detail">
					
						<div>
							<img class="imti" src="<%=root%>/resources/img/healing/책.png"><%=list.get(i).getTitle()%>
						</div>
						<div>
							<img class="imti" src="<%=root%>/resources/img/healing/주소.png"><%=list.get(i).getInfoA()%>
						</div>
						<div>
							<img class="imti" src="<%=root%>/resources/img/healing/전화.png"><%=list.get(i).getInfoB()%>
						</div>
						<div>
							<img class="imti" src="<%=root%>/resources/img/healing/돋보기.png">
							<a class="detail-link" href="<%=list.get(i).getLink()%>">더 알아보기</a>
						</div>		
											
					</div>
					<div class="diagonal-1-1 nyam-border-color"></div>
					<div class="diagonal-1-2"></div>
					<div class="diagonal-2-1 nyam-border-color"></div>
					<div class="diagonal-2-2"></div>
				
				</div>
			</div>
			
		<%}%>
		</section>
			
		<section class="page">
			<%if(pv.getStartPage() != 1){ %>	        
				<div>
			        	<a href="<%=root%>/healing/nyam?pno=<%=pv.getStartPage() - 1 %><%=sort%>"><</a>        
				</div>
        	<%} %>  
			<% for(int j = pv.getStartPage(); j<=pv.getEndPage() ;j++){%>
				<div class="current-page">
			            <a href="<%=root%>/healing/nyam?pno=<%=j %><%=sort%>"><%=j %></a> 
				</div>			
	        <%} %>
			<%if(pv.getEndPage() != pv.getMaxPage()){ %>	        
				<div>
		        	<a href="<%=root%>/healing/nyam?pno=<%=pv.getEndPage() + 1 %><%=sort%>">></a>        
	        	</div>
        	<%} %>
		</section>
	</main>
	<%@ include file="/views/common/footer.jsp" %>
	
	

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
				url: root+"/healing/nyamLike",
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
                		$('.nyam-heart'+i).css("border-color","#CBA0AE");
                	}else{
                		$('.like-count'+i).text(count);
                		$('.nyam-heart'+i).css("border-color","rgb(221, 221, 221)");
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