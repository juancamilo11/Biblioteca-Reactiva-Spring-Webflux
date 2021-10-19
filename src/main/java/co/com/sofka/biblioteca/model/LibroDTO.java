package co.com.sofka.biblioteca.model;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class LibroDTO {

    @NotBlank(message="Debe existir el Id para este libro")
    private String userId;
    @NotBlank(message="Debe existir el nombre para este libro")
    private String nombre;
    @NotBlank(message="Debe existir el tipo para este libro")
    private String tipo;
    @NotBlank(message="Debe existir la categoria para este libro")
    private String categoria;
    @NotBlank(message="Debe existir las unidades disponibles para este libro")
    private Integer unidadesDisponibles;
    private Integer unidadesPrestadas;
    private LocalDate fechaUltimoPrestamo;

    public LibroDTO() {
    }

    public LibroDTO(String userId) {
        this.userId = userId;
    }

    public LibroDTO(String userId, String nombre, String tipo, String categoria, Integer unidadesDisponibles, Integer unidadesPrestadas, LocalDate fechaUltimoPrestamo) {
        this.userId = userId;
        this.nombre = nombre;
        this.tipo = tipo;
        this.categoria = categoria;
        this.unidadesDisponibles = unidadesDisponibles;
        this.unidadesPrestadas = unidadesPrestadas;
        this.fechaUltimoPrestamo = fechaUltimoPrestamo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
