package cl.DBD.ejemplo.services;
import cl.DBD.ejemplo.models.genero;
import cl.DBD.ejemplo.repositories.generorepository;
import java.util.*;

import org.springframework.web.bind.annotation.*;

public class generoservice {
    private final generorepository generoService;


    public generoservice(generorepository generoService) {
        this.generoService = generoService;
    }

    @PostMapping
    public void crearGenero(@RequestBody genero nuevoGenero) {
        generoService.crearGenero(nuevoGenero);
    }

    @PutMapping("/{id}")
    public void actualizarGenero(@PathVariable int id, @RequestBody genero generoActualizado) {
        generoService.actualizarGenero(id, generoActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarGenero(@PathVariable int id) {
        generoService.eliminarGenero(id);
    }

    @GetMapping
    public List<genero> obtenerGeneros() {
        return generoService.obtenergeneros();
    }

    @GetMapping("/{id}")
    public genero obtenerPorIdGenero(@PathVariable int id) {
        return generoService.obtenerPorId_genero(id);
    }
}
