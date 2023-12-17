package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.models.juego_descuento;
import cl.DBD.ejemplo.models.videojuegos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.time.LocalDate;
import java.util.List;



@Repository
public class juego_descuentorepositorylpm implements juego_descuentorepository{
    @Autowired
    private Sql2o sql2o;
    // Método para agregar un descuento a un juego
    public void agregarDescuentoAJuego(juego_descuento nuevoJuegoDescuento) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO juego_descuento (id_juego, id_descuento) VALUES (:id_juego, :id_descuento)";
            conn.createQuery(sql)
                    .addParameter("id_juego", nuevoJuegoDescuento.getId_juego())
                    .addParameter("id_descuento", nuevoJuegoDescuento.getId_descuento())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al agregar descuento a juego: " + e.getMessage());
        }
    }

    // Método para eliminar un descuento de un juego
    public void eliminarDescuentoDeJuego(int id_juego, int id_descuento) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM juego_descuento WHERE id_juego = :id_juego AND id_descuento = :id_descuento";
            conn.createQuery(sql)
                    .addParameter("id_juego", id_juego)
                    .addParameter("id_descuento", id_descuento)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar descuento de juego: " + e.getMessage());
        }
    }

    // Método para obtener todos los descuentos de un juego
    public List<juego_descuento> obtenerDescuentosPorJuego(int id_juego) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM juego_descuento WHERE id_juego = :id_juego";
            return conn.createQuery(sql)
                    .addParameter("id_juego", id_juego)
                    .executeAndFetch(juego_descuento.class);
        } catch (Exception e) {
            System.out.println("Error al obtener descuentos por juego: " + e.getMessage());
            return null;
        }
    }

    // Método para obtener todos los juegos asociados a un descuento
    public List<juego_descuento> obtenerJuegosPorDescuento(int id_descuento) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM juego_descuento WHERE id_descuento = :id_descuento";
            return conn.createQuery(sql)
                    .addParameter("id_descuento", id_descuento)
                    .executeAndFetch(juego_descuento.class);
        } catch (Exception e) {
            System.out.println("Error al obtener juegos por descuento: " + e.getMessage());
            return null;
        }
    }
    @Override
    public List<videojuegos> seleccionarjuegosdescuento() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM juego_descuento")
                    .executeAndFetch(videojuegos.class);
        } catch (Exception e) {
            System.out.println("Error al seleccionar todos : " + e.getMessage());
            return null;
        }
    }
    @Override
    public void actualizarJuegoEnDescuento(int id_juego, int id_descuento, int nuevoIdDescuento) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE juego_descuento SET id_descuento = :nuevoIdDescuento WHERE id_juego = :id_juego AND id_descuento = :id_descuento";
            conn.createQuery(sql)
                    .addParameter("nuevoIdDescuento", nuevoIdDescuento)
                    .addParameter("id_juego", id_juego)
                    .addParameter("id_descuento", id_descuento)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar juego en descuento: " + e.getMessage());
        }
    }
}