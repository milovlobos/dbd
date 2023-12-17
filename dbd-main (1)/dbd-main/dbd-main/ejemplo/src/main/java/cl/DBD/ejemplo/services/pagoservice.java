package cl.DBD.ejemplo.services;
import cl.DBD.ejemplo.models.pago;
import cl.DBD.ejemplo.repositories.pagorepository;
import java.util.*;
import org.springframework.web.bind.annotation.*;


public class pagoservice {

    @RestController
    @RequestMapping("/pago")
    public class PagoController {

        private pagorepository pagoService;

        @PostMapping("/crear")
        public Void crearPago(@RequestBody pago nuevoPago) {
            pagoService.crearPago(nuevoPago);

            return null;
        }

        @PutMapping("/actualizar/{id}")
        public Void actualizarPago(@PathVariable int id, @RequestBody pago pagoActualizado) {
            pagoService.actualizarPago(id, pagoActualizado);

            return null;
        }

        @DeleteMapping("/eliminar/{id}")
        public Void eliminarPago(@PathVariable int id) {
            pagoService.eliminarPago(id);

            return null;
        }

        @GetMapping("/obtenerTodos")
        public List<pago> obtenerPagos() {
            return pagoService.obtenerpagos();
        }

        @GetMapping("/obtenerPorId/{id}")
        public List<pago> obtenerPorId(@PathVariable int id) {
            return (List<pago>) pagoService.obtenerPorId_pago(id);


        }
    }
}
