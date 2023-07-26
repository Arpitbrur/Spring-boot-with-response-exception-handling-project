package com.jsp.Springbootwithresponseexceptionproject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Springbootwithresponseexceptionproject.dto.Product;
import com.jsp.Springbootwithresponseexceptionproject.repository.ProductRepository;

@Repository
public class ProductDao {

	@Autowired
	private ProductRepository productRepository;
	
	// insert product------------------------------------------------------------------------
	public Product insertProduct(Product product) {
		return productRepository.save(product);
	}
}
