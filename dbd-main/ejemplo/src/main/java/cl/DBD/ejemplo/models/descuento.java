package cl.DBD.ejemplo.models;
import java.util.*;
public class descuento {
    private int id;
    private int porcentaje;

    public descuento(int id, int porcentaje) {
        this.id = id;
        this.porcentaje = porcentaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
}