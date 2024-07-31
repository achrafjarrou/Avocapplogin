package com.example.Avocapplogin.controller;

import com.example.Avocapplogin.model.Personne;
import com.example.Avocapplogin.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnes")
public class PersonneController {

    private final PersonneService personneService;

    @Autowired
    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Personne> ajouterPersonne(@RequestBody Personne personne) {
        Personne nouvellePersonne = personneService.savePersonne(personne);
        return ResponseEntity.ok(nouvellePersonne);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Personne> modifierPersonne(@PathVariable Long id, @RequestBody Personne personne) {
        Personne personneExistante = personneService.getPersonneById(id);
        if (personneExistante != null) {
            personne.setId(id);
            Personne personneMiseAJour = personneService.savePersonne(personne);
            return ResponseEntity.ok(personneMiseAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerPersonne(@PathVariable Long id) {
        Personne personneExistante = personneService.getPersonneById(id);
        if (personneExistante != null) {
            personneService.deletePersonne(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/afficher")
    public ResponseEntity<List<Personne>> afficherToutesLesPersonnes() {
        List<Personne> personnes = personneService.getAllPersonnes();
        return ResponseEntity.ok(personnes);
    }

    @GetMapping("/afficher/{id}")
    public ResponseEntity<Personne> afficherPersonneParId(@PathVariable Long id) {
        Personne personne = personneService.getPersonneById(id);
        if (personne != null) {
            return ResponseEntity.ok(personne);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
