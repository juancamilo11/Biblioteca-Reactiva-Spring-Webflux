package co.com.sofka.biblioteca.usecases;

import co.com.sofka.biblioteca.mapper.Mappers;
import co.com.sofka.biblioteca.model.LibroDTO;
import co.com.sofka.biblioteca.repositories.LibroRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class RecomendarPorTipoYAreaTematicaUseCase implements RecomendarPorTipoYAreaTematica {

    private final LibroRepositorio libroRepositorio;
    private final Mappers mapper;

    public RecomendarPorTipoYAreaTematicaUseCase(LibroRepositorio libroRepositorio, Mappers mapper) {
        this.libroRepositorio = libroRepositorio;
        this.mapper = mapper;
    }

    @Override
    public Flux<LibroDTO> get(String tipo, String areaTematica) {
        return libroRepositorio
                .findAllByTipoAndAreaTematica(tipo, areaTematica)
                .map(mapper.mapEntityToLibro());
    }
}
