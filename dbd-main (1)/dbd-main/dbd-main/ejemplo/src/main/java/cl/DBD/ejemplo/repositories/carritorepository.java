package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.carrito;
import java.util.*;

public interface carritorepository {
    public carrito crearCarrito(carrito nuevoCarrito);
    public carrito actualizarCarrito(int id, carrito carritoActualizado);
    public void eliminarCarrito(int id);
    public List<carrito> seleccionarcarritos();

    public carrito seleccionarPorId_carrito(int id);

}
