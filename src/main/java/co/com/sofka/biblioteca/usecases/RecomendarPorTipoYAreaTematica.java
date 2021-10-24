package co.com.sofka.biblioteca.usecases;

import co.com.sofka.biblioteca.model.LibroDTO;
import reactor.core.publisher.Flux;

import javax.validation.Valid;

public interface RecomendarPorTipoYAreaTematica {

    Flux<LibroDTO> get(@Valid String tipo, @Valid String areaTematica);

}
