package com.example.Avocapplogin.repository;

import com.example.Avocapplogin.model.Tabligh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TablighRepository extends JpaRepository<Tabligh, Long> {
}
