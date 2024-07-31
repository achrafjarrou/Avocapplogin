package com.example.Avocapplogin.controller;

import com.example.Avocapplogin.model.Tabligh;
import com.example.Avocapplogin.service.TablighService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tablighs")
public class TablighController {

    @Autowired
    private TablighService tablighService;

    @GetMapping
    public List<Tabligh> getAllTablighs() {
        return tablighService.getAllTablighs();
    }

    @GetMapping("/{id}")
    public Tabligh getTablighById(@PathVariable Long id) {
        return tablighService.getTablighById(id);
    }

    @PostMapping("/ajouter")
    public Tabligh createTabligh(@RequestBody Tabligh tabligh) {
        return tablighService.saveTabligh(tabligh);
    }

    @PutMapping("/modifier/{id}")
    public Tabligh updateTabligh(@PathVariable Long id, @RequestBody Tabligh tabligh) {
        return tablighService.updateTabligh(id, tabligh);
    }

    @DeleteMapping("/supprimer/{id}")
    public void deleteTabligh(@PathVariable Long id) {
        tablighService.deleteTabligh(id);
    }

    // Endpoint pour observer un tabligh (exemple d'observation)
    @GetMapping("/observer/{id}")
    public String observeTabligh(@PathVariable Long id) {
        Tabligh tabligh = tablighService.getTablighById(id);
        return "Observation: " + tabligh.getObservation();
    }
}
