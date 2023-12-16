package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.videojuegos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
@Repository
public class videojuegosrepositorylpm implements videojuegosrepository {
    @Autowired
    private Sql2o sql2o;

    // Método para crear un nuevo usuario


    // Método para crear un nuevo videojuego
    @Override
    public void crearVideojuego(videojuegos nuevoVideojuego) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO videojuegos (name, cantidad_vendidos, descripcion, precion, link, fecha_publicacion) " +
                            "VALUES (:name, :cantidadVendidos, :descripcion, :precio, :link, :fechaPublicacion)")
                    .addParameter("name", nuevoVideojuego.getName())
                    .addParameter("cantidadVendidos", nuevoVideojuego.getCantidad_vendidos())
                    .addParameter("descripcion", nuevoVideojuego.getDescripcion())
                    .addParameter("precio", nuevoVideojuego.getPrecion())
                    .addParameter("link", nuevoVideojuego.getLink())
                    .addParameter("fechaPublicacion", nuevoVideojuego.getFecha_publicacion())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al crear el videojuego: " + e.getMessage());
        }
    }

    // Método para actualizar un videojuego por ID
    @Override
    public void actualizarVideojuego(int id, videojuegos videojuegoActualizado) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE videojuegos SET name = :name, cantidad_vendidos = :cantidadVendidos, " +
                            "descripcion = :descripcion, precion = :precio, link = :link, fecha_publicacion = :fechaPublicacion " +
                            "WHERE id = :id")
                    .addParameter("id", id)
                    .addParameter("name", videojuegoActualizado.getName())
                    .addParameter("cantidadVendidos", videojuegoActualizado.getCantidad_vendidos())
                    .addParameter("descripcion", videojuegoActualizado.getDescripcion())
                    .addParameter("precio", videojuegoActualizado.getPrecion())
                    .addParameter("link", videojuegoActualizado.getLink())
                    .addParameter("fechaPublicacion", videojuegoActualizado.getFecha_publicacion())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar el videojuego: " + e.getMessage());
        }
    }

    // Método para eliminar un videojuego por ID
    @Override
    public void eliminarVideojuego(int id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM videojuegos WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar el videojuego: " + e.getMessage());
        }
    }

    // Método para seleccionar todos los videojuegos
    @Override
    public List<videojuegos> seleccionarvideojuegos() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM videojuegos")
                    .executeAndFetch(videojuegos.class);
        } catch (Exception e) {
            System.out.println("Error al seleccionar todos los videojuegos: " + e.getMessage());
            return null;
        }
    }

    // Método para seleccionar un videojuego por ID
    @Override
    public videojuegos seleccionarPorId_videojuegos(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM videojuegos WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(videojuegos.class);
        } catch (Exception e) {
            System.out.println("Error al seleccionar el videojuego por ID: " + e.getMessage());
            return null;
        }
    }
}
