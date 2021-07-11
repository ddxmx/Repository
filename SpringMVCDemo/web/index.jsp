<%--
  Created by IntelliJ IDEA.
  User: Yu
  Date: 2021/7/10
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<p><a href="demo1/test.do">/demo1/test.do</a></p>
<form action="demo1/post.do" method="post">
    <input type="submit" value="发送post请求">
</form>
<form action="demo1/postMapping.do" method="post">
    <input type="submit" value="设置@postMapping，支持post请求">
</form>
<p><a href="demo1/modelMap.do">使用modelMap将数据传递到前端</a></p>
<p><a href="demo1/model.do">使用model将数据传递到前端</a></p>
<h3>Restful请求获取路径参数</h3>
<p><a href="restful/test/abc.do">/restful/test/abc.do</a></p>

<h3>请求转发和重定向</h3>
<p>
    <a href="fr/forward.do">转发方式一</a>
    <a href="fr/forward2.do">转发方式二</a>
    <a href="fr/redirect.do">重定向方式</a>
</p>

<h3>请求参数</h3>
<form method="post" action="param/param.do">
    姓名：<input type="text" name="name"><br/>
    年龄：<input type="text" name="age"><br/>
    <input type="submit" value="逐个提交参数，参数名称一致">
</form>
<form method="post" action="param/paramRename.do">
    姓名：<input type="text" name="name"><br/>
    年龄：<input type="text" name="age"><br/>
    <input type="submit" value="逐个提交参数，参数名称不一致">
</form>
<form method="post" action="param/paramObject.do">
    姓名：<input type="text" name="name"><br/>
    年龄：<input type="text" name="age"><br/>
    <input type="submit" value="使用对象接收参数">
</form>

<h3>返回值类型</h3>
<p><a href="demo2/string.do">返回字符串数据</a></p>
<p><a href="demo2/string2.do">返回字符串数据，统一配置UTF-8编码</a></p>
<p><a href="demo2/object.do">直接返回对象</a></p>
<p><a href="demo3/test.do">restController，方法不需要设置responseBody</a></p>
</body>
</html>
