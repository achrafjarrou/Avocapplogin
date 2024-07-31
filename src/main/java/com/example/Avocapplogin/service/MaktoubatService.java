package com.example.Avocapplogin.service;

import com.example.Avocapplogin.model.Maktoubat;
import com.example.Avocapplogin.repository.MaktoubatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaktoubatService {

    @Autowired
    private MaktoubatRepository maktoubatRepository;

    public List<Maktoubat> getAllMaktoubats() {
        return maktoubatRepository.findAll();
    }

    public Maktoubat getMaktoubatById(Long id) {
        Optional<Maktoubat> maktoubat = maktoubatRepository.findById(id);
        return maktoubat.orElse(null);
    }

    public Maktoubat saveMaktoubat(Maktoubat maktoubat) {
        return maktoubatRepository.save(maktoubat);
    }

    public void deleteMaktoubat(Long id) {
        maktoubatRepository.deleteById(id);
    }

    public Maktoubat updateMaktoubat(Long id, Maktoubat newMaktoubat) {
        return maktoubatRepository.findById(id)
                .map(maktoubat -> {
                    maktoubat.setDate(newMaktoubat.getDate());
                    maktoubat.setSujet(newMaktoubat.getSujet());
                    maktoubat.setObservation(newMaktoubat.getObservation());
                    maktoubat.setCreated(newMaktoubat.getCreated());
                    maktoubat.setUpdated(newMaktoubat.getUpdated());
                    return maktoubatRepository.save(maktoubat);
                }).orElse(null);
    }
}
