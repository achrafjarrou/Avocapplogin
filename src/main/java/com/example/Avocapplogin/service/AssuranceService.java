package com.example.Avocapplogin.service;

import com.example.Avocapplogin.model.Assurance;
import com.example.Avocapplogin.repository.AssuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssuranceService {

    @Autowired
    private AssuranceRepository assuranceRepository;

    public Assurance saveAssurance(Assurance assurance) {
        return assuranceRepository.save(assurance);
    }

    public Assurance updateAssurance(Long id, Assurance assuranceDetails) {
        Assurance assurance = assuranceRepository.findById(id).orElseThrow(() -> new RuntimeException("Assurance not found"));
        assurance.setNom(assuranceDetails.getNom());
        assurance.setVille(assuranceDetails.getVille());
        assurance.setTelephone(assuranceDetails.getTelephone());
        return assuranceRepository.save(assurance);
    }

    public void deleteAssurance(Long id) {
        assuranceRepository.deleteById(id);
    }

    public List<Assurance> getAllAssurances() {
        return assuranceRepository.findAll();
    }
}
