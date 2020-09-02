<%--
  Created by IntelliJ IDEA.
  User: 蔡小蔚
  Date: 2020/7/21
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="all_need.jsp"%>
<html>
<head>
    <title>Home</title>
    <link href="${pageContext.request.contextPath}/css/srxstyle.css" type="text/css" rel="stylesheet">
</head>
<body>
    <div class="wel_layout">
        <div class="wel_left">
            <div class="left_1">
                <p>用领养</p>
                <p>代替购买</p>
            </div>
            <div class="left_2">
                <p>CatFound</p>
            </div>
            <div class="left_3">
                <a href="${pageContext.request.contextPath}/homepage" class="hyperlink"> >>想当铲屎官</a>
            </div>
            <div class="left_4">
                <a href="#" class="hyperlink"> >>我要找领养</a>
            </div>
        </div>
        <div class="wel_right">
            <img src="${pageContext.request.contextPath}/picture/home_page_bg.jpg"/>
        </div>
    </div>
</body>
</html>
