package com.it.mapper;

import com.it.domain.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> findAll();
}
