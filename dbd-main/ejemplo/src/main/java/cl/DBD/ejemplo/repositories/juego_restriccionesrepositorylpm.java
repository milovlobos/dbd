package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.models.juegos_restricciones;
import cl.DBD.ejemplo.models.videojuegos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.time.LocalDate;
import java.util.List;



@Repository
public class juego_restriccionesrepositorylpm implements juego_restriccionesrepository{
    @Autowired
    private Sql2o sql2o;
    // Método para agregar una restricción a un videojuego
    public void agregarRestriccionAVideojuego(juegos_restricciones nuevoJuegoRestriccion) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO juegos_restricciones (id_videojuego, id_restriccion) VALUES (:id_videojuego, :id_restriccion)";
            conn.createQuery(sql)
                    .addParameter("id_videojuego", nuevoJuegoRestriccion.getId_videojuego())
                    .addParameter("id_restriccion", nuevoJuegoRestriccion.getId_restriccion())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al agregar restricción a videojuego: " + e.getMessage());
        }
    }

    // Método para eliminar una restricción de un videojuego
    public void eliminarRestriccionDeVideojuego(int id_videojuego, int id_restriccion) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM juegos_restricciones WHERE id_videojuego = :id_videojuego AND id_restriccion = :id_restriccion";
            conn.createQuery(sql)
                    .addParameter("id_videojuego", id_videojuego)
                    .addParameter("id_restriccion", id_restriccion)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar restricción de videojuego: " + e.getMessage());
        }
    }

    // Método para obtener todas las restricciones de un videojuego
    public List<juegos_restricciones> obtenerRestriccionesPorVideojuego(int id_videojuego) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM juegos_restricciones WHERE id_videojuego = :id_videojuego";
            return conn.createQuery(sql)
                    .addParameter("id_videojuego", id_videojuego)
                    .executeAndFetch(juegos_restricciones.class);
        } catch (Exception e) {
            System.out.println("Error al obtener restricciones por videojuego: " + e.getMessage());
            return null;
        }
    }

    // Método para obtener todos los videojuegos asociados a una restricción
    public List<juegos_restricciones> obtenerVideojuegosPorRestriccion(int id_restriccion) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM juegos_restricciones WHERE id_restriccion = :id_restriccion";
            return conn.createQuery(sql)
                    .addParameter("id_restriccion", id_restriccion)
                    .executeAndFetch(juegos_restricciones.class);
        } catch (Exception e) {
            System.out.println("Error al obtener videojuegos por restricción: " + e.getMessage());
            return null;
        }
    }
    @Override
    public List<videojuegos> seleccionarjuegosrestricciones() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM juegos_restricciones")
                    .executeAndFetch(videojuegos.class);
        } catch (Exception e) {
            System.out.println("Error al seleccionar todos : " + e.getMessage());
            return null;
        }
    }
}
