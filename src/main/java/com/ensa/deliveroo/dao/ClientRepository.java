package com.ensa.deliveroo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensa.deliveroo.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
