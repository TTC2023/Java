<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- for Bootstrap CSS -->


<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Fruity Loops</title>
</head>
<body>
	<div>
	</div>
	<div class="d-flex justify-content-around m-4">
		<table class="table w-50 p-3 border">
			<tbody>
				<th>Name:</th>
				<th>Price:</th>
				<c:forEach var="fruit" items="${fruitsFromController}">
					<tr class="table-danger">
						<td><c:out value="${fruit.name}"></c:out></td>
						<td><c:out value="${fruit.price}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
	</div>
</body>
</html>