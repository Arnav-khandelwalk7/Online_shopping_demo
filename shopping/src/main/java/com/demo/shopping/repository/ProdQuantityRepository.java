package com.demo.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.shopping.entity.ProductQuantity;

@Repository
public interface  ProdQuantityRepository extends JpaRepository<ProductQuantity, Integer> {
		
	public ProductQuantity findByStockId(Integer stockId);
	
}