package cl.DBD.ejemplo.services;
import cl.DBD.ejemplo.models.videojuegos;
import cl.DBD.ejemplo.repositories.videojuegosrepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

public class videojuegosservice {
    private final videojuegosrepository videojuegosRepository;


    public videojuegosservice(videojuegosrepository videojuegosRepository) {
        this.videojuegosRepository = videojuegosRepository;
    }

    @PostMapping("/crearVideojuego")
    public void crearVideojuego(@RequestBody videojuegos nuevoVideojuego) {
        videojuegosRepository.crearVideojuego(nuevoVideojuego);
    }

    @PutMapping("/actualizarVideojuego/{id}")
    public void actualizarVideojuego(
            @PathVariable int id,
            @RequestBody videojuegos videojuegoActualizado) {
        videojuegosRepository.actualizarVideojuego(id, videojuegoActualizado);
    }

    @DeleteMapping("/eliminarVideojuego/{id}")
    public void eliminarVideojuego(@PathVariable int id) {
        videojuegosRepository.eliminarVideojuego(id);
    }

    @GetMapping("/seleccionarvideojuegos")
    public List<videojuegos> seleccionarvideojuegos() {
        return videojuegosRepository.seleccionarvideojuegos();
    }

    @GetMapping("/seleccionarPorId_videojuegos/{id}")
    public videojuegos seleccionarPorId_videojuegos(@PathVariable int id) {
        return videojuegosRepository.seleccionarPorId_videojuegos(id);
    }
}
