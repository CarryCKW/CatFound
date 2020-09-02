<%--
  Created by IntelliJ IDEA.
  User: 蔡小蔚
  Date: 2020/7/21
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="all_need.jsp"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>
    <link href="${pageContext.request.contextPath}/css/simplestyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- Main Container -->
<div class="container">
    <!-- Header -->
    <header class="header">
        <h4 class="logo">CatFound</h4>
    </header>
    <!-- Hero Section -->
    <section class="intro">
        <div class="column">
            <h3>Hi !</h3>
            <img src="${pageContext.request.contextPath}/picture/theme.jpg" alt="" class="profile"/>
            <br>
            <br>
            <a href="#"><h2>》》想做铲屎官</h2></a>
            <a href="#"><h2>》》我要找领养</h2></a>

        </div>
        <div class="column">
            <div align="left">
                <p>denglu</p>
            </div>
            <div align="justify">
                <p>zhuce</p>
            </div>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla</p>
        </div>
    </section>
    <!-- Stats Gallery Section -->
    <div class="gallery">
        <div class="thumbnail"> <a href="#"><img src="" alt="" width="2000" class="cards"/></a>
            <h4>TITLE</h4>
            <p class="tag">HTML, CSS, JS, WordPress</p>
            <p class="text_column">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
        </div>
        <div class="thumbnail"> <a href="#"><img src="" alt="" width="2000" class="cards"/></a>
            <h4>TITLE</h4>
            <p class="tag">HTML, CSS, JS, WordPress</p>
            <p class="text_column">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
        </div>

    </div>

    <!-- Footer Section -->
    <footer id="contact">
        <p class="hero_header">GET IN TOUCH WITH ME</p>
        <div class="button">EMAIL ME </div>
    </footer>
    <!-- Copyrights Section -->
    <div class="copyright">&copy;2015 - <strong>GRID</strong></div>
</div>
<!-- Main Container Ends -->
</body>
</html>
