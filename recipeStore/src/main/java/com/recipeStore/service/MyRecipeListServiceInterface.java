package com.recipeStore.service;

import com.recipeStore.entity.MyRecipeList;

import java.util.List;

public interface MyRecipeListServiceInterface {

    void saveMyRecipes(MyRecipeList recipe);

    List<MyRecipeList> getAllMyRecipes();

    void deleteById(int id);
}