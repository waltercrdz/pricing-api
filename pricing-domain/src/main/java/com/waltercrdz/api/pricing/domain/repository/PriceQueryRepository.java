package com.waltercrdz.api.pricing.domain.repository;

import com.waltercrdz.api.pricing.domain.model.GetPriceQuery;
import com.waltercrdz.api.pricing.domain.model.Price;

import java.util.List;

public interface PriceQueryRepository {

    List<Price> findByDateAndProductIdAndBrandId(GetPriceQuery query);
}
