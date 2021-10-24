package co.com.sofka.biblioteca.usecases;

import co.com.sofka.biblioteca.mapper.Mappers;
import co.com.sofka.biblioteca.model.LibroDTO;
import co.com.sofka.biblioteca.repositories.LibroRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class ActualizarLibroUseCase implements CrearLibro {

    private final LibroRepositorio libroRepositorio;
    private final Mappers mapper;

    public ActualizarLibroUseCase(LibroRepositorio libroRepositorio, Mappers mapper) {
        this.libroRepositorio = libroRepositorio;
        this.mapper = mapper;
    }

    @Override
    public Mono<LibroDTO> apply(LibroDTO libroDTO) {
        Objects.requireNonNull(libroDTO.getId());
        return libroRepositorio.save(mapper.mapperToLibro().apply(libroDTO))
                .map(libro -> mapper.mapEntityToLibro().apply(libro));
    }
}
