package com.example.Avocapplogin.repository;

import com.example.Avocapplogin.model.Depenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepensesRepository extends JpaRepository<Depenses, Long> {
}
