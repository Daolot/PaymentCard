<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>

    <link href="/static/css/boot.css" rel="stylesheet">


</head>

<body>
<div class="container">


    <c:choose>
        <c:when test="${edit}">
            <legend><h2>Редактировать владельца</h2></legend>
            <spring:url value="/admin/allOwners/editOwners" var="userActionUrl"/>
        </c:when>
        <c:otherwise>
            <legend><h2>Добавить владельца</h2></legend>
            <spring:url value="/admin/addOwner/newOwner" var="userActionUrl"/>
        </c:otherwise>
    </c:choose>

    <form:form method="POST" modelAttribute="ownerForm" action="${userActionUrl}" class="form-horizontal">
        <form:input type="hidden" path="ownerId" id="ownerId"/>

        <form:input type="hidden" path="person.personId" id="person.personId"/>

        <div class="form-group">
            <label class="col-md-4 control-label" for="person.nickname">Никнейм</label>
            <div class="col-md-4">
                <form:input type="text" path="person.nickname" id="person.nickname" class="form-control"/>
                <div class="has-error">
                    <form:errors path="person.nickname" class="help-inline"/>
                </div>
            </div>
        </div>

        <c:choose>
            <c:when test="${edit}">
                <div class="form-group" style="display: none">
                    <label class="col-md-4 control-label" for="person.password">Пароль</label>
                    <div class="col-md-4">
                        <form:input type="password" path="person.password" id="person.password" class="form-control"/>
                        <div class="has-error">
                            <form:errors path="person.password" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="form-group">
                    <label class="col-md-4 control-label" for="person.password">Пароль</label>
                    <div class="col-md-4">
                        <form:input type="password" path="person.password" id="person.password" class="form-control"/>
                        <div class="has-error">
                            <form:errors path="person.password" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>


        <div class="form-group">
            <label class="col-md-4 control-label" for="person.firstName">Имя</label>
            <div class="col-md-4">
                <form:input type="text" path="person.firstName" id="person.firstName" class="form-control"/>
                <div class="has-error">
                    <form:errors path="person.firstName" class="help-inline"/>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="person.lastName">Фамилия</label>
            <div class="col-md-4">
                <form:input type="text" path="person.lastName" id="person.lastName" class="form-control"/>
                <div class="has-error">
                    <form:errors path="person.lastName" class="help-inline"/>
                </div>
            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label" for="person.mobileNumber">Номер телефона</label>
            <div class="col-md-4">
                <form:input type="text" path="person.mobileNumber" id="person.mobileNumber" class="form-control"/>
                <div class="has-error">
                    <form:errors path="person.mobileNumber" class="help-inline"/>
                </div>
            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label" for="person.email">Электронная почта</label>
            <div class="col-md-4">
                <form:input type="text" path="person.email" id="person.email" class="form-control"/>
                <div class="has-error">
                    <form:errors path="person.email" class="help-inline"/>
                </div>
            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label" for="person.city">Выберите город</label>
            <div class="col-md-4">
                <form:select path="person.city" class="form-control">
                    <%--<form:option value="NONE" label=""/>--%>
                    <form:options items="${cities}" multiple="false" itemValue="cityId" itemLabel="cityName"/>
                    <div class="has-error">
                        <form:errors path="person.city" class="help-inline"/>
                    </div>
                </form:select>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="person.city">Выберите компанию</label>
            <div class="col-md-4">
                <form:select path="company" class="form-control">
                    <%--<form:option value="NONE" label=""/>--%>
                    <form:options items="${companies}" multiple="false" itemValue="companyId" itemLabel="companyName"/>
                    <div class="has-error">
                        <form:errors path="company" class="help-inline"/>
                    </div>
                </form:select>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label"></label>
            <div class="col-md-4">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Редактировать" class="btn btn-success"/>
                        <a href="/admin" class="forgot-password" style="padding-left: 27%">Отмена</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Добавить" class="btn btn-success"/>
                        <a href="/admin" class="forgot-password" style="padding-left: 27%">Отмена</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>

    <div class="navbar navbar-inner  navbar-fixed-bottom">
        <p>
        <center class="text-muted">© NetCracker Education Center 2017</center>
        </p>
    </div>
</div>
</body>
</html>
