package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.juego_genero;
import cl.DBD.ejemplo.models.videojuegos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.time.LocalDate;
import java.util.List;

@Repository

public class juego_generorepositorylpm implements juego_generorepository{
    @Autowired
    private Sql2o sql2o;

    // Método para agregar un género a un videojuego
    public void agregarGeneroAVideojuego(juego_genero nuevoJuegoGenero) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO juego_genero (id_videojuego, id_genero) VALUES (:id_videojuego, :id_genero)";
            conn.createQuery(sql)
                    .addParameter("id_videojuego", nuevoJuegoGenero.getId_videojuego())
                    .addParameter("id_genero", nuevoJuegoGenero.getId_genero())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al agregar género a videojuego: " + e.getMessage());
        }
    }

    // Método para eliminar un género de un videojuego
    public void eliminarGeneroDeVideojuego(int id_videojuego, int id_genero) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM juego_genero WHERE id_videojuego = :id_videojuego AND id_genero = :id_genero";
            conn.createQuery(sql)
                    .addParameter("id_videojuego", id_videojuego)
                    .addParameter("id_genero", id_genero)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar género de videojuego: " + e.getMessage());
        }
    }

    // Método para obtener todos los géneros de un videojuego
    public List<juego_genero> obtenerGenerosPorVideojuego(int id_videojuego) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM juego_genero WHERE id_videojuego = :id_videojuego";
            return conn.createQuery(sql)
                    .addParameter("id_videojuego", id_videojuego)
                    .executeAndFetch(juego_genero.class);
        } catch (Exception e) {
            System.out.println("Error al obtener géneros por videojuego: " + e.getMessage());
            return null;
        }
    }

    // Método para obtener todos los videojuegos asociados a un género
    public List<juego_genero> obtenerVideojuegosPorGenero(int id_genero) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM juego_genero WHERE id_genero = :id_genero";
            return conn.createQuery(sql)
                    .addParameter("id_genero", id_genero)
                    .executeAndFetch(juego_genero.class);
        } catch (Exception e) {
            System.out.println("Error al obtener videojuegos por género: " + e.getMessage());
            return null;
        }
    }
    @Override
    public List<videojuegos> seleccionarjuegosgenero() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM juego_genero")
                    .executeAndFetch(videojuegos.class);
        } catch (Exception e) {
            System.out.println("Error al seleccionar todos : " + e.getMessage());
            return null;
        }
    }
    @Override
    public void actualizarGeneroEnVideojuego(int id_videojuego, int id_genero, int nuevoIdGenero) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE juego_genero SET id_genero = :nuevoIdGenero " +
                    "WHERE id_videojuego = :id_videojuego AND id_genero = :id_genero";
            conn.createQuery(sql)
                    .addParameter("id_videojuego", id_videojuego)
                    .addParameter("id_genero", id_genero)
                    .addParameter("nuevoIdGenero", nuevoIdGenero)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar género en videojuego: " + e.getMessage());
        }
    }
}
