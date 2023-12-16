package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.models.permisos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.time.LocalDate;
import java.util.List;



@Repository
public class permisosrepositorylpm implements permisosrepository {
    @Autowired
    private Sql2o sql2o;

    // Método para crear un nuevo permiso
    public void crearPermiso(permisos nuevoPermiso) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO permisos (nombre, tipo) VALUES (:nombre, :tipo)";
            conn.createQuery(sql)
                    .addParameter("nombre", nuevoPermiso.getNombre())
                    .addParameter("tipo", nuevoPermiso.getTipo())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al crear el permiso: " + e.getMessage());
        }
    }

    // Método para actualizar un permiso por ID
    public void actualizarPermiso(int id, permisos permisoActualizado) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE permisos SET nombre = :nombre, tipo = :tipo WHERE id = :id";
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("nombre", permisoActualizado.getNombre())
                    .addParameter("tipo", permisoActualizado.getTipo())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar el permiso: " + e.getMessage());
        }
    }

    // Método para eliminar un permiso por ID
    public void eliminarPermiso(int id) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM permisos WHERE id = :id";
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar el permiso: " + e.getMessage());
        }
    }

    // Método para obtener todos los permisos
    public List<permisos> obtenerpermisos() {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM permisos";
            return conn.createQuery(sql)
                    .executeAndFetch(permisos.class);
        } catch (Exception e) {
            System.out.println("Error al obtener todos los permisos: " + e.getMessage());
            return null;
        }
    }

    // Método para obtener un permiso por ID
    public permisos obtenerPorId_permisos(int id) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM permisos WHERE id = :id";
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(permisos.class);
        } catch (Exception e) {
            System.out.println("Error al obtener el permiso por ID: " + e.getMessage());
            return null;
        }
    }
}
