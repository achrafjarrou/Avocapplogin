package com.example.Avocapplogin.repository;

import com.example.Avocapplogin.model.PersonnesDossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnesDossierRepository extends JpaRepository<PersonnesDossier, Long> {
}
