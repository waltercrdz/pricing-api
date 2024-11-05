package com.waltercrdz.api.pricing.out.mapper;

import com.waltercrdz.api.pricing.domain.model.Price;
import com.waltercrdz.api.pricing.out.entity.PriceEntity;

public class PriceMapper {

    public static Price toDomain(PriceEntity priceEntity) {
        return new Price.Builder()
                .id(priceEntity.getId())
                .productId(priceEntity.getProductId())
                .brandId(priceEntity.getBrandId())
                .priceList(priceEntity.getPriceList())
                .priority(priceEntity.getPriority())
                .startDate(priceEntity.getStartDate())
                .endDate(priceEntity.getEndDate())
                .price(priceEntity.getPrice())
                .currency(priceEntity.getCurrency())
                .build();
    }
}
