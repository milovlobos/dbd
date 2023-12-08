package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.biblioteca;
import java.util.*;

public interface bibliotecarepository {

    public biblioteca crearbiblioteca(biblioteca biblioteca);
    public String actualizarusuario(biblioteca biblioteca, int id_usuario);
    public String actualizarjueugo(biblioteca biblioteca, int id_juego);

    public List<biblioteca> showall();
    public List<biblioteca> mostrarbilbioteca_usuario(int id_usuario);
    public List<biblioteca>mostarjuegos_enbiblioteca(int id_usuario);

    public String eliminar(int id_usuario,int id_juego);
}
