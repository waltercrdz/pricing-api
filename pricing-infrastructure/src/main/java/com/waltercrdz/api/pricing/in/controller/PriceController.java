package com.waltercrdz.api.pricing.in.controller;

import com.waltercrdz.api.pricing.domain.model.GetPriceQuery;
import com.waltercrdz.api.pricing.in.dto.PriceDto;
import com.waltercrdz.api.pricing.in.mapper.PriceMapper;
import com.waltercrdz.api.pricing.service.PriceQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class PriceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PriceController.class);

    private final PriceQueryService service;

    public PriceController(PriceQueryService service) {
        this.service = service;
    }

    @GetMapping("/products/{product_id}/prices")
    public ResponseEntity<PriceDto> getPrice(@PathVariable("product_id") Long productId,
                                             @RequestParam(value = "date", required = false) Instant date,
                                             @RequestParam(value = "brand_id") Long brandId) {
        final var getPriceQuery = GetPriceQuery.of(productId, brandId, date);
        LOGGER.info("Finding applicable Price for {}", getPriceQuery);
        return service.getPrice(getPriceQuery)
                .map(price -> ResponseEntity.ok(PriceMapper.toDto(price)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
