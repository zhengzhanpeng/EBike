<%--
  Created by IntelliJ IDEA.
  User: ho
  Date: 2017/7/25
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <link href="css/mui.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="css/mui.picker.min.css"/>
</head>

<body>
<div class="mui-content" style="padding: 10px;">
    <div class="mui-input-group">
        <div class="mui-input-row">
            <label>姓名</label>
            <input type="text" id="name" class="mui-input-clear" placeholder="请输入姓名">
        </div>
        <div class="mui-input-row">
            <label>地址</label>
            <input type="text" id="address" class="mui-input-clear" valueId="0" placeholder="请输入购车人住址">
        </div>
        <div class="mui-input-row">
            <label>欠款</label>
            <input type="text" id="money" class="mui-input-clear" placeholder="请输入当前欠款">
        </div>
        <div class="mui-input-row">
            <label>车型</label>
            <input type="text" id="bikeType" class="mui-input-clear" valueId="0" placeholder="请输入所购的车型">
        </div>
        <div class="mui-input-row">
            <label>颜色</label>
            <input type="text" id="bikeColor" class="mui-input-clear" valueId="0" placeholder="请输入所购的车型颜色">
        </div>
        <div class="mui-input-row">
            <label>电话</label>
            <input type="text" id="phone" class="mui-input-clear" placeholder="请输入联系电话">
        </div>
        <div class="mui-input-row">
            <label>日期</label>
            <input type="text" id="sellDate" class="mui-input-clear" placeholder="请输入出售日期">
        </div>
        <div class="mui-input-row">
            <label>备注</label>
            <textarea id="remark" placeholder="请输入备注"></textarea>
        </div>
    </div>
</div>
<script src="js/mui.min.js"></script>
<script type="text/javascript" src="js/mui.picker.min.js"></script>
<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<script type="text/javascript">
    mui.init();
    mui.ready(function () {
        var addressPicker = new mui.PopPicker();
        addressPicker.setData([
            <c:forEach items="${addressList}" var="a" varStatus="v">
            <c:if test="${!v.first}">, </c:if> {
                value: ${a.id},
                text: '${a.addressName}'
            }
            </c:forEach>
        ]);
        var bikeTypePicker = new mui.PopPicker();
        bikeTypePicker.setData([
            <c:forEach items="${bikeList}" var="b" varStatus="v">
            <c:if test="${!v.first}">, </c:if> {
                value: ${b.id},
                text: '${b.bikeType}'
            }</c:forEach>]);
        var bikeColorPicker = new mui.PopPicker();
        bikeColorPicker.setData([
            <c:forEach items="${colorList}" var="c" varStatus="v">
            <c:if test="${!v.first}">, </c:if> {
                value: ${c.id},
                text: '${c.bikeColor}'
            }</c:forEach>]);
        $("#address").click(function () {
            document.activeElement.blur();
            addressPicker.show(function (rs) {
                $("#address").attr("valueId", rs[0].value).val(rs[0].text);
            })

        })
        $("#bikeType").click(function () {
            document.activeElement.blur();
            bikeTypePicker.show(function (rs) {
                $("#bikeType").attr("valueId", rs[0].value).val(rs[0].text);
            })

        })
        $("#bikeColor").click(function () {
            document.activeElement.blur();
            bikeColorPicker.show(function (rs) {
                $("#bikeColor").attr("valueId", rs[0].value).val(rs[0].text);
            })

        });
        $("#sellDate").click(function () {
            document.activeElement.blur();
            var dtPicker = new mui.DtPicker({
                "type": "date"
            });
            dtPicker.show(function (rs) {
                $("#sellDate").val(rs.text);
                dtPicker.dispose();
            });

        })
    })
</script>
</body>

</html>
