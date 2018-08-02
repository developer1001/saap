<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/25
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            background-image:url('staticResource/img/welcome.jpg');
            background-size:100%;
        }
        .di{
            text-align: center;
            margin: 20px;
        }
    </style>
</head>
<body>
<div class="di">
    看到此界面，说明服务已启动起来，但这不代表系统可以正常运行</br>
</div>
<div class="di">
    下一步需要一个简单的操作来验证系统是否可以进行正常的数据交互？
</div>
<div class="di">
    <button onclick="window.location.href='index.jsp'">我要试试</button>
</div>
</body>
</html>
