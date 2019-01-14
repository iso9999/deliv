package com.ensa.deliveroo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.deliveroo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
