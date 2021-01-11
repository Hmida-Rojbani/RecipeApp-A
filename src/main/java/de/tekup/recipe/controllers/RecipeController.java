package de.tekup.recipe.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import de.tekup.recipe.services.RecipeService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class RecipeController {
	
	private RecipeService recipeService;
	
	@GetMapping("/recipe/{id}/delete")
	public String deleteRecipe(@PathVariable("id") long recipeId) {
		recipeService.deleteRecipe(recipeId);
		
		return "redirect:/";
	}
	

}
