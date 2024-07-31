package com.example.Avocapplogin.repository;

import com.example.Avocapplogin.model.Jalassat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JalassatRepository extends JpaRepository<Jalassat, Long> {
}
