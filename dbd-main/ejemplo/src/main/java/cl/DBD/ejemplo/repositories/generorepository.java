package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.genero;
import java.util.*;
public interface generorepository {
    public void crearGenero(genero nuevoGenero);
    public void actualizarGenero(int id, genero generoActualizado);
    public void eliminarGenero(int id);
    public List<genero> obtenergeneros();
    public genero obtenerPorId_genero(int id);
}
