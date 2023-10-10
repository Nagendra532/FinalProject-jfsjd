package com.example.Grocery.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="MyGroceries")
public class MyGroceryList {
	
		@Id
		private Long id;
		private String name;
		private String category;
		private double price;
		private int quantity;
		public MyGroceryList() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public MyGroceryList(Long id, String name, String category, double price) {
		    this.id = id;
		    this.name = name;
		    this.category = category;
		    this.price = price;
		}

		public MyGroceryList(Long id, String name, String category, double price,int quantity) {
			super();
			this.id = id;
			this.name = name;
			this.category = category;
			this.price = price;
			this.quantity=quantity;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		
	}