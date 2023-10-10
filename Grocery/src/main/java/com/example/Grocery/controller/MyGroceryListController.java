package com.example.Grocery.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Grocery.service.MyGroceryListService;


@Controller
public class MyGroceryListController {
	
	@Autowired
	private MyGroceryListService service;
	
	@GetMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") Long id) {
		service.deleteById(id);
		return "redirect:/groceries/my_Groceries";
	}
}