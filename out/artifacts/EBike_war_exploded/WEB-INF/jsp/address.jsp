<%--
  Created by IntelliJ IDEA.
  User: ho
  Date: 2017/7/23
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title></title>
    <style>
        .mui-right {
            position: absolute;
            right: 40px;
        }

        .mui-right-m {
            position: absolute;
            right: 0px;
        }

        .mui-center {
            margin: 0 auto;
        }

        .btn-m {
            display: inline-block;
            margin: 0 auto;
        }

        .btn-div {
            margin: 0 auto;
        }
    </style>
    <script src="js/mui.min.js"></script>
    <link href="css/mui.min.css" rel="stylesheet"/>
    <link href="css/mui.picker.min.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">

    </script>
    <meta name="format-detection" content="telephone=no">

    <meta http-equiv="x-rim-auto-match" content="none">
</head>
<body>
<!-- 侧滑导航根容器 -->
<div class="mui-off-canvas-wrap mui-draggable">
    <!-- 主页面容器 -->
    <div class="mui-inner-wrap">
        <!-- 菜单容器 -->
        <aside class="mui-off-canvas-left">
            <div class="mui-scroll-wrapper">
                <div class="mui-scroll">
                    <!-- 菜单具体展示内容 -->
                    <ul class="mui-table-view">
                        <li class="mui-table-view-cell">
                            <a href="own.do" class="mui-navigate-right a-m">客户账单管理</a>
                        </li>
                        <li class="mui-table-view-cell">
                            <a href="hadRepay.do" class="mui-navigate-right a-m">已还清账单</a>
                        </li>
                        <li class="mui-table-view-cell">
                            <a href="address.do" class="mui-navigate-right a-m">地址设置</a>
                        </li>
                        <li class="mui-table-view-cell">
                            <a href="bike.do" class="mui-navigate-right a-m">车型设置</a>
                        </li>
                        <li class="mui-table-view-cell">
                            <a href="color.do" class="mui-navigate-right a-m">颜色设置</a>
                        </li>
                        <li class="mui-table-view-cell">
                            <a href="setPassword.do" class="mui-navigate-right a-m">修改密码</a>
                        </li>
                        <li class="mui-table-view-cell">
                            <a href="logMessage.do" class="mui-navigate-right a-m">日志查询</a>
                        </li>
                    </ul>
                </div>
            </div>
        </aside>
        <!-- 主页面标题 -->
        <header class="mui-bar mui-bar-nav">
            <a class="mui-icon mui-action-menu mui-icon-bars mui-pull-left"></a>
            <h1 class="mui-title">绿源电动车管理系统<a href="exit.do" class="mui-right-m a-m" style="color: dodgerblue">退出</a></h1>
        </header>
        <!-- 主页面内容容器 -->
        <div id="content-m" class="mui-content mui-scroll-wrapper">
            <div class="mui-input-row mui-search">
                <input type="search" id="search" class="mui-input-clear" value="${str}" placeholder="">
            </div>
            <div class="mui-button-row">
                <button id="add" class="mui-btn-primary">添加记录</button>
                <button id="search-btn" class="mui-btn-primary">查找</button>
            </div>
            <hr/>
            <div class="mui-scroll">
                <ul class="mui-table-view">
                    <c:forEach items="${list}" var="address">
                        <li class="mui-table-view-cell">
                            <div class="addressId mui-hidden">${address.id}</div>
                            <span class="addressName">${address.addressName}</span>
                            <button class="delete mui-btn-danger" style="float: right">删除</button>
                            <button class="set mui-btn-warning" style="float: right">编辑</button>
                        </li>
                    </c:forEach>
                </ul>
                <br><br><br><br><br>
            </div>
        </div>
    </div>
</div>
</body>
<script src="js/main_data.js"></script>
<script src="js/jquery-2.1.0.js"></script>
<script src="js/layer.js"></script>
<script src="js/mui.picker.min.js"></script>
<script>
    mui.init(mui("#content-m").scroll());
    mui.ready(function () {
        mui('body').on('tap','.a-m',function(){
            window.top.location.href=this.href;
        });
        //点击编辑按钮
        $(".set").click(function () {
            var addressId = $(this).parent().children(".addressId").text();
            layer.prompt({title: '请输入修改后名称'}, function (pass, index) {
                $.ajax({
                    url: "setAddress.do"
                    , type: "get"
                    , data: {"id": addressId, "addressName": pass}
                    , success: function (data) {
                        if (data == "1") {
                            layer.msg("修改成功", {icon: 6, time: 700});
                            layer.close(index);
                            setTimeout("location.reload(true)", 500);
                            return;
                        }
                        layer.msg(data, {icon: 5, anim: 0});
                    }
                    , error: function () {
                        layer.msg("当前系统繁忙，请稍后再试！", {icon: 5, anim: 0});
                    }
                });
            });
        });

        //点击添加按钮
        $("#add").click(function () {
            layer.prompt({title: '请输入名称'}, function (pass, index) {
                $.ajax({
                    url: "addAddress.do"
                    , type: "get"
                    , data: {"addressName": pass}
                    , success: function (data) {
                        if (data == "1") {
                            layer.msg("添加成功", {icon: 6, time: 700});
                            layer.close(index);
                            setTimeout("location.reload(true)", 500);
                            return;
                        }
                        layer.msg(data, {icon: 5, anim: 0});
                    }
                    , error: function () {
                        layer.msg("当前系统繁忙，请稍后再试！", {icon: 5, anim: 0});
                    }
                });
            });
        });

        //点击删除按钮
        $(".delete").click(function () {
            var addressId = $(this).parent().children(".addressId").text();
            layer.confirm("您将要删除该条记录，是否删除？", {icon: 3, title: '警告', anim: 1}, function (index) {
                $.ajax({
                    url: "deleteAddress.do"
                    , type: "get"
                    , data: {"addressId": addressId}
                    , success: function (data) {
                        if (data == "1") {
                            layer.msg("删除成功！", {icon: 6, time: 700});
                            layer.close(index);
                            setTimeout("location.reload(true)", 500);
                            return;
                        }
                        layer.msg(data, {icon: 5, anim: 0});
                    }
                    , error: function () {
                        layer.msg("当前系统繁忙，请稍后再试！", {icon: 5, anim: 0});
                    }
                });
            })
        })
    })
</script>
</html>
