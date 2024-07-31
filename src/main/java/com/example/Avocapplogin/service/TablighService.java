package com.example.Avocapplogin.service;

import com.example.Avocapplogin.model.Tabligh;
import com.example.Avocapplogin.repository.TablighRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TablighService {

    @Autowired
    private TablighRepository tablighRepository;

    public List<Tabligh> getAllTablighs() {
        return tablighRepository.findAll();
    }

    public Tabligh getTablighById(Long id) {
        Optional<Tabligh> tabligh = tablighRepository.findById(id);
        return tabligh.orElse(null);
    }

    public Tabligh saveTabligh(Tabligh tabligh) {
        return tablighRepository.save(tabligh);
    }

    public void deleteTabligh(Long id) {
        tablighRepository.deleteById(id);
    }

    public Tabligh updateTabligh(Long id, Tabligh newTabligh) {
        return tablighRepository.findById(id)
                .map(tabligh -> {
                    tabligh.setDate(newTabligh.getDate());
                    tabligh.setDelai(newTabligh.getDelai());
                    tabligh.setObservation(newTabligh.getObservation());
                    tabligh.setCreated(newTabligh.getCreated());
                    tabligh.setUpdated(newTabligh.getUpdated());
                    return tablighRepository.save(tabligh);
                }).orElse(null);
    }
}
