package cl.DBD.ejemplo.services;
import cl.DBD.ejemplo.models.usuario;
import cl.DBD.ejemplo.repositories.usuariorepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

public class usuarioservice {
    private final usuariorepository usuarioRepository;


    public usuarioservice(usuariorepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/crearUsuario")
    public void crearUsuario(@RequestBody usuario nuevoUsuario) {
        usuarioRepository.crearUsuario(nuevoUsuario);
    }

    @PutMapping("/actualizarUsuario/{id}")
    public void actualizarUsuario(@PathVariable int id, @RequestBody usuario usuarioActualizado) {
        usuarioRepository.actualizarUsuario(id, usuarioActualizado);
    }

    @DeleteMapping("/eliminarUsuario/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        usuarioRepository.eliminarUsuario_usuario(id);
    }

    @GetMapping("/seleccionarTodosUsuario")
    public List<usuario> seleccionarTodosUsuario() {
        return usuarioRepository.seleccionarTodos_usuario();
    }

    @GetMapping("/seleccionarPorIdUsuario/{id}")
    public usuario seleccionarPorIdUsuario(@PathVariable int id) {
        return usuarioRepository.seleccionarPorId_usuario(id);
    }
}
