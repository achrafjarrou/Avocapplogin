package com.example.Avocapplogin.controller;

import com.example.Avocapplogin.model.Ahkam;
import com.example.Avocapplogin.service.AhkamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ahkams")
public class AhkamController {

    @Autowired
    private AhkamService ahkamService;

    @GetMapping
    public List<Ahkam> getAllAhkams() {
        return ahkamService.getAllAhkams();
    }

    @GetMapping("/{id}")
    public Ahkam getAhkamById(@PathVariable Long id) {
        return ahkamService.getAhkamById(id);
    }

    @PostMapping("/ajouter")
    public Ahkam createAhkam(@RequestBody Ahkam ahkam) {
        return ahkamService.saveAhkam(ahkam);
    }

    @PutMapping("/modifier/{id}")
    public Ahkam updateAhkam(@PathVariable Long id, @RequestBody Ahkam ahkam) {
        return ahkamService.updateAhkam(id, ahkam);
    }

    @DeleteMapping("/supprimer/{id}")
    public void deleteAhkam(@PathVariable Long id) {
        ahkamService.deleteAhkam(id);
    }
}
