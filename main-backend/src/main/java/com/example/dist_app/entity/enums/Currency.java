package com.example.dist_app.entity.enums;

import java.math.BigDecimal;

/**
 * Supported currencies for prices with conversion rates.
 * Each currency stores its exchange rate relative to EUR (base currency).
 */
public enum Currency {
    /**
     * Euro - the base currency with a rate of 1.
     */
    EUR(new BigDecimal("1")),

    /**
     * US Dollar - exchange rate of 1.17 (1 EUR = 1.17 USD).
     */
    USD(new BigDecimal("1.17"));

    /**
     * The exchange rate relative to EUR (base currency).
     * A value of 1.17 means 1 EUR = 1.17 units of this currency.
     */
    private final BigDecimal rateToEuro;

    /**
     * Creates a currency with the specified exchange rate to EUR.
     *
     * @param rate the exchange rate relative to EUR (1 EUR = rate units of this currency)
     */
    Currency(BigDecimal rate) {
        this.rateToEuro = rate;
    }

    /**
     * Returns the exchange rate to convert this currency to EUR.
     *
     * @return the rate where 1 EUR = this rate in the current currency
     */
    public BigDecimal getRateToEuro() {
        return this.rateToEuro;
    }
}
