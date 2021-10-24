package co.com.sofka.biblioteca.repositories;

import co.com.sofka.biblioteca.collections.Libro;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface LibroRepositorio extends ReactiveCrudRepository<Libro, String> {
    Flux<Libro> findAllByTipo(String tipo);
    Flux<Libro> findAllByAreaTematica(String categoria);
    Flux<Libro> findAllByAreaTematicaAndTipo(String categoria, String tipo);

}

