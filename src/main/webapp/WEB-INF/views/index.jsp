<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recipe Home</title>
</head>
<body>

<h1>Welcome, User!</h1>

<h2><a href="/favorites">Recipe Book</a></h2>

<h2>Recipe Search</h2>

<form method="post" action="/search">

Text Search: <input type="text" name="q" />

<input type="submit" />
</form><br /><br />


<form method="post" action="/search/diet" >

Search by Diet Label: 
<select name="dietoption">
	<c:forEach var="diet" items="${ diets }">
		<option value="${ diet }">${ diet }</option>
	</c:forEach>
</select>
<input type="submit" />
</form><br /><br />

<form method="post" action="/search/health" >

Search by Health label: 
<select name="healthoption">
	<c:forEach var="health" items="${ healths }">
		<option value="${ health }">${ health }</option>
	</c:forEach>
</select>
<input type="submit" />
</form><br /><br />




</body>
</html>