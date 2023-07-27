package com.jsp.Springbootwithresponseexceptionproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.Springbootwithresponseexceptionproject.dao.ProductDao;
import com.jsp.Springbootwithresponseexceptionproject.dto.Product;
import com.jsp.Springbootwithresponseexceptionproject.dto.ResponseStructure;
import com.jsp.Springbootwithresponseexceptionproject.exception.IdNotFoundException;

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
	
	// getByID--------------------------------------------------------------------------------
	public ResponseStructure<Product> getProductById(int productId) {
		Product product = productDao.getProductById(productId);
		if(product != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("given id is fetch successfully");
			responseStructure.setData(product);
			
			
		}else {
			throw new IdNotFoundException("Given Id is not present in database");
		}
		return responseStructure;
	}
	
	// delete method----------------------------------------------------------------------------
	public ResponseStructure<Product> deleteProduct(Product product, int productId) {
		Product product2 = productDao.deleteProduct(product, productId);
		if(product2 != null) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("given id id deleted successfully");
			responseStructure.setData(product2);
		}else {
			
			throw new IdNotFoundException("Given Id is not present in database");
		}
		return responseStructure;
	}	
	
	// update product------------------------------------------------------------------------------
	public ResponseStructure<Product> updateProduct(Product product) {
		Product product2 = productDao.updateProduct(product);
		if(product2 !=null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Data updated Successfully");
			responseStructure.setData(product2);
			return responseStructure;
		}else {
			
			throw new IdNotFoundException("Given id is not found in database");
		}
	}	
	
	//display product------------------------------------------------------------------------------
	public List<Product> displayAllProduct(){
		return productDao.displayAllProduct();
	}	
}
