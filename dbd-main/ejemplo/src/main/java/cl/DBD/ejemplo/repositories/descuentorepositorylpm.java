package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.descuento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.time.LocalDate;
import java.util.List;

@Repository
public class descuentorepositorylpm implements descuentorepository{
    @Autowired
    private Sql2o sql2o;

    // Método para crear un nuevo descuento
    @Override
    public void crearDescuento(descuento nuevoDescuento) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO descuento (porcentaje) VALUES (:porcentaje)")
                    .addParameter("porcentaje", nuevoDescuento.getPorcentaje())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al crear el descuento: " + e.getMessage());
        }
    }

    // Método para actualizar un descuento por ID
    @Override
    public void actualizarDescuento(int id, descuento descuentoActualizado) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE descuento SET porcentaje = :porcentaje WHERE id = :id")
                    .addParameter("id", id)
                    .addParameter("porcentaje", descuentoActualizado.getPorcentaje())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar el descuento: " + e.getMessage());
        }
    }

    // Método para eliminar un descuento por ID
    @Override
    public void eliminarDescuento(int id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM descuento WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar el descuento: " + e.getMessage());
        }
    }

    // Método para seleccionar todos los descuentos
    @Override
    public List<descuento> seleccionardescuentos() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM descuento")
                    .executeAndFetch(descuento.class);
        } catch (Exception e) {
            System.out.println("Error al seleccionar todos los descuentos: " + e.getMessage());
            return null;
        }
    }

    // Método para seleccionar un descuento por ID
    @Override
    public descuento seleccionarPorId_descuento(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM descuento WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(descuento.class);
        } catch (Exception e) {
            System.out.println("Error al seleccionar el descuento por ID: " + e.getMessage());
            return null;
        }
    }
}
