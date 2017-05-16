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
            <th>Номер автобуса</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${buses}" var="bus">
            <tr>
                <td>${bus.busId}</td>
                <td>${bus.busNumber}</td>
                    <%--<td><input type="checkbox" value=""/></td>--%>
                <td>
                    <spring:url value="/admin/allBuses/${bus.busId}/delete" var="deleteUrl"/>
                    <spring:url value="/admin/allBuses/${bus.busId}/edit" var="editUrl"/>

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