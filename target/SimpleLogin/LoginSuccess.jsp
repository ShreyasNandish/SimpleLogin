<%--
  Created by IntelliJ IDEA.
  User: shreyas
  Date: 30-08-2022
  Time: 07:35 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Login success</title>
</head>
<body>
<h3>Hi <%= request.getAttribute("user")%>,Login successful</h3>
<a href="login.html">Login page</a>

</body>
</html>
