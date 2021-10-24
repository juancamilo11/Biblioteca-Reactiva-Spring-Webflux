package co.com.sofka.biblioteca.usecases;

import co.com.sofka.biblioteca.model.LibroDTO;
import co.com.sofka.biblioteca.repositories.LibroRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@WebFluxTest
public class EliminarLibroUseCaseTest {

    @SpyBean
    private EliminarLibroUseCase eliminarLibroUseCase;

    @MockBean
    private LibroRepositorio repository;

    @Test
    void eliminarLibroTest() {
        // Arrange
        LibroDTO libroDTO = new LibroDTO("1",
                "Nombre libro #1",
                "Tipo #1",
                "Area tematica #1",
                33,
                0,
                LocalDate.ofEpochDay(1));

        Mockito.when(repository.deleteById("1")).thenReturn(Mono.empty());

        // Act
        var result = eliminarLibroUseCase.apply("1").block();

        Assertions.assertNull(result);
    }

}
