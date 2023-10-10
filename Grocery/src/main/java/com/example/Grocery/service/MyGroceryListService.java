package com.example.Grocery.service;



import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Grocery.Repository.MyGroceryRepository;
import com.example.Grocery.entity.MyGroceryList;



@Service
public class MyGroceryListService {
 @Autowired
  private MyGroceryRepository myGrocery;
 @Autowired
 private MyGroceryRepository myGroceryListRepository;
  public void saveMyGroceries(MyGroceryList Grocery) {
	  myGrocery.save(Grocery);
  }
  
  public List<MyGroceryList> getAllMyGroceries(){
	  return myGrocery.findAll();
	  }
  
  public void deleteById(Long id) {
	  myGrocery.deleteById(id);
  }
  public double calculateTotalPrice() {
	    List<MyGroceryList> myGroceries = getAllMyGroceries();
	    double totalPrice = 0.0;

	    for (MyGroceryList item : myGroceries) {
	        totalPrice += item.getPrice() * item.getQuantity();
	    }

	    return totalPrice;
	}
  public MyGroceryList getMyGroceryById(Long id) {
	    // Implement the logic to retrieve a MyGroceryList object by its ID from your data source (e.g., database)
	    // You can use a repository or any other data access method here
	    return myGroceryListRepository.findById(id).orElse(null); // Example using Spring Data JPA
	}


}
