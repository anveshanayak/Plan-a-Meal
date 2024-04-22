package com.recipeStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.recipeStore.entity.Recipe;
import com.recipeStore.entity.Ingredient;
import com.recipeStore.entity.MyRecipeList;
import com.recipeStore.service.RecipeService;
import com.recipeStore.service.MyRecipeListService;
import com.recipeStore.service.IngredientService;

import java.util.*;

@Controller
public class RecipeController {
	
	@Autowired
	private RecipeService service;
	
	@Autowired
	private MyRecipeListService myRecipeService;

	@Autowired
	private IngredientService ingredientService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/recipe_register")
	public String RecipeRegister() {
		return "recipeRegister";
	}
	
	@GetMapping("/available_recipes")
	public ModelAndView getAllRecipe() {
		List<Recipe>list=service.getAllRecipe();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("recipeList");
//		m.addObject("recipe",list);
		return new ModelAndView("recipeList","recipe",list);
	}
	
	@PostMapping("/save")
	public String addRecipe(@ModelAttribute Recipe b) {
		service.save(b);
		return "redirect:/available_recipes";
	}
	@GetMapping("/my_recipes")
	public String getMyRecipes(Model model)
	{
		List<MyRecipeList>list=myRecipeService.getAllMyRecipes();
		model.addAttribute("recipe",list);
		return "myRecipes";
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		// Recipe b=service.getRecipeById(id);
		// MyRecipeList mb=new MyRecipeList(b.getId(),b.getName(),b.getIngredient(),b.getPrice());
		// myRecipeService.saveMyRecipes(mb);
		// return "redirect:/my_recipes";

		Recipe b = service.getRecipeById(id);

		// Split ingredients from the recipe
		String[] ingredients = b.getIngredient().split(",");

		// Check each ingredient if it exists in the ingredients table
		boolean allIngredientsExist = true;
		for (String ingredientName : ingredients) {
			Ingredient ingredient = ingredientService.getIngredientByName(ingredientName.trim());
			if (ingredient == null) {
				allIngredientsExist = false;
				break;
			}
		}

		if (allIngredientsExist) {
			// All ingredients exist in the ingredients table, add to user's list
			MyRecipeList mb = new MyRecipeList(b.getId(), b.getName(), b.getIngredient(), b.getPrice());
			myRecipeService.saveMyRecipes(mb);
		} else {
			// Not all ingredients exist in the ingredients table, handle accordingly
			// You can redirect or show an error message to the user
			return "redirect:/my_recipes?error=missing-ingredients";
		}

		return "redirect:/my_recipes";
	}
	
	@RequestMapping("/editRecipe/{id}")
	public String editRecipe(@PathVariable("id") int id,Model model) {
		Recipe b=service.getRecipeById(id);
		model.addAttribute("recipe",b);
		return "recipeEdit";
	}
	@RequestMapping("/deleteRecipe/{id}")
	public String deleteRecipe(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_recipes";
	}
	
}
