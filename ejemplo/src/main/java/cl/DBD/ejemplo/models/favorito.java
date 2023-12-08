package cl.DBD.ejemplo.models;
import java.util.*;
public class favorito {
    private int id_usuario;
    private int id_juego;

    public favorito(int id_usuario, int id_juego) {
        this.id_usuario = id_usuario;
        this.id_juego = id_juego;
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
}
