package co.grandcircus.gcApiCapstone;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="searchresults")
public class RecipeSearchResults {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long result_id;
	private String uri;
	private String url;
	private String label;
	private Integer yeild;
	private Integer totaltime;
	@OneToMany(mappedBy="searchresults")
	private List<RecipeIngredients> recipeingredients = new ArrayList<RecipeIngredients>();
	
	public RecipeSearchResults() {
		
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getResult_id() {
		return result_id;
	}
	public void setResult_id(Long result_id) {
		this.result_id = result_id;
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
