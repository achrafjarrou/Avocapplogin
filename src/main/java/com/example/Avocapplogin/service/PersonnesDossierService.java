package com.example.Avocapplogin.service;

import com.example.Avocapplogin.model.PersonnesDossier;
import com.example.Avocapplogin.repository.PersonnesDossierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnesDossierService {

    @Autowired
    private PersonnesDossierRepository personnesDossierRepository;

    public PersonnesDossier saveRelation(PersonnesDossier relation) {
        return personnesDossierRepository.save(relation);
    }

    public List<PersonnesDossier> getAllRelations() {
        return personnesDossierRepository.findAll();
    }

    public void deleteRelation(Long id) {
        personnesDossierRepository.deleteById(id);
    }
}
