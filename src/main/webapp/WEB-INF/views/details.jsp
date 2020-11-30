<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
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
		
		Servicing size ${ recipe.yield } people<br />
		Prep time ${ recipe.totalTime } minutes
	</p>
	
	<ul>
		<c:forEach var="ingredients" items="${ recipe.ingredients }">
		<li>${ ingredients.getText() }</li>
		</c:forEach>
	</ul>
	<a href="${ recipe.url }">More Details</a><br /> 
	
	<a href="/">Search again</a>
	
	
	
</body>
</html>
