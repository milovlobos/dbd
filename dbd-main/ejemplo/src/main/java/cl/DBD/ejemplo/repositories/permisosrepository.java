package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.permisos;
import java.util.*;


public interface permisosrepository {
    public void crearPermiso(permisos nuevoPermiso);
    public void actualizarPermiso(int id, permisos permisoActualizado);
    public void eliminarPermiso(int id);
    public List<permisos> obtenerpermisos();
    public permisos obtenerPorId_permisos(int id);
}
