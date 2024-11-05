package com.waltercrdz.api.pricing.service;

import com.waltercrdz.api.pricing.domain.model.GetPriceQuery;
import com.waltercrdz.api.pricing.domain.model.Price;
import com.waltercrdz.api.pricing.domain.repository.PriceQueryRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;

@Service
public class PriceQueryService {

    private final PriceQueryRepository repository;

    public PriceQueryService(PriceQueryRepository repository) {
        this.repository = repository;
    }

    public Optional<Price> getPrice(GetPriceQuery query) {
        checkArgument(Objects.nonNull(query), "Query cannot be null");
        return repository.findByDateAndProductIdAndBrandId(query).stream().findFirst();
    }
}
