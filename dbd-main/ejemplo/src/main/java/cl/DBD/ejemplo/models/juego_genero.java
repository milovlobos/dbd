package cl.DBD.ejemplo.models;
import java.util.*;
public class juego_genero {
    private  int id_videojuego;
    private int id_genero;

    public juego_genero(int id_videojuego, int id_genero) {
        this.id_videojuego = id_videojuego;
        this.id_genero = id_genero;
    }

    public int getId_videojuego() {
        return id_videojuego;
    }

    public void setId_videojuego(int id_videojuego) {
        this.id_videojuego = id_videojuego;
    }

    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }
}