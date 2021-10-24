package co.com.sofka.biblioteca.model;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class LibroDTO {

    @NotBlank(message="Debe existir el Id para este libro")
    private String id;
    @NotBlank(message="Debe existir el nombre para este libro")
    private String nombre;
    @NotBlank(message="Debe existir el tipo para este libro")
    private String tipo;
    @NotBlank(message="Debe existir el área temática para este libro")
    private String areaTematica;
    @NotBlank(message="Debe existir las unidades disponibles para este libro")
    private Integer unidadesDisponibles;
    private Integer unidadesPrestadas;
    private LocalDate fechaUltimoPrestamo;

    public LibroDTO() {
    }

    public LibroDTO(String id) {
        this.id = id;
    }

    public LibroDTO(String id, String nombre, String tipo, String areaTematica, Integer unidadesDisponibles) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.areaTematica = areaTematica;
        this.unidadesDisponibles = unidadesDisponibles;
        this.unidadesPrestadas = 0;
        this.fechaUltimoPrestamo = null;
    }

    public LibroDTO(String id, String nombre, String tipo, String areaTematica, Integer unidadesDisponibles, Integer unidadesPrestadas, LocalDate fechaUltimoPrestamo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.areaTematica = areaTematica;
        this.unidadesDisponibles = unidadesDisponibles;
        this.unidadesPrestadas = unidadesPrestadas;
        this.fechaUltimoPrestamo = fechaUltimoPrestamo;
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
