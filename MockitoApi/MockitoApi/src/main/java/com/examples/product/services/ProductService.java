package com.examples.product.services;

import java.util.List;

import com.example.product.entities.Product;

public interface ProductService {
	
	List<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);

}
