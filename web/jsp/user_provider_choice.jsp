<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 22.04.2018
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Music Store</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user-provider-choice.css"/>
</head>
<body>
<div class="container-fluid">
    <div class="limiter">
        <div class="choice-container">
            <div class="row">
                <div class="text-center"><a class="txt1" href="${pageContext.request.contextPath}/jsp/main_user.jsp">Continue as a user</a></div>
            </div>
            <div class="row">
                <div class="text-center"><a class="txt2" href="${pageContext.request.contextPath}/jsp/main_provider.jsp">Continue as a provider</a></div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.js"/>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"/>
</body>
</html>
