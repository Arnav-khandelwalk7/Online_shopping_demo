package com.demo.shopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "orders")
public class Order {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "Order_Id")
	  private Integer orderId;
	
	  @Column(name = "Quantity")
	  private Integer quantity;
	 
	  @ManyToOne
	  @JoinColumn(name = "Product_Id")
	  private Product product;
	
	  @ManyToOne
	  @JoinColumn(name = "User_Id")
	  private Customer customer;

}
