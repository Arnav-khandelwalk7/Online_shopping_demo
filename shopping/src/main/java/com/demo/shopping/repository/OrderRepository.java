package com.demo.shopping.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.shopping.entity.Customer;
import com.demo.shopping.entity.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
    @Transactional
	public void deleteByOrderId(Integer orderId);
	
	public List<Order> findByCustomer(Customer customer);
	
}
