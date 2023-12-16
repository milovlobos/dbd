package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.pago;
import java.util.*;

public interface pagorepository {
    public void crearPago(pago nuevoPago);
    public void actualizarPago(int id, pago pagoActualizado);
    public void eliminarPago(int id);
    public List<pago> obtenerpagos();
    public pago obtenerPorId_pago(int id);
}
