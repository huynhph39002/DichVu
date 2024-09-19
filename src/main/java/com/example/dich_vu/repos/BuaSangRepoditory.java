package com.example.dich_vu.repos;

import com.example.dich_vu.entity.BuaSang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuaSangRepoditory extends JpaRepository<BuaSang,Long> {
}
