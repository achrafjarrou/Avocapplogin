package com.example.Avocapplogin.repository;

import com.example.Avocapplogin.model.Tanfid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TanfidRepository extends JpaRepository<Tanfid, Long> {
}
