package co.grandcircus.gcApiCapstone;

import javax.persistence.*;

@Entity
@Table(name="recipeingredients")
public class RecipeIngredients {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ingredient_id;
	private String text;
	@ManyToOne
	@JoinColumn(name="fav_id", nullable=true,updatable=true)
	private FavoriteRecipe favoriterecipes;
	@ManyToOne
	@JoinColumn(name="result_id", nullable=true,updatable=true)
	private RecipeSearchResults searchresults;
	
	public RecipeSearchResults getSearchresult() {
		return searchresults;
	}
	public void setSearchresult(RecipeSearchResults searchresults) {
		this.searchresults = searchresults;
	}
	public FavoriteRecipe getFavoriterecipe() {
		return favoriterecipes;
	}
	public void setFavoriterecipe(FavoriteRecipe favoriterecipes) {
		this.favoriterecipes = favoriterecipes;
	}
	public RecipeIngredients() {
		
	}
	public Long getId() {
		return ingredient_id;
	}
	public void setId(Long ingredient_id) {
		this.ingredient_id = ingredient_id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	

}
