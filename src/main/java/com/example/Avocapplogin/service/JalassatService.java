package com.example.Avocapplogin.service;

import com.example.Avocapplogin.model.Jalassat;
import com.example.Avocapplogin.repository.JalassatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JalassatService {

    @Autowired
    private JalassatRepository jalassatRepository;

    public List<Jalassat> getAllJalassats() {
        return jalassatRepository.findAll();
    }

    public Jalassat getJalassatById(Long id) {
        Optional<Jalassat> jalassat = jalassatRepository.findById(id);
        return jalassat.orElse(null);
    }

    public Jalassat saveJalassat(Jalassat jalassat) {
        return jalassatRepository.save(jalassat);
    }

    public void deleteJalassat(Long id) {
        jalassatRepository.deleteById(id);
    }

    public Jalassat updateJalassat(Long id, Jalassat newJalassat) {
        return jalassatRepository.findById(id)
                .map(jalassat -> {
                    jalassat.setDate(newJalassat.getDate());
                    jalassat.setResultat(newJalassat.getResultat());
                    jalassat.setObservation(newJalassat.getObservation());
                    jalassat.setCreated(newJalassat.getCreated());
                    jalassat.setUpdated(newJalassat.getUpdated());
                    return jalassatRepository.save(jalassat);
                }).orElse(null);
    }
}
