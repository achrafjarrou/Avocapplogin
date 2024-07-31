package com.example.Avocapplogin.service;

import com.example.Avocapplogin.model.Procedure;
import com.example.Avocapplogin.repository.ProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedureService {

    @Autowired
    private ProcedureRepository procedureRepository;

    public List<Procedure> getAllProcedures() {
        return procedureRepository.findAll();
    }

    public Procedure getProcedureById(Long id) {
        return procedureRepository.findById(id).orElse(null);
    }

    public Procedure saveProcedure(Procedure procedure) {
        return procedureRepository.save(procedure);
    }

    public Procedure updateProcedure(Long id, Procedure procedure) {
        return procedureRepository.findById(id).map(existingProcedure -> {
            existingProcedure.setIdDossier(procedure.getIdDossier());
            existingProcedure.setEtape(procedure.getEtape());
            existingProcedure.setNumero(procedure.getNumero());
            existingProcedure.setReference(procedure.getReference());
            existingProcedure.setAnnee(procedure.getAnnee());
            existingProcedure.setTypeTribunal(procedure.getTypeTribunal());
            existingProcedure.setVille(procedure.getVille());
            existingProcedure.setCreated(procedure.getCreated());
            existingProcedure.setUpdated(procedure.getUpdated());
            return procedureRepository.save(existingProcedure);
        }).orElse(null);
    }

    public void deleteProcedure(Long id) {
        procedureRepository.deleteById(id);
    }
}
