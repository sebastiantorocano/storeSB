package com.example.store.storeSB.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="categories")
@NamedQuery(name = "Category.findByName",query = "From Category WHERE name=?1")
public class Category  implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	
	@Column(length = 50)
	private String name;
	 
	@Column(length = 100) 
	private String description;
	private int state;
	
	 
	@OneToMany(mappedBy = "category",fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Product> product;

	

 


	public Category(Long categoryId, String name, String description, int state, Set<Product> product) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.state = state;
		this.product = product;
	}



	public Long getCategoryId() {
		return categoryId;
	}
 


	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}


@JsonManagedReference
	public Set<Product> getProduct() {
		return product;
	}



	public void setProduct(Set<Product> product) {
		this.product = product;
	}




	public Category() {
		super();
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
	
	
	
	
}
