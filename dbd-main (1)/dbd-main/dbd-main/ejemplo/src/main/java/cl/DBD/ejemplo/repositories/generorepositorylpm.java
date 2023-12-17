package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.time.LocalDate;
import java.util.List;

@Repository
public class generorepositorylpm implements generorepository {
    @Autowired
    private Sql2o sql2o;
    // Método para crear un nuevo género
    public void crearGenero(genero nuevoGenero) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO genero (id,nombre) VALUES (:id,:genero)")
                    .addParameter("genero", nuevoGenero.getGenero())
                    .addParameter("id",nuevoGenero.getId())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al crear el género: " + e.getMessage());
        }
    }

    // Método para actualizar un género por ID
    public void actualizarGenero(int id, genero generoActualizado) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE genero SET genero = :genero WHERE id = :id")
                    .addParameter("id", id)
                    .addParameter("genero", generoActualizado.getGenero())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar el género: " + e.getMessage());
        }
    }

    // Método para eliminar un género por ID
    public void eliminarGenero(int id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM genero WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar el género: " + e.getMessage());
        }
    }

    // Método para obtener todos los géneros
    public List<genero> obtenergeneros() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM genero")
                    .executeAndFetch(genero.class);
        } catch (Exception e) {
            System.out.println("Error al obtener todos los géneros: " + e.getMessage());
            return null;
        }
    }

    // Método para obtener un género por ID
    public genero obtenerPorId_genero(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM genero WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(genero.class);
        } catch (Exception e) {
            System.out.println("Error al obtener el género por ID: " + e.getMessage());
            return null;
        }
    }
}
