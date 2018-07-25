package com.example.MockitoApi;

import java.math.BigDecimal;

import com.example.product.entities.Product;

import lombok.Builder;

public class ObjectBuilder {
	
	 @Builder(builderMethodName = "productBuilder")
	    public static Product newProduct(Integer id, Integer version, String productId,String name,BigDecimal price) {
	        final Product product = new Product();
	        product.setId(id);
	        product.setName(name);
	        product.setPrice(price);
	        product.setProductId(productId);
	        product.setVersion(version);
			return product;
	    }

}
