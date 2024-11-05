package com.waltercrdz.api.pricing.in.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;
import java.time.Instant;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record PriceDto(
        Long productId,
        Long brandId,
        Long priceList,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
        Instant startDate,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
        Instant endDate,
        BigDecimal price,
        String currency) {

    public static class Builder {
        private Long productId;
        private Long brandId;
        private Long priceList;
        private Instant startDate;
        private Instant endDate;
        private BigDecimal price;
        private String currency;

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

        public PriceDto build() {
            return new PriceDto(productId, brandId, priceList, startDate, endDate, price, currency);
        }
    }
}
