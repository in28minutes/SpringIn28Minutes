package com.in28minutes.example.layering.model.impl.client;

import com.in28minutes.example.layering.model.impl.client.Collateral;
import com.in28minutes.example.layering.model.impl.client.CollateralType;

/**
 * Collateral Model Object.
 */
public class CollateralImpl implements Collateral {

	private long id;

	private String name;

	private CollateralType type;

	public CollateralImpl(long id, String name, CollateralType type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
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
	public CollateralType getType() {
		return type;
	}

	public void setType(CollateralType type) {
		this.type = type;
	}
}
