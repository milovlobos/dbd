package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.rol;
import cl.DBD.ejemplo.models.usuario_usuario;
import java.util.*;

public interface usuario_usuariorepository {
    public void seguirUsuario(usuario_usuario nuevaRelacion);
    public void dejarDeSeguirUsuario(int id_usuario, int id_seguido);
    public List<usuario_usuario> obtenerUsuariosSeguidos(int id_usuario);
    public List<usuario_usuario> obtenerSeguidores(int id_seguido);
    public List<usuario_usuario> obtenetodo_useruser();
}
