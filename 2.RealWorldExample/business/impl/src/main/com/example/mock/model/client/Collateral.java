package com.in28minutes.example.layering.model.impl.client;

/**
 * Collateral Model API.
 */
public interface Collateral {
	
	long getId();
	
	String getName();

    CollateralType getType();
}
