<%@ page import="org.springframework.web.context.ContextLoader" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="carry.repository.Cat" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 蔡小蔚
  Date: 2020/7/20
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="all_need.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>HomePage</title>
    <link href="${pageContext.request.contextPath}/css/pagestyle.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/simplestyle.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style>
        /* Make the image fully responsive */
        .carousel-inner img {
            width: 100%;
            height: 100%;
        }
        #demo{
            width: 480px;
            height: 270px;
            margin: auto;
        }
    </style>
<%--    <link href="${pageContext.request.contextPath}/js/jquery-3.5.1.js" >--%>
<%--    <link href="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js" >--%>
<%--    <link href="${pageContext.request.contextPath}/js/pageInfoChange.js" rel="script" >--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js">
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/pageInfoChange.js">
    </script>

</head>
<body background="${pageContext.request.contextPath}/picture/home_page_bg.jpg">
<%--以下主题照片--%>
<%--    <div align="center"><img src="${pageContext.request.contextPath}/picture/theme.jpg" align="center"></div>--%>
<div id="demo" class="carousel slide" data-ride="carouse" align="center">

    <!-- 指示符 -->
    <ul class="carousel-indicators">
        <li data-target="#demo" data-slide-to="0" class="active"></li>
        <li data-target="#demo" data-slide-to="1"></li>
        <li data-target="#demo" data-slide-to="2"></li>
    </ul>

    <!-- 轮播图片 -->
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="${pageContext.request.contextPath}/picture/1.jpg">
        </div>
        <div class="carousel-item">
            <img src="${pageContext.request.contextPath}/picture/2.jpg">
        </div>
        <div class="carousel-item">
            <img src="${pageContext.request.contextPath}/picture/3.jpg">
        </div>
    </div>

    <!-- 左右切换按钮 -->
    <a class="carousel-control-prev" href="#demo" data-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </a>
    <a class="carousel-control-next" href="#demo" data-slide="next">
        <span class="carousel-control-next-icon"></span>
    </a>

</div>
<%--   以下主要猫猫显示内容 --%>
    <div id="mainwrapper">
        <header>

            <div id="logo">CatFound</div>

<%--            此处根据有无Cookie返回不同结果，若登录返回用户名--%>
            <%
                Cookie[] cookies = request.getCookies();
                String name = null;
                boolean hasUser = false;
                if (cookies!=null){
                    for (Cookie cookie:cookies){
                        if (cookie.getName().equalsIgnoreCase("name")){
                            name = URLDecoder.decode(cookie.getValue(),"utf-8");
                            if(!name.equals(null)){
                                hasUser=true;
                            }
                        }
                    }
                }
            %>

            <%
                if (hasUser){
            %>
                <h3>Weclome <%=name%> .</h3>
             <%
                }else{
             %>
            <nav>
                <a href="${pageContext.request.contextPath}/loginForm" title="Link">登录</a>
                <a href="${pageContext.request.contextPath}/registForm" title="Link">注册</a>
            </nav>
             <%
             }
             %>

        </header>
        <!--这里列举出猫猫信息-->
        <section>
            <c:if test="${not empty catlist}">
                <c:forEach var="cat" items="${catlist}" varStatus="c">
                    <div class="gallery">
                        <div class="thumbnail"> <a href="#"><img src="" alt="" width="2000" class="cards"/></a>
                            <h4>${cat.name}</h4>
                            <c:if test="${not cat.adopted}">
                                <span class="spAdopt${cat.id}">没有被领养哦!</span>
                            </c:if>
                            <c:if test="${cat.adopted}">
                                <span class="spAdopt${cat.id}">已经被领养啦!</span>
                            </c:if>
                            <p class="tag">${cat.birthTime}</p>
                            <p class="text_column">${cat.description}</p>
                            <button class="changeAdpot" id="${cat.id}">想要领养</button>
                        </div>
                    </div>

                </c:forEach>
            </c:if>


<%--            <div class="gallery">--%>
<%--                <div class="thumbnail"> <a href="#"><img src="" alt="" width="2000" class="cards"/></a>--%>
<%--                    <h4>${catlist.get(0).name}</h4>--%>
<%--                    <p class="tag">${catlist.get(0).birthTime}</p>--%>
<%--                    <p class="text_column">${catlist.get(0).description}</p>--%>
<%--                </div>--%>
<%--                <div class="thumbnail"> <a href="#"><img src="" alt="" width="2000" class="cards"/></a>--%>
<%--                    <h4>${catlist.get(1).name}</h4>--%>
<%--                    <p class="tag">${catlist.get(1).birthTime}</p>--%>
<%--                    <p class="text_column">${catlist.get(1).description}</p>--%>
<%--                </div>--%>
<%--            </div>--%>

        </section>
<%--        <footer>--%>
            <div id="footerbar">
                <p id="textplace">&copy;All rights belong to The Creator LaceyS, Carry, HLE,YYX</p>
            </div>
<%--        </footer>--%>
    </div>

</body>
</html>
