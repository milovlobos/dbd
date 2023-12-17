package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.restricciones;
import cl.DBD.ejemplo.models.roles_permisos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
@Repository

public class roles_permisosrepositorylpm implements  roles_permisosrepository{
    @Autowired
    private Sql2o sql2o;


    // Método para asignar un permiso a un rol
    public void asignarPermisoARol(roles_permisos nuevaAsignacion) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO roles_permisos (id_rol, id_permiso) VALUES (:id_rol, :id_permiso)";
            conn.createQuery(sql)
                    .addParameter("id_rol", nuevaAsignacion.getId_rol())
                    .addParameter("id_permiso", nuevaAsignacion.getId_permiso())
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al asignar permiso a rol: " + e.getMessage());
        }
    }

    // Método para revocar un permiso de un rol
    public void revocarPermisoDeRol(int id_rol, int id_permiso) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM roles_permisos WHERE id_rol = :id_rol AND id_permiso = :id_permiso";
            conn.createQuery(sql)
                    .addParameter("id_rol", id_rol)
                    .addParameter("id_permiso", id_permiso)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al revocar permiso de rol: " + e.getMessage());
        }
    }

    // Método para obtener todos los permisos de un rol
    public List<roles_permisos> obtenerPermisosPorRol(int id_rol) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM roles_permisos WHERE id_rol = :id_rol";
            return conn.createQuery(sql)
                    .addParameter("id_rol", id_rol)
                    .executeAndFetch(roles_permisos.class);
        } catch (Exception e) {
            System.out.println("Error al obtener permisos por rol: " + e.getMessage());
            return null;
        }
    }

    // Método para obtener todos los roles asociados a un permiso
    public List<roles_permisos> obtenerRolesPorPermiso(int id_permiso) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM roles_permisos WHERE id_permiso = :id_permiso";
            return conn.createQuery(sql)
                    .addParameter("id_permiso", id_permiso)
                    .executeAndFetch(roles_permisos.class);
        } catch (Exception e) {
            System.out.println("Error al obtener roles por permiso: " + e.getMessage());
            return null;
        }
    }

    public List<restricciones> obtenerTodos_rolespermisos() {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM roles_permisos";
            return conn.createQuery(sql)
                    .executeAndFetch(restricciones.class);
        } catch (Exception e) {
            System.out.println("Error al obtener todas las restricciones: " + e.getMessage());
            return null;
        }
    }
}
