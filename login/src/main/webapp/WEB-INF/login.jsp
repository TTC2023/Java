<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>Login Here</h1>
	<div>
		<form:form action="/register" method="POST" modelAttribute="newUser">
			<div>
				<form:errors path="firstName"/>
				<form:label path="firstName">First Name: </form:label>
				<form:input path="firstName"/>
			</div>
			<div>
				<form:errors path="lastName"/>
				<form:label path="lastName">Last Name: </form:label>
				<form:input path="lastName"/>
			</div>
			<div>
				<form:errors path="username"/>
				<form:label path="username">Username: </form:label>
				<form:input path="username"/>
			</div>
			<div>
				<form:errors path="email"/>
				<form:label path="email">Email: </form:label>
				<form:input path="email"/>
			</div>
			<div>
				<form:errors path="password"/>
				<form:label path="password">Password: </form:label>
				<form:input path="password"/>
			</div>
			<div>
				<form:errors path="confirm"/>
				<form:label path="confirm">Confirm Password: </form:label>
				<form:input path="confirm"/>
			</div>
			<button>Create User</button>
		</form:form>
	</div>
	<div class="p-2 g-col-6">
		<form:form action="/login" method="POST" modelAttribute="newLogin">
			<div>
				<form:errors path="email"/>
				<form:label path="email">Email: </form:label>
				<form:input path="email"/>
			</div>
			<div>
				<form:errors path="password"/>
				<form:label path="password">Password: </form:label>
				<form:input path="password"/>
			</div>
			<button>Login</button>
		</form:form>
	</div>
	
</body>
</html>