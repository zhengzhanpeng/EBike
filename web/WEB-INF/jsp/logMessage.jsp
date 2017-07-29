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
                    <c:forEach items="${list}" var="logM">
                        <li class="mui-table-view-cell">
                            <span class="bikeType">时间：<fmt:formatDate value="${logM.setDate}" type="both"/></span>
                            <p>
                            ${logM.content}
                            </p>
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
    })
</script>
</html>
