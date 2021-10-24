package co.com.sofka.biblioteca.usecases;

import co.com.sofka.biblioteca.mapper.Mappers;
import co.com.sofka.biblioteca.repositories.LibroRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class DevolverLibroUseCase implements Function<String, Mono<String>> {

    private final LibroRepositorio libroRepositorio;
    private final Mappers mapper;
    private final ActualizarLibroUseCase actualizarLibroUseCase;

    public DevolverLibroUseCase(LibroRepositorio libroRepositorio, Mappers mapper, ActualizarLibroUseCase actualizarLibroUseCase) {
        this.libroRepositorio = libroRepositorio;
        this.mapper = mapper;
        this.actualizarLibroUseCase = actualizarLibroUseCase;
    }

    @Override
    public Mono<String> apply(String id) {
        Objects.requireNonNull(id);
        return libroRepositorio.findById(id).flatMap(libro -> {
            if (libro.getUnidadesPrestadas() > 0) {
                libro.setUnidadesPrestadas(libro.getUnidadesPrestadas() - 1);
                libro.setUnidadesDisponibles(libro.getUnidadesDisponibles() + 1);
                return actualizarLibroUseCase.apply(mapper.mapEntityToLibro().apply(libro)).thenReturn("Se ha entregado el libro con id: " + id + ", queda(n) " + libro.getUnidadesDisponibles() + " unidades disponibles.");
            }
            return Mono.just("El libro con Id " + libro.getId() + " no tiene unidades prestadas, operación inválida.");
        });
    }
}
