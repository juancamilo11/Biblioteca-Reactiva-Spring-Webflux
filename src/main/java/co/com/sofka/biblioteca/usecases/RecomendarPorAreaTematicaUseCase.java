package co.com.sofka.biblioteca.usecases;

import co.com.sofka.biblioteca.mapper.Mappers;
import co.com.sofka.biblioteca.model.LibroDTO;
import co.com.sofka.biblioteca.repositories.LibroRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class RecomendarPorAreaTematicaUseCase implements RecomendarPorAreaTematica {

    private final LibroRepositorio libroRepositorio;
    private final Mappers mapper;

    public RecomendarPorAreaTematicaUseCase(LibroRepositorio libroRepositorio, Mappers mapper) {
        this.libroRepositorio = libroRepositorio;
        this.mapper = mapper;
    }

    @Override
    public Flux<LibroDTO> get(String areaTematica) {
        return libroRepositorio.findAllByAreaTematica(areaTematica)
                .map(mapper.mapEntityToLibro());
    }

}
