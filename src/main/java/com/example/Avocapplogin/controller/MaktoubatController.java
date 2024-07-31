package com.example.Avocapplogin.controller;

import com.example.Avocapplogin.model.Maktoubat;
import com.example.Avocapplogin.service.MaktoubatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maktoubats")
public class MaktoubatController {

    @Autowired
    private MaktoubatService maktoubatService;

    @GetMapping
    public List<Maktoubat> getAllMaktoubats() {
        return maktoubatService.getAllMaktoubats();
    }

    @GetMapping("/{id}")
    public Maktoubat getMaktoubatById(@PathVariable Long id) {
        return maktoubatService.getMaktoubatById(id);
    }

    @PostMapping("/ajouter")
    public Maktoubat createMaktoubat(@RequestBody Maktoubat maktoubat) {
        return maktoubatService.saveMaktoubat(maktoubat);
    }

    @PutMapping("/modifier/{id}")
    public Maktoubat updateMaktoubat(@PathVariable Long id, @RequestBody Maktoubat maktoubat) {
        return maktoubatService.updateMaktoubat(id, maktoubat);
    }

    @DeleteMapping("/supprimer/{id}")
    public void deleteMaktoubat(@PathVariable Long id) {
        maktoubatService.deleteMaktoubat(id);
    }

    @GetMapping("/observer/{id}")
    public String observeMaktoubat(@PathVariable Long id) {
        Maktoubat maktoubat = maktoubatService.getMaktoubatById(id);
        return "Observation: " + maktoubat.getObservation();
    }
}
