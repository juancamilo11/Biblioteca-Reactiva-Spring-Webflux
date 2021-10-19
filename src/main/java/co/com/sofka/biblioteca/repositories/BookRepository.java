package co.com.sofka.biblioteca.repositories;

import co.com.sofka.biblioteca.collections.Libro;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BookRepository extends ReactiveMongoRepository<Libro, String> {
    Flux<Libro> findAllByTipo(String tipo);
    Flux<Libro> findAllByCategoria(String categoria);
}

