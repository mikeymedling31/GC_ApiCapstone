package co.grandcircus.gcApiCapstone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeController {
	
	@Autowired
	private FavoriteRecipeRepository fav_repo;
	
	@Autowired
	private RecipeIngredientsRepository ing_repo;
	
	@Autowired
	private RecipeSearchResultsRepository results_repo;
	
	@Autowired
	private RecipeService service;
	
	@GetMapping("/")
	public String home(Model model) {
		
		List<String> diets = new ArrayList<>();
		

		diets.add("balanced");	
		diets.add("low-carb");
		diets.add("low-fat");


		
		model.addAttribute("diets",diets);
		
		List<String> healths = new ArrayList<>();

		healths.add("alcohol-free");
		healths.add("peanut-free");
		healths.add("sugar-conscious");
		healths.add("tree-nut-free");		
		healths.add("vegan");
		healths.add("vegetarian");


		model.addAttribute("healths",healths);
		
		return "index";
	}
	
	
	// SEARCHING
	@PostMapping("/search")
	public String searchByText(@RequestParam String q, Model model) {
		RecipeResponse response = service.getAllRecipes(q);
		
		List<OopsRecipe> oopsrecipes = response.getHits();
		List<Recipe> recipes = new ArrayList<>();
		
		Recipe recipe = new Recipe();
		
		List<Ingredients> ingredients = new ArrayList<>();
		
		ing_repo.deleteAll();
		results_repo.deleteAll();
		
		for(OopsRecipe oops : oopsrecipes) {
			recipe = oops.getRecipe();
			
			recipes.add(recipe);
			
			RecipeSearchResults searchresults = new RecipeSearchResults();
			
			searchresults.setLabel(recipe.getLabel());
			searchresults.setUri(recipe.getUri());
			searchresults.setYeild(recipe.getyield());
			searchresults.setTotaltime(recipe.getTotalTime());
			searchresults.setUrl(recipe.getUrl());
			
			results_repo.save(searchresults);
			
			ingredients = recipe.getIngredients();
			
			for(Ingredients ingredient : ingredients) {
				
				RecipeIngredients recipeingredients = new RecipeIngredients();
				
				recipeingredients.setText(ingredient.getText());
				recipeingredients.setSearchresult(searchresults);
				
				ing_repo.save(recipeingredients);
				
			}
			
			results_repo.save(searchresults);
			
		}
		
		
		model.addAttribute("recipes",recipes);
		model.addAttribute("search", q);
		
		return "results";
	}
	

	@PostMapping("/search/diet")
	public String searchBydiet(@RequestParam String dietoption, Model model) {
		RecipeResponse response = service.getDiet(dietoption);
		List<OopsRecipe> oopsrecipes = response.getHits();
		List<Recipe> recipes = new ArrayList<>();
		
		Recipe recipe = new Recipe();

		
		List<Ingredients> ingredients = new ArrayList<>();
		
		ing_repo.deleteAll();
		results_repo.deleteAll();
		
		for(OopsRecipe oops : oopsrecipes) {
			recipe = oops.getRecipe();
			
			recipes.add(recipe);
			
			RecipeSearchResults searchresults = new RecipeSearchResults();
			
			searchresults.setLabel(recipe.getLabel());
			searchresults.setUri(recipe.getUri());
			searchresults.setYeild(recipe.getyield());
			searchresults.setTotaltime(recipe.getTotalTime());
			searchresults.setUrl(recipe.getUrl());
			
			results_repo.save(searchresults);
			
			ingredients = recipe.getIngredients();
			
			for(Ingredients ingredient : ingredients) {
				
				RecipeIngredients recipeingredients = new RecipeIngredients();
				
				recipeingredients.setText(ingredient.getText());
				recipeingredients.setSearchresult(searchresults);
				
				ing_repo.save(recipeingredients);
				
			}
			
			results_repo.save(searchresults);
			
		}
		

		model.addAttribute("recipes",recipes);


		model.addAttribute("search", dietoption);

		return "results";
	}
	

	@PostMapping("/search/health")
	public String searchByhealth(@RequestParam String healthoption, Model model) {
		RecipeResponse response = service.getAllRecipes(healthoption);
		List<OopsRecipe> oopsrecipes = response.getHits();
		List<Recipe> recipes = new ArrayList<>();
		
		Recipe recipe = new Recipe();
		
		List<Ingredients> ingredients = new ArrayList<>();
		
		ing_repo.deleteAll();
		results_repo.deleteAll();
		
		for(OopsRecipe oops : oopsrecipes) {
			recipe = oops.getRecipe();
			
			recipes.add(recipe);
			
			RecipeSearchResults searchresults = new RecipeSearchResults();
			
			searchresults.setLabel(recipe.getLabel());
			searchresults.setUri(recipe.getUri());
			searchresults.setYeild(recipe.getyield());
			searchresults.setTotaltime(recipe.getTotalTime());
			searchresults.setUrl(recipe.getUrl());
			
			results_repo.save(searchresults);
			
			ingredients = recipe.getIngredients();
			
			for(Ingredients ingredient : ingredients) {
				
				RecipeIngredients recipeingredients = new RecipeIngredients();
				
				recipeingredients.setText(ingredient.getText());
				recipeingredients.setSearchresult(searchresults);
				
				ing_repo.save(recipeingredients);
				
			}
			
			results_repo.save(searchresults);
			
		}

		
		model.addAttribute("recipes",recipes);
		model.addAttribute("search", healthoption);

		
		return "results";
	}
	

	
	@PostMapping("/details")
	public String detailsBylabel(@RequestParam String label, Model model) {
		
		RecipeSearchResults result = new RecipeSearchResults();
		List<RecipeIngredients> recingr = new ArrayList<>();
		List<Ingredients> ingredients = new ArrayList<>();
		
		
		result = results_repo.findByLabel(label);
		recingr = ing_repo.findAllBySearchresults(result);
		
		Recipe recipe = new Recipe();
		
		recipe.setLabel(result.getLabel());
		recipe.setTotalTime(result.getTotaltime());
		recipe.setUri(result.getUri());
		recipe.setUrl(result.getUrl());

		
		for(RecipeIngredients ing : recingr) {
			Ingredients ingredient = new Ingredients();
			ingredient.setText(ing.getText());
			ingredients.add(ingredient);
		}
		
		recipe.setIngredients(ingredients);

		model.addAttribute("recipe",recipe);
		
		return "details";
	}
	@GetMapping("/details/{id}")
	public String detailsById(@PathVariable Long id, Model model) {

		
		RecipeSearchResults result = new RecipeSearchResults();
		List<RecipeIngredients> recingr = new ArrayList<>();
		List<Ingredients> ingredients = new ArrayList<>();
		
		
		result = results_repo.findById(id).orElse(null);
		recingr = ing_repo.findAllBySearchresults(result);
		
		Recipe recipe = new Recipe();
		
		recipe.setLabel(result.getLabel());
		recipe.setTotalTime(result.getTotaltime());
		recipe.setUri(result.getUri());
		recipe.setUrl(result.getUrl());

		
		for(RecipeIngredients ing : recingr) {
			Ingredients ingredient = new Ingredients();
			ingredient.setText(ing.getText());
			ingredients.add(ingredient);
		}
		
		recipe.setIngredients(ingredients);

		model.addAttribute("recipe",recipe);
		
		return "details";
	}
	
	@PostMapping("/addfavorite")
	public String addToFavorites(@RequestParam String label, Model model) {
		
		List<RecipeIngredients> ingredients = new ArrayList<>();
		
		RecipeSearchResults recipe = new RecipeSearchResults();
		 
				recipe = results_repo.findByLabel(label);
				
				FavoriteRecipe searchresults = new FavoriteRecipe();
				
				searchresults.setLabel(recipe.getLabel());
				searchresults.setUri(recipe.getUri());
				searchresults.setYeild(recipe.getYeild());
				searchresults.setTotaltime(recipe.getTotaltime());
				searchresults.setUrl(recipe.getUrl());
				
				ingredients = ing_repo.findAllBySearchresults(recipe);
				fav_repo.save(searchresults);
				
		for(RecipeIngredients ingredient : ingredients) {
					
					ingredient.setFavoriterecipe(searchresults);
					
					ing_repo.save(ingredient);
					
				}
				
		fav_repo.save(searchresults);
		
		RecipeSearchResults result = new RecipeSearchResults();
		List<RecipeIngredients> recingr = new ArrayList<>();
		List<Ingredients> ings = new ArrayList<>();
		Ingredients ingredient = new Ingredients();
		
		result = results_repo.findByLabel(label);
		recingr = ing_repo.findAllBySearchresults(result);
		
		Recipe rec = new Recipe();
		
		rec.setLabel(result.getLabel());
		rec.setTotalTime(result.getTotaltime());
		rec.setUri(result.getUri());
		rec.setUrl(result.getUrl());
		
		for(RecipeIngredients ing : recingr) {
			ingredient.setText(ing.getText());
			ings.add(ingredient);
		}
		
		rec.setIngredients(ings);

		model.addAttribute("recipe",rec);
		
		return "redirect:/details/"+result.getResult_id();
	}
	
	@GetMapping("/favorites")
	public String favorites(Model model) {
		
		List<FavoriteRecipe> favorites = fav_repo.findAll();
				
		model.addAttribute("favorites",favorites);
		return "favorites";
		
	}
	
	@GetMapping("/deleterecipe/{id}")
	public String deleteFavorite(@PathVariable Long id, Model model) {
		
		fav_repo.deleteById(id);
		
		List<FavoriteRecipe> favorites = fav_repo.findAll();
		
		model.addAttribute("favorites",favorites);
		
		return "redirect:/favorites";
	}
	
	

}