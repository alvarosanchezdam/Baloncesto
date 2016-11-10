package com.example.domain;

import javax.persistence.*;

        import javax.persistence.*;

@Entity
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String localidad;
    private Integer añoCreacion;

    public Equipo() {
    }

    public Equipo(String nombre, String localidad, Integer añoCreacion) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.añoCreacion = añoCreacion;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                ", añoCreacion=" + añoCreacion +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getAñoCreacion() {
        return añoCreacion;
    }

    public void setAñoCreacion(Integer añoCreacion) {
        this.añoCreacion = añoCreacion;
    }
}



