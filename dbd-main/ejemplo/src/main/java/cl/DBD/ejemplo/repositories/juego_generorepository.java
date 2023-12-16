package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.juego_genero;
import cl.DBD.ejemplo.models.videojuegos;

import java.util.*;

public interface juego_generorepository {
    public void agregarGeneroAVideojuego(juego_genero nuevoJuegoGenero);
    public void eliminarGeneroDeVideojuego(int id_videojuego, int id_genero);
    public List<juego_genero> obtenerGenerosPorVideojuego(int id_videojuego);
    public List<juego_genero> obtenerVideojuegosPorGenero(int id_genero);
    public List<videojuegos> seleccionarjuegosgenero();
}
