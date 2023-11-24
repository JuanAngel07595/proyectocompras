package com.logicfuse.logicfuse.repositories;

import com.logicfuse.logicfuse.models.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<CartModel, Integer> {
}
