package com.rest_spring_boot.service;


import com.rest_spring_boot.dto.EntityDTO;
import com.rest_spring_boot.dto.order.Order;
import com.rest_spring_boot.entity.Entity;

import java.util.List;

public interface Service<E extends EntityDTO> {
    List<E> getAll();
    void add(E e);
    boolean deleteById(long id);
    void edit(E e);
    E getById(long id);
}
