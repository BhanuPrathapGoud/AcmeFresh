package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Clients;

public interface ClientDao extends JpaRepository<Clients, Integer>{

}
