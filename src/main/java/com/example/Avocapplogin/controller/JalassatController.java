package com.example.Avocapplogin.controller;

import com.example.Avocapplogin.model.Jalassat;
import com.example.Avocapplogin.service.JalassatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jalassats")
public class JalassatController {

    @Autowired
    private JalassatService jalassatService;

    @GetMapping
    public List<Jalassat> getAllJalassats() {
        return jalassatService.getAllJalassats();
    }

    @GetMapping("/{id}")
    public Jalassat getJalassatById(@PathVariable Long id) {
        return jalassatService.getJalassatById(id);
    }

    @PostMapping("/ajouter")
    public Jalassat createJalassat(@RequestBody Jalassat jalassat) {
        return jalassatService.saveJalassat(jalassat);
    }

    @PutMapping("/modifier/{id}")
    public Jalassat updateJalassat(@PathVariable Long id, @RequestBody Jalassat jalassat) {
        return jalassatService.updateJalassat(id, jalassat);
    }

    @DeleteMapping("/supprimer/{id}")
    public void deleteJalassat(@PathVariable Long id) {
        jalassatService.deleteJalassat(id);
    }

    @GetMapping("/observer/{id}")
    public String observeJalassat(@PathVariable Long id) {
        Jalassat jalassat = jalassatService.getJalassatById(id);
        return "Observation: " + jalassat.getObservation();
    }
}
