package co.com.sofka.biblioteca.usecases;


import co.com.sofka.biblioteca.mapper.Mappers;
import co.com.sofka.biblioteca.model.LibroDTO;
import co.com.sofka.biblioteca.repositories.LibroRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CrearLibroUseCase implements CrearLibro {

    private final LibroRepositorio libroRepositorio;
    private final Mappers mapper;

    public CrearLibroUseCase(LibroRepositorio libroRepositorio, Mappers mapper) {
        this.libroRepositorio = libroRepositorio;
        this.mapper = mapper;
    }

    @Override
    public Mono<LibroDTO> apply(LibroDTO libroDTO) {
        return libroRepositorio.save(mapper.mapperToLibro().apply(libroDTO))
                .map(libro -> mapper.mapEntityToLibro().apply(libro));
    }
}
