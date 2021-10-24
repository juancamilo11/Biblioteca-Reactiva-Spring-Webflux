package co.com.sofka.biblioteca.usecases;

import co.com.sofka.biblioteca.model.LibroDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface CrearLibro {

    Mono<LibroDTO> apply(@Valid LibroDTO libroDTO);

}
