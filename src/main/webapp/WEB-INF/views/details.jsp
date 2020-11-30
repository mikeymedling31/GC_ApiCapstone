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

.hero-image {
  height: 50%; 
  border-color: #F7421B;
  border-style: solid;
}

.hero-text {
  text-align: left;
  position: absolute;
  left: 10%;
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
				<form method="post" action="/addfavorite" >
					<input type="hidden" name="label" value="${ recipe.label }" />
					<input type="submit" class="button" value="Add to cookbook"/>
				</form>
			</p>
			
			<ul>
				<c:forEach var="ingredients" items="${ recipe.ingredients }">
				<li>${ ingredients.getText() }</li>
				</c:forEach>
			</ul>
			<a href="${ recipe.url }" class="link">More Details</a><br /> <br /> 
			
			<a href="/" class="link">Search again</a>
	 	</div>
	 	<div class= "image">
	 		<img src="https://st3.depositphotos.com/10638998/16262/i/600/depositphotos_162620250-stock-photo-chef-showing-okay-sign.jpg" width="auto" height="auto">
	 	</div>
 
	</div>	

	
	
</body>
</html>
