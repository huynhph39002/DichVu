package com.example.dich_vu.service;

import com.example.dich_vu.entity.Chan;
import com.example.dich_vu.repos.ChanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChanSercice {
    @Autowired
    private ChanRepository chanRepository;

    public List<Chan> getAllChan() {
        return chanRepository.findAll();
    }

    public void saveChan(Chan chan) {
        chanRepository.save(chan);
    }

    public Chan getChanById(Long id) {
        return chanRepository.findById(id).orElse(null);
    }

    public void deleteChanById(Long id) {
        chanRepository.deleteById(id);
    }
}
