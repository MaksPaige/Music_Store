<%--
  Created by IntelliJ IDEA.
  User: Maksim Zhukovsky
  Date: 17.04.2018
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Become a provider</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/become-provider-style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css"/>
</head>
<body>
<div class="container">
    <form method="POST" action="${pageContext.request.contextPath}/controller">
        <input type="hidden" name="command" value="becomeprovider"/>
        <div class="row">
            <h1>Working with Music Store</h1>
            <p>Signing up to offer your music on iTunes is free. Additional details on the sales terms are available during the sign-up process.</p><br/>
            <p>You will be notified via email. Make sure your account is set up to receive email from makspaige@gmail.com and check any spam filters on your email account.</p>
        </div>
        <div class="row">
            <h4>Artist/group account</h4>
            <div class="input-group input-group-icon">
                <input type="text" name="artist-name" placeholder="Artist/group name"/>
                <div class="input-icon"><i class="fa fa-user"></i></div>
            </div>
            <p>You can use your personal email account or enter another email for making business with MusicStore</p>
            <div class="input-group input-group-icon">
                <input type="email" name="email" placeholder="Email Adress" value="${sessionScope.email}"/>
                <div class="input-icon"><i class="fa fa-envelope"></i></div>
            </div>
        </div>
        <div class="row">
            <h4>Description</h4>
            <div class="input-group">
                <textarea name="description" placeholder="Artist/ group desription, rewards, etc." rows="10"></textarea>
            </div>
        </div>

        <div class="container-become-provider-form-btn">
            <button type="submit" class="become-provider-form-btn" value="Becomeprovider">
                Send request
            </button>
        </div>
    </form>
    <script src="${pageContext.request.contextPath}/js/jquery.js"/>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"/>
</body>
</html>

