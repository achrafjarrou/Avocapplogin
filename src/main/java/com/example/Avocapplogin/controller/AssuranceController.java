package com.example.Avocapplogin.controller;

import com.example.Avocapplogin.model.Assurance;
import com.example.Avocapplogin.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assurances")
public class AssuranceController {

    @Autowired
    private AssuranceService assuranceService;

    @PostMapping("/ajouter")
    public ResponseEntity<Assurance> ajouterAssurance(@RequestBody Assurance assurance) {
        Assurance nouvelleAssurance = assuranceService.saveAssurance(assurance);
        return ResponseEntity.ok(nouvelleAssurance);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Assurance> modifierAssurance(@PathVariable Long id, @RequestBody Assurance assuranceDetails) {
        Assurance updatedAssurance = assuranceService.updateAssurance(id, assuranceDetails);
        return ResponseEntity.ok(updatedAssurance);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerAssurance(@PathVariable Long id) {
        assuranceService.deleteAssurance(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/afficher")
    public ResponseEntity<List<Assurance>> afficherToutesLesAssurances() {
        List<Assurance> assurances = assuranceService.getAllAssurances();
        return ResponseEntity.ok(assurances);
    }
}
