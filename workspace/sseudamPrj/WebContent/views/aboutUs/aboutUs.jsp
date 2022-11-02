<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소개 :: 쓰담쓰담</title>
<link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" /> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main/aboutUs.css" type="text/css">
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<div class="whole-line">
    <div class="bg-img"><img src="<%=root%>/resources/img/aboutUs/소개페이지 메인.jpg" alt=""></div>

    <main class="main-center">
        <div class="ment">
            <div class="ment-title">지치고 힘든 나를 위해 '쓰담쓰담'</div>
            <div class="ment-content">
                <p>인간 관계, 학업 문제, 업무 스트레스...</p>
                <p>지친 현대사회인을 위한 힐링 프로젝트</p>
                <p>남의 눈치 안보고 나혼자 편하게</p>
                <p>오직 나만을 위한 다양한 힐링 방법 제시</p>
            </div>
        </div>
        <nav>
            <article>힐링하기</article>
            <article>상담하기</article>
            <article>공유하기</article>
        </nav>
        <section>
            <article class="art1">
                <img src="<%=root%>/resources/img/aboutUs/힐링사진.jpg" alt="">
            </article>
            <article class="art2">
                <div class="us-title">힐링하기</div>
                <div class="us-content">
                    <p>먹으면서, 놀면서, 쉬면서</p>
                    <p>힐링하기 좋은곳 추천</p>
                    <p>나만의 맞춤 힐링방법 제시</p>
                </div>
            </article>
            <article class="art3">
                <div class="us-title">상담하기</div>
                <div class="us-content">
                    <p>전문가와의 1:1 매칭</p>
                    <p>상담을 통한 치유</p>
                    <p>온, 오프라인 편리한 소통</p>
                </div>
            </article>
            <article class="art4">
                <img src="<%=root%>/resources/img/aboutUs/상담사진.jpg" alt="">
            </article>
            <article class="art5">
                <img src="<%=root%>/resources/img/aboutUs/공유사진.jpg" alt="">
            </article>
            <article class="art6">
                <div class="us-title">공유하기</div>
                <div class="us-content">
                    <p>다른 사람들과의 소통</p>
                    <p>서로 다른 힐링 방식 공유</p>
                    <p>나의 힐링방식 추천</p>
                </div>
            </article>
        </section>
    </main>
</div>


<%@ include file="/views/common/footer.jsp" %>
</body>
</html>