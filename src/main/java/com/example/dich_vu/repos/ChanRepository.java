package com.example.dich_vu.repos;

import com.example.dich_vu.entity.Chan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChanRepository extends JpaRepository<Chan, Integer> {
    boolean existsByMa(String ma);
}
