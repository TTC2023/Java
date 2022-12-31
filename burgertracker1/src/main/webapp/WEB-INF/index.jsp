<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Burger Rater</title>
</head>
<body>
	<h1>Burger Tracker</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Restaurant</th>
			<th>Rating</th>
			<th>Action</th>
		</tr>
		<c:forEach var="oneBurger" items="${burgers}">
			<tr>
	        	<td><c:out value="${oneBurger.burgerName}"></c:out></td>
	        	<td><c:out value="${oneBurger.restaurantName}"></c:out></td>
	        	<td><c:out value="${oneBurger.rating}"></c:out></td>
	        	<td><a href="/edit/${oneBurger.id}">Edit</a></td>
			</tr>
   		 </c:forEach>
	</table>
	<h2>Add a Burger:</h2>
	<form:form action="/create" method="POST" modelAttribute="burger">
		<div>
			<form:errors path="burgerName"/><br>
			<form:label path="burgerName">Burger Name: </form:label>
			<form:input path="burgerName"/>
		</div>
		<div>
			<form:errors path="restaurantName"/><br>
			<form:label path="restaurantName">Restaurant Name: </form:label>
			<form:input path="restaurantName"/>
		</div>
		<div>
			<form:errors path="rating"/><br>
			<form:label path="rating">Rating: </form:label>
			<form:input path="rating"/>
		</div>
		<div>
			<form:errors path="notes"/><br>
			<form:label path="notes">Notes: </form:label>
			<form:input path="notes"/>
		</div>
		<button>Submit</button>
	</form:form>
</body>
</html>