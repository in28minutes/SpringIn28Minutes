package com.in28minutes.example.layering.model.impl.client;


public enum Currency {
	
	EURO("EUR"),
	UNITED_STATES_DOLLAR("USD"),
	INDIAN_RUPEE("INR");
	
    private final String textValue;

    Currency(final String textValue) {
        this.textValue = textValue;
    }

    @Override
    public String toString() {
        return textValue;
    }
}
