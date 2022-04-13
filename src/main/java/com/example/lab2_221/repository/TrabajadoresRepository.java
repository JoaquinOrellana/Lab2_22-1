package com.example.lab2_221.repository;

import com.example.lab2_221.entity.Trabajadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrabajadoresRepository extends JpaRepository<Trabajadores,String> {

    List<Trabajadores> findByIdsede (Integer idsede);
    @Query(nativeQuery = true,value="select * from trabajadores where idsede = ?1")
    List<Trabajadores> listaTrabajadoresporSede (Integer idsede);
}
