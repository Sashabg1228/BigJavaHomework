package com.example.bigjavahomework.repositoryes;

import com.example.bigjavahomework.entityes.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends JpaRepository<Countries, String> {
}
