package com.example.Avocapplogin.service;

import com.example.Avocapplogin.model.Tanfid;
import com.example.Avocapplogin.repository.TanfidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TanfidService {

    @Autowired
    private TanfidRepository tanfidRepository;

    public List<Tanfid> getAllTanfids() {
        return tanfidRepository.findAll();
    }

    public Tanfid getTanfidById(Long id) {
        Optional<Tanfid> tanfid = tanfidRepository.findById(id);
        return tanfid.orElse(null);
    }

    public Tanfid saveTanfid(Tanfid tanfid) {
        return tanfidRepository.save(tanfid);
    }

    public void deleteTanfid(Long id) {
        tanfidRepository.deleteById(id);
    }

    public Tanfid updateTanfid(Long id, Tanfid newTanfid) {
        return tanfidRepository.findById(id)
                .map(tanfid -> {
                    tanfid.setDate(newTanfid.getDate());
                    tanfid.setNumero(newTanfid.getNumero());
                    tanfid.setType(newTanfid.getType());
                    tanfid.setObservation(newTanfid.getObservation());
                    tanfid.setCreated(newTanfid.getCreated());
                    return tanfidRepository.save(tanfid);
                }).orElse(null);
    }
}
