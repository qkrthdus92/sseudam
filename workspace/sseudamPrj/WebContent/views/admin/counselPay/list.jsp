<%@page import="com.kh.sseudam.admin.counselPay.vo.CounselPayVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.sseudam.common.PageVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<% 

	String root1 = request.getContextPath();
	String pno = (String)request.getAttribute("pno");
	String status = (String)request.getAttribute("status");
	String search = (String)request.getAttribute("search");
	String searchType = (String)request.getAttribute("searchType");
	String startDate = (String)request.getAttribute("startDate");
	String endDate = (String)request.getAttribute("endDate");
	String range = (String)request.getAttribute("range");
	PageVo pv = (PageVo)request.getAttribute("pv");
	String listCount = (String)request.getAttribute("listCount");
	List<CounselPayVo> list = (List<CounselPayVo>)request.getAttribute("list");
	
	boolean isSearchTypeAll = searchType.equals("memberInfo") || searchType.equals("proInfo") ;

%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>쓰담쓰담 관리자 | 상담 결제 내역</title>
    <link rel="shortcut icon" href="/sseudam/resources/img/header/logo2.png" />
    <link rel="stylesheet" href="<%=root1%>/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/common/variables.css?ver=3"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/counselPay/list.css?ver=1"
    />

    <style>
      .flex-start {
        justify-content: flex-start;
      }

      select[name="searchType"] {
        cursor: pointer;
        width: 100px;
        border: 1px solid #b0b0b0;
        padding: 0px 2px;
        font-size: 15px;
      }

      .flex {
        display: flex;
        align-items: center;
      }

      .total-num-info {
        margin-right: 30px;
      }

      #range {
        border: 2px solid rgb(191, 225, 206);
        padding-left: 15px;
        height: 20px;
        border-radius: 5px;
        font-size: 15px;
        cursor: pointer;
      }

      #range + span{
        margin-left: 3px;
       
        color: var(--main);
        font-size: 14px;
      }

      .counselPay-col {
        grid-template-columns: 0.9fr 1.5fr 1.5fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr 1fr;
      }

    </style>
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <form
        action="<%=root1%>/admin/counselPay/list"
        method="get"
        class="admin-counselPay-form"
      >
      <input type="text" class="hidden" name="pno" value="1">
        <header class="admin-main-header">
          <h1> <a
            href="<%=root%>/admin/counselPay/list?pno=1&search=&searchType=memberInfo&status=all&range="
            >상담 결제 내역</a
          ></h1>
        </header>
        <section class="admin-main-section">
          <div class="admin-main-section-top flex-start">
            <div class="admin-search">
              <input
                type="text"
                placeholder="이름 또는 아이디를 입력해주세요"
                name="search"
                onkeyup="if(window.event.keyCode==13){document.querySelector('.admin-counselPay-form').submit();}"
              />
              <i class="fa-solid fa-magnifying-glass "></i>
            </div>
            <select name="searchType" id="">
              <option value="memberInfo">회원정보</option>
              <option value="proInfo">전문가정보</option>
            </select>

            <!-- <div class="add-btn"><input type="button" value="게시글 작성" /></div> -->
          </div>
          <div class="admin-main-wrapper">
            <div class="admin-main-board-top">
              <div class="flex">
                <div class="total-num-info">
                  <span>전체 결제 내역</span><span><%= listCount %></span>
                </div>
                <div >
                  <input type="text" id="range" name="range" value="" />
                  <span>결제날짜 범위를 지정하세요</span> 
                </div>
              </div>
              <div class="main-select-btn">
                <select name="status" id="">
                  <option value="all">모든 상담 조회</option>
                  <option value="F">상담완료 조회</option>
                  <option value="C">상담대기 조회</option>
                </select>
              </div>
            </div>
            <script>
              const inputSearchIcon = document.querySelector(
                "input[name=search]+i"
              );
              const selectStatus = document.querySelector(
                "select[name=status]"
              );
              inputSearchIcon.addEventListener("click", function () {
                const inputSearchForm = document.querySelector(
                  ".admin-counselPay-form"
                );
                inputSearchForm.submit();
              });

              selectStatus.addEventListener("change", function () {
                const inputSearchForm = document.querySelector(
                  ".admin-counselPay-form"
                );
                inputSearchForm.submit();
              });
            </script>
             <script>
              console.log('되나용')
              //검색어, 검색타입, status 검색후에도 유지시키기
  
              //검색어
              const searchInput = document.querySelector('input[name=search]');
  
              const reqSearch = "<%= search%>";
             
              if('<%=search%>' != 'null') {
                searchInput.value = "<%= search%>";
              }
  
              //검색타입
  
              const searchTypeArr = document.querySelectorAll('select[name=searchType] option');
              const reqSearchType = "<%=searchType%>";
              for(let i=0; i<searchTypeArr.length; i++) {
                const x = searchTypeArr[i].value;
                if(x == reqSearchType) {
                  searchTypeArr[i].selected = true;
                }
              }
  
              //status
              const statusArr = document.querySelectorAll('select[name=status] option');
              const reqStatusType = "<%=status%>";
              for(let i=0; i<statusArr.length; i++) {
                const x = statusArr[i].value;
                if(x == reqStatusType) {
                  statusArr[i].selected = true;
                }
              }
  
             
            </script>
            <script>
              $(function () {
                $("#range").daterangepicker(
                  {
                    locale: {
                      format: "YYYY-MM-DD",
                      separator: " ~ ",
                      applyLabel: "확인",
                      cancelLabel: "취소",
                      fromLabel: "From",
                      toLabel: "To",
                      customRangeLabel: "Custom",
                      weekLabel: "W",
                      daysOfWeek: ["일", "월", "화", "수", "목", "금", "토"],
                      monthNames: [
                        "1월",
                        "2월",
                        "3월",
                        "4월",
                        "5월",
                        "6월",
                        "7월",
                        "8월",
                        "9월",
                        "10월",
                        "11월",
                        "12월",
                      ],
                    },
                    startDate: "<%=startDate%>",
                    endDate: "<%=endDate%>",

                    // drops: "auto",
                  },
                  function (start, end, label) {
                    console.log(
                      "New date range selected: " +
                        start.format("YYYY-MM-DD") +
                        " to " +
                        end.format("YYYY-MM-DD") +
                        " (predefined range: " +
                        label +
                        ")"
                    );
                  }
                );
              });
            </script>
            <div class="admin-main-board counselPay-col">
              <div>번호</div>
              <div>결제날짜</div>
              <div>상담날짜</div>
              <div>전문가아이디</div>
              <div>전문가이름</div>
              <div>회원아이디</div>
              <div>회원이름</div>
              <div>결제금액</div>
              <div>결제수단</div>
              <div>별점</div>
              <div>상담상태</div>

              <%for(int i=0; i<list.size(); i++) {%>
              <div><%=list.get(i).getNo() %></div>
              <div><%= list.get(i).getPayDate() %></div>
              <div><%= list.get(i).getAdviceDate().substring(0,10)%></div>
              <div><%= list.get(i).getProId() %></div>
              <div><%= list.get(i).getProName() %></div>
              <div><%= list.get(i).getMemberId() %></div>
              <div><%= list.get(i).getMemberName() %></div>
              <div><%= list.get(i).getPrice() %></div>
              <div><%= list.get(i).getPayway()%></div>
              <%if(list.get(i).getStar()!=null){ %>
              <div><%= list.get(i).getStar() %></div>
              <%}else { %>
              <div>-</div>
              <%} %>
              <div><%= list.get(i).getStatus()%></div>

              <%}%>
            </div>
            
            <!-- 1. 조회 -->
          	<% if(status.equals("all") && search.equals("") && isSearchTypeAll) { %>
	          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/counselPay/list?status=all&pno=<%=pv.getStartPage()-1 %>&searchType=memberInfo&search=&range=<%=range%>" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/counselPay/list?status=all&pno=<%=i %>&searchType=memberInfo&search=&range=<%=range%>" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/counselPay/list?status=all&pno=<%=pv.getEndPage()+1 %>&searchType=memberInfo&search=&range=<%=range%>" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
	          </div>
          	<%} %>
          	
          	<!-- 2. 조회 -->
          	<% if(status.equals("F") && search.equals("") && isSearchTypeAll) { %>
	          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/counselPay/list?status=F&pno=<%=pv.getStartPage()-1 %>&searchType=memberInfo&search=&range=<%=range%>" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/counselPay/list?status=F&pno=<%=i %>&searchType=memberInfo&search=&range=<%=range%>" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/counselPay/list?status=F&pno=<%=pv.getEndPage()+1 %>&searchType=memberInfo&search=&range=<%=range%>" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
	          </div>
          	<%} %>
          	
          	<!-- 3. 조회 -->
          	<% if(status.equals("C") && search.equals("") && isSearchTypeAll) { %>
	          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/counselPay/list?status=C&pno=<%=pv.getStartPage()-1 %>&searchType=memberInfo&search=&range=<%=range%>" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/counselPay/list?status=C&pno=<%=i %>&searchType=memberInfo&search=&range=<%=range%>" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/counselPay/list?status=C&pno=<%=pv.getEndPage()+1 %>&searchType=memberInfo&search=&range=<%=range%>" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
	          </div>
          	<%} %>
          	
          	<!-- 4. 조회 -->
          	<% if(status.equals("all") && !search.equals("") && searchType.equals("memberInfo")) { %>
	          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/counselPay/list?status=all&pno=<%=pv.getStartPage()-1 %>&searchType=memberInfo&search=<%=search %>&range=<%=range%>" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/counselPay/list?status=all&pno=<%=i %>&searchType=memberInfo&search=<%=search %>&range=<%=range%>" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/counselPay/list?status=all&pno=<%=pv.getEndPage()+1 %>&searchType=memberInfo&search=<%=search %>&range=<%=range%>" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
	          </div>
          	<%} %>
          	
          	<!-- 5. 조회 -->
          	<% if(status.equals("F") && !search.equals("") && searchType.equals("memberInfo")) { %>
	          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/counselPay/list?status=F&pno=<%=pv.getStartPage()-1 %>&searchType=memberInfo&search=<%=search %>&range=<%=range%>" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/counselPay/list?status=F&pno=<%=i %>&searchType=memberInfo&search=<%=search %>&range=<%=range%>" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/counselPay/list?status=F&pno=<%=pv.getEndPage()+1 %>&searchType=memberInfo&search=<%=search %>&range=<%=range%>" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
	          </div>
          	<%} %>
          	
          	<!-- 6. 조회 -->
          	<% if(status.equals("C") && !search.equals("") && searchType.equals("memberInfo")) { %>
	          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/counselPay/list?status=C&pno=<%=pv.getStartPage()-1 %>&searchType=memberInfo&search=<%=search %>&range=<%=range%>" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/counselPay/list?status=C&pno=<%=i %>&searchType=memberInfo&search=<%=search %>&range=<%=range%>" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/counselPay/list?status=C&pno=<%=pv.getEndPage()+1 %>&searchType=memberInfo&search=<%=search %>&range=<%=range%>" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
	          </div>
          	<%} %>
          	
          	<!-- 7. 조회 -->
          	<% if(status.equals("all") && !search.equals("") && searchType.equals("proInfo")) { %>
	          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/counselPay/list?status=all&pno=<%=pv.getStartPage()-1 %>&searchType=proInfo&search=<%=search %>&range=<%=range%>" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/counselPay/list?status=all&pno=<%=i %>&searchType=proInfo&search=<%=search %>&range=<%=range%>" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/counselPay/list?status=all&pno=<%=pv.getEndPage()+1 %>&searchType=proInfo&search=<%=search %>&range=<%=range%>" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
	          </div>
          	<%} %>
          	
          	<!-- 8. 조회 -->
          	<% if(status.equals("F") && !search.equals("") && searchType.equals("proInfo")) { %>
	          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/counselPay/list?status=F&pno=<%=pv.getStartPage()-1 %>&searchType=proInfo&search=<%=search %>&range=<%=range%>" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/counselPay/list?status=F&pno=<%=i %>&searchType=proInfo&search=<%=search %>&range=<%=range%>" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/counselPay/list?status=F&pno=<%=pv.getEndPage()+1 %>&searchType=proInfo&search=<%=search %>&range=<%=range%>" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
	          </div>
          	<%} %>
          	
          	<!-- 9. 조회 -->
          	<% if(status.equals("C") && !search.equals("") && searchType.equals("proInfo")) { %>
	          <div class="page-area">
	            <%if(pv.getStartPage()!=1) {%>
	            <a href="<%=root1%>/admin/counselPay/list?status=C&pno=<%=pv.getStartPage()-1 %>&searchType=proInfo&search=<%=search %>&range=<%=range%>" class=""><i class="fa-solid fa-angles-left counsel-paging-left"></i></a>
	            <%}%>
		        <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++) {%>
		          <a href="<%=root1%>/admin/counselPay/list?status=C&pno=<%=i %>&searchType=proInfo&search=<%=search %>&range=<%=range%>" class=""><span><%=i %></span></a>
		        <%}%>
		        <%if(pv.getEndPage() != pv.getMaxPage()) { %>
		         <a href="<%=root1%>/admin/counselPay/list?status=C&pno=<%=pv.getEndPage()+1 %>&searchType=proInfo&search=<%=search %>&range=<%=range%>" class=""><i class="fa-solid fa-angles-right counsel-paging-right"></i></a>
		        <%}%>
          
	          </div>
          	<%} %>
          </div>
        </section>
      </form>
    </main>

    <script
      type="text/javascript"
      src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"
    ></script>
    <script
      type="text/javascript"
      src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"
    ></script>
    <script
      type="text/javascript"
      src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"
    ></script>
    <link
      rel="stylesheet"
      type="text/css"
      href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"
    />
  </body>
</html>
