<%@page import="com.kh.sseudam.healing.vo.HealingVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<HealingVo> insideList = (List<HealingVo>) request.getAttribute("insideList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뒹굴뒹굴</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/healing/healing.css"
	type="text/css">

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
			<div>< 뚜벅뚜벅</div>
			<div>냠냠 ></div>
		</section>
		<section class="order-by">
			<div>저장순</div>
			<div>최근등록순</div>
			<div>기본정렬</div>
		</section>
		<section class="contents">
			<%
			int i = 0;
			for (i = 0; i < insideList.size(); i++) {
			%>
			<article>
				<div class="healing-heart">
					<img src="<%=root%>/resources/img/healing/하트.png"><%=insideList.get(i).getLiked()%>
				</div>
				<div class="healing-pic-outline">
					<script></script>
					<a class="pop-open" href="javascript:openPop(<%=i%>)"> <img
						class="healing-pic"
						src="<%=root%>/resources/upload/<%=insideList.get(i).getImgPath()%>">
						<div class="healing-name"><%=insideList.get(i).getType()%></div>
					</a>
				</div>
			</article>

			<div class="popup_layer" id="pop<%=i%>">
				<div class="popup_box h1">
					<div class="popup_head">
						<a class="pop-close" href="javascript:closePop(<%=i%>)" alt="">x</a>
					</div>
					<div class="popup_body inside-color">
						<div class="popup_pic">
							<img
								src="<%=root%>/resources/upload/<%=insideList.get(i).getImgPath()%>">
						</div>
						<div class="popup_name"><%=insideList.get(i).getTitle()%></div>

					</div>
					<div class="popup_detail">
						<div>
							<img class="imti" src="<%=root%>/resources/img/healing/사람.png"><%=insideList.get(i).getInfo1()%>
						</div>
						<div>
							<img class="imti" src="<%=root%>/resources/img/healing/책.png"><%=insideList.get(i).getInfo2()%>
						</div>
						<div>
							<img class="imti" src="<%=root%>/resources/img/healing/돋보기.png">
							<a class="detail-link" href="<%=insideList.get(i).getLink()%>">더
								알아보기</a>
						</div>
						<div>
							<img class="imti"
								src="<%=root%>/resources/img/header/Favorite_duotone.png" alt="">저장하기
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
		<section class="page">
			<div><</div>
			<div>1</div>
			<div>2</div>
			<div>3</div>
			<div>4</div>
			<div>5</div>
			<div>></div>
		</section>
	</main>
	<%@ include file="/views/common/footer.jsp"%>


	<script>
		// 팝업

			function openPop(i) {
				document.getElementById("pop"+i).style.display = "block";
			}
			function closePop(i) {
				document.getElementById("pop"+i).style.display = "none";
			}

	</script>





</body>
</html>