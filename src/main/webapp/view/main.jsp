<%--
  Created by IntelliJ IDEA.
  User: StephenChow
  Date: 2018/7/1
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    pageContext.setAttribute("path",path);
%>
<!DOCTYPE html>
<html>
<head>
    <title>管理台</title>
    <link rel="stylesheet" href="${path}/staticResource/javascript/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/staticResource/css/font-awesome.min.css">
    <link rel="stylesheet" href="${path}/staticResource/css/main.css">
    <link rel="stylesheet" href="${path}/staticResource/css/skins/_all-skins.css">

</head>
<body class="hold-transition skin-blue sidebar-mini" style="overflow:hidden;">
<div id="ajax-loader" style="cursor: progress; position: fixed; top: -50%; left: -50%; width: 200%; height: 200%; background: #fff; z-index: 10000; overflow: hidden;">
    <img src="${path}/staticResource/img/main/ajax-loader.gif" style="position: absolute; top: 0; left: 0; right: 0; bottom: 0; margin: auto;" />
</div>
<div class="wrapper">
    <!--头部信息-->
    <header class="main-header">
        <a href="" target="_blank" class="logo">
            <span class="logo-mini">LR</span>
            <span class="logo-lg">System Control Center</span>
        </a>
        <nav class="navbar navbar-static-top">
            <a class="sidebar-toggle">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li class="dropdown messages-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-envelope-o "></i>
                            <span class="label label-success">4</span>
                        </a>
                    </li>
                    <li class="dropdown notifications-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-bell-o"></i>
                            <span class="label label-warning">10</span>
                        </a>
                    </li>
                    <li class="dropdown tasks-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-flag-o"></i>
                            <span class="label label-danger">9</span>
                        </a>
                    </li>
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="${path}/staticResource/img/main/user2-160x160.jpg" class="user-image" alt="User Image">
                            <span class="hidden-xs">${loginUser.userName}</span>
                        </a>
                        <ul class="dropdown-menu pull-right">
                            <li><a class="menuItem" data-id="userInfo" href="view/default.html"><i class="fa fa-user"></i>个人信息</a></li>
                            <%--<li><a href="javascript:void();"><i class="fa fa-trash-o"></i>清空缓存</a></li>--%>
                            <li><a href="javascript:void();"><i class="fa fa-paint-brush"></i>皮肤设置</a></li>
                            <li class="divider"></li>
                            <li><a href="logout/logout.do"><i class="ace-icon fa fa-power-off"></i>安全退出</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!--左边导航-->
    <div class="main-sidebar">
        <div class="sidebar">
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="${path}/staticResource/img/main/user2-160x160.jpg" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>${loginUser.userName}</p>
                    <a><i class="fa fa-circle text-success"></i>在线</a>
                </div>
            </div>
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="Search...">
                    <span class="input-group-btn">
                            <a class="btn btn-flat"><i class="fa fa-search"></i></a>
                        </span>
                </div>
            </form>
            <ul class="sidebar-menu" id="sidebar-menu">
                <!--<li class="header">导航菜单</li>-->
            </ul>
        </div>
    </div>
    <!--中间内容-->
    <div id="content-wrapper" class="content-wrapper">
        <div class="content-tabs">
            <button class="roll-nav roll-left tabLeft">
                <i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs menuTabs">
                <div class="page-tabs-content" style="margin-left: 0px;">
                    <a href="javascript:;" class="menuTab active" data-id="/view/Default">欢迎首页</a>
                    <%--<a href="javascript:;" class="menuTab" data-id="/Home/About" style="padding-right: 15px;">平台介绍<i class="fa fa-remove"></i></a>--%>
                    <%--<a href="javascript:;" class="menuTab" data-id="/SystemManage/Organize/Index">机构管理 <i class="fa fa-remove"></i></a>--%>
                    <%--<a href="javascript:;" class="menuTab" data-id="/SystemManage/Role/Index">角色管理 <i class="fa fa-remove"></i></a>--%>
                    <%--<a href="javascript:;" class="menuTab" data-id="/SystemManage/Duty/Index">岗位管理 <i class="fa fa-remove"></i></a>--%>
                    <%--<a href="javascript:;" class="menuTab" data-id="/SystemManage/User/Index">用户管理 <i class="fa fa-remove"></i></a>--%>
                </div>
            </nav>
            <button class="roll-nav roll-right tabRight">
                <i class="fa fa-forward" style="margin-left: 3px;"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown tabClose" data-toggle="dropdown">
                    页签操作<i class="fa fa-caret-down" style="padding-left: 3px;"></i>
                </button>
                <ul class="dropdown-menu dropdown-menu-right">
                    <li><a class="tabReload" href="javascript:void();">刷新当前</a></li>
                    <li><a class="tabCloseCurrent" href="javascript:void();">关闭当前</a></li>
                    <li><a class="tabCloseAll" href="javascript:void();">全部关闭</a></li>
                    <li><a class="tabCloseOther" href="javascript:void();">除此之外全部关闭</a></li>
                </ul>
            </div>
            <button class="roll-nav roll-right fullscreen"><i class="fa fa-arrows-alt"></i></button>
        </div>
        <div class="content-iframe" style="overflow: hidden;">
            <div class="mainContent" id="content-main" style="margin: 10px; margin-bottom: 0px; padding: 0;">
                <iframe class="LRADMS_iframe" width="100%" height="100%" src="${path}/view/default.html" frameborder="0" data-id="default.html"></iframe>
            </div>
        </div>
    </div>
</div>
<script src="${path}/js/jQuery-2.2.0.min.js"></script>
<script src="${path}/staticResource/javascript/bootstrap/js/bootstrap.min.js"></script>
<script src="${path}/staticResource/javascript/main.js"></script>
<%--<script src="${path}/staticResource/javascript/main2.js"></script>--%>
</body>
</html>
