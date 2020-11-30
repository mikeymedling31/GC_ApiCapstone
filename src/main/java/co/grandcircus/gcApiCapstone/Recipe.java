package co.grandcircus.gcApiCapstone;

import java.util.List;

public class Recipe {

	private String uri;
	private String label;
	private Integer yield;
	private Integer totalTime;
	private List<Ingredients> ingredients;
	private String url;
	
	public Recipe () {
		
	}
	
	

	public Recipe(String uri, String label, Integer yield, Integer totalTime, List<Ingredients> ingredients,
			String url) {
		super();
		this.uri = uri;
		this.label = label;
		this.yield = yield;
		this.totalTime = totalTime;
		this.ingredients = ingredients;
		this.url = url;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
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

	public Integer getyield() {
		return yield;
	}

	public void setyield(Integer yield) {
		this.yield = yield;
	}

	public Integer getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(Integer totalTime) {
		this.totalTime = totalTime;
	}

	public List<Ingredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}

	
}
