package co.com.sofka.biblioteca.usecases;

import co.com.sofka.biblioteca.model.LibroDTO;
import reactor.core.publisher.Flux;

import javax.validation.Valid;

@FunctionalInterface
public interface RecomendarPorAreaTematica {

    Flux<LibroDTO> get(@Valid String areaTematica);

}
