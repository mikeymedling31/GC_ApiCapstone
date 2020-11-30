<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recipe Details</title>
</head>
<body>
	
	<H1>${ recipe.label}</H1>
	
	<p>
		Servicing size ${ recipe.yield }
		Prep time ${ recipe.totalTime }
	</p>
	
	<ul>
		<c:forEach var="ingredients" items="${ recipe.ingredients }">
		<li>${ ingredients }</li>
		</c:forEach>
	</ul>
	
	
	
</body>
</html>
