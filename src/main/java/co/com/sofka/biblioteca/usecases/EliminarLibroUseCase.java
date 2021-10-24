package co.com.sofka.biblioteca.usecases;

import co.com.sofka.biblioteca.repositories.LibroRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class EliminarLibroUseCase implements Function<String, Mono<Void>> {

    private final LibroRepositorio libroRepositorio;

    public EliminarLibroUseCase(LibroRepositorio libroRepositorio) {
        this.libroRepositorio = libroRepositorio;
    }

    @Override
    public Mono<Void> apply(String id) {
        Objects.requireNonNull(id);
        return libroRepositorio.deleteById(id);
    }

}
