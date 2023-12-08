package cl.DBD.ejemplo.models;
import java.util.*;
public class juegos_restricciones {
    private int id_videojuego;
    private int id_restriccion;

    public juegos_restricciones(int id_videojuego, int id_restriccion) {
        this.id_videojuego = id_videojuego;
        this.id_restriccion = id_restriccion;
    }

    public int getId_videojuego() {
        return id_videojuego;
    }

    public void setId_videojuego(int id_videojuego) {
        this.id_videojuego = id_videojuego;
    }

    public int getId_restriccion() {
        return id_restriccion;
    }

    public void setId_restriccion(int id_restriccion) {
        this.id_restriccion = id_restriccion;
    }
}