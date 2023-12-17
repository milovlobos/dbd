package cl.DBD.ejemplo.services;
import cl.DBD.ejemplo.models.permisos;
import cl.DBD.ejemplo.repositories.permisosrepository;
import java.util.*;

import org.springframework.web.bind.annotation.*;

public class permisosservice {
    private final permisosrepository permisoService;


    public permisosservice(permisosrepository permisoService) {
        this.permisoService = permisoService;
    }

    @PostMapping
    public void crearPermiso(@RequestBody permisos nuevoPermiso) {
        permisoService.crearPermiso(nuevoPermiso);
    }

    @PutMapping("/{id}")
    public void actualizarPermiso(@PathVariable int id, @RequestBody permisos permisoActualizado) {
        permisoService.actualizarPermiso(id, permisoActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarPermiso(@PathVariable int id) {
        permisoService.eliminarPermiso(id);
    }

    @GetMapping
    public List<permisos> obtenerPermisos() {
        return permisoService.obtenerpermisos();
    }

    @GetMapping("/{id}")
    public permisos obtenerPorIdPermiso(@PathVariable int id) {
        return permisoService.obtenerPorId_permisos(id);
    }
}
