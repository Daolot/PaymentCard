<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="ru">

<jsp:include page="header.jsp" />

<body>

	<div class="container">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1>Все карты</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Номер карты</th>
					<th>Имя карты</th>
					<th>Статус</th>
					<th>Баланс</th>
					<th>Действие</th>
				</tr>
			</thead>

			<c:forEach var="card" items="${card}">
				<tr>
					<td>
						${card.cardId}
					</td>
					<td>${card.cardName}</td>
					<td>${card.typeCard.status}</td>
					<td>${card.cardBalance.balance}</td>
					<td>
						<spring:url value="/user/user/${card.cardId}" var="userUrl" />
						<spring:url value="/user/user/${card.cardId}/block" var="deleteUrl" />
						<spring:url value="/user/user/${card.cardId}/update" var="updateUrl" />
						<spring:url value="/user/user/${card.cardId}/money" var="moneyUrl" />
						<spring:url value="/user/user/${card.cardId}/map" var="mapUrl" />

						<button class="btn btn-info" onclick="location.href='${userUrl}'">Query</button>
						<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
						<button class="btn btn-primary" onclick="location.href='${moneyUrl}'">Money</button>
						<button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Delete</button></td>
					<button class="btn btn-danger" onclick="location.href='${mapUrl}'">Map</button></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>