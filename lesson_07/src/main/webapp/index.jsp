<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>
<h1>当前网站访问人数：${applicationScope.ol}</h1>
<a href="${pageContext.request.contextPath}/logout">点击注销</a>
</body>
</html>