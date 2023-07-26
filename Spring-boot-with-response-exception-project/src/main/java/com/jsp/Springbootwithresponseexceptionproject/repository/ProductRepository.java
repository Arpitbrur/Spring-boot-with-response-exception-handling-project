package com.jsp.Springbootwithresponseexceptionproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.jsp.Springbootwithresponseexceptionproject.dto.Product;
@Component
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
