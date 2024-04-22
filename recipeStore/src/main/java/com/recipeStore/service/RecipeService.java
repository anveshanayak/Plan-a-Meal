package com.recipeStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipeStore.entity.Ingredient;
import com.recipeStore.entity.Recipe;
import com.recipeStore.repository.RecipeRepository;

@Service
public class RecipeService implements RecipeServiceInterface{

	private IngredientService ingredientService;
	
	@Autowired
	private RecipeRepository bRepo;
	
	@Override
	public void save(Recipe b) {
		bRepo.save(b);
	}
	
	@Override
	public List<Recipe> getAllRecipe(){
		return bRepo.findAll();
	}
	
	@Override
	public Recipe getRecipeById(int id) {
		return bRepo.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}

	public boolean checkIngredientsExistInRecipe(int recipeId) {
        // Retrieve recipe details from database (assuming Recipe entity is mapped to RecipeRepository)
        Recipe recipe = bRepo.findById(recipeId).orElse(null);
        if (recipe == null) {
            return false; // Recipe not found
        }

        // Split ingredient string and check each ingredient against Ingredients table
        String[] ingredients = recipe.getIngredient().split(",");
        for (String ingredientName : ingredients) {
            // Check if ingredient exists in Ingredients table
            Ingredient ingredient = ingredientService.getIngredientByName(ingredientName.trim());
            if (ingredient == null) {
                return false; // Ingredient not found
            }
        }

        return true; // All ingredients are present in Ingredients table
    }
}
