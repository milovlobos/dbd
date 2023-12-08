package cl.DBD.ejemplo.models;
import java.util.*;
public class rol {
    private  int id;
    private  String nombre;
    private  String tipo;
    private  int id_usuario;

    public rol(int id, String nombre, String tipo, int id_usuario) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.id_usuario = id_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}