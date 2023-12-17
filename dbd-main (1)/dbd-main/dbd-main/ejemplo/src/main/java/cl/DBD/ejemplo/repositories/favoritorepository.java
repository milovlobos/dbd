package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.favorito;
import java.util.*;

public interface favoritorepository {
    public void agregarFavorito(int id_usuario, int id_juego);
    public void eliminarFavorito(int id_usuario, int id_juego);
    public List<favorito> obtenerFavoritosPorUsuario(int id_usuario);
    public List<favorito> obtenerTodos();
    public List<favorito> obtenerUsuariosPorJuego(int id_juego);
}
