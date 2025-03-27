<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="Login" method="post">
    用户名<br/>
    <input type="text" name="username"><br/>
    密码<br/>
    <input type="password" name="password"><br/>
    验证码
    <img src="register" style="width: 50px;height: 30px" alt="Captcha" onclick="this.src='register'+ new Date().getTime()">
    <input type="text" name="vcode"><br/>
    <input type="submit">
</form>
</body>
</html>