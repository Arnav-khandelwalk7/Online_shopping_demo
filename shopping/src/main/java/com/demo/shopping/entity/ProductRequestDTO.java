package com.demo.shopping.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductRequestDTO {

	  private Integer productId;
	
	  private String productName;
	
	  private Double price;
	
	  private String brand;

}
