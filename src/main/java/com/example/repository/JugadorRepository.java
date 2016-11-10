package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Jugador;
import com.example.domain.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface JugadorRepository extends JpaRepository<Jugador, Long> {
    List<Jugador> findByNombreContaining(String nombre);
    List<Jugador> findByCanastasTotalesGreaterThanEqual(int canastasTotales);
    List<Jugador> findByAsistenciasTotalesBetween(int asistenciasMin, int asistenciasMax);
    List<Jugador> findByPosicion(String posicion);
    List<Jugador> findByFechaNacimientoLessThan(LocalDate fechaNacimiento);
    @Query("SELECT  jugador.posicion, AVG(jugador.canastasTotales), AVG(jugador.asistenciasTotales), AVG(jugador.rebotesTotales)" +
            "FROM Jugador jugador " +
            "GROUP BY jugador.posicion")
    List<Object[]> AvgCanastasTotalesPerPosicion();
    @Query("SELECT  jugador.posicion, AVG(jugador.canastasTotales), MAX(jugador.canastasTotales), MIN(jugador.canastasTotales), AVG(jugador.asistenciasTotales), MAX(jugador.asistenciasTotales), MIN(jugador.asistenciasTotales), AVG(jugador.rebotesTotales), MAX(jugador.rebotesTotales), MIN(jugador.rebotesTotales)" +
            "FROM Jugador jugador " +
            "GROUP BY jugador.posicion")
    List<Object[]> AvgAndMaxAndMinCanastasTotalesPerPosicion();
    List<Jugador> findByEquipoAndPosicion(Equipo equipo, String posicion);

    List<Jugador> findByEquipo(Equipo equipo);

    @Query("SELECT  jugador " +
            "FROM Jugador jugador " +"WHERE jugador.equipo.nombre=:nombreEquipo "+
            "ORDER BY jugador.canastasTotales DESC")
    Page<Jugador> JugadorMaxCanastasEquipo(@Param("nombreEquipo") String nombreEquipo, Pageable pageable);
    //List<Jugador> findByEquipoNombre(String nombreEquipo);

}