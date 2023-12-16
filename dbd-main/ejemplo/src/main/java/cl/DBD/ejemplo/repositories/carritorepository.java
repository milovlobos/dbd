package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.carrito;
import java.util.*;

public interface carritorepository {
    public void crearCarrito(carrito nuevoCarrito);
    public void actualizarCarrito(int id, carrito carritoActualizado);
    public void eliminarCarrito(int id);
    public List<carrito> seleccionarcarritos();

    public carrito seleccionarPorId_carrito(int id);

}
