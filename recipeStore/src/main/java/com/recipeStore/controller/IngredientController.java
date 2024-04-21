package com.recipeStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.recipeStore.entity.Ingredient;
import com.recipeStore.entity.MyIngredientList;
import com.recipeStore.service.IngredientService;
import com.recipeStore.service.MyIngredientListService;

import java.util.*;

@Controller
public class IngredientController {
	
	@Autowired
	private IngredientService service;
	
	@Autowired
	private MyIngredientListService myIngredientService;
	
	// @GetMapping("/")
	// public String home() {
	// 	return "home";
	// }
	
	@GetMapping("/ingredient_register")
	public String IngredientRegister() {
		return "ingredientRegister";
	}
	
	@GetMapping("/available_ingredients")
	public ModelAndView getAllIngredient() {
		List<Ingredient>list=service.getAllIngredient();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("ingredientList");
//		m.addObject("ingredient",list);
		return new ModelAndView("ingredientList","ingredient",list);
	}
	
	@PostMapping("/savei")
	public String addIngredient(@ModelAttribute Ingredient i) {
		service.savei(i);
		return "redirect:/available_ingredients";
	}
	@GetMapping("/my_ingredients")
	public String getMyIngredients(Model model)
	{
		List<MyIngredientList>list=myIngredientService.getAllMyIngredients();
		model.addAttribute("ingredient",list);
		return "myIngredients";
	}
	@RequestMapping("/myingredientlist/{id}")
	public String getMyIngredientList(@PathVariable("id") int id) {
		Ingredient i=service.getIngredientById(id);
		MyIngredientList mb=new MyIngredientList(i.getId(),i.getName(),i.getQty(),i.getPrice());
		myIngredientService.saveMyIngredients(mb);
		return "redirect:/my_ingredients";
	}
	
	@RequestMapping("/editIngredient/{id}")
	public String editIngredient(@PathVariable("id") int id,Model model) {
		Ingredient i=service.getIngredientById(id);
		model.addAttribute("ingredient",i);
		return "ingredientEdit";
	}
	@RequestMapping("/deleteIngredient/{id}")
	public String deleteIngredient(@PathVariable("id")int id) {
		service.deleteIngredientById(id);
		return "redirect:/available_ingredients";
	}
	
}
