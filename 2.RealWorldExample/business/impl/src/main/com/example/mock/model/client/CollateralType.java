package com.in28minutes.example.layering.model.impl.client;

import java.util.Arrays;
import java.util.List;

/**
 * Available types of customers
 */
public enum CollateralType {
    REAL_ESTATE("REA"), 
    BONDS("BND"), 
    MUTUAL_FUNDS("MFD"), 
    STOCKS("STK");

    private final String textValue;

    /**
     * All collateral types classified as securities.
     */
    public static final List<CollateralType> SECURITIES = Arrays.asList(BONDS,MUTUAL_FUNDS,STOCKS);

    CollateralType(final String textValue) {
        this.textValue = textValue;
    }

    @Override
    public String toString() {
        return textValue;
    }
}
