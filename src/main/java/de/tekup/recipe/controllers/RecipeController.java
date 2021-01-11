package de.tekup.recipe.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@GetMapping("/recipe/{id}/show")
	public String showRecipe(@PathVariable("id") long recipeId, Model model) {
		model.addAttribute("recipe", recipeService.getRecipeById(recipeId)); // HTML IN APP
		return "recipe/show";
	}

}
