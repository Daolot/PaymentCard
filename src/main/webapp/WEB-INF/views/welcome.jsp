<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome page</title>
</head>
<body>
	Greeting : ${greeting} <br/>
	<a href="<c:url value="/login" />">Sign in</a> <br/>
	<a href="<c:url value="/registration" />">Sign up</a>
</body>
</html>