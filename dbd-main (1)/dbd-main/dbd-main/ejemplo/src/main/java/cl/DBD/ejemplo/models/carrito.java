package cl.DBD.ejemplo.models;
import java.util.*;
public class carrito {
    private int id;
    private List<String> articulos;
    private int total;
    private int total_sin_descuento;
    private int id_boleta;
    private int id_usuario;

    public carrito(int id, List<String> articulos, int total, int total_sin_descuento, int id_boleta, int id_usuario) {
        this.id = id;
        this.articulos = articulos;
        this.total = total;
        this.total_sin_descuento = total_sin_descuento;
        this.id_boleta = id_boleta;
        this.id_usuario = id_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<String> articulos) {
        this.articulos = articulos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_sin_descuento() {
        return total_sin_descuento;
    }

    public void setTotal_sin_descuento(int total_sin_descuento) {
        this.total_sin_descuento = total_sin_descuento;
    }

    public int getId_boleta() {
        return id_boleta;
    }

    public void setId_boleta(int id_boleta) {
        this.id_boleta = id_boleta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}