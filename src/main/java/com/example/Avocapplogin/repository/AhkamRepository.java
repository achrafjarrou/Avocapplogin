package com.example.Avocapplogin.repository;

import com.example.Avocapplogin.model.Ahkam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AhkamRepository extends JpaRepository<Ahkam, Long> {
}
