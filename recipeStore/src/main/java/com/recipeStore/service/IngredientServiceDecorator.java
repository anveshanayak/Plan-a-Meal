package com.recipeStore.service;
import java.util.List;

import com.recipeStore.entity.Ingredient;
// import com.recipeStore.repository.IngredientRepository;

public class IngredientServiceDecorator implements IngredientServiceInterface {

  private IngredientService ingredientService;

  public IngredientServiceDecorator(IngredientService ingredientService) {
    this.ingredientService = ingredientService;
  }

  @Override
  public void savei(Ingredient ingredient) {
    ingredientService.savei(ingredient);
    // System.out.println("Ingredient saved successfully.");
  }

  @Override
  public List<Ingredient> getAllIngredient() {
    List<Ingredient> ingredients = ingredientService.getAllIngredient();
    return ingredients;
  }

  @Override
  public Ingredient getIngredientById(int id) {
    try {
      Ingredient ingredient = ingredientService.getIngredientById(id);
      return ingredient;
    }
    catch (Exception e) {
      // Handling exception
      System.err.println("Error while getting ingredient by ID: " + id);
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public void deleteIngredientById(int id) {
    try {
      ingredientService.deleteIngredientById(id);
    }
    catch (Exception e) {
      // Handling exception
      System.err.println("Error while deleting ingredient by ID: " + id);
      e.printStackTrace();
    }
  }
}
