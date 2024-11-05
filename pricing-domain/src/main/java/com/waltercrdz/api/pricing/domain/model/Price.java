package com.waltercrdz.api.pricing.domain.model;

import java.math.BigDecimal;
import java.time.Instant;

public class Price {

    private final Long id;
    private final Long productId;
    private final Long brandId;
    private final Long priceList;
    private final Integer priority;
    private final Instant startDate;
    private final Instant endDate;
    private final BigDecimal price;
    private final String currency;


    private Price(Long id, Long productId, Long brandId, Long priceList, Integer priority, Instant startDate, Instant endDate, BigDecimal price, String currency) {
        this.id = id;
        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.priority = priority;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Long getPriceList() {
        return priceList;
    }

    public Integer getPriority() {
        return priority;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public static class Builder {
        private Long id;
        private Long productId;
        private Long brandId;
        private Long priceList;
        private Integer priority;
        private Instant startDate;
        private Instant endDate;
        private BigDecimal price;
        private String currency;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder productId(Long productId) {
            this.productId = productId;
            return this;
        }

        public Builder brandId(Long brandId) {
            this.brandId = brandId;
            return this;
        }

        public Builder priceList(Long priceList) {
            this.priceList = priceList;
            return this;
        }

        public Builder priority(Integer priority) {
            this.priority = priority;
            return this;
        }

        public Builder startDate(Instant startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(Instant endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Price build() {
            return new Price(id, productId, brandId, priceList, priority, startDate, endDate, price, currency);
        }
    }
}
