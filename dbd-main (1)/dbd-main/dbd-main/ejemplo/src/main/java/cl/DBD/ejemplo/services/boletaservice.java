package cl.DBD.ejemplo.services;
import cl.DBD.ejemplo.models.boleta;
import cl.DBD.ejemplo.repositories.boletarepository;
import java.util.*;

import org.springframework.web.bind.annotation.*;


public class boletaservice {
    private final boletarepository boletaRepository;


    public boletaservice(boletarepository boletaRepository) {
        this.boletaRepository = boletaRepository;
    }

    @PostMapping("/boleta")
    public void crearBoleta(@RequestBody boleta nuevaBoleta) {
        boletaRepository.crearBoleta(nuevaBoleta);
    }

    @PutMapping("/boleta/{id}")
    public void actualizarBoleta(@PathVariable int id, @RequestBody boleta boletaActualizada) {
        boletaRepository.actualizarBoleta(id, boletaActualizada);
    }

    @DeleteMapping("/boleta/{id}")
    public void eliminarBoleta(@PathVariable int id) {
        boletaRepository.eliminarBoleta(id);
    }

    @GetMapping("/boleta")
    public List<boleta> seleccionarTodasBoletas() {
        return boletaRepository.seleccionarTodas_boleta();
    }

    @GetMapping("/boleta/{id}")
    public boleta seleccionarPorIdBoleta(@PathVariable int id) {
        return boletaRepository.seleccionarPorId_boleta(id);
    }
}
