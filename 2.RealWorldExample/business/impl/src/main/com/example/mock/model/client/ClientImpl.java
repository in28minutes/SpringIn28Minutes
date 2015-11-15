package com.in28minutes.example.layering.model.impl.client;

import java.math.BigDecimal;
import java.util.List;

import com.in28minutes.example.layering.model.impl.client.Client;
import com.in28minutes.example.layering.model.impl.client.ClientType;
import com.in28minutes.example.layering.model.impl.client.Collateral;
import com.in28minutes.example.layering.model.impl.client.Product;

/**
 * Client Model API.
 */
public class ClientImpl implements Client {

	private long id;

	private String name;

	private ClientType type;

	private List<Collateral> collaterals;

	private List<Product> products;
	
	private BigDecimal productAmount;
	
	public ClientImpl(long id, String name, ClientType type,
			List<Collateral> collaterals, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.collaterals = collaterals;
		this.products = products;
	}

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
	public ClientType getType() {
		return type;
	}

	public void setType(ClientType type) {
		this.type = type;
	}

	@Override
	public List<Collateral> getCollaterals() {
		return collaterals;
	}

	public void setCollaterals(List<Collateral> collaterals) {
		this.collaterals = collaterals;
	}

	@Override
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public BigDecimal getProductAmount() {
		return productAmount;
	}

	@Override
	public void setProductAmount(BigDecimal productAmount) {
		this.productAmount = productAmount;
	}

}
