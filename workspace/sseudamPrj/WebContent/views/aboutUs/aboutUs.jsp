<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쓰담쓰담 소개</title>
<link rel="stylesheet" href="aboutUs.css?after" type="text/css">
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<div class="whole-line">
    <div class="bg-img"><img src="<%=root%>/resources/img/aboutUs/소개페이지 메인.jpg" alt=""></div>

    <main class="main-center">
        <div class="ment">지치고 힘든 나를 위해</div>
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
                <div class="us-content">힐링하기 좋은곳</div>
            </article>
            <article class="art3">
                <div class="us-title">상담하기</div>
                <div class="us-content">상담하기 좋은곳</div>
            </article>
            <article class="art4">
                <img src="<%=root%>/resources/img/aboutUs/상담사진.jpg" alt="">
            </article>
            <article class="art5">
                <img src="<%=root%>/resources/img/aboutUs/공유사진.jpg" alt="">
            </article>
            <article class="art6">
                <div class="us-title">공유하기</div>
                <div class="us-content">공유하기 좋은곳</div>
            </article>
        </section>
    </main>
</div>


<%@ include file="/views/common/footer.jsp" %>
</body>
</html>