<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 23.04.2018
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Music Store</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/provider-style.css"/>
</head>
<body>
<div class="container-fluid">
    <div class="row navigation-row">
        <div class="col-lg-3 col-md-4 col-sm-6 col-xs-8">
            <img src="${pageContext.request.contextPath}/images/fullname_logo.png" class="img-responsive"/>
        </div>
        <div class="col-lg-3 col-lg-offset-6 col-md-3 col-md-offset-5 col-sm-3 col-sm-offset-3 col-xs-3 col-xs-offset-1">
            <ul class="nav nav-pills">
                <li><a href="${pageContext.request.contextPath}/jsp/main_provider.jsp">Статистика</a></li>
                <li class="active"><a href="#">Добавить альбом</a></li>
                <li><a href="#">Добавить single</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/login.jsp">Выйти</a></li>
            </ul>
        </div>
    </div>
    <div class="row album-row">
        <div class="container-album">
            <div class="wrap-album">
                <div class="col-lg-4 col-md-4 col-sm-3">
                    <form action="${pageContext.request.contextPath}/upload" style="width: 150px; margin-right: -30px;" enctype="multipart/form-data" method="POST">
                        <img style="background-color: #FFFFFF;" src="${pageContext.request.contextPath}/images/plus.png" width="100%" height="100%" onclick="changePhoto()" id="album-img" name="album-img"></a>
                        <input type="file" accept="image/*" style="display: none;" name="album-photo" id="album-photo"/>
                        <button style="width: 80%; margin-top: 5px; margin-left: -20%;">Load file</button>
                    </form>
                </div>
                <div class="col-lg-8 col-md-8 col-sm-9">
                    <div class="input-group">
                        <input type="text" name="album-name" placeholder="Name of the album"/>
                    </div>
                    <select name="album-genre">
                        <option name="pop">Pop</option>
                        <option name="rap">Hip-Hop/Rap</option>
                    </select>
                    <table class="table" id="album-table">
                        <thead>
                        <tr>
                            <th></th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><span>1</span></td>
                            <td><div class="input-group"><input type="text" name="name-track-1" placeholder="Name of the track #1"/></div></td>
                            <td><input type="file" accept="audio/*" name="album-track-1"></td>
                        </tr>
                        <tr>
                            <td><span>2</span></td>
                            <td><div class="input-group"><input type="text" name="name-track-2" placeholder="Name of the track #2"/></div></td>
                            <td><input type="file" accept="audio/*" name="album-track-2"></td>
                        </tr>
                        </tbody>
                    </table>
                    <input type="button" value="Добавить трек" onclick="insertTrack()"/>
                </div>
                <form method="POST" action="${pageContext.request.contextPath}/controller">
                    <input type="hidden" name="command" value="addalbum"/>
                <div class="container-addalbum-form-btn">
                    <button type="submit" class="addalbum-form-btn" value="Addalbum">
                        Add album
                    </button>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    var albumTableLength = 3;

    function insertTrack() {
        var tbody = document.getElementById('album-table').getElementsByTagName('tbody')[0];
        var row = document.createElement('tr');
        tbody.appendChild(row);
        var td1 = document.createElement('td');
        var td2 = document.createElement('td');
        var td3 = document.createElement('td');
        row.appendChild(td1);
        row.appendChild(td2);
        row.appendChild(td3);
        td1.innerHTML = '<span>' + albumTableLength + '</span>';
        td2.innerHTML = '<div class="input-group"><input type="text" name="name-track-' + albumTableLength +'" placeholder="Name of the track #' + albumTableLength +'"/></div>';
        td3.innerHTML = '<input type="file" accept="audio/*" name="album-track-' + albumTableLength + '">';
        albumTableLength++;
    }

    function changePhoto() {
        document.getElementById('album-photo').click();
    }
</script>
<script language="JavaScript" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"/>
<script language="JavaScript" type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"/>
</body>

</html>
