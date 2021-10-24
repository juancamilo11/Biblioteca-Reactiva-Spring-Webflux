package co.com.sofka.biblioteca.usecases;

import co.com.sofka.biblioteca.mapper.Mappers;
import co.com.sofka.biblioteca.model.LibroDTO;
import co.com.sofka.biblioteca.repositories.LibroRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class ObtenerLibroUseCase implements Function<String, Mono<LibroDTO>> {
    private final LibroRepositorio libroRepositorio;
    private final Mappers mapper;

    public ObtenerLibroUseCase(Mappers mapper, LibroRepositorio libroRepositorio) {
        this.libroRepositorio = libroRepositorio;
        this.mapper = mapper;
    }

    @Override
    public Mono<LibroDTO> apply(String id) {
        Objects.requireNonNull(id, "Id is required");
        return libroRepositorio.findById(id)
                .map(mapper.mapEntityToLibro());
    }

}