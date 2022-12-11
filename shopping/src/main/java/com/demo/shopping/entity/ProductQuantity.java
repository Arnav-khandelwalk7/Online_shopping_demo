package com.demo.shopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name = "stock_units")
public class ProductQuantity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Stock_Id")
	private Integer stockId;
	
	@Column(name = "Stock_Quantity")
	private Integer quantity;
	

	@Column(name = "Product_Id")
	private Integer productId;
	
}
