package cl.DBD.ejemplo.services;
import cl.DBD.ejemplo.models.favorito;
import cl.DBD.ejemplo.repositories.favoritorepository;
import java.util.*;

import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/favoritos")
public class favoritoservice {

    private final favoritorepository favoritorepository;

    favoritoservice(favoritorepository favoritorepository) {
        this.favoritorepository = favoritorepository;
    }


    @PostMapping("/{id_usuario}/{id_juego}")
    public void agregarFavorito(@PathVariable int id_usuario, @PathVariable int id_juego) {
        favoritorepository.agregarFavorito(id_usuario, id_juego);
    }

    @DeleteMapping("/{id_usuario}/{id_juego}")
    public void eliminarFavorito(@PathVariable int id_usuario, @PathVariable int id_juego) {
        favoritorepository.eliminarFavorito(id_usuario, id_juego);
    }

    @GetMapping("/usuario/{id_usuario}")
    public List<favorito> obtenerFavoritosPorUsuario(@PathVariable int id_usuario) {
        return favoritorepository.obtenerFavoritosPorUsuario(id_usuario);
    }

    @GetMapping("/todos")
    public List<favorito> obtenerTodos() {
        return favoritorepository.obtenerTodos();
    }

    @GetMapping("/juego/{id_juego}")
    public List<favorito> obtenerUsuariosPorJuego(@PathVariable int id_juego) {
        return favoritorepository.obtenerUsuariosPorJuego(id_juego);
    }
}