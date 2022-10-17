<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>쓰다쓰담 메인</title>

    <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />
    <link rel="stylesheet" href="main.css?after" type="text/css">

</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
    <div class=topBtn onclick="window.scrollTo(0,0);">TOP</div>
    <nav>
        <div class="head-slider hs1">
            <div class="head-slider-in">
                <div class="ment1">지금 내 상태가 궁금하다면</div>
                <div class="ment2">스트레스 테스트하기</div>
                <div class="justGo">바로가기 ></div>
                <div class="head-slider-img"><img src="<%=root%>/resources/img/main/물음표.png"></div>
            </div>
        </div>
        <div class="head-slider hs2">
            <div class="head-slider-in">
                <div class="ment1">지금 당장 힐링이 필요해</div>
                <div class="ment2">힐링하러 가기</div>
                <div class="justGo">바로가기 ></div>
                <div class="head-slider-img"><img src="<%=root%>/resources/img/main/자연.png"></div>
            </div>
        </div>
        <div class="head-slider hs3">
            <div class="head-slider-in">
                <div class="ment1">상담이 필요한 순간</div>
                <div class="ment2">전문가와 상담하기</div>
                <div class="justGo">바로가기 ></div>
                <div class="head-slider-img"><img src="<%=root%>/resources/img/main/상담하트.png"></div>
            </div>
        </div>
        <div class="head-slider hs4">
            <div class="head-slider-in">
                <div class="ment1">다른 사람들이 궁금하다면</div>
                <div class="ment2">게시판 보러가기</div>
                <div class="justGo">바로가기 ></div>
                <div class="head-slider-img"><img src="<%=root%>/resources/img/main/게시판.png"></div>
            </div>
        </div>
        <div class="head-slider hs5">
            <div class="head-slider-in">
                <div class="ment1">필요하신게 있으신가요?</div>
                <div class="ment2">고객센터에 물어보세요</div>
                <div class="justGo">바로가기 ></div>
                <div class="head-slider-img"><img src="<%=root%>/resources/img/main/큐와에이.png"></div>
            </div>
        </div>
        
        
    </nav>
    <main>
        <article>
            <div class="little-menu">힐링하기</div>
            <div class="healing">
                <div class="healing-box">
                    <div class="healing-box-front">
                        <img class="healing-img" src="<%=root%>/resources/img/main/혼카페.jpg">
                        <div class="healing-title">먹으면서 힐링</div>
                        <div class="healing-content">혼밥 · 카페 · 혼술</div>
                        <div class="healing-box-back">혼자서 냠냠</div>
                    </div>                                      
                </div>               
                <div class="healing-box">
                    <div class="healing-box-front">
                        <img class="healing-img" src="<%=root%>/resources/img/main/산책로.jpg">
                        <div class="healing-title">여기저기 힐링</div>
                        <div class="healing-content">문화 · 운동 · 산책</div>
                        <div class="healing-box-back">밖에서 뚜벅뚜벅</div>
                    </div> 
                </div>
                <div class="healing-box">
                    <div class="healing-box-front">
                        <img class="healing-img" src="<%=root%>/resources/img/main/집뒹굴.jpg">
                        <div class="healing-title">이것저것 힐링</div>
                        <div class="healing-content">음악 · 명상 · 독서 · 영화</div>
                        <div class="healing-box-back">안에서 뒹굴뒹굴</div>
                    </div> 
                </div>
                
            </div>
        </article>
        <article>
            <div class="little-menu">후기게시판</div>
            <div class="the-more">더보기</div>
            <div class="slider-review">
                <div class="slider-box">
                    <div class="review-img"><img src="<%=root%>/resources/img/main/샘플1.jpg"></div>
                    <div class="review-content">너와 함께한 시간</div>
                </div>
                <div class="slider-box">
                    <div class="review-img"><img src="<%=root%>/resources/img/main/샘플2.jpg"></div>
                    <div class="review-content">모든 날이 눈부셨다</div>
                </div>
                <div class="slider-box">
                    <div class="review-img"><img src="<%=root%>/resources/img/main/샘플3.jpg"></div>
                    <div class="review-content">날이 좋아서</div>
                </div>
                <div class="slider-box">
                    <div class="review-img"><img src="<%=root%>/resources/img/main/샘플4.jpg"></div>
                    <div class="review-content">날이 좋지 않아서</div>
                </div>
                <div class="slider-box">
                    <div class="review-img"><img src="<%=root%>/resources/img/main/샘플5.jpg"></div>
                    <div class="review-content">날이 적당해서</div>
                </div>
                <div class="slider-box">
                    <div class="review-img"><img src="<%=root%>/resources/img/main/샘플6.jpg"></div>
                    <div class="review-content">모든 날이 좋았다</div>
                </div>                
                <div class="slider-box">
                    <div class="review-img"><img src="<%=root%>/resources/img/main/샘플7.jpg"></div>
                    <div class="review-content">심장이</div>
                </div>
                <div class="slider-box">
                    <div class="review-img"><img src="<%=root%>/resources/img/main/샘플8.jpg"></div>
                    <div class="review-content">하늘에서 땅까지 아찔한</div>
                </div>
                <div class="slider-box">
                    <div class="review-img"><img src="<%=root%>/resources/img/main/샘플9.jpg"></div>
                    <div class="review-content">진자운동을 계속하였다</div>
                </div>
                <div class="slider-box">
                    <div class="review-img"><img src="<%=root%>/resources/img/main/샘플10.jpg"></div>
                    <div class="review-content">첫사랑이었다</div>
                </div>
                
            </div>
            </div>
        </article>
        <article>
            <div class="little-menu">전문가 상담</div>
            <div class="the-more">더보기</div>
            <div class="slider-counseling">             
                <div class="slider-box">
                    <div class="counseling-box-img"><img src="<%=root%>/resources/img/main/심원용.jpg"></div>
                    <div class="counseling-box-content">코딩 전문 상담가</div>
                    <div class="counseling-box-name">심원용</div>
                    <div class="counseling-box-star">평점 : ★★★★★</div>
                </div>
                <div class="slider-box">
                    <div class="counseling-box-img"><img src="<%=root%>/resources/img/main/오은영.jpg"></div>
                    <div class="counseling-box-content">육아 전문 상담가</div>
                    <div class="counseling-box-name">오은영</div>
                    <div class="counseling-box-star">평점 : ★★★★★</div>
                </div>
                <div class="slider-box">
                    <div class="counseling-box-img"><img src="<%=root%>/resources/img/main/아이유.jpg"></div>
                    <div class="counseling-box-content">감성 전문 상담가</div>
                    <div class="counseling-box-name">아이유</div>
                    <div class="counseling-box-star">평점 : ★★★★★</div>
                </div>
                <div class="slider-box">
                    <div class="counseling-box-img"><img src="<%=root%>/resources/img/main/유재석.jpg"></div>
                    <div class="counseling-box-content">방송 전문 상담가</div>
                    <div class="counseling-box-name">유재석</div>
                    <div class="counseling-box-star">평점 : ★★★★★</div>
                </div>
                <div class="slider-box">
                    <div class="counseling-box-img"><img src="<%=root%>/resources/img/main/김민지.jpg"></div>
                    <div class="counseling-box-content">쿠키 전문 상담가</div>
                    <div class="counseling-box-name">민지</div>
                    <div class="counseling-box-star">평점 : ★★★★★</div>
                </div>
                <div class="slider-box">
                    <div class="counseling-box-img"><img src="<%=root%>/resources/img/main/임영웅.jpg"></div>
                    <div class="counseling-box-content">부모님 전문 상담가</div>
                    <div class="counseling-box-name">임영웅</div>
                    <div class="counseling-box-star">평점 : ★★★★★</div>
                </div>
                <div class="slider-box">
                    <div class="counseling-box-img"><img src="<%=root%>/resources/img/main/장원영.jpg"></div>
                    <div class="counseling-box-content">다이빙 전문 상담가</div>
                    <div class="counseling-box-name">장원영</div>
                    <div class="counseling-box-star">평점 : ★★★★★</div>
                </div>
                <div class="slider-box">
                    <div class="counseling-box-img"><img src="<%=root%>/resources/img/main/러버덕.jpg"></div>
                    <div class="counseling-box-content">러버덕</div>
                    <div class="counseling-box-name">러버덕</div>
                    <div class="counseling-box-star">평점 : ★★★★★</div>
                </div>              
                <div class="slider-box">
                    <div class="counseling-box-img"><img src="<%=root%>/resources/img/main/오박사.png"></div>
                    <div class="counseling-box-content">포켓몬 전문 상담가</div>
                    <div class="counseling-box-name">오박사</div>
                    <div class="counseling-box-star">평점 : ★★★★★</div>
                </div>
                <div class="slider-box">
                    <div class="counseling-box-img"><img src="<%=root%>/resources/img/main/주호민.png"></div>
                    <div class="counseling-box-content">재즈 전문 상담가</div>
                    <div class="counseling-box-name">주호민</div>
                    <div class="counseling-box-star">평점 : ★★★★★</div>
                </div>
                <div class="slider-box">
                    <div class="counseling-box-img"><img src="<%=root%>/resources/img/main/강형욱.jpg"></div>
                    <div class="counseling-box-content">애견 전문 상담가</div>
                    <div class="counseling-box-name">강형욱</div>
                    <div class="counseling-box-star">평점 : ★★★★★</div>
                </div>
            </div>
            </div>
        </article>
        <article>
            <div class="quote">
                <div class="slider-box-quote">
                    <img src="<%=root%>/resources/img/main/풍경 (1).jpg" alt="">
                    <pre class="quote-word">
                        삶은 실수투성이야, 
                        우리는 늘 실수를 하지.
                    </pre>
                </div>
                <div class="slider-box-quote">
                    <img src="<%=root%>/resources/img/main/풍경 (2).jpg" alt="">
                    <pre class="quote-word">
                        힘들 땐 무조건 내가 제일 힘든 것이다. 
                        그건 이기적인 게 아니다.
                    </pre>
                </div>
                <div class="slider-box-quote">
                    <img src="<%=root%>/resources/img/main/풍경 (3).jpg" alt="">
                    <pre class="quote-word">
                        흔들려도 좋으니 
                        꺾이지만 마라
                    </pre>
                </div>
                <div class="slider-box-quote">
                    <img src="<%=root%>/resources/img/main/풍경 (4).jpg" alt="">
                    <pre class="quote-word">
                        비록 아무도 과거로 돌아가 새 출발할 순 없지만, 
                        누구나 지금 시작해 새 엔딩을 만들 수 있다.
                    </pre>
                </div>
                <div class="slider-box-quote">
                    <img src="<%=root%>/resources/img/main/풍경 (5).jpg" alt="">
                    <pre class="quote-word">
                        달빛에 비치는 바다도 흔들릴 때 더 아름답다. 
                        찰랑일 때 더 빛난다 그대도 눈부시다.
                    </pre>
                </div>
                
            </div>
        </article>
    </main>
    <%@ include file="/views/common/footer.jsp" %>
    
    <script>
        $( document ).ready( function(){
            $( 'nav' ).slick({
                arrows: false,
                autoplay: true,
                autoplaySpeed: 1500,
                dots: true,
                infinite: true,
                speed: 300,
                slidesToShow: 1,
                adaptiveHeight: true,
                fade: true,
                speed:1700
            });
        });
        $( document ).ready( function(){
            $( '.slider-review' ).slick({
                autoplay: true,
                autoplaySpeed: 2000,
                slidesToShow: 4,
                slidesToScroll: 1,
            });
        });

        $( document ).ready( function(){
            $( '.slider-counseling' ).slick({
                slidesToShow: 3,
                slidesToScroll: 1,
                centerMode: true,
                arrows: true,
                dots: false,
                speed: 300,
                centerPadding: '20px',
                infinite: true,
                autoplaySpeed: 5000,
                autoplay: false
                
            });
        });
        
        $( document ).ready( function(){
            $( '.quote' ).slick({
                dots:false,
                autoplay: false,
                autoplaySpeed: 5000,
                slidesToShow: 1,
                slidesToScroll: 1,
                fade : true,
                speed: 2000,
                arrows: false
            
            });
        });
    </script>
</body>
</html>