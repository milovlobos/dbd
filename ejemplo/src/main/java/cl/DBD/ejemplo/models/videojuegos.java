package cl.DBD.ejemplo.models;
import java.util.*;

public class videojuegos {
    private int id;
    private String name;
    private  int cantidad_vendidos;
    private String descripcion;
    private int precion;
    private String link;
    private  Date fecha_publicacion;

    public videojuegos(int id, String name, int cantidad_vendidos, String descripcion, int precion, String link, Date fecha_publicacion) {
        this.id = id;
        this.name = name;
        this.cantidad_vendidos = cantidad_vendidos;
        this.descripcion = descripcion;
        this.precion = precion;
        this.link = link;
        this.fecha_publicacion = fecha_publicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCantidad_vendidos() {
        return cantidad_vendidos;
    }

    public void setCantidad_vendidos(int cantidad_vendidos) {
        this.cantidad_vendidos = cantidad_vendidos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecion() {
        return precion;
    }

    public void setPrecion(int precion) {
        this.precion = precion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(Date fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }
}