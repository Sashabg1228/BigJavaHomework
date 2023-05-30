package com.example.bigjavahomework.repositoryes;

import com.example.bigjavahomework.entityes.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {
}
