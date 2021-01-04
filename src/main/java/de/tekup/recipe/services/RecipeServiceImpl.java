package de.tekup.recipe.services;

import java.util.List;

import org.springframework.stereotype.Service;

import de.tekup.recipe.data.models.Recipe;
import de.tekup.recipe.data.repos.RecipeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {
	
	private RecipeRepository reposRecipe;
	@Override
	public List<Recipe> getRecipes() {
		return reposRecipe.findAll();
	}

	
}