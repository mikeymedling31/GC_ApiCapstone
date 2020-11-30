package co.grandcircus.gcApiCapstone;




import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RecipeService {	
	private RestTemplate restTemplate = new RestTemplate(); 
	
	public RecipeResponse getById(String r) {
				
		System.out.println(r);
		RecipeResponse getR = restTemplate.getForObject("https://api.edamam.com/search?r=" + r + "&app_id=96217916&app_key=275ea784f3be2a0c355959c3d3512b41", RecipeResponse.class);
		
		
		return getR;
	}
	public RecipeResponse getAllRecipes(String qId) {
		RecipeResponse allRecipes = restTemplate.getForObject("https://api.edamam.com/search?q=" + qId + "&app_id=96217916&app_key=275ea784f3be2a0c355959c3d3512b41", RecipeResponse.class);		
		return allRecipes;
	}
	public RecipeResponse getDiet(String dietType) {
		RecipeResponse getDiet = restTemplate.getForObject("https://api.edamam.com/search?q=&app_id=96217916&app_key=275ea784f3be2a0c355959c3d3512b41&diet=" + dietType,RecipeResponse.class);		
		return getDiet;
	}
	public RecipeResponse getHealth(String healthSearch) {
		RecipeResponse getHealth = restTemplate.getForObject("https://api.edamam.com/search?q=&app_id=96217916&app_key=275ea784f3be2a0c355959c3d3512b41&diet=" + healthSearch, RecipeResponse.class);		
		return getHealth;
	}
}