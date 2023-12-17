package cl.DBD.ejemplo.models;
import java.util.*;
public class boleta {
    private int id;
    private int total;
    private  Date fecha;
    private int id_metodo_pago;

    public boleta(int id, int total, Date fecha, int id_metodo_pago) {
        this.id = id;
        this.total = total;
        this.fecha = fecha;
        this.id_metodo_pago = id_metodo_pago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_metodo_pago() {
        return id_metodo_pago;
    }

    public void setId_metodo_pago(int id_metodo_pago) {
        this.id_metodo_pago = id_metodo_pago;
    }
}
