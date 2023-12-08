package cl.DBD.ejemplo.models;
import java.util.*;
public class juegos_carrito {
    private int id_carrito;
    private int id_juego;

    public juegos_carrito(int id_carrito, int id_juego) {
        this.id_carrito = id_carrito;
        this.id_juego = id_juego;
    }

    public int getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }

    public int getId_juego() {
        return id_juego;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }
}