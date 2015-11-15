package com.in28minutes.example.layering.model.impl.client;

import java.util.Arrays;
import java.util.List;

/**
 * Available types of customers
 */
public enum ClientType {
    /**
     * 
     */
    PRIVATE("P"), 
    /**
     * 
     */
    BUSINESS("Z");

    private final String textValue;

    /**
     * List of natural person types.
     */
    public static final List<String> NATURAL_PERSON_TYPES = Arrays.asList(ClientType.PRIVATE.toString());

    /**
     * List of corporate types.
     */
    public static final List<String> CORPORATE_TYPES = Arrays.asList(ClientType.BUSINESS.toString());

    ClientType(final String textValue) {
        this.textValue = textValue;
    }

    @Override
    public String toString() {
        return textValue;
    }
}
