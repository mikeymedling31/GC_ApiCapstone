package co.grandcircus.gcApiCapstone;

import java.util.List;

public class RecipeResponse {
	
	private String q;
	private List<OopsRecipe> hits;
	
	public RecipeResponse() {
		
	}
	public RecipeResponse(String q, List<OopsRecipe> hits) {
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
	public List<OopsRecipe> getHits() {
		return hits;
	}
	public void setHits(List<OopsRecipe> hits) {
		this.hits = hits;
	}

}
