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
    public String actualizarusuario(biblioteca biblioteca, int id_usuario) {
        return null;
    }

    @Override
    public String actualizarjueugo(biblioteca biblioteca, int id_juego) {
        return null;
    }

    @Override
    public List<biblioteca> showall() {
        return null;
    }

    @Override
    public List<biblioteca> mostrarbilbioteca_usuario(int id_usuario) {
        return null;
    }

    @Override
    public List<biblioteca> mostarjuegos_enbiblioteca(int id_usuario) {
        return null;
    }

    @Override
    public String eliminarbiblioteca(int id_usuario, int id_juego) {
        return null;
    }
}