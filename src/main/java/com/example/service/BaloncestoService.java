package com.example.service;
import com.example.domain.Jugador;
import com.example.domain.Equipo;
import com.example.repository.EquipoRepository;
import com.example.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class BaloncestoService {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private JugadorRepository jugadorRepository;


    public void testBaloncesto() {

        Equipo e1=new Equipo("F.C. Barcelona", "Barcelona", 1899);
        equipoRepository.save(e1);
        Jugador j1=new Jugador("Juan Carlos", LocalDate.of(1985,2,25), 20, 10, 5,"Escolta",e1);
        jugadorRepository.save(j1);
        Jugador j2=new Jugador("Alvaro", LocalDate.of(1995,2,25), 15, 8, 10,"Alero",e1);
        jugadorRepository.save(j2);
        Jugador j3=new Jugador("Tomic", LocalDate.of(1989,4,26), 2, 0, 30,"Pivot",e1);
        jugadorRepository.save(j3);
        Jugador j4=new Jugador("Doellman", LocalDate.of(1991,9,2), 20, 20, 5,"Ala-Pivot",e1);
        jugadorRepository.save(j4);
        Jugador j5=new Jugador("Rice", LocalDate.of(1988,8,30), 7, 20, 2,"Base",e1);
        jugadorRepository.save(j5);
        Equipo e2=new Equipo("Real Madrid", "Madrid", 1902);
        equipoRepository.save(e2);
        Jugador j6=new Jugador("Sergio Llull", LocalDate.of(1988,3,25), 20, 10, 5,"Base",e2);
        jugadorRepository.save(j6);
        Jugador j7=new Jugador("Carroll", LocalDate.of(1995,2,25), 5, 8, 10,"Escolta",e2);
        jugadorRepository.save(j7);
        Jugador j8=new Jugador("Rudy", LocalDate.of(1987,7,26), 22, 10, 5,"Alero",e2);
        jugadorRepository.save(j8);
        Jugador j9=new Jugador("Nocioni", LocalDate.of(1982,9,5), 5, 2, 30,"Ala-Pivot",e2);
        jugadorRepository.save(j9);
        Jugador j10=new Jugador("Reyes", LocalDate.of(1985,7,6), 8, 4, 22,"Pivot",e2);
        jugadorRepository.save(j10);
        Equipo e3=new Equipo("DKV Joventut", "Badalona", 1915);
        equipoRepository.save(e3);
        Jugador j11=new Jugador("Russell", LocalDate.of(1989,2,23), 9, 20, 5,"Base",e3);
        jugadorRepository.save(j11);
        Jugador j12=new Jugador("Josep", LocalDate.of(1993,5,27), 15, 8, 5,"Escolta",e3);
        jugadorRepository.save(j12);
        Jugador j13=new Jugador("Pere Tomas", LocalDate.of(1995,7,1), 2, 0, 30,"Alero",e3);
        jugadorRepository.save(j13);
        Jugador j14=new Jugador("Todorovic", LocalDate.of(1991,9,2), 10, 10, 12,"Ala-Pivot",e3);
        jugadorRepository.save(j14);
        Jugador j15=new Jugador("Rice", LocalDate.of(1988,8,30), 5, 0, 20,"Pivot",e3);
        jugadorRepository.save(j15);
        Equipo e4=new Equipo("Angeles Lakers", "Los Angeles", 1920);
        equipoRepository.save(e4);
        Jugador j16=new Jugador("Russell", LocalDate.of(1995,3,25), 30, 20, 5,"Base",e4);
        jugadorRepository.save(j16);
        Jugador j17=new Jugador("Clarckson", LocalDate.of(1984,2,12), 5, 8, 1,"Escolta",e4);
        jugadorRepository.save(j17);
        Jugador j18=new Jugador("Ingram", LocalDate.of(1996,1,6), 25, 10, 20,"Alero",e4);
        jugadorRepository.save(j18);
        Jugador j19=new Jugador("JianLian", LocalDate.of(1981,12,14), 10, 0, 25,"Ala-Pivot",e4);
        jugadorRepository.save(j19);
        Jugador j20=new Jugador("Mozgov", LocalDate.of(1994,11,30), 10, 3, 20,"Pivot",e4);
        jugadorRepository.save(j20);
        Equipo e5=new Equipo("Miami Heat", "Miami", 1899);
        equipoRepository.save(e5);
        Jugador j21=new Jugador("Dragic", LocalDate.of(1989,10,25), 8, 20, 5,"Base",e5);
        jugadorRepository.save(j21);
        Jugador j22=new Jugador("Winslow", LocalDate.of(1991,10,2), 15, 18, 8,"Escolta",e5);
        jugadorRepository.save(j22);
        Jugador j23=new Jugador("Johnson", LocalDate.of(1986,3,26), 5, 10, 15,"Alero",e5);
        jugadorRepository.save(j23);
        Jugador j24=new Jugador("Williams", LocalDate.of(1990,9,2), 0, 10, 20,"Ala-Pivot",e5);
        jugadorRepository.save(j24);
        Jugador j25=new Jugador("Bosh", LocalDate.of(1983,7,3), 30, 10, 15,"Pivot",e5);
        jugadorRepository.save(j25);
        List<Jugador> listaJ=jugadorRepository.findByNombreContaining("Dragic");

        listaJ.stream().forEach(jugador -> System.out.println(jugador));
        System.out.println("----------------------------------------------------");
        System.out.println();
        listaJ=jugadorRepository.findByCanastasTotalesGreaterThanEqual(10);
        System.out.println("JUGADORES CON 10 O MAS CANASTAS TOTALES:");
        listaJ.stream().forEach(jugador -> System.out.println(jugador));
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println("JUGADORES CON MAS DE 5 ASISTENCIA Y MENOS DE 15:");
        listaJ=jugadorRepository.findByAsistenciasTotalesBetween(5, 15);
        listaJ.stream().forEach(jugador -> System.out.println(jugador));
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println("JUGADORES QUE OCUPAN LA POSICIÓN DE BASE");
        listaJ=jugadorRepository.findByPosicion("Base");
        listaJ.stream().forEach(jugador -> System.out.println(jugador));
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println("JUGADORES NACIDOS ANTES DEL 1 DE ENERO DEL 1992");
        listaJ=jugadorRepository.findByFechaNacimientoLessThan(LocalDate.of(1992,1,1));
        listaJ.stream().forEach(jugador -> System.out.println(jugador));
        System.out.println("----------------------------------------------------");
        System.out.println();System.out.println("MEDIA DE CANASTAS, ASISTENCIAS Y REBOTES TOTALES POR POSICION");
        showStatistics(jugadorRepository.AvgCanastasTotalesPerPosicion());
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println();System.out.println("MEDIA, MAX Y MIN DE CANASTAS, ASISTENCIAS Y REBOTES TOTALES POR POSICION");
        showAllStatistics(jugadorRepository.AvgAndMaxAndMinCanastasTotalesPerPosicion());
        System.out.println("----------------------------------------------------");
        System.out.println("EQUIPOS: ");
        System.out.println("----------------------------------------------------");
        System.out.println("EQUIPOS QUE ESTAN SITUADOS EN BARCELONA");
        List<Equipo> listaE=equipoRepository.findByLocalidad("Barcelona");
        listaE.stream().forEach(equipo -> System.out.println(equipo));
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println("JUGADORES DEL EQUIPO 1(Barça)");
        listaJ=jugadorRepository.findByEquipo(e1);
        listaJ.stream().forEach(jugador -> System.out.println(jugador));
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println("JUGADORES DEL EQUIPO 1 Y QUE SON ALEROS(Barça)");
        listaJ=jugadorRepository.findByEquipoAndPosicion(e1, "Alero");
        listaJ.stream().forEach(jugador -> System.out.println(jugador));
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println("JUGADOR CON MAS CANASTAS TOTALES DEL BARÇA");
        Pageable topOne = new PageRequest(0, 1);
        showStatisticsBestPlayer(jugadorRepository.JugadorMaxCanastasEquipo("F.C. Barcelona", topOne));
        System.out.println("----------------------------------------------------");
        System.out.println();
    }

    private void showAllStatistics(List<Object[]> statisticsList) {
        statisticsList.forEach(statistic->{
            System.out.println("----  "+statistic[0]);
            System.out.println("      MEDIA DE PUNTOS:"+statistic[1]);
            System.out.println("      MAX DE PUNTOS:"+statistic[2]);
            System.out.println("      MIN DE PUNTOS:"+statistic[3]);
            System.out.println("      MEDIA DE ASISTENCIAS:"+statistic[4]);
            System.out.println("      MAX DE ASISTENCIAS:"+statistic[5]);
            System.out.println("      MIN DE ASISTENCIAS:"+statistic[6]);
            System.out.println("      MEDIA DE REBOTES:"+statistic[7]);
            System.out.println("      MAX DE REBOTES:"+statistic[8]);
            System.out.println("      MIN DE REBOTES:"+statistic[9]);
        });
    }
    private void showStatisticsBestPlayer(Page<Jugador> jugadorPage) {
        jugadorPage.getContent().forEach(jugador->{
            System.out.println(jugador);

        });
    }
    private void showStatistics(List<Object[]> statisticsList) {
        statisticsList.forEach(statistic->{
            System.out.println(statistic[0]);
            System.out.println("MEDIA DE PUNTOS:"+statistic[1]);
            System.out.println("MEDIA DE ASISTENCIAS:"+statistic[2]);
            System.out.println("MEDIA DE REBOTES:"+statistic[3]);
        });
    }
}
