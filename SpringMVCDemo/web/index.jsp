<%--
  Created by IntelliJ IDEA.
  User: Yu
  Date: 2021/7/18
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<p><a href="demo1/doTest">/demo1/doTest</a></p>
<p><a href="demo1/doGet">发送GET请求</a></p>
<form action="demo1/doPost" method="post">
    <input type="submit" value="发送POST请求">
</form>
<p><a href="demo1/doModelMap">通过ModelMap将数据传到前台</a></p>
<p><a href="demo1/doModel">通过Model将数据传到前台</a></p>
<hr/>

<p><a href="demo2/test/action/123">获取请求中的路径</a></p>
<hr/>

<form method="post" action="demo3/doEachParam">
    姓名：<input type="text" name="name"><br/>
    年龄：<input type="text" name="age"><br/>
    <input type="submit" value="逐个接收请求中的参数，参数名称一致">
</form>
<form method="post" action="demo3/doIgnoreParam">
    姓名：<input type="text" name="name"><br/>
    年龄：<input type="text" name="age"><br/>
    <input type="submit" value="逐个接收请求中的参数，参数名称不一致">
</form>
<form method="post" action="demo3/doObjectParam">
    姓名：<input type="text" name="name"><br/>
    年龄：<input type="text" name="age"><br/>
    <input type="submit" value="使用对象接收参数">
</form>
<hr/>

<p><a href="demo4/doJsonResult">返回json数据</a></p>
<hr/>

<p><a href="demo5/doForward">转发方式一</a></p>
<p><a href="demo5/doAnotherForward">转发方式二</a></p>
<p><a href="demo5/doRedirect">重定向方式</a></p>

</body>
</html>
