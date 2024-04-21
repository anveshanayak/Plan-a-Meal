package com.recipeStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipeStore.entity.MyRecipeList;

@Repository
public interface MyRecipeRepository extends JpaRepository<MyRecipeList,Integer>{

}
