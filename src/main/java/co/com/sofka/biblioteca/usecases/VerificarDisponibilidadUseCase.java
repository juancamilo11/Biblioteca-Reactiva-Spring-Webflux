package co.com.sofka.biblioteca.usecases;

import co.com.sofka.biblioteca.repositories.LibroRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class VerificarDisponibilidadUseCase implements Function<String, Mono<String>> {

    private LibroRepositorio libroRepositorio;

    public VerificarDisponibilidadUseCase(LibroRepositorio libroRepositorio) {
        this.libroRepositorio = libroRepositorio;
    }

    @Override
    public Mono<String> apply(String id) {
        Objects.requireNonNull(id);

        return libroRepositorio.findById(id)
                .map(libro ->
                        libro.getUnidadesDisponibles() > 0
                                ? String.valueOf("El libro con id " + id + " si se encuentra disponible, al momento hay " + libro.getUnidadesDisponibles() + " unidades disponibles.")
                                : String.valueOf("El libro con id " + id + " no se encuentra disponible."));
    }

}
