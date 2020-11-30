package co.grandcircus.gcApiCapstone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeSearchResultsRepository extends JpaRepository<RecipeSearchResults,Long>{
	
	public RecipeSearchResults findByLabel(String label);

}
