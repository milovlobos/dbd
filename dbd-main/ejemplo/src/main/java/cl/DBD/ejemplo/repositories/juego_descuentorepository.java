package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.juego_descuento;
import cl.DBD.ejemplo.models.videojuegos;

import java.util.*;

public interface juego_descuentorepository {
    public void agregarDescuentoAJuego(juego_descuento nuevoJuegoDescuento);
    public void eliminarDescuentoDeJuego(int id_juego, int id_descuento);
    public List<juego_descuento> obtenerDescuentosPorJuego(int id_juego);
    public List<juego_descuento> obtenerJuegosPorDescuento(int id_descuento);
    public List<videojuegos> seleccionarjuegosdescuento();
}
