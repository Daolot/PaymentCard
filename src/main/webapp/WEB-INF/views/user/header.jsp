<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">

<head>
	<title>Дорожная карта</title>

	<spring:url value="/static/css/user_css/hello.css" var="coreCss" />
	<spring:url value="/static/css/user_css/bootstrap.min.css"
				var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${coreCss}" rel="stylesheet" />
</head>


<spring:url value="/user/user/add" var="urlAddUser" />
<spring:url value="${username1}" var="user" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<ul class="nav navbar-nav navbar-left">
				<li><a class="navbar-brand" style="color: white" href="/user">Личный кабинет</a></li>
				<li><a href="${urlAddUser}">Добавить карту</a></li>
			</ul>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/user/user/${id_user}/info"><strong>${username1}</strong></a></li>
				<%--<li><a><strong>${user}</strong></a></li>--%>
				<li><a href="/logout">Выйти</a></li>
			</ul>
		</div>
	</div>
</nav>