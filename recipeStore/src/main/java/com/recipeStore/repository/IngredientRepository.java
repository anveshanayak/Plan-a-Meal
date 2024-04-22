package com.recipeStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipeStore.entity.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Integer>  {
    Ingredient findByName(String name);
}
