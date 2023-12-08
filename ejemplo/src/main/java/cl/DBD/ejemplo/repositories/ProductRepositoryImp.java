package cl.DBD.ejemplo.repositories;


import cl.DBD.ejemplo.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ProductRepositoryImp implements ProductoRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Producto crear(Producto producto){
        try(Connection conn = sql2o.open()){
            String sql = "INSERT INTO productos (id,nombre, categoria, precio, fecha_vencimiento)" +
            "VALUES (:id, :nombre, :categoria, :precio, :fecha)";
            conn.createQuery(sql, true)
                .addParameter("id", producto.getId_producto())
                .addParameter("nombre", producto.getNombre_producto())
                .addParameter("categoria", producto.getCategoria())
                .addParameter("precio", producto.getPrecio())
                .addParameter("fecha", LocalDate.parse(producto.getFvencimiento()))
                .executeUpdate();
                return producto;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }


    
    @Override
    public List<Producto> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from productos order by nombre ASC")
                    .executeAndFetch(Producto.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Producto> show(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from productos where id = :id ")
                    .addParameter("id",id)
                    .executeAndFetch(Producto.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Producto> showLessThan(Integer precio) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from productos where precio< :precio ::int")
                    .addParameter("precio",precio)
                    .executeAndFetch(Producto.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Producto> showByCategorie(int categoria) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from productos where categoria = :categoria")
                    .addParameter("categoria", categoria)
                    .executeAndFetch(Producto.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public void delete(int id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from productos where id = :id")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public String update(Producto producto, int id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update productos set nombre=:nombre, categoria= :categoria, precio=:precio, fecha_vencimiento=:fecha WHERE id=:id";
            conn.createQuery(updateSql)
                .addParameter("id", id)
                .addParameter("nombre", producto.getNombre_producto())
                .addParameter("categoria", producto.getCategoria())
                .addParameter("precio", producto.getPrecio())
                .addParameter("fecha", LocalDate.parse(producto.getFvencimiento()))
                .executeUpdate();
            return "Se actualizó el producto";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fallo al actualizar producto";
        }
    }

}