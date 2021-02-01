package com.rest_spring_boot.repository.order;

import com.rest_spring_boot.entity.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
