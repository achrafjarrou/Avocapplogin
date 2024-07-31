package com.example.Avocapplogin.controller;

import com.example.Avocapplogin.model.Dossier;
import com.example.Avocapplogin.service.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dossiers")
public class DossierController {

    private final DossierService dossierService;

    @Autowired
    public DossierController(DossierService dossierService) {
        this.dossierService = dossierService;
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Dossier> ajouterDossier(@RequestBody Dossier dossier) {
        Dossier nouveauDossier = dossierService.saveDossier(dossier);
        return ResponseEntity.ok(nouveauDossier);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Dossier> modifierDossier(@PathVariable Long id, @RequestBody Dossier dossier) {
        Optional<Dossier> dossierExistant = dossierService.getDossierById(id);
        if (dossierExistant.isPresent()) {
            dossier.setId(id);
            Dossier dossierMisAJour = dossierService.saveDossier(dossier);
            return ResponseEntity.ok(dossierMisAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerDossier(@PathVariable Long id) {
        Optional<Dossier> dossierExistant = dossierService.getDossierById(id);
        if (dossierExistant.isPresent()) {
            dossierService.deleteDossier(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/afficher")
    public ResponseEntity<List<Dossier>> afficherTousLesDossiers() {
        List<Dossier> dossiers = dossierService.getAllDossiers();
        return ResponseEntity.ok(dossiers);
    }

    @GetMapping("/afficher/{id}")
    public ResponseEntity<Dossier> afficherDossierParId(@PathVariable Long id) {
        Optional<Dossier> dossier = dossierService.getDossierById(id);
        return dossier.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
