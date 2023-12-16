package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.models.juegos_carrito;
import cl.DBD.ejemplo.models.videojuegos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.time.LocalDate;
import java.util.List;



@Repository
public class juego_carritorepositorylpm implements  juego_carritorepository{
    @Autowired
    private Sql2o sql2o;
    // Método para agregar un juego a un carrito
    public void agregarJuegoACarrito(juegos_carrito nuevoJuegoCarrito) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO juegos_carrito (id_carrito, id_juego) VALUES (:id_carrito, :id_juego)";
            conn.createQuery(sql)
                    .addParameter("id_carrito", nuevoJuegoCarrito.getId_carrito())
                    .addParameter("id_juego", nuevoJuegoCarrito.getId_juego())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al agregar juego a carrito: " + e.getMessage());
        }
    }

    // Método para eliminar un juego de un carrito
    public void eliminarJuegoDeCarrito(int id_carrito, int id_juego) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM juegos_carrito WHERE id_carrito = :id_carrito AND id_juego = :id_juego";
            conn.createQuery(sql)
                    .addParameter("id_carrito", id_carrito)
                    .addParameter("id_juego", id_juego)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar juego de carrito: " + e.getMessage());
        }
    }

    // Método para obtener todos los juegos de un carrito
    public List<juegos_carrito> obtenerJuegosPorCarrito(int id_carrito) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM juegos_carrito WHERE id_carrito = :id_carrito";
            return conn.createQuery(sql)
                    .addParameter("id_carrito", id_carrito)
                    .executeAndFetch(juegos_carrito.class);
        } catch (Exception e) {
            System.out.println("Error al obtener juegos por carrito: " + e.getMessage());
            return null;
        }
    }

    // Método para obtener todos los carritos asociados a un juego
    public List<juegos_carrito> obtenerCarritosPorJuego(int id_juego) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM juegos_carrito WHERE id_juego = :id_juego";
            return conn.createQuery(sql)
                    .addParameter("id_juego", id_juego)
                    .executeAndFetch(juegos_carrito.class);
        } catch (Exception e) {
            System.out.println("Error al obtener carritos por juego: " + e.getMessage());
            return null;
        }
    }
    @Override
    public List<videojuegos> seleccionarjuegosencarrito() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM juegos_carrito")
                    .executeAndFetch(videojuegos.class);
        } catch (Exception e) {
            System.out.println("Error al seleccionar todos : " + e.getMessage());
            return null;
        }
    }
}
