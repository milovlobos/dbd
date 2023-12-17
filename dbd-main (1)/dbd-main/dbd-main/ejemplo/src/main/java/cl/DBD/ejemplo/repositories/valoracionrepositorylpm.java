package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.valoracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
@Repository
public class valoracionrepositorylpm implements valoracionrepository {
    @Autowired
    private Sql2o sql2o;

    // Método para agregar una valoración
    public void agregarValoracion(valoracion nuevaValoracion) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO valoracion (id_usuario, id_juego, valoracion) VALUES (:id_usuario, :id_juego, :valoracion)";
            conn.createQuery(sql)
                    .addParameter("id_usuario", nuevaValoracion.getId_usuario())
                    .addParameter("id_juego", nuevaValoracion.getId_juego())
                    .addParameter("valoracion", nuevaValoracion.getValoracion())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al agregar la valoración: " + e.getMessage());
        }
    }

    // Método para actualizar una valoración por ID de usuario y ID de juego
    public void actualizarValoracion(int id_usuario, int id_juego, int nuevaValoracion) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE valoracion SET valoracion = :valoracion WHERE id_usuario = :id_usuario AND id_juego = :id_juego";
            conn.createQuery(sql)
                    .addParameter("id_usuario", id_usuario)
                    .addParameter("id_juego", id_juego)
                    .addParameter("valoracion", nuevaValoracion)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar la valoración: " + e.getMessage());
        }
    }

    // Método para eliminar una valoración por ID de usuario y ID de juego
    public void eliminarValoracion(int id_usuario, int id_juego) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM valoracion WHERE id_usuario = :id_usuario AND id_juego = :id_juego";
            conn.createQuery(sql)
                    .addParameter("id_usuario", id_usuario)
                    .addParameter("id_juego", id_juego)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar la valoración: " + e.getMessage());
        }
    }

    // Método para obtener todas las valoraciones de un juego
    public List<valoracion> obtenerValoracionesPorJuego(int id_juego) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM valoracion WHERE id_juego = :id_juego";
            return conn.createQuery(sql)
                    .addParameter("id_juego", id_juego)
                    .executeAndFetch(valoracion.class);
        } catch (Exception e) {
            System.out.println("Error al obtener valoraciones por juego: " + e.getMessage());
            return null;
        }
    }

    // Método para obtener la valoración de un usuario para un juego específico
    public valoracion obtenerValoracionPorUsuarioYJuego(int id_usuario, int id_juego) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM valoracion WHERE id_usuario = :id_usuario AND id_juego = :id_juego";
            return conn.createQuery(sql)
                    .addParameter("id_usuario", id_usuario)
                    .addParameter("id_juego", id_juego)
                    .executeAndFetchFirst(valoracion.class);
        } catch (Exception e) {
            System.out.println("Error al obtener la valoración por usuario y juego: " + e.getMessage());
            return null;
        }
    }

    public List<valoracion> obtenerTodasValoraciones() {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM valoracion";
            return conn.createQuery(sql)
                    .executeAndFetch(valoracion.class);
        } catch (Exception e) {
            System.out.println("Error al obtener todas las valoraciones: " + e.getMessage());
            return null;
        }
    }
}
