package com.waltercrdz.api.pricing.in.mapper;

import com.waltercrdz.api.pricing.in.dto.PriceDto;
import com.waltercrdz.api.pricing.domain.model.Price;

public class PriceMapper {

    public static PriceDto toDto(Price price) {
        return new PriceDto.Builder()
                .productId(price.getProductId())
                .brandId(price.getBrandId())
                .priceList(price.getPriceList())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .price(price.getPrice())
                .currency(price.getCurrency())
                .build();
    }
}
