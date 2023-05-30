package com.example.bigjavahomework.repositoryes;

import com.example.bigjavahomework.entityes.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
