package com.example.dich_vu.service;

import com.example.dich_vu.entity.BuaSang;
import com.example.dich_vu.repos.BuaSangRepoditory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuaSangService {

    @Autowired
    private BuaSangRepoditory buaSangRepoditory;

    public List<BuaSang> getAllBuaSang() {
        return buaSangRepoditory.findAll();
    }

    public void saveBS(BuaSang buaSang) {
        buaSangRepoditory.save(buaSang);
    }

    public BuaSang getBSById(Integer id) {
        return buaSangRepoditory.findById(id).orElse(null);
    }

    public void deleteBSById(Integer id) {
        buaSangRepoditory.deleteById(id);
    }
}
