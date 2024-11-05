package com.waltercrdz.api.pricing.out.repository;

import com.waltercrdz.api.pricing.out.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface PriceRepositoryH2 extends JpaRepository<PriceEntity, Long> {

    @Query("SELECT p " +
            "FROM PriceEntity p " +
            "WHERE :date BETWEEN p.startDate AND p.endDate AND " +
            "p.productId = :productId AND " +
            "p.brandId = :brandId ")
    List<PriceEntity> findByDateAndProductIdAndBrandId(@Param("date") Instant date,
                                                       @Param("productId") Long productId,
                                                       @Param("brandId") Long brandId);
}