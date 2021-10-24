package co.com.sofka.biblioteca.usecases;

import co.com.sofka.biblioteca.model.LibroDTO;
import reactor.core.publisher.Flux;

import javax.validation.Valid;

@FunctionalInterface
public interface RecomendarPorTipo {

    Flux<LibroDTO> get(@Valid String tipo);

}
