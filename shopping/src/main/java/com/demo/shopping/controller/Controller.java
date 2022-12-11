package com.demo.shopping.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.shopping.entity.Customer;
import com.demo.shopping.entity.Order;
import com.demo.shopping.entity.Product;
import com.demo.shopping.entity.ProductQuantity;
import com.demo.shopping.entity.ProductRequestDTO;
import com.demo.shopping.entity.RequestOrderDTO;
import com.demo.shopping.repository.CustomerRepository;
import com.demo.shopping.repository.OrderRepository;
import com.demo.shopping.repository.ProdQuantityRepository;
import com.demo.shopping.repository.ProductRepository;
import com.sun.istack.NotNull;

@RestController
public class Controller {

	  @Autowired
	  private ProductRepository prodRepo;
	
	  @Autowired
	  private OrderRepository orderRepo;
	
	  @Autowired
	  private CustomerRepository customRepo;
	
	  @Autowired
	  private ProdQuantityRepository prodQuantRepo;
	
	
	    @GetMapping("/getAllProducts")
	    public List<Product> getAllProds()
	    {
	        return prodRepo.findAll();
	    }

	 
	    @PostMapping("/addOrder")
	    public String addOrder(@RequestBody RequestOrderDTO reqOrder ) throws Exception
	    {	
        Order order = new Order();	    
	    
		        if(isNull(reqOrder.getProductId()) || isNull(reqOrder.getQuantity()) || isNull(reqOrder.getUserId()))
		            	return "Any field of order cannot be null except ID";
		    
	        //order.setOrderId(reqOrder.getOrderId());
	    
	        	order.setQuantity(reqOrder.getQuantity());
	    	
	        	Product product = prodRepo.findByProductId(reqOrder.getProductId());
	        	order.setProduct(product);
	    	
	        	Customer customer = customRepo.findByUserId(reqOrder.getUserId());
	        	order.setCustomer(customer);
	    	
	        orderRepo.save(order);
	        return "Order Successfully Placed!";
	    }
	 
	 
	    @PostMapping("/deleteOrder/{oid}")
	    public String getAllOrders(@PathVariable("oid") Integer orderId)
	    {
	        orderRepo.deleteByOrderId(orderId);
	        return "Deleted order "+ orderId +" successfully!";
	    }
	 
	 
	    @GetMapping("/findByCustomer")
	    public List<Order> addOrder(@NotNull @RequestBody  Customer customer )  throws Exception
	    {		    	 
		 	       return orderRepo.findByCustomer(customer);	         
	    }
	 
	 
	    @PostMapping("/updateSKU")
	    public String updateSKU(@RequestBody ProductQuantity productQuantity )
	    {	
		 	       ProductQuantity productQuantityUse = new ProductQuantity();
	    	
	    	    if(isNull(productQuantity.getProductId()) || isNull(productQuantity.getQuantity()))
	    		        return "Product ID or Quantity cannot be null";
	    
			        if(productQuantity.getStockId() == null){
			           	 productQuantityUse.setProductId(productQuantity.getProductId());
			   	         productQuantityUse.setQuantity(productQuantity.getQuantity());
				            prodQuantRepo.save(productQuantityUse);
			        }
			        else{
				            productQuantityUse = prodQuantRepo.findByStockId(productQuantity.getStockId());
				            productQuantityUse.setQuantity(productQuantity.getQuantity());
				            prodQuantRepo.save(productQuantityUse);
			        }
				 
			            return "Successfully Update SKU" ;
	    }
	 
	 
	    @GetMapping("/searchProducts")
	    public List<Product> productSearch(@RequestBody ProductRequestDTO prodReqDTO )
	    {		    	 
		 	       return prodRepo.findProductByProductIdAndProductNameAndPriceAndBrand(prodReqDTO.getProductId(),prodReqDTO.getProductName(),prodReqDTO.getPrice(),prodReqDTO.getBrand());	         
	    }
	 	
	 
		    static boolean isNull(Integer integer) 
		    {
			        if (integer == null)
				            return true;
			        return false;
		    }
}
