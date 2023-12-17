package cl.DBD.ejemplo.models;
import java.util.*;
public class roles_permisos {
    private int id_rol;
    private int id_permiso;

    public roles_permisos(int id_rol, int id_permiso) {
        this.id_rol = id_rol;
        this.id_permiso = id_permiso;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(int id_permiso) {
        this.id_permiso = id_permiso;
    }
}