<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>냠냠</title>

<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="healing.css?after" type="text/css">
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<div class=topBtn onclick="window.scrollTo(0,0);">TOP</div>
	<nav class="nyam-color">
        <div class="head-in">
			<div class="ment1">식사는 잡쉈어?</div>
			<div class="ment2">혼자서 냠냠</div>
			<div class="head-slider-img"><img src="<%=root%>/resources/img/healing/냠냠.png"></div>
        </div>
	</nav>
	<main>
		<section class="other-healing">
			<div>< 뚜벅뚜벅</div>
			<div>뒹굴뒹굴 ></div>
		</section>
		<section class="order-by">
			<div>저장순</div>
			<div>최근등록순</div>
			<div>기본정렬</div>
		</section>
		<section class="contents">
			<article>
				<div class="healing-heart">
					<img src="<%=root%>/resources/img/healing/하트.png" alt="">20
				</div>
				<div class="healing-pic-outline">
					<a class="pop-open" href="javascript:openPop()" alt="">
						<img class="healing-pic" src="<%=root%>/resources/img/main/샘플1.jpg">
						<div class="healing-name">어떤 카페</div>					
					</a>	
				</div>			
			</article>
			<article>
				<div class="healing-heart">
					<img src="<%=root%>/resources/img/healing/하트.png" alt="">20
				</div>
				<div class="healing-pic-outline">
					<a class="pop-open" href="javascript:openPop()" alt="">
						<img class="healing-pic" src="<%=root%>/resources/img/main/샘플2.jpg">
						<div class="healing-name">어떤 카페</div>					
					</a>	
				</div>			
			</article>
			<article>
				<div class="healing-heart">
					<img src="<%=root%>/resources/img/healing/하트.png" alt="">20
				</div>
				<div class="healing-pic-outline">
					<a class="pop-open" href="javascript:openPop()" alt="">
						<img class="healing-pic" src="<%=root%>/resources/img/main/샘플3.jpg">
						<div class="healing-name">어떤 카페</div>					
					</a>	
				</div>			
			</article>
			<article>
				<div class="healing-heart">
					<img src="<%=root%>/resources/img/healing/하트.png" alt="">20
				</div>
				<div class="healing-pic-outline">
					<a class="pop-open" href="javascript:openPop()" alt="">
						<img class="healing-pic" src="<%=root%>/resources/img/main/샘플4.jpg">
						<div class="healing-name">어떤 카페</div>					
					</a>	
				</div>			
			</article>
			<article>
				<div class="healing-heart">
					<img src="<%=root%>/resources/img/healing/하트.png" alt="">20
				</div>
				<div class="healing-pic-outline">
					<a class="pop-open" href="javascript:openPop()" alt="">
						<img class="healing-pic" src="<%=root%>/resources/img/main/샘플5.jpg">
						<div class="healing-name">어떤 카페</div>					
					</a>	
				</div>			
			</article>
			<article>
				<div class="healing-heart">
					<img src="<%=root%>/resources/img/healing/하트.png" alt="">20
				</div>
				<div class="healing-pic-outline">
					<a class="pop-open" href="javascript:openPop()" alt="">
						<img class="healing-pic" src="<%=root%>/resources/img/main/샘플6.jpg">
						<div class="healing-name">어떤 카페</div>					
					</a>	
				</div>			
			</article>
			<article>
				<div class="healing-heart">
					<img src="<%=root%>/resources/img/healing/하트.png" alt="">20
				</div>
				<div class="healing-pic-outline">
					<a class="pop-open" href="javascript:openPop()" alt="">
						<img class="healing-pic" src="<%=root%>/resources/img/main/샘플7.jpg">
						<div class="healing-name">어떤 카페</div>					
					</a>	
				</div>			
			</article>
			<article>
				<div class="healing-heart">
					<img src="<%=root%>/resources/img/healing/하트.png" alt="">20
				</div>
				<div class="healing-pic-outline">
					<a class="pop-open" href="javascript:openPop()" alt="">
						<img class="healing-pic" src="<%=root%>/resources/img/main/샘플8.jpg">
						<div class="healing-name">어떤 카페</div>					
					</a>	
				</div>			
			</article>
			<article>
				<div class="healing-heart">
					<img src="<%=root%>/resources/img/healing/하트.png" alt="">20
				</div>
				<div class="healing-pic-outline">
					<a class="pop-open" href="javascript:openPop()" alt="">
						<img class="healing-pic" src="<%=root%>/resources/img/main/샘플9.jpg">
						<div class="healing-name">어떤 카페</div>					
					</a>	
				</div>			
			</article>
			
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
	<%@ include file="/views/common/footer.jsp" %>
	
	<div class="popup_layer" id="pop">
		<div class="popup_box h1">
			<div class="popup_head">
				<a class="pop-close" href="javascript:closePop()" alt="">x</a>
			</div>
			<div class="popup_body nyam-color">				
				<div class="popup_pic"><img src="<%=root%>/resources/img/main/샘플2.jpg"></div>
				<div class="popup_name">어느 카페</div>				
			</div>
			<div class="popup_detail">
				<div class="popup_addr">
					<img class="imti" src="<%=root%>/resources/img/healing/주소.png">서울시 구석구석 어딘가 350
				</div>
				<div class="popup_phone">
					<img class="imti" src="<%=root%>/resources/img/healing/전화.png">010-1212-1212
				</div>
				<div class="popup_link">
					<img class="imti" src="<%=root%>/resources/img/healing/돋보기.png">더 알아보기
				</div>
				<div class="popup_heart">
					<img class="imti" src="<%=root%>/resources/img/healing/하트.png" alt="">저장하기
				</div>							
			</div>
			<div class="diagonal-1-1 nyam-border-color"></div>
			<div class="diagonal-1-2"></div>
			<div class="diagonal-2-1 nyam-border-color"></div>
			<div class="diagonal-2-2"></div>
			
		</div>
	</div>

	<script>
		// 팝업
		function openPop() {
			document.getElementById("pop").style.display = "block";
		}
		function closePop() {
			document.getElementById("pop").style.display = "none";
		}
	</script>

</body>
</html>