package com.recipeStore.service;

import com.recipeStore.entity.Recipe;

import java.util.List;

public interface RecipeServiceInterface {

    void save(Recipe recipe);

    List<Recipe> getAllRecipe();

    Recipe getRecipeById(int id);

    void deleteById(int id);

    boolean checkIngredientsExistInRecipe(int recipeId);
}
