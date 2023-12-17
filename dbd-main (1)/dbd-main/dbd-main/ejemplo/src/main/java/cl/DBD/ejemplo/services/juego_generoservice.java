package cl.DBD.ejemplo.services;
import cl.DBD.ejemplo.models.juego_genero;
import cl.DBD.ejemplo.repositories.juego_generorepository;
import cl.DBD.ejemplo.models.videojuegos;
import java.util.*;

import org.springframework.web.bind.annotation.*;

public class juego_generoservice {
    private final juego_generorepository juegoGeneroService;


    public juego_generoservice(juego_generorepository juegoGeneroService) {
        this.juegoGeneroService = juegoGeneroService;
    }

    @PostMapping
    public void agregarGeneroAVideojuego(@RequestBody juego_genero nuevoJuegoGenero) {
        juegoGeneroService.agregarGeneroAVideojuego(nuevoJuegoGenero);
    }

    @DeleteMapping("/{id_videojuego}/{id_genero}")
    public void eliminarGeneroDeVideojuego(@PathVariable int id_videojuego, @PathVariable int id_genero) {
        juegoGeneroService.eliminarGeneroDeVideojuego(id_videojuego, id_genero);
    }

    @GetMapping("/porVideojuego/{id_videojuego}")
    public List<juego_genero> obtenerGenerosPorVideojuego(@PathVariable int id_videojuego) {
        return juegoGeneroService.obtenerGenerosPorVideojuego(id_videojuego);
    }

    @GetMapping("/porGenero/{id_genero}")
    public List<juego_genero> obtenerVideojuegosPorGenero(@PathVariable int id_genero) {
        return juegoGeneroService.obtenerVideojuegosPorGenero(id_genero);
    }

    @GetMapping
    public List<videojuegos> seleccionarjuegosgenero() {
        return juegoGeneroService.seleccionarjuegosgenero();
    }

    @PutMapping("/{id_videojuego}/{id_genero}/{nuevoIdGenero}")
    public void actualizarGeneroEnVideojuego(@PathVariable int id_videojuego, @PathVariable int id_genero,
                                             @PathVariable int nuevoIdGenero) {
        juegoGeneroService.actualizarGeneroEnVideojuego(id_videojuego, id_genero, nuevoIdGenero);
    }
}
