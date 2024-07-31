package com.example.Avocapplogin.controller;

import com.example.Avocapplogin.model.AssurancesDossier;
import com.example.Avocapplogin.model.PersonnesDossier;
import com.example.Avocapplogin.service.AssurancesDossierService;
import com.example.Avocapplogin.service.PersonnesDossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relations")
public class RelationsController {

    @Autowired
    private AssurancesDossierService assurancesDossierService;

    @Autowired
    private PersonnesDossierService personnesDossierService;

    // Gestion des relations PersonnesDossier

    @PostMapping("/personnesdossiers/ajouter")
    public ResponseEntity<PersonnesDossier> ajouterPersonneDossier(@RequestBody PersonnesDossier relation) {
        PersonnesDossier nouvelleRelation = personnesDossierService.saveRelation(relation);
        return ResponseEntity.ok(nouvelleRelation);
    }

    @PutMapping("/personnesdossiers/modifier/{id}")
    public ResponseEntity<PersonnesDossier> modifierPersonneDossier(@PathVariable Long id, @RequestBody PersonnesDossier relationDetails) {
        PersonnesDossier updatedRelation = personnesDossierService.saveRelation(relationDetails);
        return ResponseEntity.ok(updatedRelation);
    }

    @DeleteMapping("/personnesdossiers/supprimer/{id}")
    public ResponseEntity<Void> supprimerPersonneDossier(@PathVariable Long id) {
        personnesDossierService.deleteRelation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/personnesdossiers/afficher")
    public ResponseEntity<List<PersonnesDossier>> afficherToutesLesPersonnesDossiers() {
        List<PersonnesDossier> relations = personnesDossierService.getAllRelations();
        return ResponseEntity.ok(relations);
    }

    // Gestion des relations AssurancesDossier

    @PostMapping("/assurancesdossiers/ajouter")
    public ResponseEntity<AssurancesDossier> ajouterAssuranceDossier(@RequestBody AssurancesDossier relation) {
        AssurancesDossier nouvelleRelation = assurancesDossierService.saveRelation(relation);
        return ResponseEntity.ok(nouvelleRelation);
    }

    @PutMapping("/assurancesdossiers/modifier/{id}")
    public ResponseEntity<AssurancesDossier> modifierAssuranceDossier(@PathVariable Long id, @RequestBody AssurancesDossier relationDetails) {
        AssurancesDossier updatedRelation = assurancesDossierService.saveRelation(relationDetails);
        return ResponseEntity.ok(updatedRelation);
    }

    @DeleteMapping("/assurancesdossiers/supprimer/{id}")
    public ResponseEntity<Void> supprimerAssuranceDossier(@PathVariable Long id) {
        assurancesDossierService.deleteRelation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/assurancesdossiers/afficher")
    public ResponseEntity<List<AssurancesDossier>> afficherToutesLesAssurancesDossiers() {
        List<AssurancesDossier> relations = assurancesDossierService.getAllRelations();
        return ResponseEntity.ok(relations);
    }
}
