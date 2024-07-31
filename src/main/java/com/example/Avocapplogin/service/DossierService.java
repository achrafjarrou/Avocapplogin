package com.example.Avocapplogin.service;

import com.example.Avocapplogin.model.Dossier;
import com.example.Avocapplogin.repository.DossierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DossierService {

    private final DossierRepository dossierRepository;

    @Autowired
    public DossierService(DossierRepository dossierRepository) {
        this.dossierRepository = dossierRepository;
    }

    public Optional<Dossier> getDossierById(Long id) {
        return dossierRepository.findById(id);
    }

    public Dossier saveDossier(Dossier dossier) {
        return dossierRepository.save(dossier);
    }

    public void deleteDossier(Long id) {
        dossierRepository.deleteById(id);
    }

    public List<Dossier> getAllDossiers() {
        return dossierRepository.findAll();
    }
}
