package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.videojuegos;
import java.util.*;

public interface videojuegosrepository {
    public void crearVideojuego(videojuegos nuevoVideojuego);
    public void actualizarVideojuego(int id, videojuegos videojuegoActualizado);

    public void eliminarVideojuego(int id);

    public List<videojuegos> seleccionarvideojuegos();
    public videojuegos seleccionarPorId_videojuegos(int id);
}