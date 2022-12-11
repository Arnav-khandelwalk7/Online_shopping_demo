package com.demo.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.shopping.entity.Order;
import com.demo.shopping.entity.Product;
import com.demo.shopping.entity.ProductRequestDTO;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	public List<Product> findAll();
	
        public Product findByProductId(Integer productId);
	
	@Query("SELECT p FROM Product p WHERE  (:id is null or p.productId = :id) and "  
		    + "(:name is null or p.productName = :name) and "
		    + "(:price is null or p.price = :price) and "
		    + "(:brand is null or p.brand = :brand)")
	public List<Product> findProductByProductIdAndProductNameAndPriceAndBrand(@Param("id") Integer productId,@Param("name") String productName, @Param("price") Double price, @Param("brand") String brand );

}
