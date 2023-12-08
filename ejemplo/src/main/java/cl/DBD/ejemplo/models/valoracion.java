package cl.DBD.ejemplo.models;
import java.util.*;

public class valoracion {
    private int id_usuario;
    private int id_juego;
    private int valoracion;

    public valoracion(int id_usuario, int id_juego, int valoracion) {
        this.id_usuario = id_usuario;
        this.id_juego = id_juego;
        this.valoracion = valoracion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_juego() {
        return id_juego;
    }

    public void setId_juego(int id_juego) {
        this.id_juego = id_juego;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }
}