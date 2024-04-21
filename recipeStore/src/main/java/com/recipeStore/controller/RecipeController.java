package com.recipeStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.recipeStore.entity.Recipe;
import com.recipeStore.entity.MyRecipeList;
import com.recipeStore.service.RecipeService;
import com.recipeStore.service.MyRecipeListService;

import java.util.*;

@Controller
public class RecipeController {
	
	@Autowired
	private RecipeService service;
	
	@Autowired
	private MyRecipeListService myRecipeService;
	
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
		Recipe b=service.getRecipeById(id);
		MyRecipeList mb=new MyRecipeList(b.getId(),b.getName(),b.getIngredient(),b.getPrice());
		myRecipeService.saveMyRecipes(mb);
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
