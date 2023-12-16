package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.favorito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.time.LocalDate;
import java.util.List;

@Repository
public class favoritorepositorylpm implements favoritorepository{
    @Autowired
    private Sql2o sql2o;
    // Método para agregar un juego a la lista de favoritos de un usuario
    public void agregarFavorito(int id_usuario, int id_juego) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO favorito (id_usuario, id_juego) VALUES (:idUsuario, :idJuego)")
                    .addParameter("idUsuario", id_usuario)
                    .addParameter("idJuego", id_juego)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al agregar juego a favoritos: " + e.getMessage());
        }
    }

    // Método para eliminar un juego de la lista de favoritos de un usuario
    public void eliminarFavorito(int id_usuario, int id_juego) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM favorito WHERE id_usuario = :idUsuario AND id_juego = :idJuego")
                    .addParameter("idUsuario", id_usuario)
                    .addParameter("idJuego", id_juego)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar juego de favoritos: " + e.getMessage());
        }
    }

    // Método para obtener todos los registros de la tabla favorito
    public List<favorito> obtenerTodos() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM favorito")
                    .executeAndFetch(favorito.class);
        } catch (Exception e) {
            System.out.println("Error al obtener todos los registros de favorito: " + e.getMessage());
            return null;
        }
    }

    // Método para obtener todos los juegos favoritos de un usuario
    public List<favorito> obtenerFavoritosPorUsuario(int id_usuario) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM favorito WHERE id_usuario = :idUsuario")
                    .addParameter("idUsuario", id_usuario)
                    .executeAndFetch(favorito.class);
        } catch (Exception e) {
            System.out.println("Error al obtener juegos favoritos por usuario: " + e.getMessage());
            return null;
        }
    }

    // Método para obtener todos los usuarios que tienen un juego en favoritos
    public List<favorito> obtenerUsuariosPorJuego(int id_juego) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM favorito WHERE id_juego = :idJuego")
                    .addParameter("idJuego", id_juego)
                    .executeAndFetch(favorito.class);
        } catch (Exception e) {
            System.out.println("Error al obtener usuarios por juego favorito: " + e.getMessage());
            return null;
        }
    }
}
