package com.waltercrdz.api.pricing.domain.model;

import java.time.Instant;

public record GetPriceQuery(Long productId, Long brandId, Instant date) {

    public static GetPriceQuery of(Long productId, Long brandId) {
        return new GetPriceQuery(productId, brandId, Instant.now());
    }

    public static GetPriceQuery of(Long productId, Long brandId, Instant date) {
        return new GetPriceQuery(productId, brandId, date);
    }
}
