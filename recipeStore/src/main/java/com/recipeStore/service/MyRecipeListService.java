package com.recipeStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipeStore.entity.MyRecipeList;
import com.recipeStore.repository.MyRecipeRepository;

@Service
public class MyRecipeListService implements MyRecipeListServiceInterface{
	
	@Autowired
	private MyRecipeRepository myrecipe;
	
	@Override
	public void saveMyRecipes(MyRecipeList recipe) {
		myrecipe.save(recipe);
	}
	
	@Override
	public List<MyRecipeList> getAllMyRecipes(){
		return myrecipe.findAll();
	}
	
	@Override
	public void deleteById(int id) {
		myrecipe.deleteById(id);
	}
}
