package co.com.sofka.biblioteca.routers;

import co.com.sofka.biblioteca.model.LibroDTO;
import co.com.sofka.biblioteca.usecases.CrearLibroUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;


@Configuration
public class LibroRouter {

    @Bean
    public RouterFunction<ServerResponse> crearLibroRuta(CrearLibroUseCase crearLibroUseCase) {
        Function<LibroDTO, Mono<ServerResponse>> executor = libroDTO -> crearLibroUseCase.apply(libroDTO)
                .flatMap(resultado -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(resultado));

        return route(POST("/crear")
                        .and(accept(MediaType.APPLICATION_JSON)),
                        request -> request.bodyToMono(LibroDTO.class).flatMap(executor));
    }

}