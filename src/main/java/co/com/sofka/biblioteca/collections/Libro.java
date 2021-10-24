package co.com.sofka.biblioteca.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class Libro {

    @Id
    private String id;
    private String nombre;
    private String tipo;
    private String areaTematica;
    private Integer unidadesDisponibles;
    private Integer unidadesPrestadas = 0;
    private LocalDate fechaUltimoPrestamo = null;

    public Libro() {
    }

    public Libro(String id) {
        this.id = id;
    }

    public Libro(String id, String nombre, String tipo, String categoria, Integer unidadesDisponibles) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.areaTematica = categoria;
        this.unidadesDisponibles = unidadesDisponibles;
        this.unidadesPrestadas = 0;
        this.fechaUltimoPrestamo = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAreaTematica() {
        return areaTematica;
    }

    public void setAreaTematica(String areaTematica) {
        this.areaTematica = areaTematica;
    }

    public Integer getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(Integer unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public Integer getUnidadesPrestadas() {
        return unidadesPrestadas;
    }

    public void setUnidadesPrestadas(Integer unidadesPrestadas) {
        this.unidadesPrestadas = unidadesPrestadas;
    }

    public LocalDate getFechaUltimoPrestamo() {
        return fechaUltimoPrestamo;
    }

    public void setFechaUltimoPrestamo(LocalDate fechaUltimoPrestamo) {
        this.fechaUltimoPrestamo = fechaUltimoPrestamo;
    }
}
