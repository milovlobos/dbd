package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.models.biblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.time.LocalDate;
import java.util.List;



@Repository
public class bibliotecarepositorylmp implements bibliotecarepository{

    @Autowired
    private Sql2o sql2o;
    @Override
    public biblioteca crearbiblioteca(biblioteca biblioteca) {
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO biblioteca (id_usuario,id_juego)" +
                    "VALUES (:id_usuario, :id_juego)";
            conn.createQuery(sql, true)
                    .addParameter("id_usuario", biblioteca.getId_usuario())
                    .addParameter("id_juego", biblioteca.getId_juego())
                    .executeUpdate();
            return biblioteca;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public String actualizarBiblioteca(int id_usuario, int id_juego, int nuevoId_juego) {
        try (Connection conn = sql2o.open()) {
            String sql = "UPDATE biblioteca SET id_juego = :nuevoId_juego WHERE id_usuario = :id_usuario AND id_juego = :id_juego";
            conn.createQuery(sql)
                    .addParameter("nuevoId_juego", nuevoId_juego)
                    .addParameter("id_usuario", id_usuario)
                    .addParameter("id_juego", id_juego)
                    .executeUpdate();
            return "Biblioteca actualizada para el usuario con ID: " + id_usuario + " y juego con ID: " + id_juego;
        } catch (Exception e) {
            System.out.println("Error al actualizar la biblioteca: " + e.getMessage());
            return null;
        }
    }
    @Override
    public List<biblioteca> showall() {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM biblioteca";
            return conn.createQuery(sql)
                    .executeAndFetch(biblioteca.class);
        } catch (Exception e) {
            System.out.println("Error al obtener bibliotecas: " + e.getMessage());
            return null;
        }
    }
    @Override
    public List<biblioteca> mostrarbilbioteca_usuario(int id_usuario) {
        try (Connection conn = sql2o.open()) {
            String sql = "SELECT * FROM biblioteca WHERE id_usuario = :id_usuario";
            return conn.createQuery(sql)
                    .addParameter("id_usuario", id_usuario)
                    .executeAndFetch(biblioteca.class);
        } catch (Exception e) {
            System.out.println("Error al obtener bibliotecas por usuario: " + e.getMessage());
            return null;
        }
    }
    @Override
    public String eliminarbiblioteca(int id_usuario, int id_juego) {
        try (Connection conn = sql2o.open()) {
            String sql = "DELETE FROM biblioteca WHERE id_usuario = :id_usuario AND id_juego = :id_juego";
            conn.createQuery(sql)
                    .addParameter("id_usuario", id_usuario)
                    .addParameter("id_juego", id_juego)
                    .executeUpdate();
            return "Biblioteca eliminada para el usuario con ID: " + id_usuario + " y juego con ID: " + id_juego;
        } catch (Exception e) {
            System.out.println("Error al eliminar la biblioteca: " + e.getMessage());
            return null;
        }
    }
}