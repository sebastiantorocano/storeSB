package com.example.store.storeSB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.store.storeSB.model.Category;


public interface CategoryRepository  extends JpaRepository<Category, Long>{

	
	List<Category> findByName(String name);
}
