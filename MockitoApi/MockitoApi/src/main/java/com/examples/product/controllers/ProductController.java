package com.examples.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.entities.Product;
import com.examples.product.services.ProductService;

@RequestMapping(value = "/product")
@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = productService.listAllProducts();
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Product> saveProduct( @RequestBody Product product){
		Product productObj = productService.saveProduct(product);
		return new ResponseEntity<>(productObj,HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Product> updateProduct( @RequestBody Product product){
		Product productObj = productService.saveProduct(product);
		return new ResponseEntity<>(productObj,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Boolean> deleteProduct( @RequestParam (value = "productId") int productId){
		 productService.deleteProduct(productId);
		 boolean status = productService.getProductById(productId) == null;
		return new ResponseEntity<>(status,HttpStatus.OK);
	}

}
