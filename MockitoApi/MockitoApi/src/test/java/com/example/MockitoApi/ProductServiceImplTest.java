package com.example.MockitoApi;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.product.entities.Product;
import com.examples.product.repository.ProductRepository;
import com.examples.product.services.ProductServiceImpl;

public class ProductServiceImplTest {
	
	@InjectMocks
	private ProductServiceImpl productServiceImpl;
	
	@Mock
	private ProductRepository repository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveProduct() {
		Product product = getProductInstance();
		Mockito.when(repository.save(product)).thenReturn(product);
		Product savedProduct = repository.save(product);
		Assert.assertEquals("abc", savedProduct.getName());
		Assert.assertEquals(new BigDecimal(300.00), savedProduct.getPrice());
		Assert.assertEquals("022", savedProduct.getProductId());
	}

	
	@Test
	public void testDelete() {
		Product product = getProductInstance();
		Mockito.when(repository.findOne(Mockito.anyInt())).thenReturn(product);
		Mockito.when(repository.existsById(Mockito.anyInt())).thenReturn(true);
		boolean status = repository.delete(Mockito.anyInt());
		Assert.assertEquals(true, status);
	}

	
	private Product getProductInstance() {
		Product product = new Product();
		product.setId(5);
		product.setName("abc");
		product.setPrice(new BigDecimal(300.00));
		product.setProductId("022");
		product.setVersion(022);
		return product;
	}
}
