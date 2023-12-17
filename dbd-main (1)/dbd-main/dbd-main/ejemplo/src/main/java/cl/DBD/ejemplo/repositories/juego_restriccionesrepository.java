package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.juegos_restricciones;
import cl.DBD.ejemplo.models.videojuegos;

import java.util.*;
public interface juego_restriccionesrepository {
    public void agregarRestriccionAVideojuego(juegos_restricciones nuevoJuegoRestriccion);
    public void eliminarRestriccionDeVideojuego(int id_videojuego, int id_restriccion);
    public List<juegos_restricciones> obtenerRestriccionesPorVideojuego(int id_videojuego);
    public List<juegos_restricciones> obtenerVideojuegosPorRestriccion(int id_restriccion);
    public List<videojuegos> seleccionarjuegosrestricciones();
    public void actualizarRestriccionEnVideojuego(int id_videojuego, int id_restriccion, int nuevoIdRestriccion);

}
