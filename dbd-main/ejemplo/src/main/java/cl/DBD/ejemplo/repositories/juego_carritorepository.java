package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.juegos_carrito;
import cl.DBD.ejemplo.models.videojuegos;

import java.util.*;

public interface juego_carritorepository {
    public void agregarJuegoACarrito(juegos_carrito nuevoJuegoCarrito);
    public void eliminarJuegoDeCarrito(int id_carrito, int id_juego);
    public List<juegos_carrito> obtenerJuegosPorCarrito(int id_carrito);
    public List<juegos_carrito> obtenerCarritosPorJuego(int id_juego);
    public List<videojuegos> seleccionarjuegosencarrito();
}
