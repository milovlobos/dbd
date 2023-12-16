package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.time.LocalDate;
import java.util.List;

@Repository
public class carritorepositorylpm implements carritorepository {
    @Autowired
    private Sql2o sql2o;
    // Método para crear un nuevo usuario

    @Override
    public void crearCarrito(carrito nuevoCarrito) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO carrito (articulos, total, total_sin_descuento, id_boleta, id_usuario) " +
                            "VALUES (:articulos, :total, :totalSinDescuento, :idBoleta, :idUsuario)")
                    .addParameter("articulos", nuevoCarrito.getArticulos())
                    .addParameter("total", nuevoCarrito.getTotal())
                    .addParameter("totalSinDescuento", nuevoCarrito.getTotal_sin_descuento())
                    .addParameter("idBoleta", nuevoCarrito.getId_boleta())
                    .addParameter("idUsuario", nuevoCarrito.getId_usuario())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al crear el carrito: " + e.getMessage());
        }
    }

    @Override
    public void actualizarCarrito(int id, carrito carritoActualizado) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE carrito SET " +
                    "articulos = :articulos, " +
                    "total = :total, " +
                    "total_sin_descuento = :total_sin_descuento, " +
                    "id_boleta = :id_boleta, " +
                    "id_usuario = :id_usuario " +
                    "WHERE id = :id";
            conn.createQuery(sql)
                    .addParameter("articulos", carritoActualizado.getArticulos())
                    .addParameter("total", carritoActualizado.getTotal())
                    .addParameter("total_sin_descuento", carritoActualizado.getTotal_sin_descuento())
                    .addParameter("id_boleta", carritoActualizado.getId_boleta())
                    .addParameter("id_usuario", carritoActualizado.getId_usuario())
                    .addParameter("id", carritoActualizado.getId())
                    .executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al actualizar el carrito: " + e.getMessage());

        }
    }

    @Override
    public void eliminarCarrito(int idCarrito) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM carrito WHERE id = :id";
            conn.createQuery(sql)
                    .addParameter("id", idCarrito)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar el carrito: " + e.getMessage());
        }
    }

    @Override
    // Método para obtener todos los carritos
    public List<carrito> seleccionarcarritos() {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM carrito";
            return conn.createQuery(sql)
                    .executeAndFetch(carrito.class);
        } catch (Exception e) {
            System.out.println("Error al obtener todos los carritos: " + e.getMessage());
            return null;
        }
    }

    @Override
    public carrito seleccionarPorId_carrito(int id) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM carrito WHERE id = :id";
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(carrito.class);
        } catch (Exception e) {
            System.out.println("Error al obtener el carrito por ID: " + e.getMessage());
            return null;
        }
    }
}
