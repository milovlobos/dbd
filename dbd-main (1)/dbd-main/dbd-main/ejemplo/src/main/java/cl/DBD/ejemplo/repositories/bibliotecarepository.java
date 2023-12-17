package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.biblioteca;
import java.util.*;

public interface bibliotecarepository {

    public biblioteca crearbiblioteca(biblioteca biblioteca);
    public String actualizarBiblioteca(int id_usuario, int id_juego, int nuevoId_juego);

    public List<biblioteca> showall();
    public List<biblioteca> mostrarbilbioteca_usuario(int id_usuario);


    public String eliminarbiblioteca(int id_usuario, int id_juego);
}
