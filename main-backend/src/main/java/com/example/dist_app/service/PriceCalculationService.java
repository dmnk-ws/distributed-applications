package com.example.dist_app.service;

import com.example.dist_app.entity.enums.Currency;
import org.springframework.beans.factory.annotation.Value;
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
     * The default currency used for price calculations.
     */
    private final Currency defaultCurrency;

    /**
     * The default discount percentage for vouchers.
     */
    private final BigDecimal discountPercentage;

    /**
     * Creates a new PriceCalculationService with the specified default currency
     * and discount percentage.
     *
     * @param defaultCurrency the default currency from application configuration
     * @param discountPercentage the default discount percentage from application configuration
     */
    public PriceCalculationService(
        @Value("${app.currency.default}") Currency defaultCurrency,
        @Value("${app.discount.percentage}") BigDecimal discountPercentage
    ) {
        this.defaultCurrency = defaultCurrency;
        this.discountPercentage = discountPercentage;
    }

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

    /**
     * Converts the given amount from one currency into another using
     * the {@link Currency} enum.
     *
     * @param amount the amount to convert
     * @param from the currency to convert from
     * @param to the currency to convert to
     * @return the rounded and converted currency
     */
    public BigDecimal convert(BigDecimal amount, Currency from, Currency to) {
        if (from.equals(to)) {
            return amount;
        }

        BigDecimal inEuro = amount.divide(
            from.getRateToEuro(), 10, RoundingMode.HALF_UP
        );

        return this.round(
            inEuro.multiply(to.getRateToEuro())
        );
    }

    /**
     * Discounts a given percentage from a given price.
     *
     * @param price the price to discount
     * @param percentage the percentage that is discounted from the price
     * @return the discounted price
     */
    public BigDecimal discount(BigDecimal price, BigDecimal percentage) {
        BigDecimal multiplier = new BigDecimal("100")
            .subtract(percentage)
            .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);

        return this.round(price.multiply(multiplier));
    }

    /**
     * Returns the default currency configured for the application.
     *
     * @return the default currency
     */
    public Currency getDefaultCurrency() {
        return this.defaultCurrency;
    }

    /**
     * Returns the default discount percentage configured for the application.
     *
     * @return the discount percentage
     */
    public BigDecimal getDiscountPercentage() {
        return this.discountPercentage;
    }
}
