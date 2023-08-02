package com.jsp.Springbootwithresponseexceptionproject.dao;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import com.jsp.Springbootwithresponseexceptionproject.dto.Product;
import com.jsp.Springbootwithresponseexceptionproject.repository.ProductRepository;

@DataJpaTest  // 
class ProductDaoTest {

	@Mock //  @mock is use instead of @Autowired
	private ProductRepository productRepository;
	
	private ProductDao productDao;
	
	private Product product1;
	
	private Product product2;
	
	List<Product> products;
	
	private AutoCloseable autoCloseable;
	
	@BeforeEach
	public void setup() {
		// id, name, color, price
		product1 = new Product(11, "bike", "white", 100000);
		product2 = new Product(12,"car", "black",200000);
		productDao = new ProductDao(productRepository);
		autoCloseable = MockitoAnnotations.openMocks(this);
		products = new ArrayList<Product>();		
		products.add(product1);
		products.add(product2);
	}
	
	@Test
	public void insertproductTest() {
		mock(ProductRepository.class);
		mock(Product.class);
		when(productRepository.save(product1)).thenReturn(product1);
		assertThat(productDao.insertProduct(product1)).isEqualTo(product1);
	}
}
