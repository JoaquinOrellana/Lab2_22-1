package com.example.lab2_221.repository;

import com.example.lab2_221.entity.Tipos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposRepository extends JpaRepository<Tipos,Integer> {
}
