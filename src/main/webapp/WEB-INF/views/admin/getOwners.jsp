<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="header.jsp"/>
<head>
</head>

<body style="background-color: #EDEEF0">
<div id="content">
    <table id="myTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>№</th>
            <th>Никнейм</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Город</th>
            <th>Мобильный телефон</th>
            <th>Почта</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${owners}" var="owner">
            <tr>
                <td>${owner.person.personId}</td>
                <td>${owner.person.nickname}</td>
                <td>${owner.person.firstName}</td>
                <td>${owner.person.lastName}</td>
                <td>${owner.person.city.cityName}</td>
                <td>${owner.person.mobileNumber}</td>
                <td>${owner.person.email}</td>
                <%--<td><input type="checkbox" value=""/></td>--%>
                <td>
                <spring:url value="/admin/allOwners/${owner.ownerId}/delete" var="deleteUrl"/>
                <spring:url value="/admin/allOwners/${owner.ownerId}/edit" var="editUrl"/>

                <button class="btn btn-primary"
                        onclick="location.href='${editUrl}'">Редактировать
                </button>
                <button class="btn btn-danger"
                        onclick="location.href='${deleteUrl}'">Удалить
                </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>