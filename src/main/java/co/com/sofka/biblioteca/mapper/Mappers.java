package co.com.sofka.biblioteca.mapper;

import co.com.sofka.biblioteca.collections.Libro;
import co.com.sofka.biblioteca.model.LibroDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class Mappers {

    public Function <LibroDTO, Libro> mapperToLibro(){
        return actualizarRecurso ->{
            Libro libro = new Libro();

            libro.setId(actualizarRecurso.getId());
            libro.setNombre(actualizarRecurso.getNombre());
            libro.setTipo(actualizarRecurso.getTipo());
            libro.setAreaTematica(actualizarRecurso.getAreaTematica());
            libro.setUnidadesDisponibles(actualizarRecurso.getUnidadesDisponibles());
            libro.setUnidadesPrestadas(actualizarRecurso.getUnidadesPrestadas());
            libro.setFechaUltimoPrestamo(actualizarRecurso.getFechaUltimoPrestamo());

            return libro;
        };
    }

    public Function<Libro, LibroDTO> mapEntityToLibro(){
        return libroDTO -> new LibroDTO(

                libroDTO.getId(),
                libroDTO.getNombre(),
                libroDTO.getTipo(),
                libroDTO.getAreaTematica(),
                libroDTO.getUnidadesDisponibles(),
                libroDTO.getUnidadesPrestadas(),
                libroDTO.getFechaUltimoPrestamo()
        );
    }

}
