package com.waltercrdz.api.pricing.out.repository;

import com.waltercrdz.api.pricing.domain.exception.DatabaseConnectionException;
import com.waltercrdz.api.pricing.domain.model.GetPriceQuery;
import com.waltercrdz.api.pricing.domain.model.Price;
import com.waltercrdz.api.pricing.domain.repository.PriceQueryRepository;
import com.waltercrdz.api.pricing.out.mapper.PriceMapper;
import jakarta.persistence.PersistenceException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PriceQueryRepositoryInMemory implements PriceQueryRepository {

    private final PriceRepositoryH2 priceRepositoryH2;

    public PriceQueryRepositoryInMemory(PriceRepositoryH2 priceRepositoryH2) {
        this.priceRepositoryH2 = priceRepositoryH2;
    }

    @Override
    public List<Price> findByDateAndProductIdAndBrandId(GetPriceQuery query) {
        try {
            return priceRepositoryH2.findByDateAndProductIdAndBrandId(
                            query.date(),
                            query.productId(),
                            query.brandId())
                    .stream()
                    .map(PriceMapper::toDomain)
                    .sorted((p1, p2) -> p2.getPriority().compareTo(p1.getPriority()))
                    .toList();
        } catch (PersistenceException | DataAccessException e) {
            throw new DatabaseConnectionException("Unexpected error when performing an DB operation", e);
        }
    }
}
