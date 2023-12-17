package cl.DBD.ejemplo.services;
import cl.DBD.ejemplo.models.restricciones;
import cl.DBD.ejemplo.repositories.restriccionesrepository;
import java.util.*;

import org.springframework.web.bind.annotation.*;

public class restriccioneservice {
    private final restriccionesrepository restriccionesService;


    public restriccioneservice(restriccionesrepository restriccionesService) {
        this.restriccionesService = restriccionesService;
    }

    @PostMapping
    public void crearRestriccion(@RequestBody restricciones nuevaRestriccion) {
        restriccionesService.crearRestriccion(nuevaRestriccion);
    }

    @PutMapping("/{id}")
    public void actualizarRestriccion(@PathVariable int id, @RequestBody restricciones restriccionActualizada) {
        restriccionesService.actualizarRestriccion(id, restriccionActualizada);
    }

    @DeleteMapping("/{id}")
    public void eliminarRestriccion(@PathVariable int id) {
        restriccionesService.eliminarRestriccion(id);
    }

    @GetMapping
    public List<restricciones> obtenerTodosRestricc() {
        return restriccionesService.obtenerTodosrestric();
    }

    @GetMapping("/{id}")
    public restricciones obtenerPorIdRestriccion(@PathVariable int id) {
        return restriccionesService.obtenerPorId_restric(id);
    }
}
