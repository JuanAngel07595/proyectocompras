package com.logicfuse.logicfuse.repositories;

import com.logicfuse.logicfuse.models.HistoricalPriceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricalPriceRepository extends JpaRepository<HistoricalPriceModel, Integer> {
}
