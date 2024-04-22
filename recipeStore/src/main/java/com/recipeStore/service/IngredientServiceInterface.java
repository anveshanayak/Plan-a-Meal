package com.recipeStore.service;

import com.recipeStore.entity.Ingredient;

import java.util.List;
// import java.util.Optional;

public interface IngredientServiceInterface {

    void savei(Ingredient ingredient);

    List<Ingredient> getAllIngredient();

    Ingredient getIngredientById(int id);

    Ingredient getIngredientByName(String name);

    void deleteIngredientById(int id);
}