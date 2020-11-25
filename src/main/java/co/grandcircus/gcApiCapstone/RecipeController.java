package co.grandcircus.gcApiCapstone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecipeController {
	
	private List<Recipe> favorites = new ArrayList<>();
	
	@Autowired
	private RecipeService service;
	
	@GetMapping("/")
	public String home(Model model) {
		
		List<String> diets = new ArrayList<>();
		
		diets.add("Balanced");	
		diets.add("High-Fiber");
		diets.add("High-Protein");
		diets.add("Low-Carb");
		diets.add("Low-Sodium");
		diets.add("Low-Fat");

		
		model.addAttribute("diets",diets);
		
		List<String> healths = new ArrayList<>();
		healths.add("Alcohol-free");
		healths.add("Immune-Supportive");
		healths.add("Celery-free");
		healths.add("Crustcean-free");
		healths.add("Dairy");
		healths.add("Eggs");
		healths.add("Fish");
		healths.add("FODMAP-free");
		healths.add("Gluten");
		healths.add("Keto");
		healths.add("Kidney-friendly");
		healths.add("Kosher");
		healths.add("low-potassium");
		healths.add("lupine-free");
		healths.add("mustard-free");
		healths.add("low-fat-abs");
		healths.add("No-oil-added");
		healths.add("low-sugar");
		healths.add("paleo");
		healths.add("peanut-free");
		healths.add("pecatarian");
		healths.add("pork-free");
		healths.add("red-meat-free");
		healths.add("sesame-free");
		healths.add("shellfish-free");
		healths.add("soy-free");
		healths.add("sugar-conscious");
		healths.add("tree-nut-free");
		healths.add("vegan");
		healths.add("vegetarian");
		healths.add("wheat-free");


		model.addAttribute("healths",healths);
		
		return "index";
	}
	
	
	// SEARCHING
	@PostMapping("/search")
	public String searchByText(@RequestParam String q, Model model) {
		RecipeResponse response = service.getAllRecipes(q);
		List<Recipe> recipes = response.getHits();
				
		model.addAttribute("recipes",recipes);
		model.addAttribute("search", q);
		
		return "results";
	}
	
	@PostMapping("/search/diet")
	public String searchBydiet(@RequestParam String diet, Model model) {
		RecipeResponse response = service.getDiet(diet);
		List<Recipe> recipes = response.getHits();
		
		
		model.addAttribute("recipes",recipes);
		model.addAttribute("search", diet);
		
		return "results";
	}
	
	@PostMapping("/search/health")
	public String searchByhealth(@RequestParam String health, Model model) {
		RecipeResponse response = service.getAllRecipes(health);
		List<Recipe> recipes = response.getHits();

		
		model.addAttribute("recipes",recipes);
		model.addAttribute("search", health);
		
		return "results";
	}
	
	
	
	@GetMapping("/details/{ id }")
	public String detailsById(@PathVariable String id, Model model) {
		RecipeResponse response = service.getById(id);
		List<Recipe> recipes = response.getHits();
		
		Recipe recipe = recipes.get(0);
		
		model.addAttribute("recipe",recipe);
		
		return "details";
	}
	
	@PostMapping("/addfavorite/{ id }")
	public String addToFavorites(@PathVariable String id, Model model) {
		RecipeResponse response = service.getById(id);
		List<Recipe> recipes = response.getHits();
		
		Recipe recipe = recipes.get(0);
		
		
		favorites.add(recipe);
		model.addAttribute("recipe",recipe);
		
		return "redirect:/details/{id}";
	}
	
	@GetMapping("/favorites")
	public String favorites(Model model) {
		
		model.addAttribute("favorites",favorites);
		return "favorites";
		
	}
	
	

}
