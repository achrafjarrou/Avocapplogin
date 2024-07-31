package com.example.Avocapplogin.service;

import com.example.Avocapplogin.model.AssurancesDossier;
import com.example.Avocapplogin.repository.AssurancesDossierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssurancesDossierService {

    @Autowired
    private AssurancesDossierRepository assurancesDossierRepository;

    public AssurancesDossier saveRelation(AssurancesDossier relation) {
        return assurancesDossierRepository.save(relation);
    }

    public List<AssurancesDossier> getAllRelations() {
        return assurancesDossierRepository.findAll();
    }

    public void deleteRelation(Long id) {
        assurancesDossierRepository.deleteById(id);
    }
}
