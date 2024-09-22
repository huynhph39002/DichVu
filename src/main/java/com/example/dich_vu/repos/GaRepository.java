package com.example.dich_vu.repos;

import com.example.dich_vu.entity.Ga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GaRepository extends JpaRepository<Ga,Integer> {
}
