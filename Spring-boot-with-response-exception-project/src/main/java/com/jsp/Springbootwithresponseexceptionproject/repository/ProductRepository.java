package com.jsp.Springbootwithresponseexceptionproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.jsp.Springbootwithresponseexceptionproject.dto.Product;
@Component
public interface ProductRepository extends JpaRepository<Product, Integer>{

	
	
	public Product findByProductName(String name);

	@Query("from Product where productColor = ?1")
	public List<Product> getProductByColor(String color);
	
	
}
