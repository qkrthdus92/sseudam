<%@page import="com.kh.sseudam.common.PageVo"%> <%@page
import="com.kh.sseudam.counsel.pro.vo.ProVo"%> <%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <% String root1 = request.getContextPath();%> <%
List<ProVo>
  proList = (List<ProVo
    >)request.getAttribute("proList"); PageVo pv =
    (PageVo)request.getAttribute("pv"); String status =
    (String)request.getAttribute("status"); String search =
    (String)request.getAttribute("search"); String pno =
    (String)request.getAttribute("pno"); String listCount =
    (String)request.getAttribute("listCount"); %>
    <!DOCTYPE html>
    <html>
      <head>
        <meta charset="UTF-8" />
        <title>Insert title here</title>
        <link
          rel="stylesheet"
          href="<%=root1%>/resources/css/common/reset.css"
        />
        <link
          rel="stylesheet"
          href="<%=root1%>/resources/css/common/variables.css?ver=2"
        />
        <link
          rel="stylesheet"
          href="<%=root1%>/resources/css/admin/common/component.css"
        />
        <link
          rel="stylesheet"
          href="<%=root1%>/resources/css/admin/pro/list.css?ver=3"
        />
      </head>
      <body>
        <%@ include file="/views/admin/common/menu.jsp"%>
        <main class="admin-main">
          <header class="admin-main-header">
            <h1>
              <a href="<%=root%>/admin/pro/list?pno=1&status=all">전문가</a>
            </h1>
          </header>
          <section class="admin-main-section">
            <div class="admin-main-section-top">
              <form action="<%=root1%>/admin/pro/list" id="pro-search-form">
                <div class="admin-search">
                  <input type="hidden" name="pno" value="1" />
                  <input
                    type="text"
                    name="search"
                    onkeyup="if(window.event.keyCode==13){document.getElementById('pro-search-form').submit();}"
                    placeholder="전문가 이름 또는 아이디를 입력해주세요"
                  />
                  <i
                    class="fa-solid fa-magnifying-glass"
                    onclick="document.getElementById('pro-search-form').submit();"
                  ></i>
                </div>
              </form>

              <div class="add-btn">
                <input
                  type="button"
                  value="전문가 추가"
                  onclick="location.href='<%=root%>/admin/pro/add?&pno=<%=pno%>&status=<%=status%>'"
                />
              </div>
            </div>
            <div class="admin-main-wrapper">
              <div class="admin-main-board-top">
                <div class="total-num-info">
                  <span>전체 전문가</span><span><%= listCount %></span>
                </div>
                <form action="<%=root1%>/admin/pro/list" method="get">
                  <input type="hidden" name="pno" value="1" />
                  <div class="main-select-btn">
                    <select name="status" id="" onchange="this.form.submit();">
                      <% if(status.equals("all")) { %>
                      <option value="all" selected>모든 회원 조회</option>
                      <% }else { %>
                      <option value="all">모든 회원 조회</option>

                      <%} %> <% if(status.equals("W")) { %>
                      <option value="W" selected>승인대기 회원 조회</option>
                      <% }else { %>
                      <option value="W">승인대기 회원 조회</option>

                      <%} %> <% if(status.equals("J")) { %>
                      <option value="J" selected>승인완료 회원 조회</option>
                      <% }else { %>
                      <option value="J">승인완료 회원 조회</option>

                      <%} %> <% if(status.equals("Q")) { %>
                      <option value="Q" selected>탈퇴 회원 조회</option>
                      <% }else { %>
                      <option value="Q">탈퇴 회원 조회</option>

                      <%} %>
                    </select>
                  </div>
                </form>
              </div>
              <div class="admin-main-board">
                <div>번호</div>
                <div>이름</div>
                <div>성별</div>
                <div>아이디</div>
                <div>상담분야</div>
                <div>이메일</div>
                <div>전화번호</div>
                <div>최종학력</div>
                <div>상담금액</div>
                <div>계정상태</div>
                <div>상담현황</div>
                <div>edit</div>
                <%for(int i=0; i < proList.size(); i++) {%>
                <div><%= proList.get(i).getNo() %></div>
                <div><%= proList.get(i).getName() %></div>
                <% if(proList.get(i).getGender().equals("F")){ %>
                <div>여</div>
                <%}else { %>
                <div>남</div>
                <%} %>

                <div><%= proList.get(i).getId()%></div>
                <div><%= proList.get(i).getCounselType() %></div>
                <div><%= proList.get(i).getEmail() %></div>
                <div><%= proList.get(i).getPhone() %></div>
                <div><%= proList.get(i).getEducation() %></div>
                <% if(proList.get(i).getPrice() != null) {%>
                <div><%= proList.get(i).getPrice() %></div>
                <%}else { %>
                <div>미정</div>
                <%} %> <%if(proList.get(i).getProStatus().equals("J")) { %>
                <div>승인완료</div>
                <%} %> <%if(proList.get(i).getProStatus().equals("W")) { %>
                <div>승인대기</div>
                <%} %> <%if(proList.get(i).getProStatus().equals("Q")) { %>
                <div>탈퇴회원</div>
                <%} %>

                <div>
                  <a
                    href="<%=root%>/admin/pro/counsel?mno=<%=proList.get(i).getNo()%>&pno=<%=pno%>&status=<%=status%>"
                    ><i class="fa-solid fa-magnifying-glass"></i
                  ></a>
                </div>
                <div>
                  <a
                    href="<%=root%>/admin/pro/edit?mno=<%=proList.get(i).getNo()%>&pno=<%=pno%>&status=<%=status%>"
                    ><i class="fa-solid fa-pen-to-square"></i
                  ></a>
                </div>
                <%}%>
              </div>
              <div id="page-area">
                <% if(status.equals("all") && search == null) { %>
                <%if(pv.getStartPage()!=1) {%>
                <a
                  href="<%=root1%>/admin/pro/list?status=all&pno=<%=pv.getStartPage()-1 %>"
                  class="btn btn-primary btn-sm"
                  >이전</a
                >
                <%}%> <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++)
                {%>
                <a
                  href="<%=root1%>/admin/pro/list?status=all&pno=<%=i %>"
                  class="btn btn-primary btn-sm"
                  ><%=i %></a
                >
                <%}%> <%if(pv.getEndPage() != pv.getMaxPage()) { %>
                <a
                  href="<%=root1%>/admin/pro/list?status=all&pno=<%=pv.getEndPage()+1 %>"
                  class="btn btn-primary btn-sm"
                  >다음</a
                >
                <%}%> <%} %> <% if(status.equals("J") && search == null) { %>
                <%if(pv.getStartPage()!=1) {%>
                <a
                  href="<%=root1%>/admin/pro/list?status=J&pno=<%=pv.getStartPage()-1 %>"
                  class="btn btn-primary btn-sm"
                  >이전</a
                >
                <%}%> <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++)
                {%>
                <a
                  href="<%=root1%>/admin/pro/list?status=J&pno=<%=i %>"
                  class="btn btn-primary btn-sm"
                  ><%=i %></a
                >
                <%}%> <%if(pv.getEndPage() != pv.getMaxPage()) { %>
                <a
                  href="<%=root1%>/admin/pro/list?status=J&pno=<%=pv.getEndPage()+1 %>"
                  class="btn btn-primary btn-sm"
                  >다음</a
                >
                <%}%> <%} %> <% if(status.equals("W") && search == null) { %>
                <%if(pv.getStartPage()!=1) {%>
                <a
                  href="<%=root1%>/admin/pro/list?status=W&pno=<%=pv.getStartPage()-1 %>"
                  class="btn btn-primary btn-sm"
                  >이전</a
                >
                <%}%> <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++)
                {%>
                <a
                  href="<%=root1%>/admin/pro/list?status=W&pno=<%=i %>"
                  class="btn btn-primary btn-sm"
                  ><%=i %></a
                >
                <%}%> <%if(pv.getEndPage() != pv.getMaxPage()) { %>
                <a
                  href="<%=root1%>/admin/pro/list?status=W&pno=<%=pv.getEndPage()+1 %>"
                  class="btn btn-primary btn-sm"
                  >다음</a
                >
                <%}%> <%} %> <% if(status.equals("Q") && search == null) { %>
                <%if(pv.getStartPage()!=1) {%>
                <a
                  href="<%=root1%>/admin/pro/list?status=Q&pno=<%=pv.getStartPage()-1 %>"
                  class="btn btn-primary btn-sm"
                  >이전</a
                >
                <%}%> <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++)
                {%>
                <a
                  href="<%=root1%>/admin/pro/list?status=Q&pno=<%=i %>"
                  class="btn btn-primary btn-sm"
                  ><%=i %></a
                >
                <%}%> <%if(pv.getEndPage() != pv.getMaxPage()) { %>
                <a
                  href="<%=root1%>/admin/pro/list?status=Q&pno=<%=pv.getEndPage()+1 %>"
                  class="btn btn-primary btn-sm"
                  >다음</a
                >
                <%}%> <%} %> <% if(search!=null) { %> <%if(pv.getStartPage()!=1)
                {%>
                <a
                  href="<%=root1%>/admin/pro/list?search=<%=search %>&pno=<%=pv.getStartPage()-1 %>"
                  class="btn btn-primary btn-sm"
                  >이전</a
                >
                <%}%> <%for(int i=pv.getStartPage(); i<=pv.getEndPage(); i++)
                {%>
                <a
                  href="<%=root1%>/admin/pro/list?search=<%=search %>&pno=<%=i %>"
                  class="btn btn-primary btn-sm"
                  ><%=i %></a
                >
                <%}%> <%if(pv.getEndPage() != pv.getMaxPage()) { %>
                <a
                  href="<%=root1%>/admin/por/list?search=<%=search %>&pno=<%=pv.getEndPage()+1 %>"
                  class="btn btn-primary btn-sm"
                  >다음</a
                >
                <%}%> <%} %>
              </div>
            </div>
          </section>
        </main>
      </body>
    </html>
  </ProVo></ProVo
>
