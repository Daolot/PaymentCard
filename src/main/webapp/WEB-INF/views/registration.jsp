<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>

    <link href="/static/css/boot.css" rel="stylesheet">




</head>

<body>
<div class="container">
    <legend><h2>Регистрация</h2></legend>
    <form:form method="POST" modelAttribute="userForm" action="/registration/newUser" class="form-horizontal">
        <form:input type="hidden" path="personId" id="personId"/>

            <div class="form-group">
                <label class="col-md-4 control-label" for="nickname">Никнейм</label>
                <div class="col-md-4">
                    <c:choose>
                        <c:when test="${edit}">
                            <form:input type="text" path="nickname" id="nickname" class="form-control"/>
                        </c:when>
                        <c:otherwise>
                            <form:input type="text" path="nickname" id="nickname" class="form-control"/>
                            <div class="has-error">
                                <form:errors path="nickname" class="help-inline"/>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Пароль</label>
                <div class="col-md-4">
                    <form:input type="password" path="password" id="password" class="form-control"/>
                    <div class="has-error">
                        <form:errors path="password" class="help-inline"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="firstName">Имя</label>
                <div class="col-md-4">
                    <form:input type="text" path="firstName" id="firstName" class="form-control"/>
                    <div class="has-error">
                        <form:errors path="firstName" class="help-inline"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="lastName">Фамилия</label>
                <div class="col-md-4">
                    <form:input type="text" path="lastName" id="lastName" class="form-control"/>
                    <div class="has-error">
                        <form:errors path="lastName" class="help-inline"/>
                    </div>
                </div>
            </div>


            <div class="form-group">
                <label class="col-md-4 control-label" for="mobileNumber">Номер телефона</label>
                <div class="col-md-4">
                    <form:input type="text" path="mobileNumber" id="mobileNumber" class="form-control"/>
                    <div class="has-error">
                        <form:errors path="mobileNumber" class="help-inline"/>
                    </div>
                </div>
            </div>


            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Электронная почта</label>
                <div class="col-md-4">
                    <form:input type="text" path="email" id="email" class="form-control"/>
                    <div class="has-error">
                        <form:errors path="email" class="help-inline"/>
                    </div>
                </div>
            </div>


            <div class="form-group">
                <label class="col-md-4 control-label" for="City">Город</label>
                <div class="col-md-4">
                    <form:select path="city" items="${cities}" multiple="false" itemValue="cityId" itemLabel="cityName"
                                 class="form-control"/>
                    <div class="has-error">
                        <form:errors path="city" class="help-inline"/>
                    </div>
                </div>
            </div>


            <sec:authorize access="hasRole('ADMIN')">
                <div class="row">

                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="Role">Role</label>
                        <div class="col-md-7">
                            <form:select path="role" items="${rollers}" multiple="false" itemValue="roleId" itemLabel="roleType"
                                         class="form-control"/>
                            <div class="has-error">
                                <form:errors path="role" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
            </sec:authorize>

            <div class="form-group">
                <label class="col-md-4 control-label"></label>
                <div class="col-md-4">
                    <input type="submit" value="Зарегистрироваться" class="btn btn-success"/>
                    <a href="/welcome" class="forgot-password" style="padding-left: 27%">Отмена</a>
                </div>
            </div>
        </form:form>

        <div class="navbar navbar-inner  navbar-fixed-bottom">
            <p><center  class="text-muted">© NetCracker Education Center 2017</center></p>
        </div>
</div>
</body>
</html>