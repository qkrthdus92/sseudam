<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
      html {
        background-color: rgb(50, 50, 50);
      }
      .center {
        display: flex;
        justify-content: center;
        align-items: center;
      }

      .admin-login-body {
        height: 700px;
      }

      .admin-login-main {
      }

      .admin-login-header {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin-bottom: 40px;
      }
      .admin-login-header div:first-child {
        color: white;
        font-size: 40px;
        font-weight: 600;
      }

      .admin-login-header div:last-child {
        color: white;
        font-size: 20px;
        color: darkgray;
      }

      .admin-login-id,
      .admin-login-pwd {
        display: flex;
        width: 400px;
        height: 50px;
        box-sizing: border-box;
      }

      .admin-input-label {
        background-color: rgb(224, 224, 224);
        color: rgb(105, 105, 105);
        width: 40px;
        height: 100%;
      }

      .admin-login-inputs input {
        width: 360px;
        line-height: 100%;
        outline: none;
        border: none;
        padding-left: 10px;
      }

      .admin-login-id .admin-input-label {
        border-top-left-radius: 5px;
      }

      .admin-login-id input {
        border-top-right-radius: 5px;
      }

      .admin-login-pwd .admin-input-label {
        border-bottom-left-radius: 5px;
      }

      .admin-login-pwd input {
        border-bottom-right-radius: 5px;
      }

      .admin-login-btn {
        width: 100%;
        height: 40px;
        margin-top: 10px;
        border-radius: 5px;
        border: none;
        cursor: pointer;
        background-color: #26aa82;
        color: white;
        font-size: 17px;
      }
    </style>
  </head>
  <body class="admin-login-body center">
    <form action="/sseudam/admin/login" method="post">
      <main class="admin-login-main">
        <header class="admin-login-header">
          <div>쓰담쓰담</div>
          <div>Administration</div>
        </header>
        <section class="admin-login-inputs">
          <div class="admin-login-id">
            <div class="admin-input-label center">ID</div>
            <input type="text" placeholder="아이디를 입력하세요" name="id" />
          </div>
          <div class="admin-login-pwd">
            <div class="admin-input-label center">PW</div>
            <input type="text" placeholder="비밀번호를 입력하세요" name="pwd" />
          </div>
        </section>
        <section class="admin-login-submit">
          <input type="submit" value="Log In" class="admin-login-btn" />
        </section>
      </main>
    </form>
  </body>
</html>
