<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recipe Details</title>
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
  left: 10%;
  

  color: Black;
}

.image {
	padding-left: 50%;
}
</style>
</head>
<body>

	<div class="hero-image">
		  <div class="hero-text">
			<H1>${ recipe.label}</H1>
			
			<p>
				Servicing size ${ recipe.yield } people<br />
				Prep time ${ recipe.totalTime } minutes<br />
				<form method="post" action="/addfavorite">
					<input type="hidden" name="label" value="${ recipe.label }" />
					<input type="submit" value="Add to cookbook"/>
				</form>
			</p>
			
			<ul>
				<c:forEach var="ingredients" items="${ recipe.ingredients }">
				<li>${ ingredients.getText() }</li>
				</c:forEach>
			</ul>
			<a href="${ recipe.url }">More Details</a><br /> 
			
			<a href="/">Search again</a>
	 	</div>
	 	<div class= "image">
	 		<img src="https://st3.depositphotos.com/10638998/16262/i/600/depositphotos_162620250-stock-photo-chef-showing-okay-sign.jpg" width="auto" height="auto">
	 	</div>
 
	</div>	

	
	
</body>
</html>
