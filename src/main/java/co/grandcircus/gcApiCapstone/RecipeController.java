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

@Controller
public class RecipeController {
	
	private List<Recipe> favorites = new ArrayList<>();
	
	@Autowired
	private RecipeService service;
	
	@GetMapping("/")
	public String home(Model model) {
		
		List<String> dishtypes = new ArrayList<>();
		
		dishtypes.add("Alcohol-cocktail");	
		dishtypes.add("Biscuits and cookies");
		dishtypes.add("Bread");
		dishtypes.add("Cereals");
		dishtypes.add("Condiments and sauces");
		dishtypes.add("Drinks");
		dishtypes.add("Desserts");
		dishtypes.add("Egg");
		dishtypes.add("Main course");
		dishtypes.add("Omelet");
		dishtypes.add("Pancake");
		dishtypes.add("Preps");
		dishtypes.add("Preserve");
		dishtypes.add("Salad");
		dishtypes.add("Sandwiches");
		dishtypes.add("Soup");
		dishtypes.add("Starter");
		
		model.addAttribute("dishtypes",dishtypes);
		
		List<String> cuisinetypes = new ArrayList<>();
		cuisinetypes.add("American");
		cuisinetypes.add("Asian");
		cuisinetypes.add("British");
		cuisinetypes.add("Caribbean");
		cuisinetypes.add("Central Europe");
		cuisinetypes.add("Chinese");
		cuisinetypes.add("Eastern Europe");
		cuisinetypes.add("French");
		cuisinetypes.add("Indian");
		cuisinetypes.add("Italian");
		cuisinetypes.add("Japanese");
		cuisinetypes.add("Kosher");
		cuisinetypes.add("Mediterranean");
		cuisinetypes.add("Mexican");
		cuisinetypes.add("Middle Eastern");
		cuisinetypes.add("Nordic");
		cuisinetypes.add("South American");
		cuisinetypes.add("South East Asian");

		model.addAttribute("cuisinetypes",cuisinetypes);
		
		return "index";
	}
	
	@PostMapping("/search/{q}")
	public String searchByText(@PathVariable String q, Model model) {
		List<Recipe> recipes = new ArrayList<>();//api service with api method for getting all recipes according to q;
				
		model.addAttribute("recipes",recipes);
		model.addAttribute("search", q);
		
		return "redirect:/results";
	}
	
	@PostMapping("/search/dishtype/{dishtype}")
	public String searchByDishType(@PathVariable String dishtype, Model model) {
		List<Recipe> recipes = new ArrayList<>();//api service with api method for getting all recipes according to dishType;
		
		model.addAttribute("recipes",recipes);
		model.addAttribute("search", dishtype);
		
		return "redirect:/results";
	}
	
	@PostMapping("/search/cuisinetype/{ cuisinetype }")
	public String searchByCuisineType(@PathVariable String cuisinetype, Model model) {
		List<Recipe> recipes = new ArrayList<>();//api service with api method for getting all recipes according to cuisinetype;
		
		model.addAttribute("recipes",recipes);
		model.addAttribute("search", cuisinetype);
		
		return "redirect:/results";
	}
	
	@PostMapping("/search/calories/{ low }/{ high }")
	public String searchByCuisineType(@PathVariable Double low,@PathVariable Double high, Model model) {
		List<Recipe> recipes = new ArrayList<>();//api service with api method for getting all recipes according to cuisinetype;
		
		String search = low + "-" + high;
		
		model.addAttribute("recipes",recipes);
		model.addAttribute("search", search);
		
		return "redirect:/results";
	}
	
	@GetMapping("/details/{ id }")
	public String detailsById(@PathVariable String id, Model model) {
		Recipe recipe = new Recipe();//api service with api method for getting all recipes according to id;
		
		model.addAttribute("recipe",recipe);
		
		return "details";
	}
	
	@PostMapping("/addfavorite/{ id }")
	public String addToFavorites(@PathVariable String id, Model model) {
		Recipe recipe = new Recipe();//api service with api method for getting all recipes according to id;
		
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
