package cl.DBD.ejemplo.services;
import cl.DBD.ejemplo.models.usuario_usuario;
import cl.DBD.ejemplo.repositories.usuario_usuariorepository;

import java.util.*;

import org.springframework.web.bind.annotation.*;

public class usuario_usuarioservice {
    private final usuario_usuariorepository usuarioUsuarioRepository;


    public usuario_usuarioservice(usuario_usuariorepository usuarioUsuarioRepository) {
        this.usuarioUsuarioRepository = usuarioUsuarioRepository;
    }

    @PostMapping("/seguirUsuario")
    public void seguirUsuario(@RequestBody usuario_usuario nuevaRelacion) {
        usuarioUsuarioRepository.seguirUsuario(nuevaRelacion);
    }

    @DeleteMapping("/dejarDeSeguirUsuario/{id_usuario}/{id_seguido}")
    public void dejarDeSeguirUsuario(@PathVariable int id_usuario, @PathVariable int id_seguido) {
        usuarioUsuarioRepository.dejarDeSeguirUsuario(id_usuario, id_seguido);
    }

    @GetMapping("/obtenerUsuariosSeguidos/{id_usuario}")
    public List<usuario_usuario> obtenerUsuariosSeguidos(@PathVariable int id_usuario) {
        return usuarioUsuarioRepository.obtenerUsuariosSeguidos(id_usuario);
    }

    @GetMapping("/obtenerSeguidores/{id_seguido}")
    public List<usuario_usuario> obtenerSeguidores(@PathVariable int id_seguido) {
        return usuarioUsuarioRepository.obtenerSeguidores(id_seguido);
    }

    @GetMapping("/obtenerTodoUserUser")
    public List<usuario_usuario> obtenerTodoUserUser() {
        return usuarioUsuarioRepository.obtenetodo_useruser();
    }
}
