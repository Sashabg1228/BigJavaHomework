package com.example.bigjavahomework.repositoryes;

import com.example.bigjavahomework.entityes.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
}
