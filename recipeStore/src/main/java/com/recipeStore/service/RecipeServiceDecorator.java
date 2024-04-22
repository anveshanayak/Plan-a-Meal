package com.recipeStore.service;


import java.util.List;


import com.recipeStore.entity.Recipe;
// import com.recipeStore.repository.RecipeRepository;

public class RecipeServiceDecorator implements RecipeServiceInterface {

  private RecipeService recipeService;

  public RecipeServiceDecorator(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @Override
  public void save(Recipe recipe) {
    recipeService.save(recipe);
  }

  @Override
  public List<Recipe> getAllRecipe() {
    List<Recipe> recipes = recipeService.getAllRecipe();
    return recipes;
  }

  @Override
  public Recipe getRecipeById(int id) {
    try{
      Recipe recipe = recipeService.getRecipeById(id);
      return recipe;
    }
    catch (Exception e) {
      // Handling exception
      System.err.println("Error while getting recipe by ID: " + id);
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public void deleteById(int id) {
    try{
      recipeService.deleteById(id);
    }
    catch (Exception e) {
      // Handling exception
      System.err.println("Error while deleting recipe by ID: " + id);
      e.printStackTrace();
    }
  }
}
