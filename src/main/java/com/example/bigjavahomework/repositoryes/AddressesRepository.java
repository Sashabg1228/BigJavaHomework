package com.example.bigjavahomework.repositoryes;

import com.example.bigjavahomework.entityes.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressesRepository extends JpaRepository<Addresses, Integer> {
}
