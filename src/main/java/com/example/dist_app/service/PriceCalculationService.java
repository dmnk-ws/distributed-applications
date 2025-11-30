package com.example.dist_app.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Implementation of {@link IPriceCalculationService} that provides
 * price calculation utilities for the application.
 */
@Service
public class PriceCalculationService implements IPriceCalculationService {
    /**
     * Rounds the price to two decimal places using HALF_UP rounding mode
     * (rounds up when the digit is 0.5 or greater).
     *
     * @param price the price to round
     * @return the rounded price with two decimal places
     */
    public BigDecimal round(BigDecimal price) {
        return price.setScale(2, RoundingMode.HALF_UP);
    }
}
