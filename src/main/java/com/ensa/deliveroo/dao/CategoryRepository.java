package com.ensa.deliveroo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.deliveroo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
