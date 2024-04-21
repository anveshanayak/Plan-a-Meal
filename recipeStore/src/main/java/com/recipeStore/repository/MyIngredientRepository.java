package com.recipeStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipeStore.entity.MyIngredientList;

@Repository
public interface MyIngredientRepository extends JpaRepository<MyIngredientList,Integer>{

}
