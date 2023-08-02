package com.jsp.Springbootwithresponseexceptionproject.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	private int productId;
	private String productName;
	private String productColor;
	private double productPrice;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public Product(int productId, String productName, String productColor, double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productColor = productColor;
		this.productPrice = productPrice;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	
}
