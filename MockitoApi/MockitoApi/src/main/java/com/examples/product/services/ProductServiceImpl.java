package com.examples.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.product.entities.Product;
import com.examples.product.repository.ProductRepository;

public class ProductServiceImpl implements ProductService{
	
	private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }


}
