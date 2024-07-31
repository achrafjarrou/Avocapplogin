package com.example.Avocapplogin.service;

import com.example.Avocapplogin.model.Ahkam;
import com.example.Avocapplogin.repository.AhkamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AhkamService {

    @Autowired
    private AhkamRepository ahkamRepository;

    public List<Ahkam> getAllAhkams() {
        return ahkamRepository.findAll();
    }

    public Ahkam getAhkamById(Long id) {
        return ahkamRepository.findById(id).orElseThrow(() -> new RuntimeException("Ahkam not found"));
    }

    public Ahkam saveAhkam(Ahkam ahkam) {
        return ahkamRepository.save(ahkam);
    }

    public Ahkam updateAhkam(Long id, Ahkam ahkam) {
        Ahkam existingAhkam = getAhkamById(id);
        existingAhkam.setNumero(ahkam.getNumero());
        existingAhkam.setType(ahkam.getType());
        existingAhkam.setObservation(ahkam.getObservation());
        return ahkamRepository.save(existingAhkam);
    }

    public void deleteAhkam(Long id) {
        ahkamRepository.deleteById(id);
    }
}
