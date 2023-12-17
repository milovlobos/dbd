package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.restricciones;
import java.util.*;

public interface restriccionesrepository {
    public void crearRestriccion(restricciones nuevaRestriccion);
    public void actualizarRestriccion(int id, restricciones restriccionActualizada);
    public void eliminarRestriccion(int id);
    public List<restricciones> obtenerTodosrestric();
    public restricciones obtenerPorId_restric(int id);
}
