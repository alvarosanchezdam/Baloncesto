package com.example.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Jugador;
import com.example.domain.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    List<Equipo> findByLocalidad(String localidad);

}
