package com.in28minutes.example.layering.model.impl.client;

/**
 * Product Model API.
 */
public interface Product {

	long getId();
	
    String getName();

    ProductType getType();
    
    Amount getAmount();
}
