package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.usuario;
import java.util.*;

public interface usuariorepository {
    public void crearUsuario(usuario nuevoUsuario);

    public void actualizarUsuario(int id, usuario usuarioActualizado);
    public void eliminarUsuario_usuario(int id);
    public List<usuario> seleccionarTodos_usuario();
    public usuario seleccionarPorId_usuario(int id);
}