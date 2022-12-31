<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>
	<form:form action="/edit/${burger.id}" method="put" modelAttribute="burger">
		<div>
			<form:errors path="burgerName"/><br>
			<form:label path="burgerName">Burger Name: </form:label>
			<form:input value="${burger.burgerName}" path="burgerName"/>
		</div>
		<div>
			<form:errors path="restaurantName"/><br>
			<form:label path="restaurantName">Restaurant Name: </form:label>
			<form:input value="${burger.restaurantName}" path="restaurantName"/>
		</div>
		<div>
			<form:errors path="rating"/><br>
			<form:label path="rating">Rating: </form:label>
			<form:input value="${burger.rating}" path="rating"/>
		</div>
		<div>
			<form:errors path="notes"/><br>
			<form:label path="notes">Notes: </form:label>
			<form:input value="${burger.notes}" path="notes"/>
		</div>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>