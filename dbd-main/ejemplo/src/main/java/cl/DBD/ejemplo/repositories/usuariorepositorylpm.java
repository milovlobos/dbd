package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.time.LocalDate;
import java.util.List;

@Repository
public class usuariorepositorylpm implements usuariorepository{
    @Autowired
    private Sql2o sql2o;
    // Método para crear un nuevo usuario

    @Override
    public void crearUsuario(usuario nuevoUsuario) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("INSERT INTO usuario (nombre, contraseña, correo, fecha_nacimiento) " +
                            "VALUES (:nombre, :contraseña, :correo, :fechaNacimiento)")
                    .addParameter("nombre", nuevoUsuario.getNombre_usuario())
                    .addParameter("contraseña", nuevoUsuario.getContraseña_usuario())
                    .addParameter("correo", nuevoUsuario.getCorreo_usuario())
                    .addParameter("fechaNacimiento", nuevoUsuario.getFecha_nacimeinto_usuario())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al crear usuario: " + e.getMessage());
        }
    }

    // Método para actualizar un usuario por ID
    @Override
    public void actualizarUsuario(int id, usuario usuarioActualizado) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("UPDATE usuario SET nombre = :nombre, contraseña = :contraseña, correo = :correo, fecha_nacimiento = :fechaNacimiento " +
                            "WHERE id = :id")
                    .addParameter("id", id)
                    .addParameter("nombre", usuarioActualizado.getNombre_usuario())
                    .addParameter("contraseña", usuarioActualizado.getContraseña_usuario())
                    .addParameter("correo", usuarioActualizado.getCorreo_usuario())
                    .addParameter("fechaNacimiento", usuarioActualizado.getFecha_nacimeinto_usuario())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
    }

    // Método para eliminar un usuario por ID
    @Override
    public void eliminarUsuario_usuario(int id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM usuario WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }

    // Método para seleccionar todos los usuarios
    @Override
    public List<usuario> seleccionarTodos_usuario() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM usuario")
                    .executeAndFetch(usuario.class);
        } catch (Exception e) {
            System.out.println("Error al seleccionar todos los usuarios: " + e.getMessage());
            return null;
        }
    }

    // Método para seleccionar un usuario por ID
    @Override
    public usuario seleccionarPorId_usuario(int id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM usuario WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(usuario.class);
        } catch (Exception e) {
            System.out.println("Error al seleccionar usuario por ID: " + e.getMessage());
            return null;
        }
    }
}

