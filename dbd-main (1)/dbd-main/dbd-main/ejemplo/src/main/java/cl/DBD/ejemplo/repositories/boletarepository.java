package cl.DBD.ejemplo.repositories;
import cl.DBD.ejemplo.models.boleta;
import java.util.*;

public interface boletarepository {
    public void crearBoleta(boleta nuevaBoleta);
    public void actualizarBoleta(int id, boleta boletaActualizada);
    public void eliminarBoleta(int id);
    public List<boleta> seleccionarTodas_boleta();
    public boleta seleccionarPorId_boleta(int id);
}
