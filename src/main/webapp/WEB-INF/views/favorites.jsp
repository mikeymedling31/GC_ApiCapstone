<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    
<!DOCTYPE html>
<html>
<head>
<style> .button { font: bold 11px Arial; text-decoration: none; background-color: #EEEEEE; color: #333333; padding: 2px 6px 2px 6px; border-top: 1px solid #CCCCCC; border-right: 1px solid #333333; border-bottom: 1px solid #333333; border-left: 1px solid #CCCCCC; } </style> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<img src="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.HpLqcyoP2QTxgG6jC4DUkwHaHa%26pid%3DApi&f=1
" alt="Favorite Family Recipes" width="300" height="300">

<h1> Your Recipe Book: </h1>

<ul> 
<c:forEach var="favorite" items="${ favorites }">  
<li> ${ favorite.label }
<a href="/details/${ favorite.id }" class="button">See Recipe Details</a> 
<a href="/deleterecipe/${ favorite.id }" class="button">Delete This Recipe</a> 
</li>
		</c:forEach>
		</ul>
		



</body>
</html>