package cl.DBD.ejemplo.models;
import java.util.*;
public class pago {
    private int id;
    private String datos_bancarios;

    public pago(int id, String datos_bancarios) {
        this.id = id;
        this.datos_bancarios = datos_bancarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatos_bancarios() {
        return datos_bancarios;
    }

    public void setDatos_bancarios(String datos_bancarios) {
        this.datos_bancarios = datos_bancarios;
    }
}