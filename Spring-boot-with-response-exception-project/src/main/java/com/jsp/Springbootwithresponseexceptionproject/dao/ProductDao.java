package com.jsp.Springbootwithresponseexceptionproject.dao;

import java.util.List;
import java.util.Optional;

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
	
	// getByID--------------------------------------------------------------------------------
	public Product getProductById(int productId) {
		Optional<Product> optional = productRepository.findById(productId);
		
		if(optional.isPresent()) {
			Product product = optional.get();
			
			return product;
		}else {
			return null;
		}
	}
	
	// delete method----------------------------------------------------------------------------
	public Product deleteProduct(Product product, int productId) {
		Optional<Product> optional = productRepository.findById(productId);
		
		if(optional.isPresent()) {
			productRepository.delete(optional.get());
			return product;
		}else {
			return null;
		}
	}
	
	// update product------------------------------------------------------------------------------
	public Product updateProduct(Product product) {
		Product product2 = getProductById(product.getProductId());
		if(product2 != null) {
			product2.setProductName(product.getProductName());
			product2.setProductColor(product.getProductColor());
			product2.setProductPrice(product.getProductPrice());
			
			return productRepository.save(product2);
		}else {
			return null;
		}
		
	}
	
	//display product------------------------------------------------------------------------------
	public List<Product> displayAllProduct(){
		return productRepository.findAll();
	}
}
