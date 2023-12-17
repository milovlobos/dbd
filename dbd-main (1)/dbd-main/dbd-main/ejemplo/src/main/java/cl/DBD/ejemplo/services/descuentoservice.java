package cl.DBD.ejemplo.services;
import cl.DBD.ejemplo.models.descuento;
import cl.DBD.ejemplo.repositories.descuentorepository;

import java.util.*;


import org.springframework.web.bind.annotation.*;

public class descuentoservice {
    private final descuentorepository descuentoRepository;


    descuentoservice(descuentorepository descuentoRepository) {
        this.descuentoRepository = descuentoRepository;
    }

    @PostMapping("/descuento")
    public void crearDescuento(@RequestBody descuento nuevoDescuento) {
        descuentoRepository.crearDescuento(nuevoDescuento);
    }

    @PutMapping("/descuento/{id}")
    public void actualizarDescuento(@PathVariable int id, @RequestBody descuento descuentoActualizado) {
        descuentoRepository.actualizarDescuento(id, descuentoActualizado);
    }

    @DeleteMapping("/descuento/{id}")
    public void eliminarDescuento(@PathVariable int id) {
        descuentoRepository.eliminarDescuento(id);
    }

    @GetMapping("/descuento")
    public List<descuento> seleccionarTodosDescuentos() {
        return descuentoRepository.seleccionardescuentos();
    }

    @GetMapping("/descuento/{id}")
    public descuento seleccionarPorIdDescuento(@PathVariable int id) {
        return descuentoRepository.seleccionarPorId_descuento(id);
    }
}
