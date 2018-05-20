<%--
  Created by IntelliJ IDEA.
  User: Maksim Zhukovsky
  Date: 24.03.2018
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="top-nav">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="top-nav-left">one good thing about music, when it hits you, you feel no pain.</div>
                </div>
                <div class="col-md-6 text-right">
                        <ul class="top-nav-menu">
                            <li class="currency">
                                <a href="#">usd<i class="fa fa-angle-down"></i></a>
                                <ul class="currency-selection">
                                    <li><a href="#">byn</a></li>
                                </ul>
                            </li>
                            <li class="language">
                                <a href="#">English<i class="fa fa-angle-down"></i></a>
                                <ul class="language-selection">
                                    <li><a href="#">Russian</a></li>
                                </ul>
                            </li>
                        </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="row navigation-row">
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
            <img src="${pageContext.request.contextPath}/images/fullname_logo.png" class="img-responsive"/>
        </div>
        <div class="col-lg-4 col-lg-offset-2 col-md-4 col-md-offset-2 col-sm-4 col-sm-offset-2 col-xs-4 col-xs-offset-2">
            <ul class="nav nav-pills">
                <li class="active"><a href="#">Магазин</a></li>
                <li><a href="#">Моя музыка</a></li>
                <li><a href="#">О нас</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/become_provider.jsp">Сотрудничество с MusicStore</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/login.jsp">Выйти</a></li>
            </ul>
        </div>
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">

                <div class="row"><p>Приветствуем, ${sessionScope.firstName}!</p></div>
                <div class="row"><p>На вашем балансе: ${sessionScope.cash}$</p></div>
        </div>

            <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 left">
                <span class="user-form-avatar">
                <img style="border-radius: 50%" src="${pageContext.request.contextPath}${sessionScope.avatar}">
            </span>
            </div>
    </div>
    </div>
        <ul id="slides">
            <li class="slide showing"></li>
            <li class="slide"></li>
            <li class="slide"></li>
            <li class="slide"></li>
            <li class="slide"></li>
            <li class="slide"></li>
        </ul>

            <div class="row category-header">
                <h2>Новые альбомы</h2>
            </div>
            <div class="row showcase">
                <div class="wrap">
                    <c:forEach var="album" items="${sessionScope.latestAlbums}" >
                        <div class="block col">
                            <form method="POST" action="${pageContext.request.contextPath}/controller">
                                <input type="hidden" name="command" value="showalbum"/>
                            <img src="${pageContext.request.contextPath}/${album.imagePath}"/>
                            <h2 class="title">${album.name}</h2>
                            <p class="sub-title">${album.performerId}</p>
                            <p class="price">Price <span class="price-count">${album.cost}</span> $</p>
                            <button type="submit" class="main-form-btn" name="album-id" value="${album.id}">More</button>
                            </form>
                        </div>
                    </c:forEach>


            </div>
        </div>
</div>
<script>
    var slides = document.querySelectorAll('#slides .slide');
    var currentSlide = 0;
    var slideInterval = setInterval(nextSlide,3000);

    function nextSlide() {
        slides[currentSlide].className = 'slide';
        currentSlide = (currentSlide+1)%slides.length;
        slides[currentSlide].className = 'slide showing';
    }
</script>
</body>
</html>
