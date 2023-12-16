package cl.DBD.ejemplo.models;
import java.util.*;


public class  usuario {
    private int id;
    private String nombre;
    private String contraseña;
    private String correo;
    private Date fecha_nacimeinto;

    public usuario(int id, String nombre, String contraseña, String correo, Date fecha_nacimeinto) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correo = correo;
        this.fecha_nacimeinto = fecha_nacimeinto;
    }

    public int getId_usuario() {
        return id;
    }

    public void setId_usuario(int id) {
        this.id = id;
    }

    public String getNombre_usuario() {
        return nombre;
    }

    public void setNombre_usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña_usuario() {
        return contraseña;
    }

    public void setContraseña_usuario(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo_usuario() {
        return correo;
    }

    public void setCorreo_usuario(String correo) {
        this.correo = correo;
    }

    public Date getFecha_nacimeinto_usuario() {
        return fecha_nacimeinto;
    }

    public void setFecha_nacimeinto_usuario(Date fecha_nacimeinto) {
        this.fecha_nacimeinto = fecha_nacimeinto;
    }
}