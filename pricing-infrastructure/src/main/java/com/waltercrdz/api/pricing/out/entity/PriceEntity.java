package com.waltercrdz.api.pricing.out.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "prices", indexes = {
        @Index(name = "idx_prices_product_brand_dates", columnList = "start_date, end_date, product_id, brand_id")
})
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_id", nullable = false)
    private Long productId;
    @Column(name = "brand_id", nullable = false)
    private Long brandId;
    @Column(name = "price_list", nullable = false)
    private Long priceList;
    private Integer priority;
    @Column(name = "start_date", nullable = false)
    private Instant startDate;
    @Column(name = "end_date", nullable = false)
    private Instant endDate;
    private BigDecimal price;
    private String currency;

    public PriceEntity() {}

    private PriceEntity(Long id, Long productId, Long brandId, Long priceList, Integer priority, Instant startDate, Instant endDate, BigDecimal price, String currency) {
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

    public static PriceEntity of(Long id, Long productId, Long brandId, Long priceList, Integer priority, Instant startDate, Instant endDate, BigDecimal price, String currency) {
        return new PriceEntity(id, productId, brandId, priceList, priority, startDate, endDate, price, currency);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceEntity that = (PriceEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(productId, that.productId) && Objects.equals(brandId, that.brandId) && Objects.equals(priceList, that.priceList) && Objects.equals(priority, that.priority) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(price, that.price) && Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, brandId, priceList, priority, startDate, endDate, price, currency);
    }
}