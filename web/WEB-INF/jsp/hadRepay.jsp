<%--
  Created by IntelliJ IDEA.
  User: ho
  Date: 2017/7/23
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
            <h1 class="mui-title">绿源电动车管理系统<a href="exit.do" class="mui-right-m a-m" style="color: dodgerblue">退出</a> </h1>
        </header>
        <!-- 主页面内容容器 -->
        <div id="content-m" class="mui-content mui-scroll-wrapper">
            <div class="mui-input-row mui-search">
                <input type="search" id="search" class="mui-input-clear" value="${str}" placeholder="">
            </div>
            <div class="mui-button-row">
                <button id="order" class="mui-btn-primary">升序排序</button>
                <button id="order-desc" class="mui-btn-primary">降序排序</button>
                <button id="search-btn" class="mui-btn-primary">查找</button>
            </div>
            <hr/>
            <div class="mui-scroll">
                <ul class="mui-table-view">
                    <c:forEach items="${list}" var="ownUnique">
                        <li class="mui-table-view-cell mui-collapse">
                            <a class="mui-navigate-right"  style="color: brown;" href="#">
                                <span class="mui-left">${ownUnique.name} </span>
                                <span class="mui-center">&nbsp;&nbsp;${ownUnique.addressName}</span>
                                <sapn class="mui-right">${ownUnique.money}</sapn>
                            </a>
                            <div class="mui-collapse-content">
                                <div class="ownId mui-hidden">${ownUnique.id}</div>
                                <div class="bikeId mui-hidden">${ownUnique.bikeId}</div>
                                <div class="addressId mui-hidden">${ownUnique.addressId}</div>
                                <label>姓名：</label><span class="name">${ownUnique.name}</span>
                                <hr/>
                                <label>地址：</label><span class="address">${ownUnique.addressName}</span>
                                <hr/>
                                <label>欠款：</label><span class="money">${ownUnique.money}</span>
                                <hr/>
                                <label>所购车型：</label><span class="bikeType">${ownUnique.bikeType}</span>
                                <hr/>
                                <label>颜色：</label><span class="bikeColor">${ownUnique.bikeColor}</span>
                                <hr/>
                                <label>联系电话：</label><a class="a-m" href="tel:${ownUnique.phone}"> <span class="phone">${ownUnique.phone}</span></a>
                                <hr/>
                                <label>出售日期：</label><span class="sellDate"><fmt:formatDate value="${ownUnique.sellDate}" type="date"/></span>
                                <hr/>
                                <label>备注：</label><span class="remark">${ownUnique.remark}</span>
                                <hr/>
                                <c:set value="${ownUnique.ownMessages}" var="om"/>
                                <div class="repay-message-content mui-hidden">
                                    <c:forEach items="${om}" var="ownMessage">
                                        <p>还款金额：${ownMessage.money}<br>日期：<fmt:formatDate value="${ownMessage.setDate}" type="date" dateStyle="full"/><br>备注:${ownMessage.remark}
                                        <hr>
                                        </p>
                                    </c:forEach>
                                </div>
                                <div class="mui-button-row">
                                    <button type="button" class="repay-message btn-m mui-btn mui-btn-primary">还款记录
                                    </button>
                                    <button type="button" class="update-remark btn-m mui-btn-warning ">编辑</button>
                                    <button type="button" class="delete-remark btn-m mui-btn-danger ">删除</button>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                    <br><br><br><br><br><br><br><br>
                </ul>
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
        $(".repay-message").click(function () {
            var str = $(this).parent().prevAll(".repay-message-content").html();
//            mui.alert(str, "还款记录");
            layer.alert(str, {title: "还款记录"});
        })

        //点击编辑按钮
        $(".update-remark").click(function () {
            var ownId = $(this).parent().parent().children(".ownId").text();
            var parent = $(this).parent().parent();
            layer.open({
                type: 2
                , content: 'updateModel.do'
                , title: '修改记录'
                , area: ['90%', '400px']
                , btn: ['修改', '取消']
                , success: function (layero, index) {
                    layer.getChildFrame("#name").val(parent.children(".name").text());
                    layer.getChildFrame("#address").val(parent.children(".address").text());
                    layer.getChildFrame("#money").val(parent.children(".money").text());
                    layer.getChildFrame("#bikeType").val(parent.children(".bikeType").text());
                    layer.getChildFrame("#bikeColor").val(parent.children(".bikeColor").text());
                    layer.getChildFrame("#phone").val(parent.children(".a-m").children(".phone").text());
                    layer.getChildFrame("#sellDate").val(parent.children(".sellDate").text());
                    layer.getChildFrame("#remark").val(parent.children(".remark").text());
                    layer.getChildFrame("#address").attr("valueId", parent.children(".addressId").text())
                    layer.getChildFrame("#bikeType").attr("valueId", parent.children(".bikeId").text())
                    layer.getChildFrame("#bikeColor").attr("valueId", parent.children(".colorId").text())
                }
                , yes: function (index, layero) {
                    var name = layer.getChildFrame("#name").val();
                    var addressId = layer.getChildFrame("#address").attr("valueId");
                    var money = layer.getChildFrame("#money").val();
                    var bikeId = layer.getChildFrame("#bikeType").attr("valueId");
                    var colorId = layer.getChildFrame("#bikeColor").attr("valueId");
                    var phone = layer.getChildFrame("#phone").val();
                    var sellDate = layer.getChildFrame("#sellDate").val();
                    var remark = layer.getChildFrame("#remark").val();
                    $.ajax({
                        type: "post",
                        url: "setHadRepay.do",
                        data: {
                            "id": ownId,
                            "name": name,
                            "addressId": addressId,
                            "money": money,
                            "bikeId": bikeId,
                            "colorId": colorId,
                            "phone": phone,
                            "sellDateStr": sellDate,
                            "remark": remark
                        },
                        success: function (data) {
                            if (data == "1") {
                                layer.msg("修改成功！", {icon: 6, time: 700});
                                layer.close(index);
                                setTimeout("location.reload(true)", 500);
                                return;
                            }
                            layer.msg(data, {icon: 5, anim: 0});
                        }
                        ,error : function () {
                            layer.msg("当前系统繁忙，请稍后再试！", {icon: 5, anim: 0});
                        }
                    });
                }
            })
        });

        //点击删除按钮
        $(".delete-remark").click(function () {
            var ownId = $(this).parent().parent().children(".ownId").text();
            layer.confirm("您将要删除该条记录，是否删除？", {icon: 3, title: '警告', anim: 1}, function (index) {
                $.ajax({
                    url: "deleteHadRepay.do"
                    ,type: "post"
                    ,data: {"ownId": ownId}
                    ,success: function (data) {
                        if (data == "1") {
                            layer.msg("删除成功！", {icon: 6, time: 700});
                            layer.close(index);
                            setTimeout("location.reload(true)", 500);
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

        //查询信息
        $("#search-btn").click(function () {
            var str = $("#search").val();
            if(str == "") {
                window.location.href = "hadRepay.do";
                return;
            }
            window.location.href = str + "/searchHadRepay.do";
        })

        //升序排序
        $("#order").click(function () {
            var orderPicker = new mui.PopPicker();
            orderPicker.setData([
                {
                    value: 1,
                    text: "按欠款排序"
                }, {
                    value: 3,
                    text: "按日期排序"
            }]);
            orderPicker.show(function(rs) {
                var order = rs[0].value;
                var str = $("#search").val();
                if(str == "") {
                    window.location.href = order + "/orderHadRepay.do"
                } else {
                    window.location.href = order + "/"+ str + "/orderHadRepay.do"
                }
            })
        });
        //降序排序
        $("#order-desc").click(function () {
            var orderPicker = new mui.PopPicker();
            orderPicker.setData([
                {
                    value: 0,
                    text: "按欠款排序"
                }, {
                    value: 2,
                    text: "按日期排序"
                }]);
            orderPicker.show(function(rs) {
                var order = rs[0].value;
                var str = $("#search").val();
                if(str == "") {
                    window.location.href = order + "/orderHadRepay.do"
                } else {
                    window.location.href = order + "/"+ str + "/orderHadRepay.do"
                }
            })
        });
    })
</script>
</html>
