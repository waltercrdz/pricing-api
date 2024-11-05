package com.waltercrdz.api.pricing.in.mapper;

import com.waltercrdz.api.pricing.domain.model.Price;
import com.waltercrdz.api.pricing.in.dto.PriceDto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PriceMapperTest {

    private static final Long ID = 1234L;
    private static final Long PRODUCT_ID = 1L;
    private static final Long BRAND_ID = 35455L;
    private static final Long PRICE_LIST = 1L;
    private static final Instant START_DATE = Instant.parse("2020-06-14T00:00:00Z");
    private static final Instant END_DATE = Instant.parse("2020-12-31T23:59:59Z");
    private static final Integer PRIORITY = 1;
    private static final BigDecimal PRICE = BigDecimal.valueOf(35.50);
    private static final String CURRENCY = "EUR";

    @Test
    void testToDto() {
        // Arrange
        final Price price = new Price.Builder()
                .productId(PRODUCT_ID)
                .brandId(BRAND_ID)
                .priceList(PRICE_LIST)
                .startDate(START_DATE)
                .endDate(END_DATE)
                .priority(PRIORITY)
                .price(PRICE)
                .currency(CURRENCY)
                .build();
        // Act
        final PriceDto priceDto = PriceMapper.toDto(price);
        // Assert
        assertEquals(price.getProductId(), priceDto.productId());
        assertEquals(price.getBrandId(), priceDto.brandId());
        assertEquals(price.getPriceList(), priceDto.priceList());
        assertEquals(price.getStartDate(), priceDto.startDate());
        assertEquals(price.getEndDate(), priceDto.endDate());
        assertEquals(price.getPrice(), priceDto.price());
        assertEquals(price.getCurrency(), priceDto.currency());
    }
}