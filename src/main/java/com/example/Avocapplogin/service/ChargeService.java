package com.example.Avocapplogin.service;

import com.example.Avocapplogin.model.Charge;
import com.example.Avocapplogin.repository.ChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChargeService {

    @Autowired
    private ChargeRepository chargeRepository;

    public List<Charge> getAllCharges() {
        return chargeRepository.findAll();
    }

    public Charge getChargeById(Long id) {
        Optional<Charge> charge = chargeRepository.findById(id);
        return charge.orElse(null);
    }

    public Charge saveCharge(Charge charge) {
        return chargeRepository.save(charge);
    }

    public void deleteCharge(Long id) {
        chargeRepository.deleteById(id);
    }

    public Charge updateCharge(Long id, Charge newCharge) {
        return chargeRepository.findById(id)
                .map(charge -> {
                    charge.setMontant(newCharge.getMontant());
                    charge.setDesignation(newCharge.getDesignation());
                    charge.setUpdated(newCharge.getUpdated());
                    return chargeRepository.save(charge);
                }).orElse(null);
    }
}
