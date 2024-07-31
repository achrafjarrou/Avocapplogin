package com.example.Avocapplogin.controller;

import com.example.Avocapplogin.model.Depenses;
import com.example.Avocapplogin.service.DepensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depenses")
public class DepensesController {

    private final DepensesService depensesService;

    @Autowired
    public DepensesController(DepensesService depensesService) {
        this.depensesService = depensesService;
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Depenses> ajouterDepense(@RequestBody Depenses depenses) {
        Depenses nouvelleDepenses = depensesService.saveDepense(depenses);
        return ResponseEntity.ok(nouvelleDepenses);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Depenses> modifierDepense(@PathVariable Long id, @RequestBody Depenses depenses) {
        Depenses depensesExistante = depensesService.getDepenseById(id);
        if (depensesExistante != null) {
            depenses.setId(id);
            Depenses depensesMiseAJour = depensesService.saveDepense(depenses);
            return ResponseEntity.ok(depensesMiseAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerDepense(@PathVariable Long id) {
        Depenses depensesExistante = depensesService.getDepenseById(id);
        if (depensesExistante != null) {
            depensesService.deleteDepense(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/afficher")
    public ResponseEntity<List<Depenses>> afficherToutesLesDepenses() {
        List<Depenses> depenses = depensesService.getAllDepenses();
        return ResponseEntity.ok(depenses);
    }

    @GetMapping("/afficher/{id}")
    public ResponseEntity<Depenses> afficherDepenseParId(@PathVariable Long id) {
        Depenses depenses = depensesService.getDepenseById(id);
        if (depenses != null) {
            return ResponseEntity.ok(depenses);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
