package com.example.Avocapplogin.repository;

import com.example.Avocapplogin.model.AssurancesDossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssurancesDossierRepository extends JpaRepository<AssurancesDossier, Long> {
}
