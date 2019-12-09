<%--
  Created by IntelliJ IDEA.
  User: TungDaiCa
  Date: 11/19/2019
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <label><h1>calculater</h1></label><br/>
    <input type="text" name="num1" placeholder="num1"/>
    <input type="text" name="num2" placeholder="num2"/><br/>
    <input type="submit" name="operater" value="addition(+)"/>
    <input type="submit" name="operater" value="Subtraction(-)"/>
    <input type="submit" name="operater" value="divition(/)"/>
    <input type="submit" name="operater" value="Multiplication(X)"/>
</form>
<h1>Result: ${result}</h1>
</body>
</html>
