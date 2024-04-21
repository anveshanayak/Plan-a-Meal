package com.recipeStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipeStore.entity.MyRecipeList;
import com.recipeStore.repository.MyRecipeRepository;

@Service
public class MyRecipeListService {
	
	@Autowired
	private MyRecipeRepository myrecipe;
	
	public void saveMyRecipes(MyRecipeList recipe) {
		myrecipe.save(recipe);
	}
	
	public List<MyRecipeList> getAllMyRecipes(){
		return myrecipe.findAll();
	}
	
	public void deleteById(int id) {
		myrecipe.deleteById(id);
	}
}
