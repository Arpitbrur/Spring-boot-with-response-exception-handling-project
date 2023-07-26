package com.jsp.Springbootwithresponseexceptionproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Springbootwithresponseexceptionproject.dto.Product;
import com.jsp.Springbootwithresponseexceptionproject.dto.ResponseStructure;
import com.jsp.Springbootwithresponseexceptionproject.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	// insert product------------------------------------------------------------------------
	@PostMapping("/saveProduct")
	public ResponseStructure<Product> insertProduct(@RequestBody Product product) {
		return productService.insertProduct(product);
	}	
}
