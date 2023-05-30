package com.example.bigjavahomework.repositoryes;

import com.example.bigjavahomework.entityes.Statuses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusesRepository extends JpaRepository<Statuses, String> {
}
