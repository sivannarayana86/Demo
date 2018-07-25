package com.examples.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findOne(int anyInt);

	boolean delete(int anyInt);

}
