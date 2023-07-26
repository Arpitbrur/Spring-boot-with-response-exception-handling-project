package com.jsp.Springbootwithresponseexceptionproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.Springbootwithresponseexceptionproject.dao.ProductDao;
import com.jsp.Springbootwithresponseexceptionproject.dto.Product;
import com.jsp.Springbootwithresponseexceptionproject.dto.ResponseStructure;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ResponseStructure<Product> responseStructure;
	
	// insert product------------------------------------------------------------------------
	public ResponseStructure<Product> insertProduct(Product product) {
		responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
		responseStructure.setMsg("data inserted Successfully..............");
		responseStructure.setData(product);
		
		productDao.insertProduct(product);
		return responseStructure;
	
	}	
}
