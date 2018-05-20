<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24.04.2018
  Time: 23:47
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
        <div class="col-lg-3 col-md-4 col-sm-6 col-xs-8">
            <img src="${pageContext.request.contextPath}/images/fullname_logo.png" class="img-responsive"/>
        </div>
        <div class="col-lg-3 col-lg-offset-6 col-md-3 col-md-offset-5 col-sm-3 col-sm-offset-3 col-xs-3 col-xs-offset-1">
            <ul class="nav nav-pills">
                <li class="active"><a href="#">Магазин</a></li>
                <li><a href="#">Моя музыка</a></li>
                <li><a href="#">О нас</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/become_provider.jsp">Сотрудничество с MusicStore</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/login.jsp">Выйти</a></li>
            </ul>
        </div>
    </div>
    <div class="container-album">
        <div class="wrap-album">
            <div class="col-lg-4 col-md-4 col-sm-3">
                <img src="${pageContext.request.contextPath}/images/albums/The%20Weeknd%20-%20My%20Dear%20Melancholy,.jpg" class="img-responsive"/>
            </div>
            <div class="col-lg-8 col-md-8 col-sm-9">
                <h2>${album.name}</h2>
                <p>${album.performerId}</p>
                <p>${album.genreId}</p>
                <p>${trackCount} songs</p>
                <p>Released: ${album.releaseDate}</p>
                <div id="nowPlay">
                    <span class="left" id="npAction">Paused...</span>
                    <span class="right" id="npTitle"></span>
                </div>
                <div id="audiowrap">
                    <div id="audio0">
                        <audio preload id="audio1" controls="controls">Your browser does not support HTML5 Audio!</audio>
                    </div>
                <table class="table" id="album-table">
                    <thead>
                    <tr>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="track" items="${trackList}" >
                        <tr>
                            <td><span onclick="playTrack(${track.id})">${track.count}</span></td>
                            <td><span>${track.name}</span></td>
                            <td><span>3:20</span></td>
                            <td><input type="button" value="0.99$" onclick="buyTrack(${track.id})"></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</div>
    <script>

        function playTrack(rowNumber) {
            var audioPlayer = document.getElementById('audio1');
            if (rowNumber === 1) {
                audioPlayer.src = '${pageContext.request.contextPath}/songs/The%20Weeknd%20-%20Call%20Out%20My%20Name.mp3';
            }
            if (rowNumber === 2) {
                audioPlayer.src = '${pageContext.request.contextPath}/songs/The%20Weeknd%20-%20Try%20Me.mp3';
            }
            if (rowNumber === 3) {
                audioPlayer.src = '${pageContext.request.contextPath}/songs/The%20Weeknd%20-%20Wasted%20Times.mp3';
            }
            if (rowNumber === 4) {
                audioPlayer.src = '${pageContext.request.contextPath}/songs/The%20Weeknd%20-%20I%20Was%20Never%20There%20(feat.%20Gesaffelstein).mp3';
            }
            if (rowNumber === 5) {
                audioPlayer.src = '${pageContext.request.contextPath}/songs/The%20Weeknd%20-%20Hurt%20You%20(feat.%20Gesaffelstein).mp3';
            }
            if (rowNumber === 6) {
                audioPlayer.src = '${pageContext.request.contextPath}/songs/The%20Weeknd%20-%20Privilege.mp3';
            }
        }

        function buyTrack(rowNumber) {
            if (rowNumber === 1) {

            }
        }

    </script>
</body>
</html>
