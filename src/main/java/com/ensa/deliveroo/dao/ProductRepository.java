package com.ensa.deliveroo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.deliveroo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
