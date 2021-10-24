package co.com.sofka.biblioteca.routers;

import co.com.sofka.biblioteca.model.LibroDTO;
import co.com.sofka.biblioteca.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


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

    @Bean
    public RouterFunction<ServerResponse> listarLibros(ListarLibrosUseCase listarLibrosUseCase) {
        return route(GET("/libros"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(listarLibrosUseCase.get(), LibroDTO.class)));
    }

    @Bean
    public RouterFunction<ServerResponse> obtenerLibro(ObtenerLibroUseCase obtenerLibroUseCase) {
        return route(GET("/libro/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(obtenerLibroUseCase.apply(request.pathVariable("id")), LibroDTO.class)));
    }

    @Bean
    public RouterFunction<ServerResponse> actualizarLibro(ActualizarLibroUseCase actualizarLibroUseCase){
        Function<LibroDTO, Mono<ServerResponse>> executor = libroDTO -> actualizarLibroUseCase.apply(libroDTO)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));

        return route(PUT("/actualizar")
                        .and(accept(MediaType.APPLICATION_JSON)), request -> request
                        .bodyToMono(LibroDTO.class)
                        .flatMap(executor)
        );
    }

    @Bean
    public RouterFunction<ServerResponse> eliminarLibro(EliminarLibroUseCase eliminarLibroUseCase) {
        return route(
                DELETE("/eliminar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(eliminarLibroUseCase.apply(request.pathVariable("id")), Void.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> verificarDisponibilidad(VerificarDisponibilidadUseCase verificarDisponibilidadUseCase) {
        return route(GET("/disponibilidad/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(verificarDisponibilidadUseCase.apply(request.pathVariable("id")), String.class)));
    }

    @Bean
    public RouterFunction<ServerResponse> listarLibrosPorTipo(RecomendarPorTipoUseCase recomendarPorTipoUseCase) {
        return route(GET("/librosPorTipo/{tipo}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(recomendarPorTipoUseCase.get(request.pathVariable("tipo")), LibroDTO.class)));
    }

}
