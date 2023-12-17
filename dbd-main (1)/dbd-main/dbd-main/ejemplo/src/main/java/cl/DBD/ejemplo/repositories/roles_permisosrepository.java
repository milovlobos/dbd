package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.restricciones;
import cl.DBD.ejemplo.models.roles_permisos;
import java.util.*;

public interface roles_permisosrepository {
    public void asignarPermisoARol(roles_permisos nuevaAsignacion);
    public void revocarPermisoDeRol(int id_rol, int id_permiso);
    public List<roles_permisos> obtenerPermisosPorRol(int id_rol);
    public List<roles_permisos> obtenerRolesPorPermiso(int id_permiso);
    public List<restricciones> obtenerTodos_rolespermisos();
}
