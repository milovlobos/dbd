package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
@Repository

public class rolrepositorylpm implements rolrepository{
    @Autowired
    private Sql2o sql2o;

    // Método para crear un nuevo rol
    public void crearRol(rol nuevoRol) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO rol (nombre, tipo, id_usuario) VALUES (:nombre, :tipo, :id_usuario)";
            conn.createQuery(sql)
                    .addParameter("nombre", nuevoRol.getNombre())
                    .addParameter("tipo", nuevoRol.getTipo())
                    .addParameter("id_usuario", nuevoRol.getId_usuario())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al crear el rol: " + e.getMessage());
        }
    }

    // Método para actualizar un rol por ID
    public void actualizarRol(int id, rol rolActualizado) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE rol SET nombre = :nombre, tipo = :tipo, id_usuario = :id_usuario WHERE id = :id";
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("nombre", rolActualizado.getNombre())
                    .addParameter("tipo", rolActualizado.getTipo())
                    .addParameter("id_usuario", rolActualizado.getId_usuario())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar el rol: " + e.getMessage());
        }
    }

    // Método para eliminar un rol por ID
    public void eliminarRol(int id) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM rol WHERE id = :id";
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar el rol: " + e.getMessage());
        }
    }

    // Método para obtener todos los roles
    public List<rol> obtenerroles() {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM rol";
            return conn.createQuery(sql)
                    .executeAndFetch(rol.class);
        } catch (Exception e) {
            System.out.println("Error al obtener todos los roles: " + e.getMessage());
            return null;
        }
    }

    // Método para obtener un rol por ID
    public rol obtenerPorId_rol(int id) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM rol WHERE id = :id";
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(rol.class);
        } catch (Exception e) {
            System.out.println("Error al obtener el rol por ID: " + e.getMessage());
            return null;
        }
    }
}
