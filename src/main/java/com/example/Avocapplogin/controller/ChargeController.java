package com.example.Avocapplogin.controller;

import com.example.Avocapplogin.model.Charge;
import com.example.Avocapplogin.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/charges")
public class ChargeController {

    @Autowired
    private ChargeService chargeService;


    @GetMapping
    public List<Charge> getAllCharges() {
        return chargeService.getAllCharges();
    }

    @GetMapping("/{id}")
    public Charge getChargeById(@PathVariable Long id) {
        return chargeService.getChargeById(id);
    }
    @PostMapping("/ajouter")
    public Charge createCharge(@RequestBody Charge charge) {
        return chargeService.saveCharge(charge);
    }

    @PutMapping("/modifier/{id}")
    public Charge updateCharge(@PathVariable Long id, @RequestBody Charge charge) {
        return chargeService.updateCharge(id, charge);
    }

    @DeleteMapping("/supprimer/{id}")
    public void deleteCharge(@PathVariable Long id) {
        chargeService.deleteCharge(id);
    }

}
