package cl.DBD.ejemplo.services;
import cl.DBD.ejemplo.models.juego_descuento;
import cl.DBD.ejemplo.repositories.juego_descuentorepository;
import cl.DBD.ejemplo.models.videojuegos;
import java.util.*;

import org.springframework.web.bind.annotation.*;

public class juego_descuentoservice {
    private final juego_descuentorepository juegoDescuentoService;


    public juego_descuentoservice(juego_descuentorepository juegoDescuentoService) {
        this.juegoDescuentoService = juegoDescuentoService;
    }

    @PostMapping
    public void agregarDescuentoAJuego(@RequestBody juego_descuento nuevoJuegoDescuento) {
        juegoDescuentoService.agregarDescuentoAJuego(nuevoJuegoDescuento);
    }

    @DeleteMapping("/{id_juego}/{id_descuento}")
    public void eliminarDescuentoDeJuego(@PathVariable int id_juego, @PathVariable int id_descuento) {
        juegoDescuentoService.eliminarDescuentoDeJuego(id_juego, id_descuento);
    }

    @GetMapping("/porJuego/{id_juego}")
    public List<juego_descuento> obtenerDescuentosPorJuego(@PathVariable int id_juego) {
        return juegoDescuentoService.obtenerDescuentosPorJuego(id_juego);
    }

    @GetMapping("/porDescuento/{id_descuento}")
    public List<juego_descuento> obtenerJuegosPorDescuento(@PathVariable int id_descuento) {
        return juegoDescuentoService.obtenerJuegosPorDescuento(id_descuento);
    }

    @GetMapping
    public List<videojuegos> seleccionarjuegosdescuento() {
        return juegoDescuentoService.seleccionarjuegosdescuento();
    }

    @PutMapping("/{id_juego}/{id_descuento}/{nuevoIdDescuento}")
    public void actualizarJuegoEnDescuento(@PathVariable int id_juego, @PathVariable int id_descuento,
                                           @PathVariable int nuevoIdDescuento) {
        juegoDescuentoService.actualizarJuegoEnDescuento(id_juego, id_descuento, nuevoIdDescuento);
    }
}
