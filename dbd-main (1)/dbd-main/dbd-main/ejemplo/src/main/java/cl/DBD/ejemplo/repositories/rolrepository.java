package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.rol;
import java.util.*;

public interface rolrepository {
    public void crearRol(rol nuevoRol);
    public void actualizarRol(int id, rol rolActualizado);
    public void eliminarRol(int id);
    public List<rol> obtenerroles();
    public rol obtenerPorId_rol(int id);
}
