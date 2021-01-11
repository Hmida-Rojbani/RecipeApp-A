package de.tekup.recipe.services;

import java.util.List;
import java.util.NoSuchElementException;

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
	@Override
	public void deleteRecipe(long id) {
		reposRecipe.deleteById(id);
		
	}
	@Override
	public Recipe getRecipeById(long id) {
		
		return reposRecipe.findById(id)
						.orElseThrow(()-> new NoSuchElementException());
	}

	
}
