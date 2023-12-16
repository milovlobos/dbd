package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.boleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.time.LocalDate;
import java.util.List;

@Repository
public class boletarepositorylpm implements boletarepository{
    @Autowired
    private Sql2o sql2o;
    // Método para crear una nueva boleta
    @Override
    public void crearBoleta(boleta nuevaBoleta) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO boleta (total, fecha, id_metodo_pago) " +
                            "VALUES (:total, :fecha, :idMetodoPago)")
                    .addParameter("total", nuevaBoleta.getTotal())
                    .addParameter("fecha", nuevaBoleta.getFecha())
                    .addParameter("idMetodoPago", nuevaBoleta.getId_metodo_pago())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al crear la boleta: " + e.getMessage());
        }
    }

    // Método para actualizar una boleta por ID
    @Override
    public void actualizarBoleta(int id, boleta boletaActualizada) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE boleta SET total = :total, fecha = :fecha, " +
                            "id_metodo_pago = :idMetodoPago WHERE id = :id")
                    .addParameter("id", id)
                    .addParameter("total", boletaActualizada.getTotal())
                    .addParameter("fecha", boletaActualizada.getFecha())
                    .addParameter("idMetodoPago", boletaActualizada.getId_metodo_pago())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar la boleta: " + e.getMessage());
        }
    }

    // Método para eliminar una boleta por ID
    @Override
    public void eliminarBoleta(int id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM boleta WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar la boleta: " + e.getMessage());
        }
    }

    // Método para seleccionar todas las boletas
    @Override
    public List<boleta> seleccionarTodas_boleta() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM boleta")
                    .executeAndFetch(boleta.class);
        } catch (Exception e) {
            System.out.println("Error al seleccionar todas las boletas: " + e.getMessage());
            return null;
        }
    }

    // Método para seleccionar una boleta por ID
    @Override
    public boleta seleccionarPorId_boleta(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM boleta WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(boleta.class);
        } catch (Exception e) {
            System.out.println("Error al seleccionar la boleta por ID: " + e.getMessage());
            return null;
        }
    }
}