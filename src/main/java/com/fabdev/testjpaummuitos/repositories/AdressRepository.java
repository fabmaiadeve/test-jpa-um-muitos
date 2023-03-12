package com.fabdev.testjpaummuitos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabdev.testjpaummuitos.models.Adress;

public interface AdressRepository extends JpaRepository<Adress, UUID> {

}
