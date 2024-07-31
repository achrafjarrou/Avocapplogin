package com.example.Avocapplogin.controller;

import com.example.Avocapplogin.model.Procedure;
import com.example.Avocapplogin.service.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/procedures")
public class ProcedureController {

    @Autowired
    private ProcedureService procedureService;

    @GetMapping
    public List<Procedure> getAllProcedures() {
        return procedureService.getAllProcedures();
    }

    @GetMapping("/{id}")
    public Procedure getProcedureById(@PathVariable Long id) {
        return procedureService.getProcedureById(id);
    }

    @PostMapping("/ajouter")
    public Procedure createProcedure(@RequestBody Procedure procedure) {
        return procedureService.saveProcedure(procedure);
    }

    @PutMapping("/modifier/{id}")
    public Procedure updateProcedure(@PathVariable Long id, @RequestBody Procedure procedure) {
        return procedureService.updateProcedure(id, procedure);
    }

    @DeleteMapping("/supprimer/{id}")
    public void deleteProcedure(@PathVariable Long id) {
        procedureService.deleteProcedure(id);
    }
}
