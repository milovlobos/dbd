package cl.DBD.ejemplo.services;
import cl.DBD.ejemplo.models.valoracion;
import cl.DBD.ejemplo.repositories.valoracionrepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;
public class valoracionservice {
    private final valoracionrepository valoracionRepository;


    public valoracionservice(valoracionrepository valoracionRepository) {
        this.valoracionRepository = valoracionRepository;
    }

    @PostMapping("/agregarValoracion")
    public void agregarValoracion(@RequestBody valoracion nuevaValoracion) {
        valoracionRepository.agregarValoracion(nuevaValoracion);
    }

    @PutMapping("/actualizarValoracion/{id_usuario}/{id_juego}")
    public void actualizarValoracion(
            @PathVariable int id_usuario,
            @PathVariable int id_juego,
            @RequestParam int nuevaValoracion) {
        valoracionRepository.actualizarValoracion(id_usuario, id_juego, nuevaValoracion);
    }

    @DeleteMapping("/eliminarValoracion/{id_usuario}/{id_juego}")
    public void eliminarValoracion(@PathVariable int id_usuario, @PathVariable int id_juego) {
        valoracionRepository.eliminarValoracion(id_usuario, id_juego);
    }

    @GetMapping("/obtenerValoracionesPorJuego/{id_juego}")
    public List<valoracion> obtenerValoracionesPorJuego(@PathVariable int id_juego) {
        return valoracionRepository.obtenerValoracionesPorJuego(id_juego);
    }

    @GetMapping("/obtenerValoracionPorUsuarioYJuego/{id_usuario}/{id_juego}")
    public valoracion obtenerValoracionPorUsuarioYJuego(
            @PathVariable int id_usuario,
            @PathVariable int id_juego) {
        return valoracionRepository.obtenerValoracionPorUsuarioYJuego(id_usuario, id_juego);
    }

    @GetMapping("/obtenerTodasValoraciones")
    public List<valoracion> obtenerTodasValoraciones() {
        return valoracionRepository.obtenerTodasValoraciones();
    }
}
