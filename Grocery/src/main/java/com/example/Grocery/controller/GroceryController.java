package com.example.Grocery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.Grocery.entity.Grocery;
import com.example.Grocery.service.GroceryService;
import com.example.Grocery.service.MyGroceryListService;
import com.example.Grocery.entity.MyGroceryList;

import java.util.List;

@Controller
@RequestMapping("/groceries")
public class GroceryController {

    @Autowired
    private GroceryService groceryService;
    
    @Autowired
	private MyGroceryListService myGroceryService;
	

    @GetMapping("/")
    public String listGroceries(Model model) {
        List<Grocery> groceries = groceryService.getAllGroceries();
        model.addAttribute("groceries", groceries);
        return "list";
    }

    @GetMapping("/add")
    public String addGroceryForm(Model model) {
        model.addAttribute("grocery", new Grocery());
        return "add";
    }

    @PostMapping("/add")
    public String addGrocery(@ModelAttribute Grocery grocery) {
        groceryService.createGrocery(grocery);
        return "redirect:/groceries/";
    }

    @GetMapping("/edit/{id}")
    public String editGroceryForm(@PathVariable Long id, Model model) {
        Grocery grocery = groceryService.getGroceryById(id);
        model.addAttribute("grocery", grocery);
        return "edit";
    }

    @PostMapping("/save/{id}")
    public String editGrocery(@PathVariable Long id, @ModelAttribute Grocery updatedGrocery) {
        groceryService.updateGrocery(id, updatedGrocery);
        return "redirect:/groceries/";
    }

    @GetMapping("/delete/{id}")
    public String deleteGrocery(@PathVariable Long id) {
        groceryService.deleteGrocery(id);
        return "redirect:/groceries/";
    }

    @GetMapping("/search")
    public String searchGroceryForm() {
        return "search";
    }

    @GetMapping("/search-result")
    public String searchGrocery(@RequestParam Long id, Model model) {
        Grocery grocery = groceryService.getGroceryById(id);
        if (grocery != null) {
            model.addAttribute("grocery", grocery);
        } else {
            model.addAttribute("errorMessage", "Grocery not found with ID: " + id);
        }
        return "search";
    }
    
//    @GetMapping("/my_Groceries") 
//    public String getMyGroceries(Model model) {
//        List<MyGroceryList> list = myGroceryService.getAllMyGroceries();
//        model.addAttribute("Grocery", list);
//        return "myGroceries";
//    }

    @GetMapping("/mylist/{id}")
    public String addToMyGroceries(@PathVariable("id") Long id) {
        Grocery g = groceryService.getGroceryById(id);
        MyGroceryList mb = myGroceryService.getMyGroceryById(id);

        if (mb != null) {
            // Grocery item already exists, increment quantity
            mb.setQuantity(mb.getQuantity() + 1);
        } else {
            // Grocery item is new, set quantity to 1
            mb = new MyGroceryList(g.getId(), g.getName(), g.getCategory(), g.getPrice());
            mb.setQuantity(1);
        }

        myGroceryService.saveMyGroceries(mb);
        return "redirect:/groceries/my_Groceries";
    }
    
//    @Autowired
//    private MyGroceryListService service;

    @GetMapping("/my_Groceries")
    public String getMyGroceries(Model model) {
        List<MyGroceryList> list = myGroceryService.getAllMyGroceries();
        double totalPrice = myGroceryService.calculateTotalPrice(); // Calculate total price
        model.addAttribute("Grocery", list);
        model.addAttribute("totalPrice", totalPrice); // Pass total price to the view
        return "myGroceries";
    }




}