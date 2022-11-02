<%@page import="com.kh.sseudam.counsel.pro.vo.CertificateVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.sseudam.counsel.pro.vo.ProVo"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <% String root1 =
request.getContextPath();%> 

<% 
		ProVo vo = (ProVo)request.getAttribute("proVo");
		List<CertificateVo> voList = (List<CertificateVo>)request.getAttribute("voList");
		String pno = (String)request.getAttribute("pno");
		String status = (String)request.getAttribute("status");
		String search = (String)request.getAttribute("search");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="<%=root1%>/resources/css/common/reset.css" />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/common/variables.css?ver=2"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/pro/list.css?ver=7"
    />
    <link
      rel="stylesheet"
      href="<%=root1%>/resources/css/admin/common/component.css?ver=6"
    />
    <style>
       .grid-col3 {
        grid-template-columns: 1fr 1fr 6fr;
        grid-template-rows: repeat(15, 50px);
      }
    </style>
  </head>
  <body>
    <%@ include file="/views/admin/common/menu.jsp"%>
    <main class="admin-main">
      <form
        action="<%=root1 %>/admin/pro/edit?mno=<%=vo.getNo() %>&pno=<%=pno %>&status=<%=status %>&search=<%=search%>"
        method="post"
        enctype="multipart/form-data"
      >
      <header class="admin-main-header flex-between">
        <h1>전문가 정보 수정</h1>
        <div class="btn-set">
          <input
            class="cancel-btn"
            type="button"
            value="취소"
            onclick="location.href='<%=root%>/admin/pro/list?mno=<%=vo.getNo()%>&pno=<%=pno %>&status=<%=status %>&search=<%=search%>'"
          />
          <input class="save-btn" type="submit" value="저장" onclick="return checkId();"/>
        </div>
      </header>
      <section class="admin-main-section">
        <div class="admin-main-wrapper">
          <div class="admin-main-board grid-col3">
            <div>번호</div>
            <div><%= vo.getNo() %></div>
            <div></div>
            <div>이름</div>
            <div>
              <input
                  type="text"
                  value="<%= vo.getName() %>"
                  class="upload-name"
                  name="name"
                />

            </div>
            <div></div>
            <div>성별</div>
              <div>
                <label for="">남
                  <input type="radio" name="gender" value="M">
                </label>
                <label for="">여
                  <input type="radio" name="gender" value="F">
                </label>
              </div>
            <div></div>
            <div>아이디</div>
            <div>
              <input
                  type="text"
                  value="<%= vo.getId() %>"
                  class="upload-name"
                  name="id"
                  id="targetId"
                />

            </div>
            <div class="padding-left0">
              <input type="button" value="중복확인" class="label-btn border-none" onclick="checkDupId();"/>
              <div id="printDupId"></div>
            </div>
            <div>비밀번호</div>
            <div>
              <input
              type="text"
              value="<%= vo.getPwd() %>"
              class="upload-name"
              name="pwd"
            />

            </div>
            <div></div>
            <div>상담분야</div>
          
          <div>
            <select name="counselType" id="" class="select-edit">
              <option value="청소년상담">청소년상담</option>
              <option value="가족심리상담">가족심리상담</option>
              <option value="우울증상담">우울증상담</option>
              <option value="취업/진로상담">취업/진로상담</option>
            </select>

          </div>
            
            <div></div>
            <div>이메일</div>
            <div>
              <input
              type="text"
              value="<%= vo.getEmail() %>"
              class="upload-name"
              name="email"
            />

            </div>
            <div></div>
            <div>전화번호</div>
            <div>
              <input
              type="text"
              value="<%= vo.getPhone() %>"
              class="upload-name"
              name="phone"
            />

            </div>
            <div></div>
            <div>최종학력</div>
            <div>

              <input
              type="text"
              value="<%= vo.getEducation() %>"
              class="upload-name"
              name="education"
            />
            </div>
            <div></div>
            <div>상담금액</div>
            <%if(vo.getPrice()!=null){%>
              <div>
                <input
                type="text"
                value="<%= vo.getPrice() %>"
                class="upload-name"
                name="price"
              />

              </div>
          <%}else { %>
            <div>

              <input
              type="text"
              value="미정"
              class="upload-name"
              name="price"
            />
            </div>
            <%}%>
            <div></div>
            <div>프로필사진</div>
            <div>
              <img
                src="<%=root%>/resources/upload/pro/<%=vo.getImg()%>"
                alt=""
                class="small-img"
              />
              <input type="text" disabled value="<%=vo.getImg()%>" class="input-edit">
            </div>
            <div  class="padding-left0"><input type="file" name="img" class="upload-btn" /></div>
            <div>소개글</div>
            <div>
              <input
              type="text"
              value="<%= vo.getIntroduce() %>"
              class="upload-name"
              name="introduce"
            />

            </div>
            <div></div>
            <div>계정상태</div>
            <%if(vo.getProStatus().equals("J")) {%>
            <div>승인완료회원</div>
            <%} %> <%if(vo.getProStatus().equals("W")) {%>
            <div>승인대기회원</div>
            <%} %> <%if(vo.getProStatus().equals("Q")) {%>
            <div>탈퇴회원</div>
            <%} %>
           

            <%if(vo.getProStatus().equals("W")) {%>  
            <div  class="padding-left0">
              <input type="button" value="전문가승인" class="label-btn border-none" onclick="proOk();"/>
            </div>
            <%}else if(vo.getProStatus().equals("J")) {%>
              <div>
                <input type="button" value="승인취소" class="check-btn" onclick="proCancel();"/>
              </div>
              
            <%}else {%>
              <div></div>
              <%}%>
            <div>가입일</div>
            <div><%= vo.getJoinDate() %></div>
            <div></div>
            <div>정보수정일자</div>
            <div><%= vo.getModifyDate() %></div>
            <div></div>
          </div>
          <input type="button" value="회원탈퇴" class="delete-btn" onclick="quit();"/>
        </div>
        <div class="admin-main-wrapper admin-cer-wrapper">
          <div class="admin-add-certificate ">
            <div class="black border-left">자격증이름</div>
            <div class="black">자격번호</div>
            <div class="black border-right">자격증첨부파일</div>

          </div>
          <div class="admin-add-certificate">
            <%for(int i=0; i<voList.size(); i++) {%>
              <div><%= voList.get(i).getName() %></div>
              <div><%= voList.get(i).getNum() %></div>
              <div><span> <%= voList.get(i).getImg() %></span>
               <i class='fa-solid fa-square-xmark x-btn' onclick='dbDeleteCer(this);'></i></div>
              <%}%>
            
            
       
          </div>
          <div class="admin-add-certificate2 cer-target">
          
           
            
            
       
          </div>
          <div class=" admin-add-certificate">
            <div>
            </div>
            <div>
              <input type="button" value="추가" class="small-add-btn " onclick="cerAd();"/>
              
            </div>
            <div></div>
            
          </div>
        </div>
       
      </section>
    </form>
      
    </main>
    <script>
      
      function dbDeleteCer(x) {
        const parent = x.parentNode;
        
        const targetSpan = parent.firstChild;
        console.log(targetSpan.innerText);
        Swal.fire({
          title: "전문가 자격증 삭제",
          text: "정말로 삭제 하시겠습니까?",
          icon: "warning",
          showCancelButton: true,
          confirmButtonColor: "#26aa82",
          cancelButtonColor: "#f85a2a",
          confirmButtonText: "삭제",
          cancelButtonText: "취소"
        }).then((result) => {
          if (result.isConfirmed) {
            location.href='<%=root%>/admin/pro/deleteCer?mno=<%=vo.getNo()%>&pno=<%=pno %>&status=<%=status %>&img='+targetSpan.innerText;
          }
        });
      }
    </script>
    <script>
      function cerAd() {
      
        const cerTarget = document.querySelector('.cer-target');
        const newDiv0 = document.createElement('div');

        const newDiv1 = document.createElement('div');
        newDiv1.innerHTML = "<input type='text' class='cer-edit' name='cerName' placeholder='자격증이름을 입력하세요' />";
        const newDiv2 = document.createElement('div');
        newDiv2.innerHTML = "<input type='text' class='cer-edit' name='cerNum' placeholder='자격번호를 입력하세요' />";
        const newDiv3 = document.createElement('div');
        newDiv3.innerHTML = "<input type='file' class='upload-btn' name='f'  multiple/><i class='fa-solid fa-square-xmark x-btn' onclick='deleteCer(this);'></i>";

        newDiv0.appendChild(newDiv1);
        newDiv0.appendChild(newDiv2);
        newDiv0.appendChild(newDiv3);

        cerTarget.appendChild(newDiv0);
       


      }
    </script>
    <script>
      function deleteCer(x) {
      
        var parent = x.parentNode.parentNode;
        parent.remove();

      }
    </script>
    <script>
      function checkId() {
        let checkId = $("#printDupId").text();
     
        console.log(checkId);
    
        if (
          (checkId.includes("현재") || checkId.includes("사용가능한")) 
        ) {
          return true;
        } else {
          Swal.fire("아이디 중복체크해주세요!");
          return false;
        }
      }
    </script>
    <script>
      let id = document.querySelector("#targetId").value;
      console.log(id);
      function checkDupId() {
        console.log('여기여기');
        $.ajax({
          url: "<%=root1%>/admin/checkProIdDup",
          type: "get",
          data: {
            id: $('#targetId').val(),
            mno : <%=vo.getNo()%>
          },
          success: function (x) {
            $("#printDupId").html(x);
          },
          error: function () {
            alert("통신에러발생~");
          },
        });
      }
    </script>
     <script>
      function quit() {
        Swal.fire({
          title: <%=vo.getNo()%>+"번 전문가 탈퇴",
          text: "정말로 탈퇴처리 하시겠습니까?",
          icon: "warning",
          showCancelButton: true,
          confirmButtonColor: "#26aa82",
          cancelButtonColor: "#f85a2a",
          confirmButtonText: "탈퇴",
          cancelButtonText: "취소"
        }).then((result) => {
          if (result.isConfirmed) {
            location.href='<%=root%>/admin/pro/quit?mno=<%=vo.getNo()%>&pno=<%=pno %>&status=<%=status %>';
          }
        });
      }
    </script>
    <script>
      function proOk() {
        Swal.fire({
          title: <%=vo.getNo()%>+"번 전문가 승인",
          text: "정말로 승인처리 하시겠습니까?",
          icon: "warning",
          showCancelButton: true,
          confirmButtonColor: "#26aa82",
          cancelButtonColor: "#f85a2a",
          confirmButtonText: "승인",
          cancelButtonText: "취소"
        }).then((result) => {
          if (result.isConfirmed) {
            location.href='<%=root%>/admin/pro/ok?mno=<%=vo.getNo()%>&pno=<%=pno %>&status=<%=status %>';
          }
        });
      }
    </script>
    <script>
      function proCancel() {
        Swal.fire({
          title: <%=vo.getNo()%>+"번 전문가 승인취소",
          text: "정말로 승인취소 하시겠습니까?",
          icon: "warning",
          showCancelButton: true,
          confirmButtonColor: "#26aa82",
          cancelButtonColor: "#f85a2a",
          confirmButtonText: "승인취소",
          cancelButtonText: "취소"
        }).then((result) => {
          if (result.isConfirmed) {
            location.href='<%=root%>/admin/pro/cancel?mno=<%=vo.getNo()%>&pno=<%=pno %>&status=<%=status %>';
          }
        });
      }
    </script>
    <script>
      //상담분야 체크하기
      const counselTypeArr = document.querySelectorAll('select[name=counselType] option');
      const counselTypeStr = "<%=vo.getCounselType()%>";
   
      const genderArr = document.querySelectorAll('input[name=gender]');
      const genderStr = "<%=vo.getGender()%>";

      for(let i=0; i<counselTypeArr.length; i++) {
        const x = counselTypeArr[i].value;
        let result = counselTypeStr.search(x);
        if(result >= 0) {
          counselTypeArr[i].selected = true;
        }

      }

      for(let i=0; i<genderArr.length; i++) {
        const x = genderArr[i].value;
        let result = genderStr.search(x);
        if(result >= 0) {
          genderArr[i].checked = true;
        }

      }
    </script>
  </body>
</html>
