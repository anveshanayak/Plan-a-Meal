package com.recipeStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recipeStore.service.MyIngredientListService;

@Controller
public class MyIngredientListController {
	
	@Autowired
	private MyIngredientListService service;
	
	@RequestMapping("/deleteMyIngredientList/{id}")
	public String deleteMyIngredientList(@PathVariable("id") int id) {
		service.deleteIngredientById(id);
		return "redirect:/my_ingredients";
	}
}
