package com.recipeStore.service;

import com.recipeStore.entity.MyIngredientList;

import java.util.List;

public interface MyIngredientListServiceInterface {

    void saveMyIngredients(MyIngredientList ingredient);

    List<MyIngredientList> getAllMyIngredients();

    void deleteIngredientById(int id);
}