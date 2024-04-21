package com.recipeStore.service;

import com.recipeStore.entity.Ingredient;

import java.util.List;

public interface IngredientServiceInterface {

    void savei(Ingredient ingredient);

    List<Ingredient> getAllIngredient();

    Ingredient getIngredientById(int id);

    void deleteIngredientById(int id);
}