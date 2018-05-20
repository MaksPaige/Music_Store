<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 22.04.2018
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Music Store</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user-style.css"/>
</head>
<body>
<div class="container-fluid">
    <div class="row navigation-row">
        <div class="col-lg-3 col-md-4 col-sm-6 col-xs-8">
            <img src="${pageContext.request.contextPath}/images/fullname_logo.png" class="img-responsive"/>
        </div>
        <div class="col-lg-3 col-lg-offset-6 col-md-3 col-md-offset-5 col-sm-3 col-sm-offset-3 col-xs-3 col-xs-offset-1">
            <ul class="nav nav-pills">
                <li class="active"><a href="#">Статистика</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/new_album.jsp">Добавить альбом</a></li>
                <li><a href="#">Добавить single</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/login.jsp">Выйти</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
