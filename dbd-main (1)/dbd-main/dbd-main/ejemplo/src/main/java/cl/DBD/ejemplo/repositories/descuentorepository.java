package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.descuento;
import java.util.*;
public interface descuentorepository {
    public void crearDescuento(descuento nuevoDescuento);
    public void actualizarDescuento(int id, descuento descuentoActualizado);
    public void eliminarDescuento(int id);
    public List<descuento> seleccionardescuentos();
    public descuento seleccionarPorId_descuento(int id);
}
