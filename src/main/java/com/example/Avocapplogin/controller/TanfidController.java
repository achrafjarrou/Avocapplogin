package com.example.Avocapplogin.controller;

import com.example.Avocapplogin.model.Tanfid;
import com.example.Avocapplogin.service.TanfidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tanfids")
public class TanfidController {

    @Autowired
    private TanfidService tanfidService;

    // Endpoint pour récupérer tous les tanfids
    @GetMapping
    public List<Tanfid> getAllTanfids() {
        return tanfidService.getAllTanfids();
    }

    // Endpoint pour récupérer un tanfid par son ID
    @GetMapping("/{id}")
    public Tanfid getTanfidById(@PathVariable Long id) {
        return tanfidService.getTanfidById(id);
    }

    // Endpoint pour créer un nouveau tanfid
    @PostMapping("/ajouter")
    public Tanfid createTanfid(@RequestBody Tanfid tanfid) {
        return tanfidService.saveTanfid(tanfid);
    }

    // Endpoint pour mettre à jour un tanfid existant
    @PutMapping("/modifier/{id}")
    public Tanfid updateTanfid(@PathVariable Long id, @RequestBody Tanfid tanfid) {
        return tanfidService.updateTanfid(id, tanfid);
    }

    // Endpoint pour supprimer un tanfid
    @DeleteMapping("/supprimer/{id}")
    public void deleteTanfid(@PathVariable Long id) {
        tanfidService.deleteTanfid(id);
    }

    // Endpoint pour observer un tanfid (exemple d'observation)
    @GetMapping("/observer/{id}")
    public String observeTanfid(@PathVariable Long id) {
        Tanfid tanfid = tanfidService.getTanfidById(id);
        return "Observation: " + tanfid.getObservation();
    }
}
