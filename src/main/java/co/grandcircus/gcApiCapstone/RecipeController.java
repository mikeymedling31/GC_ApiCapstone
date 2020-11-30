package co.grandcircus.gcApiCapstone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeController {
	private List<Recipe> searchResults = new ArrayList<>();
	private List<Recipe> favorites = new ArrayList<>();
	
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
		
		for(OopsRecipe oops : oopsrecipes) {
			recipes.add(oops.getRecipe());
		}
		
		searchResults.clear();
		searchResults.addAll(recipes);
		
		model.addAttribute("recipes",recipes);
		model.addAttribute("search", q);
		
		return "results";
	}
	
	@PostMapping("/search/diet")
	public String searchBydiet(@RequestParam String dietoption, Model model) {
		RecipeResponse response = service.getDiet(dietoption);
		List<OopsRecipe> oopsrecipes = response.getHits();
		List<Recipe> recipes = new ArrayList<>();
		
		for(OopsRecipe oops : oopsrecipes) {
			recipes.add(oops.getRecipe());
		}
		
		searchResults.clear();
		searchResults.addAll(recipes);
		model.addAttribute("recipes",recipes);
		model.addAttribute("search", dietoption);
		
		return "results";
	}
	
	@PostMapping("/search/health")
	public String searchByhealth(@RequestParam String healthoption, Model model) {
		RecipeResponse response = service.getAllRecipes(healthoption);
		List<OopsRecipe> oopsrecipes = response.getHits();
		List<Recipe> recipes = new ArrayList<>();
		
		for(OopsRecipe oops : oopsrecipes) {
			recipes.add(oops.getRecipe());
		}

		searchResults.clear();
		searchResults.addAll(recipes);
		model.addAttribute("recipes",recipes);
		model.addAttribute("search", healthoption);
		
		return "results";
	}
	
	
	
	@PostMapping("/details")
	public String detailsById(@RequestParam String label, Model model) {
		String id = "";
		
		Recipe recipe = new Recipe();
		
		for(int i = 0; i<searchResults.size(); i++) {
			if(label.compareTo(searchResults.get(i).getLabel())==0) {
				recipe = searchResults.get(i);
			}
		}
		System.out.println(id);		

		model.addAttribute("recipe",recipe);
		
		return "details";
	}
	
	@PostMapping("/addfavorite")
	public String addToFavorites(@RequestParam String label, Model model) {
		String id = "";
		Recipe recipe = new Recipe();
		
		for(int i = 0; i<searchResults.size(); i++) {
			if(label.compareTo(searchResults.get(i).getLabel())==0) {
				recipe = searchResults.get(i);
			}
		}
		
		
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
