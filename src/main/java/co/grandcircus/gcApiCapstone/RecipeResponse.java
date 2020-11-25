package co.grandcircus.gcApiCapstone;

import java.util.List;

public class RecipeResponse {
	
	private String q;
	private List<Recipe> hits;
	
	public RecipeResponse() {
		
	}
	public RecipeResponse(String q, List<Recipe> hits) {
		super();
		this.q = q;
		this.hits = hits;
	}
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	public List<Recipe> getHits() {
		return hits;
	}
	public void setHits(List<Recipe> hits) {
		this.hits = hits;
	}

}
