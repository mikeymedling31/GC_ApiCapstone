package co.grandcircus.gcApiCapstone;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="favoriterecipes")
public class FavoriteRecipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long fav_id;
	private String uri;
	private String url;
	private String label;
	private Integer yeild;
	private Integer totaltime;
	@OneToMany(mappedBy="favoriterecipes")
	private List<RecipeIngredients> recipeingredients = new ArrayList<RecipeIngredients>();
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public FavoriteRecipe() {
		
	}
	public Long getId() {
		return fav_id;
	}
	public void setId(Long fav_id) {
		this.fav_id = fav_id;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Integer getYeild() {
		return yeild;
	}
	public void setYeild(Integer yeild) {
		this.yeild = yeild;
	}
	public Integer getTotaltime() {
		return totaltime;
	}
	public void setTotaltime(Integer totaltime) {
		this.totaltime = totaltime;
	}
	public List<RecipeIngredients> getRecipeingredients() {
		return recipeingredients;
	}
	public void setRecipeingredients(List<RecipeIngredients> recipeingredients) {
		this.recipeingredients = recipeingredients;
	}
	

}
