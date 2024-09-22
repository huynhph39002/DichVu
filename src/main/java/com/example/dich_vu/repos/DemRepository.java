package com.example.dich_vu.repos;

import com.example.dich_vu.entity.Dem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemRepository extends JpaRepository<Dem,Integer> {
}
