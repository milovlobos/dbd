package cl.DBD.ejemplo.services;
import cl.DBD.ejemplo.models.roles_permisos;
import cl.DBD.ejemplo.repositories.roles_permisosrepository;
import cl.DBD.ejemplo.models.restricciones;
import java.util.*;

import org.springframework.web.bind.annotation.*;


public class roles_permisosservice {
    private final roles_permisosrepository rolesPermisosRepository;


    public roles_permisosservice(roles_permisosrepository rolesPermisosRepository) {
        this.rolesPermisosRepository = rolesPermisosRepository;
    }

    @PostMapping("/asignarPermisoARol")
    public void asignarPermisoARol(@RequestBody roles_permisos nuevaAsignacion) {
        rolesPermisosRepository.asignarPermisoARol(nuevaAsignacion);
    }

    @DeleteMapping("/revocarPermisoDeRol/{idRol}/{idPermiso}")
    public void revocarPermisoDeRol(@PathVariable int idRol, @PathVariable int idPermiso) {
        rolesPermisosRepository.revocarPermisoDeRol(idRol, idPermiso);
    }

    @GetMapping("/obtenerPermisosPorRol/{idRol}")
    public List<roles_permisos> obtenerPermisosPorRol(@PathVariable int idRol) {
        return rolesPermisosRepository.obtenerPermisosPorRol(idRol);
    }

    @GetMapping("/obtenerRolesPorPermiso/{idPermiso}")
    public List<roles_permisos> obtenerRolesPorPermiso(@PathVariable int idPermiso) {
        return rolesPermisosRepository.obtenerRolesPorPermiso(idPermiso);
    }

    @GetMapping("/obtenerTodosRolesPermisos")
    public List<restricciones> obtenerTodosRolesPermisos() {
        return rolesPermisosRepository.obtenerTodos_rolespermisos();
    }
}
