package cl.DBD.ejemplo.services;
import cl.DBD.ejemplo.models.biblioteca;
import cl.DBD.ejemplo.repositories.bibliotecarepository;
import java.util.*;

import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class bibliotecaservice {

    private final bibliotecarepository bibliotecaRepository;

     bibliotecaservice(bibliotecarepository bibliotecaRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
    }


    @PostMapping
    public biblioteca crearbiblioteca(@RequestBody biblioteca nuevaBiblioteca) {
        return bibliotecaRepository.crearbiblioteca(nuevaBiblioteca);
    }

    @PutMapping("/biblioteca/{id_usuario}/{id_juego}")
    public String actualizarBiblioteca(@PathVariable int id_usuario, @PathVariable int id_juego, @RequestParam int nuevoId_juego) {
        return bibliotecaRepository.actualizarBiblioteca(id_usuario, id_juego, nuevoId_juego);
    }

    @GetMapping
    public List<biblioteca> showall() {
        return bibliotecaRepository.showall();
    }

    @GetMapping("/biblioteca/{id_usuario}")
    public List<biblioteca> mostrarbilbioteca_usuario(@PathVariable int id_usuario) {
        return bibliotecaRepository.mostrarbilbioteca_usuario(id_usuario);
    }

    @DeleteMapping("/biblioteca/{id_usuario}/{id_juego}")
    public String eliminarbiblioteca(@PathVariable int id_usuario, @PathVariable int id_juego) {
        return bibliotecaRepository.eliminarbiblioteca(id_usuario, id_juego);
    }
}