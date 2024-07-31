package com.example.Avocapplogin.repository;

import com.example.Avocapplogin.model.Maktoubat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaktoubatRepository extends JpaRepository<Maktoubat, Long> {
}
