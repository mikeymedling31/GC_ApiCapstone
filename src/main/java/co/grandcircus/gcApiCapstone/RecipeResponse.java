package co.grandcircus.gcApiCapstone;

public class RecipeResponse {
	
	private String q;
	private Recipe[] hits;
	
	public RecipeResponse() {
		
	}
	public RecipeResponse(String q, Recipe[] hits) {
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
	public Recipe[] getHits() {
		return hits;
	}
	public void setHits(Recipe[] hits) {
		this.hits = hits;
	}

}
