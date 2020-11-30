package co.grandcircus.gcApiCapstone;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientsRepository extends JpaRepository<RecipeIngredients,Long>{
	
	public List<RecipeIngredients> findAllBySearchresults(RecipeSearchResults searchresults);

}
