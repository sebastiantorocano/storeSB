package com.example.store.storeSB.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.storeSB.model.Category;
import com.example.store.storeSB.model.Product;
import com.example.store.storeSB.repository.CategoryRepository;
import com.mysql.cj.Query;

@RestController
@RequestMapping("/api")
public class CategoryController {

	
	@Autowired
	CategoryRepository categoryRepository;
	
	
	
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getAllCategories(@RequestParam(required = false) String name){
		try {
		
		List<Category> categories = new ArrayList<Category>();
	
		
		if(name==null) {
			
			System.out.print("nulll nameee------");
			//System.out.print(products.get(0).getName());
			categoryRepository.findAll().forEach(categories::add);;
		}else {
			categoryRepository.findByName(name).forEach(categories::add);
		}
		System.out.print("producto");
		System.out.print(categories.get(0));
		
		 return new ResponseEntity<>(categories, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/categoriesName")
	public ResponseEntity<List<Category>> getAllCategoriesName(@RequestParam(required = false) String name){
		try {
			System.out.print("nombre "+name);
		
			List<Category> categories = new ArrayList<Category>();
			categoryRepository.findByName(name).forEach(categories::add);;
		
		 return new ResponseEntity<>(categories, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/categories")
	  public ResponseEntity<Category> createProduct(@RequestBody Category category) {
	    try {
	    	Category _category= categoryRepository
	          .save(category);
	      return new ResponseEntity<>(_category, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}
