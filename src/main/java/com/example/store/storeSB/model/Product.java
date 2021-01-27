package com.example.store.storeSB.model;



import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="products")
public class Product  implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	
	@Column(length = 50)
	private String name; 
	
	@Column(length = 100)
	private String description;
	private double price;
	
	
	@Column(length = 50)
	private String route;
	private int state;
	
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	
	







	public Product(Long productId, String name, String description, double price, String route, int state,
			Category category) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.route = route;
		this.state = state;
		this.category = category;
	}





	public String getRoute() {
		return route;
	}





	public void setRoute(String route) {
		this.route = route;
	}





	public Category getCategory() {
		return category;
	}


 


	public void setCategory(Category category) {
		this.category = category;
	}










	public int getState() {
		return state;
	}





	public void setState(int state) {
		this.state = state;
	}





	public Product() {
		super();
	}


	


	public Long getProductId() {
		return productId;
	}





	public void setProductId(Long productId) {
		this.productId = productId;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	 
	

	
	
	
	
	
	
	

}
