package cl.DBD.ejemplo.services;




import cl.DBD.ejemplo.models.carrito;
import cl.DBD.ejemplo.repositories.carritorepository;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

public class CarritoService {
    private final carritorepository carrito;

    CarritoService(carritorepository carrito) {
        this.carrito = carrito;
    }

    // Crear C
    @PostMapping("/carrito")
    @ResponseBody
    public carrito crearCarrito(@RequestBody carrito nuevoCarrito) {
        carrito resultado = carrito.crearCarrito(nuevoCarrito);
        return resultado;
    }

    // Obtener todos los carritos
    @GetMapping("/carrito")
    public List<carrito> seleccionarcarritos() {
        return carrito.seleccionarcarritos();
    }

    // Obtener por ID
    @GetMapping("/carrito/{id}")
    public carrito seleccionarPorId_carrito(@PathVariable int id) {
        return carrito.seleccionarPorId_carrito(id);
    }

    // Actualizar U
    @PutMapping("/carrito/{id}")
    @ResponseBody
    public carrito actualizarCarrito(@RequestBody carrito carritoActualizado, @PathVariable int id) {
        carritoActualizado.setId(id);
        carrito resultado = carrito.actualizarCarrito(id, carritoActualizado);
        return resultado;
    }

    // Borrar D
    @DeleteMapping("/carrito/{id}")
    public void eliminarCarrito(@PathVariable int id) {
        carrito.eliminarCarrito(id);
    }
}
