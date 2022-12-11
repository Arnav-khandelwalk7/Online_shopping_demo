package com.demo.shopping.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RequestOrderDTO {

	
	private Integer orderId;
	
	private Integer quantity;

	private Integer productId;
	
	private Integer userId;
}
