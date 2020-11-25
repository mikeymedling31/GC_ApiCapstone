package co.grandcircus.gcApiCapstone;

import java.util.ArrayList;

public class Recipe {

	private String uri;
	private String label;
	private Integer yeild;
	private Integer totalTime;
	private Double calories;
	private ArrayList<Ingredients> ingredients;
	
	public Recipe () {
		
	}
	
	public Recipe(String uri, String label, Integer yeild, Integer totalTime, Double calories,
			ArrayList<Ingredients> ingredients) {
		super();
		this.uri = uri;
		this.label = label;
		this.yeild = yeild;
		this.totalTime = totalTime;
		this.calories = calories;
		this.ingredients = ingredients;
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

	public Integer getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(Integer totalTime) {
		this.totalTime = totalTime;
	}

	public Double getCalories() {
		return calories;
	}

	public void setCalories(Double calories) {
		this.calories = calories;
	}

	public ArrayList<Ingredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}

	
}
