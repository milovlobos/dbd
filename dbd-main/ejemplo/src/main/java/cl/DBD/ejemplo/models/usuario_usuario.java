package cl.DBD.ejemplo.models;
import java.util.*;
public class usuario_usuario {
    private int id_usuario;
    private int id_seguido;

    public usuario_usuario(int id_usuario, int id_seguido) {
        this.id_usuario = id_usuario;
        this.id_seguido = id_seguido;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_seguido() {
        return id_seguido;
    }

    public void setId_seguido(int id_seguido) {
        this.id_seguido = id_seguido;
    }
}