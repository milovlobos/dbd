package cl.DBD.ejemplo.repositories;

import cl.DBD.ejemplo.models.Producto;

import java.util.List;

public interface ProductoRepository {
    /**
    * Inserta un producto en la tabla producto.
    * Al ser el todos sus atributos obligatorios (excepto id), si son nulos o vacíos se lanzará
    * una excepción o si la conexion falla .
    *
    * @param producto objeto de la clase Producto que tiene los atributos correspondientes a insertar como producto.
    * @return retorna un Producto que contiene el producto creado o null si se lanza excepcion.
    * @throws Exception Si uno de los atributos es null o vacio.
    */
    public Producto crear(Producto producto);

    /**
    * Inserta datos en un producto en la tabla producto.
    * Al ser el todos sus atributos obligatorios (excepto id), si son nulos o vacíos se lanzará
    * una excepción, si la conexion falla o si no encuentra el id.
    *
    * @param producto objeto de la clase Producto que tiene los atributos correspondientes a insertar en un producto.
    * @param id string alfanumerico correspondiente al id del producto al cual se desea insertar datos.
    * @return retorna un string que indica el exito de la actualización de los datos.
    * @throws Exception Si uno de los atributos es null o vacio o si no encuentra el id.
    */
    public String update(Producto producto, int id);


    /**
    * Lista todos los productos de la base de datos ascendente por nombre.
    * Si la conexion falla lanzará excepción.
    *
    * @return retorna una lista de Producto que contiene los productos o null si se lanza excepcion.
    * @throws Exception Si la conexion falla.
    */
    public List<Producto> getAll();


    /**
    * Lista un producto con un id especifico de la base de datos.
    * Si la conexion falla o si no encuentra el id lanzará excepción.
    *
    * @param id identificador del producto que se desea mostrar.
    * @return retorna una lista de Producto que contiene el producto con el id solicitado o null si se lanza excepcion.
    * @throws Exception Si la conexion falla o si no encuentra el id.
    */
    public List<Producto> show(int id);


    /**
    * Lista un producto con un precio menor a un valor especifico de la base de datos.
    * Si la conexion falla o si no encuentra el id lanzará excepción.
    *
    * @param precio maximo de los productos que se desea mostrar.
    * @return retorna una lista de Producto que contiene el producto con el precio menor al solicitado o null si se lanza excepcion.
    * @throws Exception Si la conexion falla o si no encuentra el id.
    */
    public List<Producto> showLessThan(Integer precio);


    /**
    * Lista un producto con una categoria especifica de la base de datos.
    * Si la conexion falla o si no encuentra el id lanzará excepción.
    *
    * @param categoria del producto que se desea mostrar.
    * @return retorna una lista de Producto que contiene el producto con la categoria solicitada o null si se lanza excepcion.
    * @throws Exception Si la conexion falla o si no encuentra el id.
    */
    public List<Producto> showByCategorie(int categoria);



    /**
    * Elimina un producto de la base de datos por su id.
    * Si la conexion falla o si no encuentra el id lanzará excepción.
    *
    * @param id identificador del producto que se desea eliminar.
    * @throws Exception Si la conexion falla o si no encuentra el id.
    */
    public void delete(int id);
}