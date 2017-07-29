<%--
  Created by IntelliJ IDEA.
  User: ho
  Date: 2017/7/27
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="ui-page-login">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title></title>
    <link href="css/mui.min.css" rel="stylesheet" />
    <link href="css/style.css" rel="stylesheet" />
    <style>
        .area {
            margin: 20px auto 0px auto;
        }
        .mui-input-group:first-child {
            margin-top: 20px;
        }
        .mui-input-group label {
            width: 22%;
        }
        .mui-input-row label~input,
        .mui-input-row label~select,
        .mui-input-row label~textarea {
            width: 78%;
        }
        .mui-checkbox input[type=checkbox],
        .mui-radio input[type=radio] {
            top: 6px;
        }
        .mui-content-padded {
            margin-top: 25px;
        }
        .mui-btn {
            padding: 10px;
        }
        .mui-input-row label {
            width: 75px;
            padding: 10px 0 10px 15px;
            color: #586C96;
        }
        .mui-input-row input {
            float: left !important;
        }

    </style>
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
            <hr/>
            <div class="mui-scroll">
                <form class="mui-input-group">
                    <div class="mui-input-row">
                        <label>原密码</label>
                        <input id='password' type="password" class="mui-input-clear mui-input" placeholder="请输入原密码">
                    </div>
                    <div class="mui-input-row">
                        <label>新密码</label>
                        <input id='password1' type="password" class="mui-input-clear mui-input" placeholder="请输入新密码">
                    </div>
                    <div class="mui-input-row">
                        <label>确认</label>
                        <input id='password2' type="password" class="mui-input-clear mui-input" placeholder="请确认密新码">
                    </div>
                </form>
                <div class="mui-content-padded">
                    <button id='set' class="mui-btn mui-btn-block mui-btn-primary">修改</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="js/mui.min.js"></script>
<script type="text/javascript" src="js/jquery-2.1.0.js" ></script>
<script type="text/javascript" src="js/layer.js" ></script>
<script>
    mui.init();
    $(function () {
        mui('body').on('tap','.a-m',function(){
            window.top.location.href=this.href;
        });
        $("#set").click(function () {
            var password = $("#password").val();
            var password1 = $("#password1").val();
            var password2 = $("#password2").val();
            $.ajax({
                url: "setPassword.do"
                ,type: "post"
                ,data: {"password": password, "password1": password1, "password2": password2}
                ,success: function (data) {
                    if (data == "1") {
                        layer.msg("修改成功！", {icon: 6, time: 700});
                        setTimeout("window.location.href='exit.do'", 500);
                        return;
                    }
                    layer.msg(data, {icon: 5, anim: 0});
                }
                ,error: function () {
                    layer.msg("当前系统繁忙，请稍后再试！", {icon: 5, anim: 0});
                }
            });
        })
    })

</script>
</body>
</html>
