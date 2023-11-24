package com.logicfuse.logicfuse.repositories;

import com.logicfuse.logicfuse.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Integer> {
}
