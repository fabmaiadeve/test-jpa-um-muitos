package com.fabdev.testjpaummuitos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabdev.testjpaummuitos.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
