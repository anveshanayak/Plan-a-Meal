package com.recipeStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipeStore.entity.Recipe;
import com.recipeStore.repository.RecipeRepository;

@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepository bRepo;
	
	public void save(Recipe b) {
		bRepo.save(b);
	}
	
	public List<Recipe> getAllRecipe(){
		return bRepo.findAll();
	}
	
	public Recipe getRecipeById(int id) {
		return bRepo.findById(id).get();
	}
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
}
