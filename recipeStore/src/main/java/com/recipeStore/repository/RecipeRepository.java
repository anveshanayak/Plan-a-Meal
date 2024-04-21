package com.recipeStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipeStore.entity.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Integer>  {

}
