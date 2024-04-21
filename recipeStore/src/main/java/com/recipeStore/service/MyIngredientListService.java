package com.recipeStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipeStore.entity.MyIngredientList;
import com.recipeStore.repository.MyIngredientRepository;

@Service
public class MyIngredientListService {
	
	@Autowired
	private MyIngredientRepository myingredient;
	
	public void saveMyIngredients(MyIngredientList ingredient) {
		myingredient.save(ingredient);
	}
	
	public List<MyIngredientList> getAllMyIngredients(){
		return myingredient.findAll();
	}
	
	public void deleteIngredientById(int id) {
		myingredient.deleteById(id);
	}
}
