<%--
  Created by IntelliJ IDEA.
  User: Maksim Zhukovsky
  Date: 25.03.2018
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/signup-style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css"/>
</head>
<body>
<div class="container">
    <form method="POST" action="${pageContext.request.contextPath}/controller">
        <input type="hidden" name="command" value="signup"/>
        <div class="row">
            <h4>Account</h4>
            <div class="input-group input-group-icon">
                <input type="text" name="login" placeholder="Login"/>
                <div class="input-icon"><i class="fa fa-user"></i></div>
            </div>
            <div class="input-group input-group-icon">
                <input type="email" name="email" placeholder="Email Adress"/>
                <div class="input-icon"><i class="fa fa-envelope"></i></div>
            </div>
            <div class="input-group input-group-icon">
                <input type="password" name="password" placeholder="Password"/>
                <div class="input-icon"><i class="fa fa-key"></i></div>
            </div>
        </div>
        <div class="row">
            <div class="col-half">
                <h4>Date of Birth</h4>
                <div class="input-group">
                    <div class="col-third">
                        <input type="text" name="day-of-birth" placeholder="DD"/>
                    </div>
                    <div class="col-third">
                        <input type="text" name="month-of-birth" placeholder="MM"/>
                    </div>
                    <div class="col-third">
                        <input type="text" name="year-of-birth" placeholder="YYYY"/>
                    </div>
                </div>
            </div>
            <div class="col-half">
                <h4>Gender</h4>
                <div class="input-group">
                    <input type="radio" name="gender" value="Male" id="gender-male"/>
                    <label for="gender-male">Male</label>
                    <input type="radio" name="gender" value="Female" id="gender-female"/>
                    <label for="gender-female">Female</label>
                </div>
            </div>
        </div>
        <div class="row">
            <h4>Personal Details</h4>
            <div class="input-group input-group-icon">
                <input type="text" name="first-name" placeholder="First name"/>
                <div class="input-icon"><i class="fa fa-user"></i></div>
            </div>
            <div class="input-group input-group-icon">
                <input type="text" name="second-name" placeholder="Second name"/>
                <div class="input-icon"><i class="fa fa-user"></i></div>
            </div>
        </div>
        <div class="row">
            <h4>Terms and Conditions</h4>
            <div class="input-group">
                <input type="checkbox" id="terms"/>
                <label for="terms">I accept the terms and conditions for signing up to this service, and hereby confirm I have read the privacy policy.</label>
            </div>
        </div>
        <div class="container-signup-form-btn">
            <button type="submit" class="signup-form-btn" value="Signup">
                Sign Up
            </button>
        </div>
    </form>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.js"/>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"/>
</body>
</html>
