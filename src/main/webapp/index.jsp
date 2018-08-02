<%@ page contentType="text/html; charset=utf-8"%>
<%--<%--%>
    <%--String path = request.getContextPath();--%>
    <%--String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";--%>
<%--%>--%>
<!doctype html>
<html>
<head>
    <%--<base href="<%=basePath%>">--%>
    <title>查找用户</title>
    <%--<meta http-equiv="pragma" content="no-cache">--%>
    <%--<meta http-equiv="cache-control" content="no-cache">--%>
    <%--<meta http-equiv="expires" content="0">--%>
    <%--<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">--%>
    <%--<meta http-equiv="description" content="This is my page">--%>
</head>
<link rel="stylesheet" href="staticResource/css/index.css" type="text/css">
<%--引入jquery--%>
<script src="js/jquery-3.1.1.js"></script>
<script src="staticResource/javascript/index.js"></script>
<body>
<div>
<div class="findUser">
    <input type="text" id="userid" placeholder="请输入用户ID"  value="1"/>
    <button onclick="find()">查找用户</button></br>
    <textarea  id="result" cols="40" rows="14">点击查询,正常情况下，此处会返回json串</textarea>
</div>
<div class="updateUser">
    <button onclick="update()">更新用户</button></br>
    <textarea  id="updateResult" cols="40" rows="7"></textarea><br>
    <input type="hidden" id="up_userid">
    <label>用户名：</label><input type="text" id="up_username" ><br>
    <label>密&nbsp;&nbsp;&nbsp;码：</label><input type="text" id="up_pwd" placeholder="理应加密处理"><br>
    <label>年&nbsp;&nbsp;&nbsp;龄：</label><input type="text" id="up_age" >
</div>
<div class="addUser">
    <button onclick="add()">添加用户</button></br>
    <textarea  id="addResult" cols="40" rows="7"></textarea><br>
    <label>用户名：</label><input type="text" id="add_username"><br>
    <label>密&nbsp;&nbsp;&nbsp;码：</label><input type="text" id="add_pwd" placeholder="理应加密处理"><br>
    <label>年&nbsp;&nbsp;&nbsp;龄：</label><input type="text" id="add_age">
</div>
<div class="deleteUser">
    <input type="text" id="delId" placeholder="请输入用户ID"  value="100"/>
    <button onclick="del()">删除用户</button></br>
    <textarea  id="deleteResult" cols="40" rows="14"></textarea>
</div>
</div>
<div>
    <a href="user/toNewPage.do">跳转测试</a>
</div>
</body>
</html>