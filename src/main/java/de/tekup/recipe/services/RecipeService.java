package de.tekup.recipe.services;

import java.util.List;

import de.tekup.recipe.data.models.Recipe;

public interface RecipeService {
	
	List<Recipe> getRecipes();
	void deleteRecipe(long id);


}