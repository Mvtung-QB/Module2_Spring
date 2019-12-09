<%--
  Created by IntelliJ IDEA.
  User: TungDaiCa
  Date: 11/19/2019
  Time: 8:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="getCondiment">
    <label>Sandwich Condiments</label><br/>
    <input type="checkbox" name="Condiment" value="lettuce"  /> lettuce
    <input type="checkbox" name="Condiment" value="tomato"/>tomato
    <input type="checkbox" name="Condiment" value="mustard" />mustard
    <input type="checkbox" name="Condiment" value="sprouts"/>sprouts<br/>
    <input type="submit" name="save" value="Save"/>
</form>
</body>
</html>
