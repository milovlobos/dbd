package cl.DBD.ejemplo.services;
import cl.DBD.ejemplo.models.rol;
import cl.DBD.ejemplo.repositories.rolrepository;

import java.util.*;

import org.springframework.web.bind.annotation.*;


public class rolservice {
    private final rolrepository rolRepository;


    public rolservice(rolrepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @PostMapping("/crearRol")
    public void crearRol(@RequestBody rol nuevoRol) {
        rolRepository.crearRol(nuevoRol);
    }

    @PutMapping("/actualizarRol/{id}")
    public void actualizarRol(@PathVariable int id, @RequestBody rol rolActualizado) {
        rolRepository.actualizarRol(id, rolActualizado);
    }

    @DeleteMapping("/eliminarRol/{id}")
    public void eliminarRol(@PathVariable int id) {
        rolRepository.eliminarRol(id);
    }

    @GetMapping("/obtenerRoles")
    public List<rol> obtenerRoles() {
        return rolRepository.obtenerroles();
    }

    @GetMapping("/obtenerRol/{id}")
    public rol obtenerPorIdRol(@PathVariable int id) {
        return rolRepository.obtenerPorId_rol(id);
    }
}
