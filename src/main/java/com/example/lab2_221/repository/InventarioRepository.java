package com.example.lab2_221.repository;

import com.example.lab2_221.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario,Integer> {
}
