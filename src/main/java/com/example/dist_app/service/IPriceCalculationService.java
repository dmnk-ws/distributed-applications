package com.example.dist_app.service;

import java.math.BigDecimal;

/**
 * Service interface for price calculations such as rounding.
 */
public interface IPriceCalculationService {
    /**
     * Rounds the price to two decimal places using HALF_UP rounding mode
     * (rounds up when the digit is 0.5 or greater).
     *
     * @param price the price to round
     * @return the rounded price with two decimal places
     */
    BigDecimal round(BigDecimal price);
}
