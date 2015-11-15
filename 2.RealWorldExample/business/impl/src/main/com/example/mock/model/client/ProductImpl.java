package com.in28minutes.example.layering.model.impl.client;

import com.in28minutes.example.layering.model.impl.client.Amount;
import com.in28minutes.example.layering.model.impl.client.Product;
import com.in28minutes.example.layering.model.impl.client.ProductType;

/**
 * Collateral Model Object.
 */
public class ProductImpl implements Product {

	private long id;

	private String name;

	private ProductType type;
	
	private Amount amount;

	public ProductImpl(long id, String name, ProductType type, Amount amount) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.amount = amount;
	}

	@Override
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	@Override
	public Amount getAmount() {
		return amount;
	}
	
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
}
