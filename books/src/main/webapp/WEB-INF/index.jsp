<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach var="oneBook" items="${books}">
			<tr>
	        	<td><a href="/books/${oneBook.id}"><c:out value="${oneBook.title}"></c:out></a></td>
	        	<td><c:out value="${oneBook.description}"></c:out></td>
	        	<td><c:out value="${oneBook.language}"></c:out></td>
	        	<td><c:out value="${oneBook.numberOfPages}"></c:out></td>
			</tr>
   		 </c:forEach>
	</table>
</body>
</html>