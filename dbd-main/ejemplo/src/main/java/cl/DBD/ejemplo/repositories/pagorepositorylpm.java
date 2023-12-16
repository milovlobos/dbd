package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.models.pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.time.LocalDate;
import java.util.List;



@Repository
public class pagorepositorylpm implements pagorepository{
    @Autowired
    private Sql2o sql2o;
    // Método para crear un nuevo pago
    public void crearPago(pago nuevoPago) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO pago (datos_bancarios) VALUES (:datos_bancarios)";
            conn.createQuery(sql)
                    .addParameter("datos_bancarios", nuevoPago.getDatos_bancarios())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al crear el pago: " + e.getMessage());
        }
    }

    // Método para actualizar un pago por ID
    public void actualizarPago(int id, pago pagoActualizado) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE pago SET datos_bancarios = :datos_bancarios WHERE id = :id";
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("datos_bancarios", pagoActualizado.getDatos_bancarios())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar el pago: " + e.getMessage());
        }
    }

    // Método para eliminar un pago por ID
    public void eliminarPago(int id) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM pago WHERE id = :id";
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar el pago: " + e.getMessage());
        }
    }

    // Método para obtener todos los pagos
    public List<pago> obtenerpagos() {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM pago";
            return conn.createQuery(sql)
                    .executeAndFetch(pago.class);
        } catch (Exception e) {
            System.out.println("Error al obtener todos los pagos: " + e.getMessage());
            return null;
        }
    }

    // Método para obtener un pago por ID
    public pago obtenerPorId_pago(int id) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM pago WHERE id = :id";
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(pago.class);
        } catch (Exception e) {
            System.out.println("Error al obtener el pago por ID: " + e.getMessage());
            return null;
        }
    }
}
