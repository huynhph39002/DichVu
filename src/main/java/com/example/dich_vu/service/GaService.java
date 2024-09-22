package com.example.dich_vu.service;

import com.example.dich_vu.entity.Ga;
import com.example.dich_vu.repos.GaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GaService {
    @Autowired
    private GaRepository gaRepository;

    public List<Ga> getAllGa() {
        return gaRepository.findAll();
    }

    public void saveGa(Ga ga) {
        gaRepository.save(ga);
    }

    public Ga getGaById(Integer id) {
        return gaRepository.findById(id).orElse(null);
    }

    public void deleteGaById(Integer id) {
        gaRepository.deleteById(id);
    }
}
