package com.recipeStore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MyRecipe")
public class MyRecipeList {
	
	@Id
	private int id;
	private String name;
	private String ingredient;
	private String price;
	public MyRecipeList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyRecipeList(int id, String name, String ingredient, String price) {
		super();
		this.id = id;
		this.name = name;
		this.ingredient = ingredient;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
