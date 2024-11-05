package com.waltercrdz.api.pricing.out.mapper;

import com.waltercrdz.api.pricing.domain.model.Price;
import com.waltercrdz.api.pricing.out.entity.PriceEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;

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
    void testToDomain() {
        final PriceEntity priceEntity = PriceEntity.of(
                ID,
                PRODUCT_ID,
                BRAND_ID,
                PRICE_LIST,
                PRIORITY,
                START_DATE,
                END_DATE,
                PRICE,
                CURRENCY
        );

        final Price price = PriceMapper.toDomain(priceEntity);

        assertEquals(priceEntity.getId(), price.getId());
        assertEquals(priceEntity.getProductId(), price.getProductId());
        assertEquals(priceEntity.getBrandId(), price.getBrandId());
        assertEquals(priceEntity.getPriceList(), price.getPriceList());
        assertEquals(priceEntity.getStartDate(), price.getStartDate());
        assertEquals(priceEntity.getEndDate(), price.getEndDate());
        assertEquals(priceEntity.getPriority(), price.getPriority());
        assertEquals(priceEntity.getPrice(), price.getPrice());
        assertEquals(priceEntity.getCurrency(), price.getCurrency());
    }
}