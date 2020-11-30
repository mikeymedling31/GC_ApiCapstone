<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recipe Home</title>
<style>
	body, html {
    height: 100%;
}

/* The hero image */
.hero-image {
  /* Use "linear-gradient" to add a darken background effect to the image (photographer.jpg). This will make the text easier to read */
 
  /* Set a specific height */
  height: 50%; 
  border-color: #F7421B;
  border-style: solid;
}

/* Place text in the middle of the image */
.hero-text {
  text-align: left;
  position: absolute;
  left: 30%;
  font-weight: bold;
  color: Black;
}

.image {
	padding-left: 50%;
}

.button{
	font-weight: bold;
	color: white;
	background-color: #F7421B;	
}

.link {
  font: bold;
  text-decoration: none;
  background-color: #F7421B;
  color: white;
  padding: 2px 6px 2px 6px;
  border-top: 1px solid #CCCCCC;
  border-right: 1px solid #333333;
  border-bottom: 1px solid #333333;
  border-left: 1px solid #CCCCCC;
}

.banner {
   width: 100%;
   height: 400px;
}


</style>
</head>
<body>

	<div>
		<div>
			<img alt="" src="https://fwfarms.com/wp-content/uploads/2011/04/Recipe-Banner.jpg" class="banner">
		</div>
	
		<div class="hero-text">
			<h1>Welcome, User!</h1>
			
			<h2><a href="/favorites" class="link">Recipe Book</a></h2>
			
			<h2>Recipe Search</h2>
			
			<form method="post" action="/search">
			
			Text Search: <input type="text" name="q" />
			
			<input type="submit" class="button"/>
			</form><br /><br />
			
			
			<form method="post" action="/search/diet" >
			
			Search by Diet Label: 
			<select name="dietoption" >
				<c:forEach var="diet" items="${ diets }">
					<option value="${ diet }">${ diet }</option>
				</c:forEach>
			</select>
			<input type="submit" class="button"/>
			</form><br /><br />
			
			<form method="post" action="/search/health" >
			
			Search by Health label: 
			<select name="healthoption">
				<c:forEach var="health" items="${ healths }">
					<option value="${ health }">${ health }</option>
				</c:forEach>
			</select>
			<input type="submit" class="button"/>
			</form><br /><br />
		</div>
	</div>

</body>

</html>