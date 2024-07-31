package com.example.Avocapplogin.service;

import com.example.Avocapplogin.model.Personne;
import com.example.Avocapplogin.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneService {

    private final PersonneRepository personneRepository;

    @Autowired
    public PersonneService(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    public Personne getPersonneById(Long id) {
        Optional<Personne> personne = personneRepository.findById(id);
        return personne.orElse(null);
    }

    public Personne savePersonne(Personne personne) {
        return personneRepository.save(personne);
    }

    public void deletePersonne(Long id) {
        personneRepository.deleteById(id);
    }

    public List<Personne> getAllPersonnes() {
        return personneRepository.findAll();
    }
}
