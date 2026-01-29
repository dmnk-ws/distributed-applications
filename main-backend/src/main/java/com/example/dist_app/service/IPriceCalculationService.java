package com.example.dist_app.service;

import com.example.dist_app.entity.enums.Currency;

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

    /**
     * Converts the given amount from one currency into another using
     * the {@link Currency} enum.
     *
     * @param amount the amount to convert
     * @param from the currency to convert from
     * @param to the currency to convert to
     * @return the rounded and converted currency
     */
    BigDecimal convert(BigDecimal amount, Currency from, Currency to);

    /**
     * Discounts a given percentage from a given price.
     *
     * @param price the price to discount
     * @param percentage the percentage that is discounted from the price
     * @return the discounted price
     */
    BigDecimal discount(BigDecimal price, BigDecimal percentage);

    /**
     * Returns the default currency configured for the application.
     *
     * @return the default currency
     */
    Currency getDefaultCurrency();

    /**
     * Returns the default discount percentage configured for the application.
     *
     * @return the discount percentage
     */
    BigDecimal getDiscountPercentage();
}
