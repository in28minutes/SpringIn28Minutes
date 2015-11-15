package com.in28minutes.example.layering.model.impl.client;

import java.math.BigDecimal;

public interface Amount {
	BigDecimal getValue();
	Currency getCurrency();
}
