package com.recipeStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipeStore.entity.Ingredient;
import com.recipeStore.repository.IngredientRepository;

@Service
public class IngredientService implements IngredientServiceInterface{
	
	@Autowired
	private IngredientRepository iRepo;

	@Autowired
    public IngredientService(IngredientRepository iRepo) {
        this.iRepo = iRepo;
    }
	
	@Override
	public void savei(Ingredient i) {
		iRepo.save(i);
	}
	
	@Override
	public List<Ingredient> getAllIngredient(){
		return iRepo.findAll();
	}
	
	@Override
	public Ingredient getIngredientById(int id) {
		return iRepo.findById(id).get();
	}

	@Override
    public Ingredient getIngredientByName(String name) {
        return iRepo.findByName(name);
    }

	@Override
	public void deleteIngredientById(int id) {
		iRepo.deleteById(id);
	}
}
