package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.valoracion;
import java.util.*;


public interface valoracionrepository {
    public void agregarValoracion(valoracion nuevaValoracion);
    public void actualizarValoracion(int id_usuario, int id_juego, int nuevaValoracion);
    public void eliminarValoracion(int id_usuario, int id_juego);
    public List<valoracion> obtenerValoracionesPorJuego(int id_juego);
    public valoracion obtenerValoracionPorUsuarioYJuego(int id_usuario, int id_juego);
    public List<valoracion> obtenerTodasValoraciones();

}
