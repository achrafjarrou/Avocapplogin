package com.example.Avocapplogin.service;

import com.example.Avocapplogin.model.Depenses;
import com.example.Avocapplogin.repository.DepensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepensesService {

    private final DepensesRepository depensesRepository;

    @Autowired
    public DepensesService(DepensesRepository depensesRepository) {
        this.depensesRepository = depensesRepository;
    }

    public Depenses saveDepense(Depenses depenses) {
        return depensesRepository.save(depenses);
    }

    public Depenses getDepenseById(Long id) {
        return depensesRepository.findById(id).orElse(null);
    }

    public List<Depenses> getAllDepenses() {
        return depensesRepository.findAll();
    }

    public void deleteDepense(Long id) {
        depensesRepository.deleteById(id);
    }
}
