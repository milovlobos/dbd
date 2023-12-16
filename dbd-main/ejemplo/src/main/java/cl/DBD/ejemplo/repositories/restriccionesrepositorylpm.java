package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.models.restricciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.time.LocalDate;
import java.util.List;



@Repository

public class restriccionesrepositorylpm implements restriccionesrepository{
    @Autowired
    private Sql2o sql2o;
    // Método para crear una nueva restricción
    public void crearRestriccion(restricciones nuevaRestriccion) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO restricciones (nombre) VALUES (:nombre)";
            conn.createQuery(sql)
                    .addParameter("nombre", nuevaRestriccion.getNombre())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al crear la restricción: " + e.getMessage());
        }
    }

    // Método para actualizar una restricción por ID
    public void actualizarRestriccion(int id, restricciones restriccionActualizada) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE restricciones SET nombre = :nombre WHERE id = :id";
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("nombre", restriccionActualizada.getNombre())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar la restricción: " + e.getMessage());
        }
    }

    // Método para eliminar una restricción por ID
    public void eliminarRestriccion(int id) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM restricciones WHERE id = :id";
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar la restricción: " + e.getMessage());
        }
    }

    // Método para obtener todas las restricciones
    public List<restricciones> obtenerTodosrestric() {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM restricciones";
            return conn.createQuery(sql)
                    .executeAndFetch(restricciones.class);
        } catch (Exception e) {
            System.out.println("Error al obtener todas las restricciones: " + e.getMessage());
            return null;
        }
    }

    // Método para obtener una restricción por ID
    public restricciones obtenerPorId_restric(int id) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM restricciones WHERE id = :id";
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(restricciones.class);
        } catch (Exception e) {
            System.out.println("Error al obtener la restricción por ID: " + e.getMessage());
            return null;
        }
    }

}
