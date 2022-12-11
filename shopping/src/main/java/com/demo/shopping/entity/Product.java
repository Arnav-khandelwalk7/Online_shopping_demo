package com.demo.shopping.entity;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Product_Id")
	private Integer productId;
	
	@Column(name = "Product_Name")
	private String productName;
	
	@Column(name = "Price")
	private Double price;
	
	@Column(name = "Brand")
	private String brand;
	
	@OneToMany(mappedBy = "productId")	
	private List<ProductQuantity> productQuantity;
}
