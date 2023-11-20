package com.logicfuse.logicfuse.repositories;

import com.logicfuse.logicfuse.models.SaleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<SaleModel,Integer> {
}
