package com.example.lab2_221.repository;

import com.example.lab2_221.entity.Trabajadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadoresRepository extends JpaRepository<Trabajadores,String> {
}
