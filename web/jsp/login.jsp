<%--
  Created by IntelliJ IDEA.
  User: Maksim Zhukovsky
  Date: 18.03.2018
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Music Store</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login-style.css"/>
</head>
<body>
    <div class="container-fluid">
        <div class="limiter">
            <div class="container-login">
                <div class="wrap-login">
                    <form class="login-form validate-form" method="POST" action="${pageContext.request.contextPath}/controller">
                        <input type="hidden" name="command" value="login"/>
					    <span class="login-form-logo">
						    <i class="zmdi zmdi-landscape"></i>
					    </span>
                        <span class="login-form-title">Log in</span>
                        <div class="wrap-input">
                            <input class="input" type="text" name="login" placeholder="Login">
                            <span class="focus-input" data-placeholder="&#xf207;"></span>
                        </div>
                        <div class="wrap-input">
                            <input class="input" type="password" name="password" placeholder="Password">
                            <span class="focus-input" data-placeholder="&#xf191;"></span>
                        </div>
                        <div class="contact-form-checkbox">
                            <input class="input-checkbox" id="ckb1" type="checkbox" name="remember-me">
                            <label class="label-checkbox" for="ckb1">
                                Remember me
                            </label>
                        </div>
                        <div class="container-login-form-btn">
                            <button type="submit" class="login-form-btn" value="Login">
                                Log in
                            </button>
                        </div>
                        <div class="text-center">
                            <a class="txt1" href="${pageContext.request.contextPath}/jsp/signup.jsp">
                                Don't have an account? Just Sign Up!
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/jquery.js"/>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"/>
</body>
</html>
