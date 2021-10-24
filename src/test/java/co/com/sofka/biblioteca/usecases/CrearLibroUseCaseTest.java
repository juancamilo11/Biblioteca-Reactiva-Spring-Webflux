package co.com.sofka.biblioteca.usecases;

import co.com.sofka.biblioteca.collections.Libro;
import co.com.sofka.biblioteca.mapper.Mappers;
import co.com.sofka.biblioteca.model.LibroDTO;
import co.com.sofka.biblioteca.repositories.LibroRepositorio;
import co.com.sofka.biblioteca.routers.LibroRouter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {LibroRouter.class, CrearLibroUseCase.class, Mappers.class})
class GuardarRecursoUseCaseTest {

    @MockBean
    private LibroRepositorio libroRepositorio;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void crearLibroTest() {
        // Arrange
        Libro libro = new Libro();

        libro.setId("1");
        libro.setNombre("Nombre #1");
        libro.setTipo("Tipo #1");
        libro.setAreaTematica("Area tematica #1");
        libro.setUnidadesDisponibles(10);
        libro.setUnidadesPrestadas(5);
        libro.setFechaUltimoPrestamo(LocalDate.parse("2020-01-10"));

        LibroDTO libroDTO = new LibroDTO(libro.getId(),
                libro.getNombre(),
                libro.getTipo(),
                libro.getAreaTematica(),
                libro.getUnidadesDisponibles(),
                libro.getUnidadesPrestadas(),
                libro.getFechaUltimoPrestamo());

        // Act
        Mono<Libro> libroMono = Mono.just(libro);
        when(libroRepositorio.save(any())).thenReturn(libroMono);

        // Assert
        webTestClient.post()
                .uri("/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(libroDTO), LibroDTO.class)
                .exchange()
                .expectStatus().isOk();
    }
}