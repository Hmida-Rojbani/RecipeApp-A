package de.tekup.recipe.controllers;


import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.recipe.data.models.Recipe;
import de.tekup.recipe.dto.models.RecipeRequest;
import de.tekup.recipe.services.RecipeService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class RecipeController {
	
	private RecipeService recipeService;
	private ModelMapper mapper;
	
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
	
	@GetMapping("/recipe/{id}/update")
	public String updateRecipe(@PathVariable("id") long recipeId, Model model) {
		RecipeRequest request = mapper.map(recipeService.getRecipeById(recipeId), RecipeRequest.class);
		model.addAttribute("recipe", request); // HTML IN APP
		return "recipe/recipeform";
	}
	
	@PostMapping("/recipe")
	public  String saveOrUpdate(@Valid @ModelAttribute("recipe") RecipeRequest request, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "recipe/recipeform";
		}
		Recipe recipe = mapper.map(request, Recipe.class);
		recipeService.saveOrUpdate(recipe);
		
		return "redirect:/";
		
	}
	
	@GetMapping("/recipe/add")
	public String newRecipe( Model model) {
		
		model.addAttribute("recipe", new RecipeRequest()); // HTML IN APP
		return "recipe/recipeform";
	}

}
