package cl.DBD.ejemplo.services;
import cl.DBD.ejemplo.models.juegos_restricciones;
import cl.DBD.ejemplo.repositories.juego_restriccionesrepository;
import cl.DBD.ejemplo.models.videojuegos;
import java.util.*;

public class juego_restriccionesservice {

    private juego_restriccionesrepository juegoRestriccionesRepository;

    // Método para agregar una restricción a un videojuego
    public void agregarRestriccionAVideojuego(juegos_restricciones nuevoJuegoRestriccion) {
        juegoRestriccionesRepository.agregarRestriccionAVideojuego(nuevoJuegoRestriccion);
    }

    // Método para eliminar una restricción de un videojuego
    public void eliminarRestriccionDeVideojuego(int id_videojuego, int id_restriccion) {
        juegoRestriccionesRepository.eliminarRestriccionDeVideojuego(id_videojuego, id_restriccion);
    }

    // Método para obtener todas las restricciones de un videojuego
    public List<juegos_restricciones> obtenerRestriccionesPorVideojuego(int id_videojuego) {
        return juegoRestriccionesRepository.obtenerRestriccionesPorVideojuego(id_videojuego);
    }

    // Método para obtener todos los videojuegos asociados a una restricción
    public List<juegos_restricciones> obtenerVideojuegosPorRestriccion(int id_restriccion) {
        return juegoRestriccionesRepository.obtenerVideojuegosPorRestriccion(id_restriccion);
    }

    // Método para seleccionar todos los juegos con restricciones
    public List<videojuegos> seleccionarJuegosRestricciones() {
        return juegoRestriccionesRepository.seleccionarjuegosrestricciones();
    }

    // Método para actualizar una restricción en un videojuego
    public void actualizarRestriccionEnVideojuego(int id_videojuego, int id_restriccion, int nuevoIdRestriccion) {
        juegoRestriccionesRepository.actualizarRestriccionEnVideojuego(id_videojuego, id_restriccion, nuevoIdRestriccion);
    }
}
