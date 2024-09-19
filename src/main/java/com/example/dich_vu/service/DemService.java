package com.example.dich_vu.service;

import com.example.dich_vu.entity.Dem;
import com.example.dich_vu.repos.DemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemService {
    @Autowired
    private DemRepository demRepository;

    public List<Dem> getAllDem() {
        return demRepository.findAll();
    }

    public void saveDem(Dem dem) {
        demRepository.save(dem);
    }

    public Dem getDemById(Long id) {
        return demRepository.findById(id).orElse(null);
    }

    public void deleteDemById(Long id) {
        demRepository.deleteById(id);
    }
}
