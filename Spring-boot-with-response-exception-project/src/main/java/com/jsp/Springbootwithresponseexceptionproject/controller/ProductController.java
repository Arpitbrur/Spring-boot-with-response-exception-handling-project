package com.jsp.Springbootwithresponseexceptionproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	// getByID--------------------------------------------------------------------------------
	@GetMapping("/getProductById/{productId}")
	public ResponseStructure<Product> getProductById(@PathVariable int productId) {
		return productService.getProductById(productId);
	}	
	
	// delete method----------------------------------------------------------------------------
	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseStructure<Product> deleteProduct(Product product, @PathVariable int productId) {
		return productService.deleteProduct(product, productId);
	}	
	
	// update product------------------------------------------------------------------------------
	@PutMapping("/updateProduct")
	public ResponseStructure<Product> updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}	
	
	//display product------------------------------------------------------------------------------
	@GetMapping("/displayAllProduct")
	public List<Product> displayAllProduct(){
		return productService.displayAllProduct();
	}	
}
