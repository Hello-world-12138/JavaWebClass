<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录页面</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }
    .login-container {
      background-color: #fff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      width: 300px;
      text-align: center;
    }
    .login-container h2 {
      margin-bottom: 20px;
    }
    .login-container input {
      width: 100%;
      padding: 10px;
      margin: 10px 0;
      border: 1px solid #ccc;
      border-radius: 5px;
    }
    .login-container button {
      width: 100%;
      padding: 10px;
      background-color: #28a745;
      color: #fff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }
    .login-container button:hover {
      background-color: #218838;
    }
    .error-message {
      color: red;
      margin-top: 10px;
    }
  </style>
</head>
<body>
<div class="login-container">
  <h2>用户登录</h2>
  <form action="login" method="post">
    <input type="text" name="username" placeholder="用户名" required>
    <input type="password" name="password" placeholder="密码" required>
    <button type="submit">登录</button>
    <button type="button" onclick="window.location.href = '/lesson_03_war/register.jsp';">注册</button>
  </form>
  <%-- 显示错误信息 --%>
  <div class="error-message">
    <%= request.getAttribute("msg") == null ? "" : request.getAttribute("msg") %>
  </div>
</div>
</body>
</html>