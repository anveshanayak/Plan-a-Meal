package com.recipeStore.entity;

// import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MyIngredient")
public class MyIngredientList {
	
	@Id
	private int id;
	private String name;
	private String qty;
	private String price;
	public MyIngredientList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyIngredientList(int id, String name, String qty, String price) {
		super();
		this.id = id;
		this.name = name;
		this.qty = qty;
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
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
