<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Results</title>
</head>
<body>

<h1>Search Results</h1>

You searched for: ${ search }, here are the top ten results:

<ul><c:forEach var="recipe" items="${ recipes }">

	<li>${ recipe.label }<form method="post" action="/details"><input type="hidden" name="label" value="${ recipe.label }" /><input type="submit" value="View Details" /></form></li><br />

</c:forEach></ul>

</body>
</html>