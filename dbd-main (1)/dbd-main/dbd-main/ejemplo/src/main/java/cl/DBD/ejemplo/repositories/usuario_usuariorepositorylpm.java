package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.rol;
import cl.DBD.ejemplo.models.usuario_usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
@Repository
public class usuario_usuariorepositorylpm implements usuario_usuariorepository{
    @Autowired
    private Sql2o sql2o;
    // Método para seguir a un usuario
    public void seguirUsuario(usuario_usuario nuevaRelacion) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO usuario_usuario (id_usuario, id_seguido) VALUES (:id_usuario, :id_seguido)";
            conn.createQuery(sql)
                    .addParameter("id_usuario", nuevaRelacion.getId_usuario())
                    .addParameter("id_seguido", nuevaRelacion.getId_seguido())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al seguir al usuario: " + e.getMessage());
        }
    }

    // Método para dejar de seguir a un usuario
    public void dejarDeSeguirUsuario(int id_usuario, int id_seguido) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM usuario_usuario WHERE id_usuario = :id_usuario AND id_seguido = :id_seguido";
            conn.createQuery(sql)
                    .addParameter("id_usuario", id_usuario)
                    .addParameter("id_seguido", id_seguido)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al dejar de seguir al usuario: " + e.getMessage());
        }
    }

    // Método para obtener todos los usuarios seguidos por un usuario
    public List<usuario_usuario> obtenerUsuariosSeguidos(int id_usuario) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM usuario_usuario WHERE id_usuario = :id_usuario";
            return conn.createQuery(sql)
                    .addParameter("id_usuario", id_usuario)
                    .executeAndFetch(usuario_usuario.class);
        } catch (Exception e) {
            System.out.println("Error al obtener usuarios seguidos por el usuario: " + e.getMessage());
            return null;
        }
    }

    // Método para obtener todos los seguidores de un usuario
    public List<usuario_usuario> obtenerSeguidores(int id_seguido) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM usuario_usuario WHERE id_seguido = :id_seguido";
            return conn.createQuery(sql)
                    .addParameter("id_seguido", id_seguido)
                    .executeAndFetch(usuario_usuario.class);
        } catch (Exception e) {
            System.out.println("Error al obtener seguidores del usuario: " + e.getMessage());
            return null;
        }
    }
    public List<usuario_usuario> obtenetodo_useruser() {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM usuario_usuario";
            return conn.createQuery(sql)
                    .executeAndFetch(usuario_usuario.class);
        } catch (Exception e) {
            System.out.println("Error al obtener todo: " + e.getMessage());
            return null;
        }
    }
}
