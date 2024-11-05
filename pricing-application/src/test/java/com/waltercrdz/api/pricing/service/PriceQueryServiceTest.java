package com.waltercrdz.api.pricing.service;

import com.waltercrdz.api.pricing.domain.model.GetPriceQuery;
import com.waltercrdz.api.pricing.domain.model.Price;
import com.waltercrdz.api.pricing.domain.repository.PriceQueryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PriceQueryServiceTest {

    private static final Long ID = 1234L;
    private static final Long PRODUCT_ID = 1L;
    private static final Long BRAND_ID = 35455L;
    private static final Long PRICE_LIST = 1L;
    private static final Instant START_DATE = Instant.parse("2020-06-14T00:00:00Z");
    private static final Instant END_DATE = Instant.parse("2020-12-31T23:59:59Z");
    private static final Integer PRIORITY = 1;
    private static final BigDecimal PRICE = BigDecimal.valueOf(35.50);
    private static final String CURRENCY = "EUR";

    @Mock
    private PriceQueryRepository repository;

    @InjectMocks
    private PriceQueryService service;

    private Price price;

    @BeforeEach
    public void setUp() {
        price = new Price.Builder()
                .id(ID)
                .productId(PRODUCT_ID)
                .brandId(BRAND_ID)
                .priceList(PRICE_LIST)
                .priority(PRIORITY)
                .startDate(START_DATE)
                .endDate(END_DATE)
                .price(PRICE)
                .currency(CURRENCY)
                .build();
    }

    @Test
    @DisplayName("When parameters have results should return an Optional with the expected Price")
    public void when_getPriceWithValidParameters_should_returnAnExpectedPrice() {
        final GetPriceQuery query = GetPriceQuery.of(PRODUCT_ID, BRAND_ID, START_DATE);
        when(repository.findByDateAndProductIdAndBrandId(query)).thenReturn(List.of(price));

        final Optional<Price> result = service.getPrice(query);

        verify(repository, times(1)).findByDateAndProductIdAndBrandId(query);
        assertEquals(Optional.of(price), result);
    }

    @Test
    @DisplayName("When parameters have no results should return an empty Optional")
    public void when_parametersHaveNoResults_should_returnAnEmptyOptional() {
        final GetPriceQuery query = GetPriceQuery.of(PRODUCT_ID, BRAND_ID, START_DATE);
        when(repository.findByDateAndProductIdAndBrandId(query)).thenReturn(List.of());

        final Optional<Price> result = service.getPrice(query);

        verify(repository, times(1)).findByDateAndProductIdAndBrandId(query);
        assertEquals(Optional.empty(), result);
    }

    @Test
    @DisplayName("When GetPriceQuery null should throw IllegalArgumentException")
    public void when_getPriceWithNullGetPriceQuery_should_returnThrowsAnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> service.getPrice(null));
        verify(repository, times(0)).findByDateAndProductIdAndBrandId(any());
    }
}
