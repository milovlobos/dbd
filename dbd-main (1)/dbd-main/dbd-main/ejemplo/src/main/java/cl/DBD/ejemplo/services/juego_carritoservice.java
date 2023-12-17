package cl.DBD.ejemplo.services;
import cl.DBD.ejemplo.models.juegos_carrito;
import cl.DBD.ejemplo.repositories.juego_carritorepository;
import cl.DBD.ejemplo.models.videojuegos;
import java.util.*;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/juego_carrito")
@CrossOrigin
public class juego_carritoservice {

    private final juego_carritorepository juegoCarritoService;


    public juego_carritoservice(juego_carritorepository juegoCarritoService) {
        this.juegoCarritoService = juegoCarritoService;
    }

    @PostMapping("/agregar")
    public void agregarJuegoACarrito(@RequestBody juegos_carrito nuevoJuegoCarrito) {
        juegoCarritoService.agregarJuegoACarrito(nuevoJuegoCarrito);
    }

    @DeleteMapping("/eliminar/{id_carrito}/{id_juego}")
    public void eliminarJuegoDeCarrito(@PathVariable int id_carrito, @PathVariable int id_juego) {
        juegoCarritoService.eliminarJuegoDeCarrito(id_carrito, id_juego);
    }

    @GetMapping("/juegos/{id_carrito}")
    public List<juegos_carrito> obtenerJuegosPorCarrito(@PathVariable int id_carrito) {
        return juegoCarritoService.obtenerJuegosPorCarrito(id_carrito);
    }

    @GetMapping("/carritos/{id_juego}")
    public List<juegos_carrito> obtenerCarritosPorJuego(@PathVariable int id_juego) {
        return juegoCarritoService.obtenerCarritosPorJuego(id_juego);
    }

    @GetMapping("/seleccionar")
    public List<videojuegos> seleccionarjuegosencarrito() {
        return juegoCarritoService.seleccionarjuegosencarrito();
    }

    @PutMapping("/actualizar/{id_carrito}/{id_juego}/{nuevoIdJuego}")
    public void actualizarJuegoEnCarrito(@PathVariable int id_carrito, @PathVariable int id_juego, @PathVariable int nuevoIdJuego) {
        juegoCarritoService.actualizarJuegoEnCarrito(id_carrito, id_juego, nuevoIdJuego);
    }
}
