package com.rest_spring_boot.repository.product;

import com.rest_spring_boot.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
